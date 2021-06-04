package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCliente {

	
	@RequestMapping("/homeCliente")
	public ModelAndView irAHomeCliente(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol != null) 
			if(rol.equals("Cliente"))
				return new ModelAndView("homeCliente");
		
		return new ModelAndView("redirect:/login");
		
	}
	
	@RequestMapping("/productos")
	public ModelAndView irAProductos() {
		return new ModelAndView("productos");
	}
	
	@RequestMapping("/compras")
	public ModelAndView irACompras() {
		return new ModelAndView("compras");
	}
}
