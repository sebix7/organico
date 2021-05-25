package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vegetal;
@Repository("repositorioVegetal")
public class RepositorioVegetalImpl implements RepositorioVegetal {
	private SessionFactory sessionFactory;
	
	 @Autowired
		public RepositorioVegetalImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
	}
	@Override
	public Vegetal consultarVegetal(Vegetal usuario) {
		// TODO Auto-generated method stub
		final Session session = sessionFactory.getCurrentSession();
		return (Vegetal) session.createCriteria(Vegetal.class)
				.add(Restrictions.eq("nombreDelProducto", usuario.getNombreDelProducto()))
				.add(Restrictions.eq("precio", usuario.getPrecio()))
				.uniqueResult();
	}

	@Override
	public void guardar(Vegetal usuario) {
		
		sessionFactory.getCurrentSession().save(usuario);

	}

	@Override
	public Vegetal buscar(String nombre) {
		
		return (Vegetal) sessionFactory.getCurrentSession().createCriteria(Vegetal.class)
				.add(Restrictions.eq("nombreDelProducto", nombre))
				.uniqueResult();
	}

	@Override
	public void modificar(Vegetal usuario) {
		
		sessionFactory.getCurrentSession().update(usuario);

	}

}
