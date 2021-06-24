package ar.edu.unlam.tallerweb1.repositorios;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;

public interface RepositorioComboCarro {

	ComboCarro obtenerComboCarro(Long id, Long id2);
	void modificarComboCarro(ComboCarro cc);
	void guardarComboCarro(ComboCarro cc);

}
