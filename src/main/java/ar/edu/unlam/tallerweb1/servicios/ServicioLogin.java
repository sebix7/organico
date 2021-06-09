package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
	void registro(Usuario usuario);
	Usuario buscarPorMail(String mail);
	List<Usuario> listarTodos();
	List<Usuario> busquedaPorRol(String string);
	Usuario buscarPorId(Long id);

	void actualizar(Usuario usuario);
}
