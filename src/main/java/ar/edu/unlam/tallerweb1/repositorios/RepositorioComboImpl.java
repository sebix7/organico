package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
@Repository("repositorioCombo")
public class RepositorioComboImpl implements RepositorioCombo {
	private SessionFactory sessionFactory;
	
	  @Autowired
		public RepositorioComboImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
	@Override
	public Combo consultarCombo(Combo usuario) {
		final Session session = sessionFactory.getCurrentSession();
		return (Combo) session.createCriteria(Combo.class)
				.add(Restrictions.eq("nombre", usuario.getNombre()))
				.uniqueResult();
	}

	@Override
	public void guardar(Combo Combo) {
		sessionFactory.getCurrentSession().saveOrUpdate(Combo);

	}

	@Override
	public Combo buscar(String nombre) {
		return (Combo) sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
	}

	@Override
	public void modificar(Combo usuario) {
		sessionFactory.getCurrentSession().update(usuario);

	}

	@Override
	public List<Combo> consultarCombos() {
		return this.sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.list();
	}
	@Override
	public Combo buscarPorId(Long id) {
		return (Combo) sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.add(Restrictions.eq("id",id)).uniqueResult();
	}
	@Override
	public List<Combo> consultarCombosPorId(Usuario entrada) {
		return this.sessionFactory.getCurrentSession().createCriteria(Combo.class)
				.add(Restrictions.eq("usuario", entrada))
				.list();
	}


}
