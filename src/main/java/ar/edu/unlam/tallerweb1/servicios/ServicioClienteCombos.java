package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;

public interface ServicioClienteCombos {

	List<Combo> consultarCombos();
	Combo obtenerComboPorId(Long id);
	void modificarCombo(Combo combo);
	void actualizarStockDelCombo(Long id, Integer i);
	void restaurarStockDeCombos(List<Combo> combos);
	void valorar(Long idUsuario, Long idCombo, boolean valoracion);
	Integer obtenerPositivosCombo(Long idcombo);
	Integer obtenerNegativosCombo(Long idcombo);
	boolean validaValoracion(Long idcombo, Long id);
	List<ValorarCombo> obtenerComentariosdeCombo(Long idcombo);
	void guardarComentario(Long idusuario, long idcombo, String comentario);
	boolean validaComentario(Long idcombo, Long idusuario);
	void marcarComentarios(Long idcombo);
	Integer contarComentariosNoLeidos(Long idcombo);
	
	
}
