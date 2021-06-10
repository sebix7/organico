package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

@Repository
public class RepositorioPedidoImpl implements RepositorioPedido {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioPedidoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void guardarPedido(Pedido pedido) {
		this.sessionFactory.getCurrentSession().save(pedido);
	}

}
