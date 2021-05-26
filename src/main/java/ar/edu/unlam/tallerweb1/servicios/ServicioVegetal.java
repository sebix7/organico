package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vegetal;

public interface ServicioVegetal {
	Vegetal consultarUsuario(Vegetal usuario);
	void registro(Vegetal usuario);
}
