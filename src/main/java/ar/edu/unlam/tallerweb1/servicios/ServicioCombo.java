package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCombo {
	

		Combo consultarCombo(Combo usuario);
		Combo buscarPorNombre(String nombre);
		void registro(Combo usuario);
		List<Combo> consultarCombos();
		void modificar(Combo combo);
		Combo buscarPorId(Long id);
		List<Combo> consultarCombosPorUs(Usuario entrada);


}
