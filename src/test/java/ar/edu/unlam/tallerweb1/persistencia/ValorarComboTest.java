package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;

public class ValorarComboTest extends SpringTest{
	
	@Test
	@Transactional
	@Rollback(true)
	public void testBusqueTodosCombosValoracionPositiva() {
		
		//Declarar
				Combo combo1;
				Combo combo2;
				ValorarCombo val1,val2,val3;
				Session session = session();
		
		//inicializamos
			
				combo1= new Combo();
				combo2 = new Combo();
				val1  = new ValorarCombo();
				val2  = new ValorarCombo();
			    val3  = new ValorarCombo();
		//seteamos   
			    
			    combo1.setEstacion("primavera");
			     combo1.setNombre("combo1");
			       
			    combo2.setEstacion("verano");
		        combo2.setNombre("combo2");
		        
			    val1.setValoracion(false);
			    val2.setValoracion(false);
			    val3.setValoracion(true);
			    
			    val1.setCombo(combo1);
			    val2.setCombo(combo2);
			    val3.setCombo(combo1);
			    
		//guardar
			    session.save(combo1);
			    session.save(combo2);
			    session.save(val1);
			    session.save(val2);
			    session.save(val3);
			    
			    
				List<ValorarCombo>resultado;
				resultado=session.createCriteria(ValorarCombo.class)
						.createAlias("combo", "comb")
					    .add(Restrictions.eq("comb.nombre","combo1"))
						.add(Restrictions.eq("valoracion", true))
						.list();
				
				assertThat(resultado).hasSize(1);
			    
				Integer positivos=0;
			
				for(ValorarCombo lista : resultado) {
					System.out.println(lista.isValoracion());
					System.out.println(lista.getCombo().getId());
					positivos ++;
				}
			    
				System.out.println("Los Positivos son : "+ positivos);
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testBusqueTodosCombosValoracionNegativa() {
		
		//Declarar
		Combo combo1;
		Combo combo2;
		ValorarCombo val1,val2,val3;
		Session session = session();

//inicializamos
	
		combo1= new Combo();
		combo2 = new Combo();
		val1  = new ValorarCombo();
		val2  = new ValorarCombo();
	    val3  = new ValorarCombo();
//seteamos   
	    
	      combo1.setEstacion("primavera");
	       combo1.setNombre("combo1");
	       
	       combo2.setEstacion("verano");
	       combo2.setNombre("combo2");
	       
	    val1.setValoracion(false);
	    val2.setValoracion(false);
	    val3.setValoracion(true);
	    
	    val1.setCombo(combo1);
	    val2.setCombo(combo2);
	    val3.setCombo(combo1);
	    
//guardar
	    session.save(combo1);
	    session.save(combo2);
	    session.save(val1);
	    session.save(val2);
	    session.save(val3);
	    
		List<ValorarCombo>resultado;
		resultado=session.createCriteria(ValorarCombo.class)
				.createAlias("combo", "comb")
				.add(Restrictions.eq("comb.nombre","combo1"))
				.add(Restrictions.eq("valoracion",false))
				.list();
		
		assertThat(resultado).hasSize(1);
	    
		Integer negativos=0;
	
		for(ValorarCombo lista : resultado) {
			System.out.println(lista.isValoracion());
			System.out.println(lista.getCombo().getId());
			negativos ++;
		}
	    
		System.out.println("Los Negativos son : "+ negativos);
		
	}

}
