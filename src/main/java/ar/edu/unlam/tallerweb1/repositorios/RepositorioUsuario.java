package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {

    Usuario consultarUsuario (Usuario usuario);
    void guardar(Usuario usuario);
    Usuario buscar(String email);
    void modificar(Usuario usuario);
	List<Usuario> findAll();
	List<Usuario> findByRol(String rol);
	List<Usuario> rolynull(String rol);
	Usuario buscarPorId(Long id);
}