package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;

@Service
@Transactional
public class ServicioClienteImpl implements ServicioCliente {

	private RepositorioCliente servicioClienteDao;

	@Autowired
	public ServicioClienteImpl(RepositorioCliente servicioClienteDao){
		this.servicioClienteDao = servicioClienteDao;
	}
	
	@Override
	public void guardarCliente(Cliente cliente) {
		this.servicioClienteDao.guardarCliente(cliente);
	}
	
}
