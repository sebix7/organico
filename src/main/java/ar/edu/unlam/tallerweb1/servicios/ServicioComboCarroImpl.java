package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComboCarro;

@Service
@Transactional
public class ServicioComboCarroImpl implements ServicioComboCarro {
	
	private RepositorioComboCarro repositorioComboCarro;
	
	@Autowired
	public ServicioComboCarroImpl(RepositorioComboCarro repositorioComboCarro) {
		this.repositorioComboCarro = repositorioComboCarro;
	}

	@Override
	public void guardarComboCarro(Carro carro, List<Combo> combos) {
		for (Combo combo : combos) {
			ComboCarro cc = this.repositorioComboCarro.obtenerComboCarro(carro.getId(), combo.getId());
			if(cc != null) {
				cc.setCantidad(cc.getCantidad() + 1);
				this.repositorioComboCarro.modificarComboCarro(cc);
			} else if(cc == null) {
				cc = new ComboCarro();
				cc.setCantidad(1);
				cc.setCarro(carro);
				cc.setCombo(combo);
				this.repositorioComboCarro.guardarComboCarro(cc);
			}
		}
	}

	public void modificarComboCarro(ComboCarro cc) {
		this.repositorioComboCarro.modificarComboCarro(cc);
	}

	@Override
	public ComboCarro obtenerComboCarro(Long carroId, Long comboId) {
		return this.obtenerComboCarro(carroId, comboId);
	}

}
