package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;
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

	@Override
	public List<Pedido> obtenerPedidosDelCliente(Long clienteId) {
		return this.sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				.createAlias("carro", "carro")
				.createAlias("carro.usuario", "usuario")
				.add(Restrictions.eq("usuario.id", clienteId))
				.list();
	}

	@Override
	public List<ComboCarro> obtenerComboCarrosVinculadosAlPedido(Long carroId) {
		return this.sessionFactory.getCurrentSession().createCriteria(ComboCarro.class)
				.createAlias("carro", "carro")
				.add(Restrictions.eq("carro.id", carroId))
				.list();
	}

}
