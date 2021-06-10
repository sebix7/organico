package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;

@Controller
public class ControladorClienteCombos {
	
	private ServicioClienteCombos servicioClienteCombos;
	private ServicioCarro servicioCarro;

	@Autowired
	public ControladorClienteCombos(ServicioClienteCombos servicioClienteCombos, ServicioCarro servicioCarro) {
		this.servicioClienteCombos = servicioClienteCombos;
		this.servicioCarro = servicioCarro;
	}
	
	@RequestMapping("/combos")
	public ModelAndView irACombos(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
			List<Combo> combos = this.servicioClienteCombos.consultarCombos();
			ModelMap modelo = new ModelMap();
			if(combos.size() == 0) {
				String mensaje = "No hay combos disponibles";
				modelo.put("mensaje", mensaje);
			} else {
				modelo.put("combos", combos);
			}
			return new ModelAndView("combos", modelo);
		}
		else {
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(path = "/agregarACarrito", method = RequestMethod.GET)
	public ModelAndView validarAgregarACarrito(@RequestParam(value = "id", required = true) Long id, HttpServletRequest request) {
		
			String rol=(String)request.getSession().getAttribute("ROL");
		
			if(rol.equals("Cliente")) {
				List<Combo> carro = (List<Combo>) request.getSession().getAttribute("carro");
//				Long clienteId=(Long)request.getSession().getAttribute("ClienteId");
				Combo combo = servicioClienteCombos.obtenerComboPorId(id);
				carro.add(combo);
				request.getSession().setAttribute("carro", carro);
				servicioClienteCombos.actualizarStockDelCombo(id, -1);
//				Carro compras = servicioCarro.obtenerCarroPorClienteId(clienteId);
				
//				combo.setCompras(compras);
//				servicioClienteCombos.modificarCombo(combo);
				
				return new ModelAndView("redirect:/carrito");
			}
			else {
				return new ModelAndView("login");
			}
	}

}
