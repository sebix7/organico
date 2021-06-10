package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
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

	@Override
	public void actualizarStockDelCombo(Long id, Integer i) {
		Combo combo = this.repositorioClienteCombos.obtenerComboPorId(id);
		combo.setStock(combo.getStock() + i);
		this.repositorioClienteCombos.modificarCombo(combo);		
	}
	
	@Override
	public void restaurarStockDeCombos(List<Combo> combos) {
		for (Combo combo : combos) {
			Combo aux = this.repositorioClienteCombos.obtenerComboPorId(combo.getId());
			aux.setStock(aux.getStock() + 1);
			this.repositorioClienteCombos.modificarCombo(aux);
		}
	}

}
