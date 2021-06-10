package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioClienteCombos;

@Service
@Transactional
public class ServicioCarroImpl implements ServicioCarro {

	private RepositorioCarro repositorioCarro;
	private RepositorioClienteCombos repositorioClienteCombos;
	
	@Autowired
	public ServicioCarroImpl(RepositorioCarro repositorioCarro) {
		this.repositorioCarro = repositorioCarro;
	}
	
	@Override
	public List<Combo> consultarProductosDelCarrito(Long id) {
		return this.repositorioCarro.consultarProductosDelCarrito(id);
	}

	@Override
	public void guardarCarro(Carro carro) {
		this.repositorioCarro.guardarCarro(carro);
		
	}

	@Override
	public Carro obtenerCarroPorClienteId(Long clienteId) {
		return this.repositorioCarro.obtenerCarroPorClienteId(clienteId);
	}

}
