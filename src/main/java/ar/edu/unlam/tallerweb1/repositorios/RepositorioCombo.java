package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioCombo {
	 	Combo consultarCombo (Combo usuario);
	    void guardar(Combo usuario);
	    Combo buscar(String nombre);
	    List<Combo> buscarPorEstacion(String estacion);
	    void modificar(Combo usuario);
	    Combo buscarPorId(Long id);
	    List<Combo> consultarCombos();
	    List<Combo> consultarCombosConDireccion();
	    List<Combo> consultarCombosConDescuento();
	    List<Combo> consultarCombosSinDescuento();
	    List<Combo> consultarCombosPorId(Usuario entrada);
	    List<Combo> consultarCombosPorEstacionYDescuentoSi(String estacion,Usuario email);
	    List<Combo> consultarCombosPorEstacionYDescuentoNo(String estacion,Usuario email);
	    
}
