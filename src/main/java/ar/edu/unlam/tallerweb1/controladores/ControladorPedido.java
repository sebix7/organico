package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioComboCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;

@Controller
public class ControladorPedido {
	private ServicioPedido servicioPedido;
	private ServicioLogin servicioLogin;
	private ServicioComboCarro servicioComboCarro;
	private ServicioClienteCombos servicioClienteCombos;

	@Autowired
	public ControladorPedido(ServicioPedido servicioPedido,ServicioLogin servicioLogin,ServicioComboCarro servicioComboCarro,ServicioClienteCombos servicioClienteCombos) {
		this.servicioPedido = servicioPedido;
		this.servicioLogin=servicioLogin;
		this.servicioComboCarro = servicioComboCarro;
		this.servicioClienteCombos = servicioClienteCombos;
	}
	
	
	@RequestMapping(path="pedidosCliente")
	public ModelAndView pedidosCliente(HttpServletRequest request) {
		
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
//			Long id=(Long)request.getSession().getAttribute("ClienteId");
			Usuario usuario= servicioLogin.buscarPorId((Long) request.getSession().getAttribute("ClienteId"));
			List<Pedido> pedidos = this.servicioPedido.obtenerPedidosDelCliente(usuario.getId());
			
			ModelMap modelo = new ModelMap();
			if(pedidos.size() == 0) {
				String mensaje = "Aún no has hecho compras";
				modelo.put("mensaje", mensaje);
			} else {
				modelo.put("pedidos", pedidos);
			}
			return new ModelAndView("pedidosCliente", modelo);
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(path="pedidosVendedor")
	public ModelAndView pedidosVendedor(HttpServletRequest request) {
		
		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Vendedor")) {
//			Long id=(Long)request.getSession().getAttribute("ClienteId");
			Usuario usuario= servicioLogin.buscarPorId((Long) request.getSession().getAttribute("VendedorId"));
			List<Pedido> pedidos = this.servicioPedido.obtenerPedidosDelVendedor(usuario.getId());
			
			ModelMap modelo = new ModelMap();
			if(pedidos.size() == 0) {
				String mensaje = "Aún no has recibido pedidos";
				modelo.put("mensaje", mensaje);
			} else {
				modelo.put("pedidos", pedidos);
			}
			return new ModelAndView("pedidosVendedor", modelo);
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(path = "/detallePedido", method = RequestMethod.GET)
	public ModelAndView detallePedido(@RequestParam(value = "id", required = true) Long id, HttpServletRequest request) {
		
			String rol=(String)request.getSession().getAttribute("ROL");
		
			if(rol.equals("Cliente") || rol.equals("Vendedor")) {
				ModelMap modelo = new ModelMap();
				List<Combo> combos = servicioPedido.consultarCombosDelPedido(id);
				modelo.put("carro", combos);
				return new ModelAndView("detallePedido", modelo);
			} else {
				return new ModelAndView("login");
			}
	}
	
	//action que cambia la entrega del pedido a cancelado
		@RequestMapping(value = "/cancelarPedido", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String cancelaPedido(@RequestParam("id") Long idpedido) {

			  List<Combo> combos = new ArrayList<Combo>();
		      Pedido pedido =servicioPedido.buscarPedidoPorId(idpedido);
		      List<ComboCarro> combocarro = servicioComboCarro.obtenerComboCarrosDelCarro(pedido.getCarro().getId());
		      for (ComboCarro cc : combocarro) {
		    	  for (int i = 0; i < cc.getCantidad(); i++) {
		    		  combos.add(cc.getCombo());
		    	  }
		      }
		      this.servicioClienteCombos.restaurarStockDeCombos(combos);
		      pedido.setEntrega("Cancelado");
		      servicioPedido.actualizar(pedido);	
			
			return null; 
		}
	
		//action que cambia la entrega del pedido a cancelado
		@RequestMapping(value = "/entregarPedido", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String entregaPedido(@RequestParam("id") Long idpedido) {

		      Pedido pedido =servicioPedido.buscarPedidoPorId(idpedido);
		      pedido.setEntrega("Entregado");
		      servicioPedido.actualizar(pedido);	
			
			return null; 
		}
	
	

}
