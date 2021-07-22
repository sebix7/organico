package ar.edu.unlam.tallerweb1.persistencia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.controladores.ControladorVendedor;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorVendedorTest {
	
	
	private ControladorVendedor controladorVendedor;
	private ServicioCombo servicioComboMock;
	private HttpSession sessionMock;
	private ServicioLogin servicioLoginMock;
	private ServicioClienteCombos servicioClienteCombosMock;
	private HttpServletRequest requestMock;
	private Combo ComboMock;
	private ModelAndView mavMock;



	@Before
	public void init() {
	requestMock = mock(HttpServletRequest.class);
	sessionMock = mock(HttpSession.class);
	servicioComboMock = mock(ServicioCombo.class);
	servicioLoginMock = mock(ServicioLogin.class);
	servicioClienteCombosMock = mock(ServicioClienteCombos.class);
	ComboMock = mock(Combo.class);
	controladorVendedor = new ControladorVendedor(servicioComboMock, servicioLoginMock,servicioClienteCombosMock);
	}
	
	@Test
	public void testQueVerificaQueSeCreeUnCombo() {
		
		givenUnaSession();

		whenPreparoUnaVista();

		thenSeMuestraVistaCreacionCombo();
	}

	private void thenSeMuestraVistaCreacionCombo() {
		assertThat(mavMock.getViewName()).isEqualTo("creacionCombo");
		
	}

	private void whenPreparoUnaVista() {
		mavMock = controladorVendedor.creacionCombos(requestMock);
		
	}

	private void givenUnaSession() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(sessionMock.getAttribute(anyString())).thenReturn("Vendedor");
	}
	
	
	
}
