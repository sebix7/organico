package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;

@Repository
public class RepositorioCarroImpl implements RepositorioCarro {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioCarroImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Combo> consultarProductosDelCarrito(Long id) {		
		return this.sessionFactory.getCurrentSession().createCriteria(Combo.class)
			.createAlias("compras", "carro")
			.createAlias("carro.cliente", "cliente")
			.createAlias("cliente.usuario", "usuario")
			.add(Restrictions.eq("usuario.id", id))
			.list();
	}

	@Override
	public void guardarCarro(Carro carro) {
		this.sessionFactory.getCurrentSession().save(carro);
	}

	@Override
	public Carro obtenerCarroPorClienteId(Long clienteId) {
		return (Carro) this.sessionFactory.getCurrentSession().createCriteria(Carro.class)
			.createAlias("cliente", "cliente")
			.createAlias("cliente.usuario", "usuario")
			.add(Restrictions.eq("usuario.id", clienteId))
			.uniqueResult();
	}

}
