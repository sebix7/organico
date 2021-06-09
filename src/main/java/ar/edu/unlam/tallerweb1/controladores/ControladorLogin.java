package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private ServicioCarro servicioCarro;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioCarro servicioCarro){
		this.servicioLogin = servicioLogin;
		this.servicioCarro = servicioCarro;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			  request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			  request.getSession().setAttribute("EMAIL", usuarioBuscado.getEmail());
			  request.getSession().setAttribute("userId", usuarioBuscado.getId());
			  
			  model.put("usuario",usuarioBuscado);
			
			String rol=(String)request.getSession().getAttribute("ROL");

			switch(rol) {
			case "Vendedor":   
				//guardar un objeto en una sesi�n
				request.getSession().setAttribute("VendedorId", usuarioBuscado.getId());
				return new ModelAndView("redirect:/homeVendedor",model);
			        
			case "Cliente": 
				request.getSession().setAttribute("ClienteId", usuarioBuscado.getId());
				return new ModelAndView("redirect:/homeCliente",model);		
			
			case "Administrador": 
				request.getSession().setAttribute("AdministradorId", usuarioBuscado.getId());
				return new ModelAndView("redirect:/homeAdministrador",model);
			
		   }
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	/*
	@RequestMapping(path = "/cerrarsesion", method = RequestMethod.GET)
	public ModelAndView cerrarsesion(HttpServletRequest request) {
		request.getSession().removeAttribute("ROL");
		return new ModelAndView("redirect:/login");
		
	}*/
	
 	@RequestMapping("/cerrarsesion")
	public ModelAndView cerrarSession(HttpServletRequest request) {
		
		request.getSession().invalidate();
		return new ModelAndView("redirect:/login");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	
	@RequestMapping("/registroUsuario")
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registroUsuario", modelo);
	}
	@RequestMapping(path="/procesarRegistro",method=RequestMethod.POST)
	public ModelAndView procesarRegistroUsuario(
			@ModelAttribute("usuario") Usuario usuario,
			@RequestParam(value="repassword",required=false) String repass
			) {
		//validar password con repassword
		ModelMap modelo = new ModelMap();
		if(usuario.getPassword().equals(repass)) {
			//guardamelo en la base
			servicioLogin.registro(usuario);
			
				modelo.put("mensaje","Usuario registrado! "+usuario.getEmail());
			}
			
			if(usuario.getRol().equals("Cliente")) {
		
				Carro carro = new Carro();

				servicioCarro.guardarCarro(carro);
				
				modelo.put("mensaje","Usuario registrado! "+usuario.getEmail());
			} else if(usuario.getRol().equals("Vendedor")) {
				modelo.put("mensaje","Usuario registrado! "+usuario.getEmail());
			}
			else {
			modelo.put("mensaje","Error no coinciden las pass");
		}
		return new ModelAndView("login",modelo);
		
	}
	

	//tanto el cliente como el vendedor que esten logueados van a poder ver su perfil y modificarlo 
	@RequestMapping(path="perfil")
	public ModelAndView mostrarPerfil(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("userId") == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelMap modelo = new ModelMap();
		
		Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
		modelo.put("usuario", usuarioLogueado);
		modelo.put("nombre", usuarioLogueado.getNombre());
		modelo.put("email", usuarioLogueado.getEmail());
		modelo.put("password", usuarioLogueado.getPassword());
		
		return new ModelAndView("perfil" , modelo);
	}
	
	
	@RequestMapping(path="actualizar-perfil" , method = RequestMethod.POST)
	public ModelAndView actualizarPerfil(@ModelAttribute("usuario") Usuario usuario , HttpServletRequest request) {
		
		if(request.getSession().getAttribute("userId") == null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelMap modelo = new ModelMap();
		
		Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
		
		if(servicioLogin.buscarPorId(usuario.getId()) != null) {
			servicioLogin.actualizar(usuario);
			modelo.put("mensaje", "Se actualizo correctamente");
			modelo.put("usuario", usuario);

		} else {
			modelo.put("mensaje", "No se pudo actualizar");
			modelo.put("usuario", usuarioLogueado);
		
		}
		return new ModelAndView("perfil", modelo);
	}
}
