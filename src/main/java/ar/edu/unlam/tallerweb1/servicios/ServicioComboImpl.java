package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCombo;

@Service("servicioCombo")
@Transactional
public class ServicioComboImpl implements ServicioCombo {
	
	private RepositorioCombo nuevo;
	
	@Autowired
	public ServicioComboImpl(RepositorioCombo nuevo){
		this.nuevo = nuevo;
	}
	@Override
	public Combo consultarCombo(Combo usuario) {
	
		return nuevo.consultarCombo(usuario);
	}

	@Override
	public void registro(Combo usuario1) {
	
		nuevo.guardar(usuario1);
	}
	@Override
	public List<Combo> consultarCombos() {
		return this.nuevo.consultarCombos();
	}
	@Override
	public Combo buscarPorNombre(String nombre) {
		return this.nuevo.buscar(nombre);
	}
	@Override
	public void modificar(Combo combo) {
		this.nuevo.modificar(combo);
		
	}
	@Override
	public Combo buscarPorId(Long id) {
		return nuevo.buscarPorId(id);
	}
	@Override
	public List<Combo> consultarCombosPorUs(Usuario entrada) {
		return nuevo.consultarCombosPorId(entrada);
	}
	@Override
	public void aplicarDescuento(Long descuento,Long id) {
		Combo entrada = new Combo();
		 entrada = nuevo.buscarPorId(id);
		 Double total = entrada.getPrecio();
		 Double resto = (entrada.getPrecio() * descuento) / 100;
		 entrada.setPrecio(total - resto);
		 Boolean descuentos = true;
		 entrada.setTieneDescuento(descuentos);
	}
	@Override
	public List<Combo> consultarCombosConDescuento() {
		return this.nuevo.consultarCombosConDescuento();
	}
	@Override
	public List<Combo> consultarCombosPorEstacion(String estacion) {
		// TODO Auto-generated method stub
		return nuevo.buscarPorEstacion(estacion);
	}
	@Override
	public List<Combo> consultarCombosSinDescuento() {
		// TODO Auto-generated method stub
		return nuevo.consultarCombosSinDescuento();
	}
	@Override
	public List<Combo> Obtener3CombosConMenorPrecio() {
		  List<Combo> resultado = new ArrayList();
	    	
	    	resultado = nuevo.consultarCombos();
	    	Collections.sort(resultado, (x, y) -> x.getPrecio().compareTo(y.getPrecio()));
	    	
	    	if(resultado.size()>=3)
	    	{
	    		List<Combo> tresPrimeros=resultado.subList(0, 3);
	    		return tresPrimeros;
	    	}
	    	

	return resultado;
   }
	@Override
	public List<Combo> consultarCombosPorEstacionYDescuentoSi(String estacion,Usuario email) {
		// TODO Auto-generated method stub
		return nuevo.consultarCombosPorEstacionYDescuentoSi(estacion, email);
	}
	@Override
	public List<Combo> consultarCombosPorEstacionYDescuentoNo(String estacion,Usuario email) {
		// TODO Auto-generated method stub
		return nuevo.consultarCombosPorEstacionYDescuentoNo(estacion, email);
	}
	@Override
	public List<Combo> ordenarPorDistancia(Double lat, Double lng) {
		// TODO Auto-generated method stub
		 List<Combo> aux = this.nuevo.consultarCombosConDireccion();
		 
		 for (Combo combo : aux) {
			 Double radioTierra = 6371.0;//en kilómetros  
			 Double dLat = Math.toRadians(lat - combo.getLatitud());
			 Double dLng = Math.toRadians(lng - combo.getLongitud());
			 
			 Double sindLat = Math.sin(dLat / 2);  
		     Double sindLng = Math.sin(dLng / 2);
		     
		     Double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
             * Math.cos(Math.toRadians(combo.getLatitud())) * Math.cos(Math.toRadians(lat));  
		     Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		     Double distancia = radioTierra * va2; 
		     
		     combo.setDistancia(distancia);
		     
		     this.nuevo.guardar(combo);
		     
		}
		 
		 List<Combo> aux2 =	this.nuevo.consultarCombosConDireccion();
		 
		Collections.sort(aux2, (x, y) -> x.getDistancia().compareTo(y.getDistancia()));
		return aux2;
	}

}
