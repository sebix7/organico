package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAdmin {

	// Escucha la URL /periodo por GET, y redirige a una vista.
	@RequestMapping("/homeAdministrador")
	public ModelAndView irAHomeAdministrador(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Administrador")) {
			return new ModelAndView("homeAdministrador");
		}
		else {
			return new ModelAndView("login");
		}
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
