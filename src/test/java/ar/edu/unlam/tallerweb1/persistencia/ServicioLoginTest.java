package ar.edu.unlam.tallerweb1.persistencia;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;

public class ServicioLoginTest {

private ServicioLoginImpl servicio ;
	
	@Test
	public void CuandoConsulteUsuarioDevuelvaUsuarioSiEstaGuardado() {
		
		
		Usuario usuario = mock(Usuario.class);
		
		RepositorioUsuario repoUsuario = mock(RepositorioUsuario.class);
		servicio = new ServicioLoginImpl(repoUsuario);
		
		when(servicio.consultarUsuario(usuario)).thenReturn(usuario);
		
	}

	
	@Test
	public void CuandoConsulteUsuarioNODevuelvaUsuarioSiNOEstaGuardado() {
		
		Usuario usuario = mock(Usuario.class);
		
		RepositorioUsuario repoUsuario = mock(RepositorioUsuario.class);
		servicio = new ServicioLoginImpl(repoUsuario);
		when(servicio.consultarUsuario(usuario)).thenReturn(null);
		
	}
	
	@Test
	public void QueCuandoSeConcultePorRolDevuelvaUnaListaDeUsuarios() {
		
		Usuario usuario = mock(Usuario.class);
		List<Usuario> resultado = mock(ArrayList.class);
		RepositorioUsuario repoUsuario = mock(RepositorioUsuario.class);
		servicio = new ServicioLoginImpl(repoUsuario);
		
		when(servicio.busquedaPorRol(usuario.getRol())).thenReturn(resultado);
		
		
		
	}
}
