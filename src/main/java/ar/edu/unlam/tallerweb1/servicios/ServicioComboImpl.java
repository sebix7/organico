package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCombo;

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
	public List<Combo> consultarCombos() {
		return this.nuevo.consultarCombos();
	}
	@Override
	public Combo buscarPorNombre(String nombre) {
		return this.nuevo.buscar(nombre);
	}
	@Override
	public void modificar(Combo combo) {
		this.nuevo.modificar(combo);
		
	}
	@Override
	public Combo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return nuevo.buscarPorId(id);
	}
	@Override
	public List<Combo> consultarCombosPorUs(Usuario entrada) {
		return nuevo.consultarCombosPorId(entrada);
	}

}
