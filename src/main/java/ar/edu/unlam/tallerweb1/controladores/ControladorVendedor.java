package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;
import ar.edu.unlam.tallerweb1.modelo.VerDetalleViewModel;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;



@Controller
public class ControladorVendedor {
	
	private ServicioCombo creado;
	private ServicioLogin idVendedor;
	private ServicioClienteCombos servicioClienteCombos;


	
	@Autowired
	public ControladorVendedor(ServicioCombo creado, ServicioLogin idVendedor,ServicioClienteCombos servicioClienteCombos){
		this.creado = creado;
		this.idVendedor = idVendedor;
		this.servicioClienteCombos=servicioClienteCombos;
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/homeVendedor", method = RequestMethod.GET)
	public ModelAndView irAHomeVendedor(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol != null) 
			if(rol.equals("Vendedor"))
				return new ModelAndView("homeVendedor");
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(path = "/aplicacionDescuento", method = RequestMethod.GET)
	public ModelAndView aplicacionDescuento(HttpServletRequest request,@RequestParam(value="descuento",required=false) Integer descuento ) {
		String rol=(String)request.getSession().getAttribute("ROL");
		if(rol != null) 
		if(rol.equals("Vendedor")) {
			return new ModelAndView("aplicacionDescuento");
		}
		return new ModelAndView("redirect:/login");
		
	}
	
	@RequestMapping(path = "/aplicarDescuento", method = RequestMethod.POST)
	public ModelAndView aplicarDescuento(HttpServletRequest request,@RequestParam(value="descuento",required=false) Long descuento, @RequestParam(value="descuentosAlCombo",required=false) Long id ) {
		String rol=(String)request.getSession().getAttribute("ROL");
		if(rol != null) 
			if(rol.equals("Vendedor")) {
				ModelMap modelo = new ModelMap();
				this.creado.aplicarDescuento(descuento, id);
				modelo.put("create","Descuento Aplicado");
				return new ModelAndView("aplicacionDescuento", modelo);
			}
			return new ModelAndView("redirect:/login");
			
		}

	@RequestMapping("/creacionCombo")
	public ModelAndView creacionCombos(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		if(rol != null) 
		if(rol.equals("Vendedor")) {
			ModelMap modelo = new ModelMap();
			Combo nuevo = new Combo();
			modelo.put("combo", nuevo);
			return new ModelAndView("creacionCombo", modelo);
		}
		return new ModelAndView("redirect:/login");
		
	}
	
	@RequestMapping(path="/envioId",method=RequestMethod.POST)
	public ModelAndView editarCombos(HttpServletRequest request,@RequestParam(value="idDetalle",required=false) Long idDelCombo) {
		String rol=(String)request.getSession().getAttribute("ROL");
		if(rol != null) 
		if(rol.equals("Vendedor")) {
			ModelMap modelo = new ModelMap();
			Combo nuevo = new Combo();
			nuevo = creado.buscarPorId(idDelCombo);
			modelo.put("combo", nuevo);
			modelo.put("id", nuevo.getId());
			modelo.put("nombre", nuevo.getNombre());
			modelo.put("estacion", nuevo.getEstacion());
			modelo.put("descripcion", nuevo.getDescripcion());
			modelo.put("precio", nuevo.getPrecio());
			modelo.put("peso", nuevo.getPeso());
			modelo.put("stock", nuevo.getStock());
			return new ModelAndView("creacionCombo", modelo);
		}
		return new ModelAndView("redirect:/index");
		
	}
	@RequestMapping(path="/crear",method=RequestMethod.POST)
	public ModelAndView procesarRegistroCombo(
			@ModelAttribute("combo") Combo frutalOVegetal,HttpServletRequest request
			) {
		String rol=(String)request.getSession().getAttribute("ROL");
		String email=(String)request.getSession().getAttribute("EMAIL");
		if(rol != null) {
			if(rol.equals("Vendedor")) {
				ModelMap modelo = new ModelMap();
				if(frutalOVegetal!=null) {
					frutalOVegetal.setUsuario(idVendedor.buscarPorMail(email));
					creado.registro(frutalOVegetal);
					modelo.put("create","Combo Creado! "+frutalOVegetal.getNombre());
					return new ModelAndView("creacionCombo",modelo);
			}else {
				modelo.put("create","Error");	
			}
		}
		}
			return new ModelAndView("redirect:/index");
		
	
		
	}
	@RequestMapping("/verCombos")
	public ModelAndView irACombosVendedor(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		String email=(String)request.getSession().getAttribute("EMAIL");
		if(rol!=null){
			if(rol.equals("Vendedor")) {
				List<Combo> combos = this.creado.consultarCombosPorUs(idVendedor.buscarPorMail(email));
			    ModelMap modelo = new ModelMap();
			   List<VerDetalleViewModel> resultado = new ArrayList();
			  
				if(combos.size() == 0) {
					String mensaje = "No hay combos Creados";
					modelo.put("mensaje", mensaje);
				} else {
					
					resultado= servicioClienteCombos.obtenerComentariosSinLeerPorCombo(combos);		
				    modelo.put("combos", resultado);
				}
				return new ModelAndView("verCombos", modelo);
			}
			else {
				return new ModelAndView("login");
			}
			
		}
				return new ModelAndView("redirect:/index");
		
	}
	
	@RequestMapping(path="/descuentosAlCombo",method=RequestMethod.POST)
	public ModelAndView procesardescuentosAlCombo(
			HttpServletRequest request,@RequestParam(value="descuentosAlCombo",required=false) Long idDelCombo
			) {
		String rol=(String)request.getSession().getAttribute("ROL");
		if(rol != null) 
		if(rol.equals("Vendedor")) {
			ModelMap modelo = new ModelMap();
			Combo nuevo = new Combo();
			nuevo = creado.buscarPorId(idDelCombo);
			modelo.put("combo", nuevo);
			modelo.put("id", nuevo.getId());
			modelo.put("nombre", nuevo.getNombre());
			return new ModelAndView("aplicacionDescuento", modelo);
		}
		return new ModelAndView("redirect:/index");
		
	}
	
	//action que permite visualizar la vista VerDetalle de cada combo
	@RequestMapping(path ="/verDetalleVendedor",method = RequestMethod.GET)
	public ModelAndView irDetalleVendedor(@RequestParam(value = "id", required = true) Long idcombo, HttpServletRequest request) {
		
	         List<ValorarCombo> comentarios = new ArrayList();	
		
		String rol=(String)request.getSession().getAttribute("ROL");
		//solo ingresa si es vendedor
		      if(rol.equals("Vendedor")) {
			      ModelMap modelo = new ModelMap();
			      
			      comentarios =servicioClienteCombos.obtenerComentariosdeCombo(idcombo);
			      Integer NoLeidoComentario =servicioClienteCombos.contarComentariosNoLeidos(idcombo);
			      Combo combo=servicioClienteCombos.obtenerComboPorId(idcombo);
			      Integer CantidadPositivos=servicioClienteCombos.obtenerPositivosCombo(idcombo);//Cantidad de MeGusta que posee el combo
			      Integer CantidadNegativos=servicioClienteCombos.obtenerNegativosCombo(idcombo);//cantidad de no me gusta
                
			       modelo.put("NoLeidoComentario",NoLeidoComentario);
			       modelo.put("comentarios",comentarios);
			       modelo.put("combo", combo);
			       modelo.put("positivos",CantidadPositivos);
			       modelo.put("negativos", CantidadNegativos);
	
			      return new ModelAndView("verDetalleVendedor",modelo);
		 }	
		
		return new ModelAndView("login");
	}

	 //action que pasa todos los comentarios a true = leido
	@RequestMapping(value = "/marcarComentariosLeidos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String leerComentarios(@RequestParam("id") Long idcombo) {

		      servicioClienteCombos.marcarComentarios(idcombo);
		
		return null; 
	}
	
	@RequestMapping(path = "/filtrar", method = RequestMethod.GET)
	public ModelAndView irAfiltro(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol != null) 
			if(rol.equals("Vendedor"))
				return new ModelAndView("filtrar");
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(path="/filtro",method=RequestMethod.GET)
	public ModelAndView filtro(
			HttpServletRequest request,@RequestParam(value="Estacion",required=false) String estaciones,@RequestParam(value="Descuento",required=false) String Descuento,
			@RequestParam(value="precio",required=false) String precio
			) {
		String rol=(String)request.getSession().getAttribute("ROL");
		String email=(String)request.getSession().getAttribute("EMAIL");
		if(rol != null) 
		if(rol.equals("Vendedor")) {
			ModelMap modelo = new ModelMap();
			 List<Combo> filtro;
			 
			 if(Descuento.equals("si")) {
				 filtro = creado.consultarCombosPorEstacionYDescuentoSi(estaciones,this.idVendedor.buscarPorMail(email));
				 modelo.put("combos",filtro);
			 }else {
				 filtro = creado.consultarCombosPorEstacionYDescuentoNo(estaciones,this.idVendedor.buscarPorMail(email));
				 modelo.put("combos",filtro);
			 }
			 
			 switch (precio) {
				case "menor":
					Collections.sort(filtro, (x, y) -> x.getPrecio().compareTo(y.getPrecio()));
					
					break;

				default:
					Collections.sort(filtro, (x, y) -> y.getPrecio().compareTo(x.getPrecio()));
			
					break;
				}
			 

				if(filtro.size()>0) {
					
					modelo.put("mensaje","exito en la busqueda");
				}else {
					
					modelo.put("mensaje","No Existe combo con esas Caracteristicas");
				}
			 
			return new ModelAndView("filtroBusqueda", modelo);
		}
		
		return new ModelAndView("redirect:/index");
	}
	
	
	@RequestMapping(path = "/geo", method = RequestMethod.GET)
	public ModelAndView irAGeo(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol != null) 
			if(rol.equals("Vendedor"))
				return new ModelAndView("geo");
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(path = "/procesarLocalizacion", method = RequestMethod.GET)
	public ModelAndView procesoGeo(HttpServletRequest request,@RequestParam(value="lata",required=false) Double latitud,@RequestParam(value="lona",required=false) Double longitud) {
		String rol=(String)request.getSession().getAttribute("ROL");
		String email=(String)request.getSession().getAttribute("EMAIL");
		ModelMap modelo = new ModelMap();
		List <Combo> localizado;
		localizado = this.creado.consultarCombosPorUs(this.idVendedor.buscarPorMail(email));
		if(rol != null) 
			if(rol.equals("Vendedor")) {
				
				if(localizado.size()!=0) {
					for (Combo combo : localizado) {
						combo.setLatitud(latitud);
						combo.setLongitud(longitud);
						this.creado.registro(combo);
					}
				}else {
					modelo.put("mensaje", "debes tener combos para geolocalizarte");
					return new ModelAndView("geo",modelo);
				}
				
				
				modelo.put("mensaje", "exito al cargar tu ubicacion");
				return new ModelAndView("geo",modelo);
			}
		
		return new ModelAndView("redirect:/login");
	}
	
	
	
	
}
