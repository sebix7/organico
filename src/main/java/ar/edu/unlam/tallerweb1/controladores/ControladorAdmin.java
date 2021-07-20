package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorAdmin {

	private ServicioLogin servicioLogin;
	private ServicioPedido servicioPedido;
	
	
	@Autowired
	public ControladorAdmin(ServicioLogin servicioLogin,ServicioPedido servicioPedido){
		this.servicioLogin = servicioLogin;
		this.servicioPedido=servicioPedido;
	}
	// Escucha la URL /periodo por GET, y redirige a una vista.
	@RequestMapping("/homeAdministrador")
	public ModelAndView irAHomeAdministrador(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol != null) 
			if(rol.equals("Administrador"))
				return new ModelAndView("homeAdministrador");
		
		return new ModelAndView("redirect:/login");
	}
	
	
	@RequestMapping("/usuarios")
	public ModelAndView irAClientes(HttpServletRequest request) {
 		
 		String rol=(String)request.getSession().getAttribute("ROL");
 		    if(!rol.equals("Administrador"))
			return new ModelAndView("redirect:/login");
	
 		
 	ModelMap modelo = new ModelMap();
	List<Usuario> busqueda = servicioLogin.listarTodos();
	modelo.put("busqueda", busqueda);
	
	return new ModelAndView("usuarios",modelo);
	}
   
 	
	@RequestMapping(path = "/usuarios", method = RequestMethod.POST)
	 public ModelAndView irUsuariosBusqueda(
			@RequestParam(defaultValue = "true") String roles ){
			
			ModelMap modelo = new ModelMap();
			
		//Cada if hace un criteria que trae todos los usuarios de un rol en particular
	   	if (roles.equalsIgnoreCase("Vendedor")) {
	  
			modelo.put("busqueda",servicioLogin.busquedaPorRol("Vendedor"));
			return new ModelAndView("usuarios", modelo);
	    }
		
		if (roles.equalsIgnoreCase("Cliente")) {
	    
			modelo.put("busqueda",servicioLogin.busquedaPorRol("Cliente"));
			return new ModelAndView("usuarios", modelo);
	    }
		
		if (roles.equalsIgnoreCase("Administrador")) {
	      
			modelo.put("busqueda",servicioLogin.busquedaPorRol("Administrador"));
			return new ModelAndView("usuarios", modelo);
	    }
		
		if (roles.equalsIgnoreCase("Todos")) {
		      
			modelo.put("busqueda",servicioLogin.listarTodos());
			return new ModelAndView("usuarios", modelo);
	    }
		
		return null;
		
	}
	
	
	@RequestMapping("/calificarClientes")
	public ModelAndView irACalificar(HttpServletRequest request) {
		
		  String rol=(String)request.getSession().getAttribute("ROL");
		     if(!rol.equals("Administrador"))
		          return new ModelAndView("redirect:/login");
		    
		     
			List<Pedido> pedidos = servicioPedido.ObtenerPedidosCancelados();
			
		       ModelMap modelo = new ModelMap();
			
			   if(pedidos.size() == 0) {
			      	String mensaje = "No hay pedidos Cancelados";
				     modelo.put("mensaje", mensaje);
			}   else {
			      modelo.put("pedidos", pedidos);
			}
		
	return new ModelAndView("calificarClientes",modelo);
		
		}
	
	//action que cambia el valor activo del usuario a false
	@RequestMapping(value = "/desactivarUsuario", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String desactivaUsuario(@RequestParam("id") Long idusuario) {

	       Usuario usuario= servicioLogin.buscarPorId(idusuario);
	       usuario.setActivo(false);
	       servicioLogin.actualizar(usuario);	       
		
		return null; 
	}
	
	//action que cambia el valor activo del usuario a true
	@RequestMapping(value = "/activarUsuario", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String activaUsuario(@RequestParam("id") Long idusuario) {

	       Usuario usuario= servicioLogin.buscarPorId(idusuario);
	       usuario.setActivo(true);
	       servicioLogin.actualizar(usuario);	       
		
		return null; 
	}
	
	
	@RequestMapping("/periodo")
	public ModelAndView irAPeriodo() {
		return new ModelAndView("periodo");
		}
	   
	@RequestMapping("/estadisticas")
	public ModelAndView irAEstadisticas() {
		return new ModelAndView("estadisticas");
	}
	
}
