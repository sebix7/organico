package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;

public interface ServicioCombo {
	

		Combo consultarCombo(Combo usuario);
		void registro(Combo usuario);
		List ver();


}
