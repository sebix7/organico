package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCliente {

	
	@RequestMapping("/homeCliente")
	public ModelAndView irAHomeCliente() {
		return new ModelAndView("homeCliente");
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
