package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Vegetal;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVegetal;
@Service("servicioVegetal")
@Transactional
public class ServicioVegetalImpl implements ServicioVegetal {
	
	private RepositorioVegetal nuevo;
	
	@Autowired
	public ServicioVegetalImpl(RepositorioVegetal nuevo){
		this.nuevo = nuevo;
	}
	
	@Override
	public Vegetal consultarUsuario(Vegetal usuario) {
		// TODO Auto-generated method stub
		return nuevo.consultarVegetal(usuario);
	}

	@Override
	public void registro(Vegetal usuario) {
		// TODO Auto-generated method stub
		nuevo.guardar(usuario);
	}

}
