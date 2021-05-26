package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioClienteCombos;

@Service
@Transactional
public class ServicioClienteCombosImpl implements ServicioClienteCombos {

	private RepositorioClienteCombos repositorioClienteCombos;
	
	@Autowired
	public ServicioClienteCombosImpl(RepositorioClienteCombos repositorioClienteCombos) {
		this.repositorioClienteCombos = repositorioClienteCombos;
	}
	
	@Override
	public List<Combo> consultarCombos() {
		return this.repositorioClienteCombos.consultarCombos();
	}

	@Override
	public Combo obtenerComboPorId(Long id) {
		return this.repositorioClienteCombos.obtenerComboPorId(id);
	}

	@Override
	public void modificarCombo(Combo combo) {
		this.repositorioClienteCombos.modificarCombo(combo);
	}

}
