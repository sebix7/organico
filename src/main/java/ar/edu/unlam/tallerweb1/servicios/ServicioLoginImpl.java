package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	private RepositorioUsuario servicioLoginDao;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario servicioLoginDao){
		this.servicioLoginDao = servicioLoginDao;
	}

	@Override
	public Usuario consultarUsuario (Usuario usuario) {
		return servicioLoginDao.consultarUsuario(usuario);
	}

	@Override
	public void registro(Usuario usuario) {
		 usuario.setActivo(true);
		servicioLoginDao.guardar(usuario);
		
	}

	@Override
	public Usuario buscarPorMail(String mail) {
		return servicioLoginDao.buscar(mail);
	}

	@Override
	public List<Usuario> listarTodos() {
		return servicioLoginDao.findAll();
	}

	@Override
	public List<Usuario> busquedaPorRol(String rol) {
		return servicioLoginDao.findByRol(rol);
	}
	
	@Override
	public Usuario buscarPorId(Long id) {
		return servicioLoginDao.buscarPorId(id);
	}

	@Override
	public void actualizar(Usuario usuario) {
		 servicioLoginDao.modificar(usuario);
		
	}

	@Override
	public List<Usuario> listarTodosVendedoresLongitud(String string) {
	return	servicioLoginDao.rolynull(string);
	}
	

}
