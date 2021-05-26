package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface RepositorioCarro {
	
	List<Combo> consultarProductosDelCarrito(Long id);
	void guardarCarro(Carro carro);
	Carro obtenerCarroPorClienteId(Long clienteId);
	
}
