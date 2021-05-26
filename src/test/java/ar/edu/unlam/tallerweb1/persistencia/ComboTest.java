package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Vendedor;

public class ComboTest extends SpringTest {
	@Test
	@Transactional
	@Rollback(true)
	public void QueSePuedaCrearUnComboTest() {
	//declaramos e inicializamos
	Vendedor vendedor1 = new Vendedor();
	//Carro carro1=new Carro();	
	Combo combo1=new Combo();
	
	//seteamos
	combo1.setNombre("ComboPrimavera");
	combo1.setEstacion("Primavera");
	combo1.setVendedor(vendedor1);
	//combo1.setCompras(carro1);
	
	//guardamos
	session().save(vendedor1);
	//session().save(carro1);
	session().save(combo1);
	
	assertThat(combo1.getId()).isNotNull();
	
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void QueMeMuestreTodosLosCombosPrimaveraCreados() {	
		
		//declaramos e inicializamos
		Vendedor vendedor2 = new Vendedor();
		Combo combo4= new Combo();
		Combo combo2= new Combo();
		Combo combo3= new Combo();
		//seteamos
		combo4.setNombre("ComboPrimavera");
		combo4.setEstacion("Primavera");
		combo4.setVendedor(vendedor2);
		
		combo2.setNombre("ComboVerano");
		combo2.setEstacion("Verano");
		combo2.setVendedor(vendedor2);
		
		combo3.setNombre("ComboFrutal");
		combo3.setEstacion("Primavera");
		combo3.setVendedor(vendedor2);
		//guardamos
		
		session().save(combo4);
		session().save(combo2);
		session().save(combo3);
		session().save(vendedor2);
		
		List<Combo> resultado;
		resultado=session().createCriteria(Combo.class)
				.add(Restrictions.eq("estacion","Primavera"))
				.list();
		
		assertThat(resultado).hasSize(2);
		
		for(Combo lista :resultado) {
			assertEquals("Primavera",lista.getEstacion());
		}	

	}
	
}
