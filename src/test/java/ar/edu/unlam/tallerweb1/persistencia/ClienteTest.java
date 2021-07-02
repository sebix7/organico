package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class ClienteTest extends SpringTest {
	
	@Test
    @Transactional @Rollback
    public void testQueCreaUnCliente(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("Cliente");
        
        session().save(usuario);
        
        Usuario usuarioGuardado =session().get(Usuario.class,1L);
        
        
        assertEquals(usuarioGuardado.getEmail(),"seba@gmail.com");
     
    }

//	@Test
//    @Transactional @Rollback
//    public void testQueAgregaUnComboAlCarritoDelCliente(){
//		Usuario usuario = new Usuario();
//		Carro carro = new Carro();
//
//		session().save(usuario);
//		
//		carro.setUsuario(usuario);
//		
//		session().save(carro);
//		
//		Combo combo1 = new Combo();
//		
//		combo1.setCompras(carro);
//		
//		session().save(combo1);
//		
//		assertEquals(combo1.getCompras().getId(), carro.getId());
//	}
	
//	@Test
//    @Transactional @Rollback
//    public void testQueListaLosCombosQueEstanEnElCarritoDelCliente(){
//		Usuario usuario = new Usuario();
//		Carro carro = new Carro();
//
//		session().save(usuario);
//		
//		carro.setUsuario(usuario);
//		
//		session().save(carro);
//		
//		Combo combo1 = new Combo();
//		
//		combo1.setCompras(carro);
//		
//		session().save(combo1);
//		
//		List<Combo> combosDelCarrito;
//		combosDelCarrito = session().createCriteria(Combo.class)
//				.createAlias("compras", "carro")
//				.createAlias("cliente.usuario", "usuario")
//				.add(Restrictions.eq("usuario.id", usuario.getId()))
//				.list();
//		
//		assertEquals(combosDelCarrito.size(), 1);
//	}
    
//	@Test
//    @Transactional @Rollback
//    public void testQueListaLosCombosQueNoEstanEnElCarritoDeNingunCliente(){
//		Usuario usuario = new Usuario();
//		Carro carro = new Carro();
//		
//		Usuario usuario2 = new Usuario();
//		Carro carro2 = new Carro();
//
//		session().save(usuario);
//		session().save(usuario2);
//
//		carro.setUsuario(usuario);		
//		carro2.setUsuario(usuario2);
//		
//		session().save(carro);
//		session().save(carro2);
//		
//		Combo combo1 = new Combo();
//		Combo combo2 = new Combo();
//		Combo combo3 = new Combo();
//		Combo combo4 = new Combo();
//		
//		combo1.setCompras(carro);
//		combo2.setCompras(carro2);
//		
//		session().save(combo1);
//		session().save(combo2);
//		session().save(combo3);
//		session().save(combo4);
//		
//		List<Combo> combosNoReservados;
//		combosNoReservados = session().createCriteria(Combo.class)
//				.add(Restrictions.isNull("compras"))
//				.list();
//		
//		assertEquals(combosNoReservados.size(), 2);
//	}
	
}
