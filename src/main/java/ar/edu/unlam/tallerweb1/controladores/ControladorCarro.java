package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorCarro {
	
	private ServicioCarro servicioCarro;
	private ServicioLogin servicioLogin;
	private ServicioPedido servicioPedido;

	@Autowired
	public ControladorCarro(ServicioCarro servicioCarro, ServicioLogin servicioLogin, ServicioPedido servicioPedido) {
		this.servicioCarro = servicioCarro;
		this.servicioLogin = servicioLogin;
		this.servicioPedido = servicioPedido;
	}
	
	@RequestMapping("/carrito")
	public ModelAndView irACarrito(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
//			Long id=(Long)request.getSession().getAttribute("ClienteId");
			List<Combo> combos = (List<Combo>) request.getSession().getAttribute("carro");
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
	
	@RequestMapping("/validar-comprar-carro")
	public ModelAndView comprarCarrito(HttpServletRequest request) {
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
			ModelMap modelo = new ModelMap();
			List<Combo> combos = (List<Combo>) request.getSession().getAttribute("carro");
			Usuario usuario = this.servicioLogin.buscarPorMail((String)request.getSession().getAttribute("EMAIL"));
			Carro carrito = new Carro();
			Pedido pedido = new Pedido();
			carrito.setUsuario(usuario);
			carrito.setCombos(combos);
			this.servicioCarro.guardarCarro(carrito);
			pedido.setFechaDeEmision(new Date());
			pedido.setEstado("Pago");
			pedido.setCarro(carrito);
			this.servicioPedido.guardarPedido(pedido);
			request.getSession().setAttribute("carro", null);
			if(request.getSession().getAttribute("carro") == null) {
				List<Combo> carro = new ArrayList<Combo>();
				request.getSession().setAttribute("carro", carro);
			}
			
			modelo.put("mensaje2","Gracias por su compra!");
			return new ModelAndView("carrito", modelo);
		} else {
			return new ModelAndView("login");
		}
		
		
	}

}
