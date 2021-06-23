package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;



@Controller
public class ControladorVendedor {
	
	private ServicioCombo creado;
	private ServicioLogin idVendedor;

	
	@Autowired
	public ControladorVendedor(ServicioCombo creado, ServicioLogin idVendedor){
		this.creado = creado;
		this.idVendedor = idVendedor;
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
				if(combos.size() == 0) {
					String mensaje = "No hay combos Creados";
					modelo.put("mensaje", mensaje);
				} else {
					modelo.put("combos", combos);
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
	
	
}
