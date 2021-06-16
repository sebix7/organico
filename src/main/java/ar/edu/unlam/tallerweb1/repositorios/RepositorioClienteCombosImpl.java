package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;
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
	
	@Override
	public void guardarValoracion(ValorarCombo nuevaValoracion) {
		sessionFactory.getCurrentSession().save(nuevaValoracion);
	}

	@Override
	public List<ValorarCombo> obtenerValoracionesPositivas(Long idcombo) {
		    
		List<ValorarCombo>resultado;
		resultado=sessionFactory.getCurrentSession().createCriteria(ValorarCombo.class)
				.createAlias("combo", "comb")
				.add(Restrictions.eq("comb.id",idcombo))
				.add(Restrictions.eq("valoracion", true))
				.list();	
		
		return resultado;
	}

	@Override
	public List<ValorarCombo> obtenerValoracionesNegativas(Long idcombo) {
		
		List<ValorarCombo>resultado;
		resultado=sessionFactory.getCurrentSession().createCriteria(ValorarCombo.class)
				.createAlias("combo", "comb")
				.add(Restrictions.eq("comb.id",idcombo))
				.add(Restrictions.eq("valoracion", false))
				.list();	
		
		return resultado;
	}

}
