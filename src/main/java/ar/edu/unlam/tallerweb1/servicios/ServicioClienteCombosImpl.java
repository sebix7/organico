package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;
import ar.edu.unlam.tallerweb1.modelo.VerDetalleViewModel;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioClienteCombos;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioClienteCombosImpl implements ServicioClienteCombos {

	private RepositorioClienteCombos repositorioClienteCombos;
	private  RepositorioUsuario repositorioUsuario;
	
	@Autowired
	public ServicioClienteCombosImpl(RepositorioClienteCombos repositorioClienteCombos,RepositorioUsuario repositorioUsuario) {
		this.repositorioClienteCombos = repositorioClienteCombos;
		this.repositorioUsuario=repositorioUsuario;
	}
	
	@Override
	public List<Combo> consultarCombos() {
		return this.repositorioClienteCombos.consultarCombos();
	}

	@Override
	public Combo obtenerComboPorId(Long id) {
		return this.repositorioClienteCombos.obtenerComboPorId(id);
	}

	@Override
	public void modificarCombo(Combo combo) {
		this.repositorioClienteCombos.modificarCombo(combo);
	}

	@Override
	public void actualizarStockDelCombo(Long id, Integer i) {
		Combo combo = this.repositorioClienteCombos.obtenerComboPorId(id);
		combo.setStock(combo.getStock() + i);
		this.repositorioClienteCombos.modificarCombo(combo);		
	}
	
	@Override
	public void restaurarStockDeCombos(List<Combo> combos) {
		for (Combo combo : combos) {
			Combo aux = this.repositorioClienteCombos.obtenerComboPorId(combo.getId());
			aux.setStock(aux.getStock() + 1);
			this.repositorioClienteCombos.modificarCombo(aux);
		}
	}
	

	@Override
	public void valorar(Long idUsuario, Long idCombo, boolean valoracion) {
	
		     ValorarCombo nuevaValoracion = new ValorarCombo();
		
	         Combo combo= repositorioClienteCombos.obtenerComboPorId(idCombo);
	         Usuario usuario= repositorioUsuario.buscarPorId(idUsuario);
	    
	         nuevaValoracion.setValoracion(valoracion);
	         nuevaValoracion.setCombo(combo);
	         nuevaValoracion.setUsuario(usuario);
	    
	    repositorioClienteCombos.guardarValoracion(nuevaValoracion);    
		
	}

	@Override
	public Integer obtenerPositivosCombo(Long idcombo) {
	    Integer positivos = 0;
	    
	    List<ValorarCombo> resultado = repositorioClienteCombos.obtenerValoracionesPositivas(idcombo);
	   
	       for(ValorarCombo lista : resultado) {
			  positivos ++;
	     	}	    
	      
		return positivos;
	}

	@Override
	public Integer obtenerNegativosCombo(Long idcombo) {
		 Integer negativos = 0;
		    
		    List<ValorarCombo> resultado = repositorioClienteCombos.obtenerValoracionesNegativas(idcombo);
		   
		       for(ValorarCombo lista : resultado) {
				  negativos ++;
		     	}	    
		      
			return negativos;
		
	}
	@Override
	public boolean validaValoracion(Long idcombo, Long idusuario) {
	     boolean validar ;
	     validar = repositorioClienteCombos.VerificaUnaSolaValoracion(idusuario,idcombo); 
	     
		return validar;
	}

	@Override
	public List<ValorarCombo> obtenerComentariosdeCombo(Long idcombo) {
		 
		List<ValorarCombo> comentarios = repositorioClienteCombos.obtenerComentariosCombo(idcombo);
		
		return comentarios;
	}

	@Override
	public void guardarComentario(Long idusuario, long idcombo, String comentario) {
		
		     ValorarCombo valoracion ;
		
		     Combo combo= repositorioClienteCombos.obtenerComboPorId(idcombo);
	         Usuario usuario= repositorioUsuario.buscarPorId(idusuario);
	         
	         valoracion = repositorioClienteCombos.obtenerValoracionPorid(combo.getId(),usuario.getId());
	       
	        if(valoracion.getComentario()== null)
	            {
	             	  valoracion.setComentario(comentario);
	             	  repositorioClienteCombos.guardarValoracion(valoracion);
	            }         
	         
		
	}

	@Override
	public boolean validaComentario(Long idcombo, Long idusuario) {
		
		return repositorioClienteCombos.verificaUnSoloComentario(idcombo, idusuario);
	}

	@Override
	public void marcarComentarios(Long idcombo) {
		List<ValorarCombo> resultado = repositorioClienteCombos.obtenerComentariosCombo(idcombo);
			
			  for(ValorarCombo lista : resultado) {
				  
				  if(lista.isLeido()== false)
		            {
		             	  lista.setLeido(true);
		             	  repositorioClienteCombos.guardarValoracion(lista);
		            }
		    
		     	}	
	                 
			
		}

	@Override
	public Integer contarComentariosNoLeidos(Long idcombo) {
		
		  Integer contador=0;
			List<ValorarCombo> resultado = repositorioClienteCombos.obtenerComentariosCombo(idcombo);
			
			 for(ValorarCombo lista : resultado) {
				 if(lista.isLeido()== false)
		            {
		             	  contador ++;
		            }
			 }
			 
			 return contador;
		}

	@Override
	public List<VerDetalleViewModel> obtenerComentariosSinLeerPorCombo(List<Combo> combos) {
	
 List<VerDetalleViewModel> resultado = new ArrayList();
		 
		 
		 Integer cantidad=0;
		 
    	 for(Combo lista : combos) {
    		     VerDetalleViewModel nodo = new VerDetalleViewModel();
    		     
		         nodo.setId(lista.getId());
		         nodo.setNombre(lista.getNombre());
		         nodo.setTieneDescuento(lista.getTieneDescuento());
		         nodo.setImagen(lista.getImagen());
		         cantidad = contarComentariosNoLeidos(lista.getId());
		         nodo.setCantidadMensajesNoLeidos(cantidad);	
		         
		         resultado.add(nodo);
	 }
    	 
    	 
		 return resultado;
		
	}


}
