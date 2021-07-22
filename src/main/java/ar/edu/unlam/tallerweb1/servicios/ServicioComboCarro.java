package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;

public interface ServicioComboCarro {

	void guardarComboCarro(Carro carro, List<Combo> combos);
	ComboCarro obtenerComboCarro(Long carroId, Long comboId);
	List<ComboCarro> obtenerComboCarrosDelCarro(Long carroId);

}
