package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;

@Repository
public class RepositorioClienteCombosImpl implements RepositorioClienteCombos {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioClienteCombosImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Combo> consultarCombos() {
		return this.sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.list();
	}

	@Override
	public Combo obtenerComboPorId(Long id) {
		return (Combo) this.sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificarCombo(Combo combo) {
		this.sessionFactory.getCurrentSession().update(combo);
	}

}
