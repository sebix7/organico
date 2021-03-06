package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;

public interface RepositorioClienteCombos {

	List<Combo> consultarCombos();
	Combo obtenerComboPorId(Long id);
	void modificarCombo(Combo combo);
	void guardarValoracion(ValorarCombo nuevaValoracion);
	List<ValorarCombo> obtenerValoracionesPositivas(Long idcombo);
	List<ValorarCombo> obtenerValoracionesNegativas(Long idcombo);
	boolean VerificaUnaSolaValoracion(Long idusuario, long idcombo);
	List<ValorarCombo> obtenerComentariosCombo(Long idcombo);
	ValorarCombo obtenerValoracionPorid(Long idcombo, Long idusuario);
	boolean verificaUnSoloComentario(Long idcombo, Long idusuario);

}
