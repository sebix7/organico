package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface RepositorioCombo {
	 	Combo consultarCombo (Combo usuario);
	    void guardar(Combo usuario);
	    Combo buscar(String nombre);
	    void modificar(Combo usuario);
	    List ver();
}
