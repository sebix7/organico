package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Vendedor;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVendedor;
@Service
@Transactional
public class ServicioVendedorImpl implements ServicioVendedor {
	private RepositorioVendedor nuevo;
	
	@Autowired
	public ServicioVendedorImpl(RepositorioVendedor nuevo){
		this.nuevo = nuevo;
	}
	@Override
	public void guardarVendedor(Vendedor nuevo) {
		// TODO Auto-generated method stub
		this.nuevo.guardarVendedor(nuevo);

	}

}
