package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;

public class RepositorioUsuarioTest extends SpringTest {

	
	@Test
	@Transactional
	@Rollback(true)	
	public void ConcultarUsuarioDeberiaDevolverUsuarioConElMismoMailYPassword() {
		       //preparacion
				Usuario alguien = new Usuario();
				alguien.setEmail("algo@email.com");
				alguien.setPassword("1234");
				session().save(alguien);
		
				RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
				//ejecucion
				Usuario usuario =new Usuario();
				usuario.setEmail("algo@email.com");
				usuario.setPassword("1234");
				
				usuario=  repo.consultarUsuario(usuario);
				
				assertThat(usuario).isNotNull();
	}
	
	
	@Test
	@Transactional
	@Rollback(true)	
	public void ConcultarUsuarioNODeberiaDevolverUsuarioSiNoTieneElMismoMailYPassword() {
		
		Usuario alguien = new Usuario();
		alguien.setEmail("algo@email.com");
		alguien.setPassword("1234");
		session().save(alguien);

		RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
		//ejecucion
		Usuario usuario =new Usuario();
		usuario.setEmail("algo@email.com");
		usuario.setPassword("12");
		
		usuario=  repo.consultarUsuario(usuario);
		assertThat(usuario).isNull();
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void buscarDeberiaDevolverUnUsuarioConElMismoMail() {
		
		//preparacion
		Usuario juan = new Usuario();
		juan.setEmail("algo@email.com");
		session().save(juan);
		
		RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
		//ejecucion
		Usuario usuario = repo.buscar("algo@email.com");
		
		//comprobacion
		assertThat(usuario).isNotNull();
		
	}

	@Test
	@Transactional
	@Rollback(true)
	public void buscarNoDeberiaDevolverUnUsuarioSiEmailEsIncorrecto() {
		
		//preparacion
		Usuario anonimo = new Usuario();
		anonimo.setEmail("algo@email.com");
		session().save(anonimo);
		
		RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
		//ejecucion
		Usuario usuario = repo.buscar("anonimo@email.com");
		
		//comprobacion
		assertThat(usuario).isNull();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void buscarPoridDeberiaDevolverUnUsuarioSiEstaGuardado() {
		       //preparacion
				Usuario anonimo = new Usuario();
				anonimo.setNombre("Mariano");
				anonimo.setId(1L);
				session().save(anonimo);
				
				RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
				//ejecucion
				
				Usuario usuario = repo.buscarPorId(anonimo.getId());
				
				//comprobacion
				assertThat(usuario).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void buscarPorROLDeberiaDevolverUnaListaUsuario() {
		
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Mariano");
		usuario1.setRol("Cliente");
		session().save(usuario1);
		
		
		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Camila");
		usuario2.setRol("Vendedor");
		session().save(usuario2);
		
	
		Usuario usuario3 = new Usuario();
		usuario3.setNombre("Juan");
		usuario2.setRol("Cliente");
		session().save(usuario3);
		
		RepositorioUsuario repo = new RepositorioUsuarioImpl(this.sessionFactory);
		
		List<Usuario> resultado = repo.findByRol("Cliente");
		
		assertThat(resultado).hasSize(2);
		
		
	}
}
