package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Combo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class ControladorLoginTest {

	//@Mock
	//Nos permite realizar mocks anotando el código, y así el mismo queda más
	//claro y limpio.
	
	@Mock private HttpSession session;
	@Mock private HttpServletRequest request;
	@Mock private ServicioLogin servicioLogin;
	@Mock private ServicioCarro servicioCarro;
	@Mock private ServicioClienteCombos servicioClienteCombos;
	
	@Mock private Usuario usuario;
	@InjectMocks private ControladorLogin controller;
	
	@Before
	public void inyeccionDeMocksInicializadaAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testQueVerificaQueElLoginSeaValido(){
		when(request.getSession()).thenReturn(session);
		
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		
		when(usuario.getId()).thenReturn(91L);
		when(usuario.getEmail()).thenReturn("cliente@cliente.com");
		when(usuario.getPassword()).thenReturn("123");
		when(usuario.getRol()).thenReturn("Cliente");	
		
		when(session.getAttribute("ROL")).thenReturn("rol");
		when(session.getAttribute("ROL")).thenReturn("Cliente");

		ModelAndView modelo = controller.validarLogin(usuario, request);
	
		assertThat(modelo.getViewName()).isEqualTo("redirect:/homeCliente");
		assertThat(modelo.getModel()).isNotEmpty();
		
	
		verify(session, times(1)).setAttribute("userId", 91L);
		
	}
	
	
	@Test
	public void testQueVerificaQueElLoginSeaInvalido() {
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		
		ModelAndView modelo = controller.validarLogin(usuario, request);
		
		assertThat(modelo.getViewName()).isEqualTo("login");
		assertThat(modelo.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
		
		verify(session , never()).setAttribute("ROL", "Cliente");
		
	}
	
	@Test
	public void testQueVerificaQueHayaCerradoSesionCorrectamente() {
		
		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("carro")).thenReturn("carro");

		List<Combo> combos = new ArrayList<Combo>();
		
		when(request.getSession().getAttribute("carro")).thenReturn(combos);
		ModelAndView modelo = controller.cerrarSession(request);
		
		assertThat(modelo.getViewName()).isEqualTo("redirect:/index");
	
	}
	
	
	@Test
	public void testQueVerificaQueSePuedaEnviarARegistrar() {		
		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("carro")).thenReturn(null);
		List<Combo> combos = new ArrayList<Combo>();
		when(request.getSession().getAttribute("carro")).thenReturn(combos);
		Usuario usuario = new Usuario();
		
		ModelAndView modelo = controller.registro(request);
		assertThat(modelo.getViewName()).isEqualTo("registroUsuario");
		assertThat(modelo.getModel().get("usuario")).isEqualTo(usuario);
	}
	
	
	@Test
	public void testQueActualiceElPerfilCorrectamente() {
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("userId")).thenReturn(8L);
		when(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId")))
		.thenReturn(usuario);
		when(usuario.getId()).thenReturn(8L);
		when(session.getAttribute("ROL")).thenReturn("rol");
		
		
		ModelAndView modelo = controller.actualizarPerfil(usuario, request);
		assertThat(modelo.getModel().get("mensaje")).isEqualTo("Se actualizo correctamente");
		assertThat(modelo.getModel().get("usuario")).isEqualTo(usuario);
		
		//se verifica la cantidad de llamadas
		verify(servicioLogin, times(2)).buscarPorId(any(Long.class));
		verify(servicioLogin, times(1)).actualizar(any(Usuario.class));	
	}
	
	@Test
	public void testQueFallaLaActualizacion(){
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("userId")).thenReturn(-1L);
		when(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId")))
			.thenReturn(usuario);
		when(usuario.getId()).thenReturn(null);
		
		ModelAndView modelo = controller.actualizarPerfil(usuario, request);
		assertThat(modelo.getModel().get("mensaje")).isEqualTo("No se pudo actualizar");
		assertThat(modelo.getModel().get("usuario")).isEqualTo(usuario);
		
		verify(servicioLogin, times(2)).buscarPorId(any(Long.class));
		verify(servicioLogin, never()).actualizar(any(Usuario.class));
	}
}
