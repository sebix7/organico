package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCombo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVegetal;
@Service("servicioCombo")
@Transactional
public class ServicioComboImpl implements ServicioCombo {
	
	private RepositorioCombo nuevo;
	
	@Autowired
	public ServicioComboImpl(RepositorioCombo nuevo){
		this.nuevo = nuevo;
	}
	@Override
	public Combo consultarCombo(Combo usuario) {
	
		return nuevo.consultarCombo(usuario);
	}

	@Override
	public void registro(Combo usuario1) {
	
		nuevo.guardar(usuario1);
	}
	@Override
	public List ver() {
		
		return nuevo.ver();
	}

}
