package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vegetal;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class VendedorTest extends SpringTest {
	
    @Test
    @Transactional @Rollback
    public void crearUnVendedor(){
        Usuario usuario = new Usuario();
        usuario.setEmail("seba@gmail.com");
        usuario.setPassword("1234");
        usuario.setRol("Vendedor");
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void crearUnVegetal(){
        Vegetal usuario = new Vegetal();
        usuario.setNombreDelProducto("Tomate");
        usuario.setPeso(0.5);
        usuario.setPrecio(15.0);
        usuario.setTipo("Fruta");
        usuario.setCosecha(null);
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }

}
