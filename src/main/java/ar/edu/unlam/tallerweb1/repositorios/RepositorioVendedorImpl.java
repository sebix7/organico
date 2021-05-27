package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Vendedor;
@Repository("repositorioVendedor")
public class RepositorioVendedorImpl implements RepositorioVendedor {
	private SessionFactory sessionFactory;
	 @Autowired
		public RepositorioVendedorImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
	@Override
	public void guardarVendedor(Vendedor nuevo) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(nuevo);
	}

}
