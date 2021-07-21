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

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.VerDetalleViewModel;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorCliente {
	private ServicioCombo servicioCombo;
	private ServicioLogin servicioLogin;
	private ServicioClienteCombos servicioClienteCombos;
	
	@Autowired
	public ControladorCliente(ServicioCombo servicioCombo,ServicioLogin servicioLogin,ServicioClienteCombos servicioClienteCombos){
		this.servicioCombo = servicioCombo;
		this.servicioLogin=servicioLogin;
		this.servicioClienteCombos = servicioClienteCombos;
		
	}
	@RequestMapping("/homeCliente")
	public ModelAndView home(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
			  Usuario usuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
			     ModelMap modelo = new ModelMap();
			     
			     if(usuario.isActivo())
			     {
			          List<Combo> combos = this.servicioCombo.consultarCombosSinDescuento();
			         
			          
			          List<Combo> combos2 = this.servicioCombo.consultarCombosConDescuento();
			          
			          if(combos.size() == 0) {
				      String mensaje = "No hay combos disponibles";
			    	  modelo.put("mensaje", mensaje);
			          } else {
				      modelo.put("combos", combos);
				      modelo.put("combos2", combos2);
		        	  }
			     
			        return new ModelAndView("homeCliente", modelo);
			     }
			     else
			     {
			    	 String mensajeActivo="Usted es un usuario no activo. Por el momento no puede realizar ninguna compra";
			    	 modelo.put("mensajeActivo", mensajeActivo);
			    	 return new ModelAndView("combos", modelo);
			     }
		}
		else {
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(path = "/agregarACarrito2", method = RequestMethod.GET)
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
				
				return new ModelAndView("redirect:/homeCliente");
			}
			else {
				return new ModelAndView("login");
			}
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
