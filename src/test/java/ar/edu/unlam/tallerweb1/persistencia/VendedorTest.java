package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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

}
