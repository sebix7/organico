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
import ar.edu.unlam.tallerweb1.modelo.Vegetal;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioVegetal;

@Controller
public class ControladorVendedor {
	
	private ServicioCombo creado;
	
	@Autowired
	public ControladorVendedor(ServicioCombo creado){
		this.creado = creado;
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/homeVendedor", method = RequestMethod.GET)
	public ModelAndView irAHomeVendedor(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Vendedor")) {
			return new ModelAndView("homeVendedor");
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/creacionCombo")
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		Combo usuario = new Combo();
		modelo.put("combo", usuario);
		return new ModelAndView("creacionCombo", modelo);
	}
	@RequestMapping(path="/crear",method=RequestMethod.POST)
	public ModelAndView procesarRegistroCombo(
			@ModelAttribute("combo") Combo frutalOVegetal
			) {
		ModelMap modelo = new ModelMap();
		if(frutalOVegetal!=null) {
			//guardamelo en la base
			creado.registro(frutalOVegetal);
			modelo.put("create","Combo Creado! "+frutalOVegetal.getNombre());
		}else {
			modelo.put("create","Error");
		}
		return new ModelAndView("creacionCombo",modelo);
		
	}
	
	@RequestMapping("/verCombos")
	public ModelAndView irAvista() {
		ArrayList<Combo> a = (ArrayList) creado.ver();
		String x = " ";
		for (Combo combo : a) {
			 x += combo.getNombre() + "\n";
			 x += " ";
		}
		ModelMap modelo = new ModelMap();
		modelo.put("create","Combos activos-> "+ x);
		return new ModelAndView("verCombos",modelo);
	}
	
}
