package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;

@Controller
public class ControladorCarro {
	
	private ServicioCarro servicioCarro;

	@Autowired
	public ControladorCarro(ServicioCarro servicioCarro) {
		this.servicioCarro = servicioCarro;
	}
	
	@RequestMapping("/carrito")
	public ModelAndView irACarrito(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
			Long id=(Long)request.getSession().getAttribute("ClienteId");
			List<Combo> combos = this.servicioCarro.consultarProductosDelCarrito(id);
			ModelMap modelo = new ModelMap();
			if(combos.size() == 0) {
				String mensaje = "No hay items en el carrito";
				modelo.put("mensaje", mensaje);
			} else {
				modelo.put("combos", combos);
			}
			return new ModelAndView("carrito", modelo);
		}
		else {
			return new ModelAndView("login");
		}
		
	}

}
