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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;

public class VerificaUnComentarioTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testQueMePermitaSoloUnComentarioEnCombo() {
		
		//Declarar
				Usuario usuario1;
				Combo combo1;
			
				ValorarCombo val1;
				Session session = session();
				
				//inicializamos
				    usuario1 = new Usuario();
					combo1= new Combo();
					val1  = new ValorarCombo();
			
					
					//seteamos 
					
					usuario1.setId(1L);
				    combo1.setId(1L);
				    val1.setCombo(combo1);
				    val1.setUsuario(usuario1);
				   // val1.setComentario("hola");
				    
				  //guardar
				    session.save(combo1);
				    session.save(usuario1);
				    session.save(val1);
				 
				    
				    List<ValorarCombo>resultado;
				    
					resultado= session.createCriteria(ValorarCombo.class)
							.createAlias("combo", "comb")
							.add(Restrictions.eq("comb.id",1L))
							.createAlias("usuario", "usu")
							.add(Restrictions.eq("usu.id",1L))
							.add(Restrictions.isNull("comentario"))
							.list();
				
					 assertThat(resultado).hasSize(1);
  }
}