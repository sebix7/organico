package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
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

import ar.edu.unlam.tallerweb1.controladores.ControladorAdmin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorAdminTest {
	
	@Mock private HttpSession session;
	@Mock private HttpServletRequest request;
	@Mock private ServicioLogin servicioLogin;

	@Mock private Usuario usuario;
	@InjectMocks private ControladorAdmin controller;
	
	@Before
	public void inyeccionDeMocksInicializadaAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void UsuarioQueNoEsAdminNoPuedeIrALaVistaHomeAdmin() {
		
		 when(request.getSession()).thenReturn(session);
		  
			when(session.getAttribute("ROL")).thenReturn("rol");
			when(session.getAttribute("ROL")).thenReturn("Vendedor");
			
			ModelAndView modelo = controller.irAHomeAdministrador(request);
			assertThat(modelo.getViewName()).isEqualTo("redirect:/login");
	}
	
	@Test
	public void UsuarioQueEsAdminIrALaVistaHomeAdmin() {
		
		 when(request.getSession()).thenReturn(session);
		  
			when(session.getAttribute("ROL")).thenReturn("rol");
			when(session.getAttribute("ROL")).thenReturn("Administrador");
			
			ModelAndView modelo = controller.irAHomeAdministrador(request);
			assertThat(modelo.getViewName()).isEqualTo("homeAdministrador");
		
	}
	
	@Test
	public void UsuarioQueEsAdminIrALaVistaUsuarios() {
		 when(request.getSession()).thenReturn(session);
		  
			when(session.getAttribute("ROL")).thenReturn("rol");
			when(session.getAttribute("ROL")).thenReturn("Administrador");
			
			List<Usuario> busqueda = new ArrayList();
			when(servicioLogin.listarTodos()).thenReturn(busqueda);
			
			ModelAndView modelo = controller.irAClientes(request);
			assertThat(modelo.getViewName()).isEqualTo("usuarios");
			assertThat(modelo.getModel().get("busqueda")).isEqualTo(busqueda);	
			
	}
	

}
