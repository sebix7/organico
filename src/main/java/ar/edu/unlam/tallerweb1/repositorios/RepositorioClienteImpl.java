package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Repository
public class RepositorioClienteImpl implements RepositorioCliente {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioClienteImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void guardarCliente(Cliente cliente) {
		this.sessionFactory.getCurrentSession().save(cliente);
	}
}
