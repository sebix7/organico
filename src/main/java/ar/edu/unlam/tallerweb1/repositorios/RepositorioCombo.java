package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioCombo {
	 	Combo consultarCombo (Combo usuario);
	    void guardar(Combo usuario);
	    Combo buscar(String nombre);
	    void modificar(Combo usuario);
	    Combo buscarPorId(Long id);
	    List<Combo> consultarCombos();
	    List<Combo> consultarCombosPorId(Usuario entrada);
	    
}
