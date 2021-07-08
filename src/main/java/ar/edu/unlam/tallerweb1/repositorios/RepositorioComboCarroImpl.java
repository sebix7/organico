package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;

@Repository
public class RepositorioComboCarroImpl implements RepositorioComboCarro {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioComboCarroImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ComboCarro obtenerComboCarro(Long id, Long id2) {
		return (ComboCarro) this.sessionFactory.getCurrentSession().createCriteria(ComboCarro.class)
				.createAlias("carro", "carro")
				.createAlias("combo", "combo")
				.add(Restrictions.eq("carro.id", id))
				.add(Restrictions.eq("combo.id", id2))
				.uniqueResult();
	}

	@Override
	public void modificarComboCarro(ComboCarro cc) {
		sessionFactory.getCurrentSession().update(cc);
	}

	@Override
	public void guardarComboCarro(ComboCarro cc) {
		sessionFactory.getCurrentSession().save(cc);
	}

	@Override
	public List<ComboCarro> obtenerComboCarrosDelCarro(Long carroId) {
		return this.sessionFactory.getCurrentSession().createCriteria(ComboCarro.class)
				.createAlias("carro", "carro")
				.add(Restrictions.eq("carro.id", carroId))
				.list();
	}

}
