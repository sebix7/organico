package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface RepositorioClienteCombos {

	List<Combo> consultarCombos();
	Combo obtenerComboPorId(Long id);
	void modificarCombo(Combo combo);
	
}
