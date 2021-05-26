package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface ServicioClienteCombos {

	List<Combo> consultarCombos();
	Combo obtenerComboPorId(Long id);
	void modificarCombo(Combo combo);
	
}
