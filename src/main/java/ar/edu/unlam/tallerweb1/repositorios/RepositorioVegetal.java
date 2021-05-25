package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Vegetal;

public interface RepositorioVegetal {
	
	    Vegetal consultarVegetal (Vegetal usuario);
	    void guardar(Vegetal usuario);
	    Vegetal buscar(String nombre);
	    void modificar(Vegetal usuario);
}
