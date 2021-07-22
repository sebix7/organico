package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCombo {
	

		Combo consultarCombo(Combo usuario);
		Combo buscarPorNombre(String nombre);
		void registro(Combo usuario);
		List<Combo> consultarCombos();
		List<Combo> consultarCombosPorEstacion(String estacion);
		void modificar(Combo combo);
		Combo buscarPorId(Long id);
		List<Combo> consultarCombosPorUs(Usuario entrada);
		void aplicarDescuento(Long descuento,Long id);
		List<Combo> consultarCombosConDescuento();
		List<Combo> consultarCombosSinDescuento();
		List<Combo> Obtener3CombosConMenorPrecio();
		List<Combo> ordenarPorDistancia(Double lat,Double lng);
	    List<Combo> consultarCombosPorEstacionYDescuentoSi(String estacion,Usuario a);
	    List<Combo> consultarCombosPorEstacionYDescuentoNo(String estacion,Usuario a);


}
