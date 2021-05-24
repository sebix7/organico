package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAdmin {

	// Escucha la URL /periodo por GET, y redirige a una vista.
	@RequestMapping("/homeAdministrador")
	public ModelAndView irAHomeAdministrador() {
		return new ModelAndView("homeAdministrador");
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
