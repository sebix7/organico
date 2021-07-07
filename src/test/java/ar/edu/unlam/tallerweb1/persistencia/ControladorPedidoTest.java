package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorPedido;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;


public class ControladorPedidoTest {

	@Mock private HttpSession session;
	@Mock private HttpServletRequest request;
	@Mock private ServicioPedido servicioPedido;
	@Mock private ServicioLogin servicioLogin;

	@Mock private Usuario usuario;
	@InjectMocks private ControladorPedido controller;
	
	@Before
	public void inyeccionDeMocksInicializadaAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void UsuarioNoEsClienteNoPuedeIrALaVistaPedidos() {
		    when(request.getSession()).thenReturn(session);
		  
			when(session.getAttribute("ROL")).thenReturn("rol");
			when(session.getAttribute("ROL")).thenReturn("Vendedor");
			
			ModelAndView modelo = controller.pedidosCliente(request);
			assertThat(modelo.getViewName()).isEqualTo("login");
			assertThat(modelo.getModel()).isEmpty();
		
	}
	
	@Test
	public void IrALaVistaPedidosQueUsuarioSeaClienteYNoHayaRealizadoPedidos() {
		 when(request.getSession()).thenReturn(session);
		 
		 when(session.getAttribute("ROL")).thenReturn("rol");
		 when(session.getAttribute("ROL")).thenReturn("Cliente");
		 List<Pedido> pedidos = new ArrayList();
		 when(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("ClienteId")))
		.thenReturn(usuario);
		 when(servicioPedido.obtenerPedidosDelCliente(usuario.getId())).thenReturn(pedidos);
		 
		 ModelAndView modelo = controller.pedidosCliente(request);
		 assertThat(modelo.getViewName()).isEqualTo("pedidosCliente");
		 assertThat(modelo.getModel().get("mensaje")).isEqualTo("Aún no has hecho compras");
		 
		 
	}
	
	@Test
	public void IrALaVistaPedidosQueUsuarioSeaClienteYSiHayaRealizadoPedidos() {
		 when(request.getSession()).thenReturn(session);
		 
		 when(session.getAttribute("ROL")).thenReturn("rol");
		 when(session.getAttribute("ROL")).thenReturn("Cliente");
		 List<Pedido> pedidos = new ArrayList();
		
		 when(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("ClienteId")))
		.thenReturn(usuario);
		 
		Pedido pedido1= new Pedido();
		Pedido pedido2=new Pedido();
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		
		 when(servicioPedido.obtenerPedidosDelCliente(usuario.getId())).thenReturn(pedidos);
		
	
		 ModelAndView modelo = controller.pedidosCliente(request);
		 assertThat(modelo.getViewName()).isEqualTo("pedidosCliente");
		 assertThat(modelo.getModel().get("pedidos")).isEqualTo(pedidos);	 
	}
	
	@Test
	public void QueSeaClienteYPuedaIrALaVistaDetallePedido() {
         when(request.getSession()).thenReturn(session);
		 
		 when(session.getAttribute("ROL")).thenReturn("rol");
		 when(session.getAttribute("ROL")).thenReturn("Cliente");
		 
		 List<Combo> combos = new ArrayList();
		 Long IdCarro=8L;
		 when(servicioPedido.consultarCombosDelPedido(IdCarro)).thenReturn(combos);
		 
		 ModelAndView modelo = controller.detallePedido(IdCarro, request);
		 assertThat(modelo.getModel().get("carro")).isEqualTo(combos);
		 
	}
	
	@Test
	public void QueSePuedacancelarUnPedido() {
		 Long Idpedido=8L;
		 Pedido pedido = new Pedido();
		 when(servicioPedido.buscarPedidoPorId(Idpedido)).thenReturn(pedido);
		 
		 String modelo = controller.cancelaPedido(Idpedido);
		 
		 verify(servicioPedido, times(1)).actualizar(any(Pedido.class));
		 
		
	}
}
