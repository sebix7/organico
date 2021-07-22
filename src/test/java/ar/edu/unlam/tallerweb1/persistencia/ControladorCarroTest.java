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

import ar.edu.unlam.tallerweb1.controladores.ControladorCarro;
import ar.edu.unlam.tallerweb1.modelo.Combo;

public class ControladorCarroTest {
	
	@Mock private HttpSession session;
	@Mock private HttpServletRequest request;
	
	@InjectMocks private ControladorCarro controller;
	
	@Before
	public void inyeccionDeMocksInicializadaAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void QueMuestreMensajeCuandoCarroEstaVacio() {
		
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("ROL")).thenReturn("rol");
		when(session.getAttribute("ROL")).thenReturn("Cliente");

		List<Combo> combos = new ArrayList<Combo>();
		when(session.getAttribute("carro")).thenReturn(combos);
		
		ModelAndView modelo = controller.irACarrito(request);
		when(combos.size()).thenReturn(0);
		assertThat(modelo.getModel().get("mensaje")).isEqualTo("No hay items en el carrito");
		assertThat(modelo.getViewName()).isEqualTo("carrito");
		
	}
	
	@Test
	public void QueMuestreCombosCuandoCarroNoEstaVacio() {
		
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("ROL")).thenReturn("rol");
		when(session.getAttribute("ROL")).thenReturn("Cliente");

		List<Combo> combos = new ArrayList<Combo>();
		Combo combo = new Combo();
		combos.add(combo);
		when(session.getAttribute("carro")).thenReturn(combos);
		
		ModelAndView modelo = controller.irACarrito(request);
		when(combos.size()).thenReturn(1);
		assertThat(modelo.getModel().get("combos")).isEqualTo(combos);
		assertThat(modelo.getViewName()).isEqualTo("carrito");
		
	}
	
	
}
