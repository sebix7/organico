package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface ServicioCarro {
	
	List<Combo> consultarProductosDelCarrito(Long id);
	void guardarCarro(Carro carro);
	Carro obtenerCarroPorClienteId(Long clienteId);

}
