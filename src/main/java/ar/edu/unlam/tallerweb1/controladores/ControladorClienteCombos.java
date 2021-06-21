package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Carro;
import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComentarDAO;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.ValorarCombo;
import ar.edu.unlam.tallerweb1.modelo.ValorarDAO;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarro;
import ar.edu.unlam.tallerweb1.servicios.ServicioClienteCombos;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorClienteCombos {
	
	private ServicioClienteCombos servicioClienteCombos;
	private ServicioCarro servicioCarro;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorClienteCombos(ServicioClienteCombos servicioClienteCombos, ServicioCarro servicioCarro,ServicioLogin servicioLogin) {
		this.servicioClienteCombos = servicioClienteCombos;
		this.servicioCarro = servicioCarro;
		this.servicioLogin=servicioLogin;
	}
	
	@RequestMapping("/combos")
	public ModelAndView irACombos(HttpServletRequest request) {

		String rol=(String)request.getSession().getAttribute("ROL");
		
		if(rol.equals("Cliente")) {
			List<Combo> combos = this.servicioClienteCombos.consultarCombos();
			ModelMap modelo = new ModelMap();
			if(combos.size() == 0) {
				String mensaje = "No hay combos disponibles";
				modelo.put("mensaje", mensaje);
			} else {
				modelo.put("combos", combos);
			}
			return new ModelAndView("combos", modelo);
		}
		else {
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(path = "/agregarACarrito", method = RequestMethod.GET)
	public ModelAndView validarAgregarACarrito(@RequestParam(value = "id", required = true) Long id, HttpServletRequest request) {
		
			String rol=(String)request.getSession().getAttribute("ROL");
		
			if(rol.equals("Cliente")) {
				List<Combo> carro = (List<Combo>) request.getSession().getAttribute("carro");
//				Long clienteId=(Long)request.getSession().getAttribute("ClienteId");
				Combo combo = servicioClienteCombos.obtenerComboPorId(id);
				carro.add(combo);
				request.getSession().setAttribute("carro", carro);
				servicioClienteCombos.actualizarStockDelCombo(id, -1);
//				Carro compras = servicioCarro.obtenerCarroPorClienteId(clienteId);
				
//				combo.setCompras(compras);
//				servicioClienteCombos.modificarCombo(combo);
				
				return new ModelAndView("redirect:/carrito");
			}
			else {
				return new ModelAndView("login");
			}
	}

	
	//action que permite visualizar la vista VerDetalle de cada combo
		@RequestMapping(path ="/verDetalle",method = RequestMethod.GET)
		public ModelAndView irDetalle(@RequestParam(value = "id", required = true) Long idcombo, HttpServletRequest request) {
			
		         List<ValorarCombo> comentarios = new ArrayList();
		
			
			String rol=(String)request.getSession().getAttribute("ROL");
			//solo imgresa si es cliente
			      if(rol.equals("Cliente")) {
				      ModelMap modelo = new ModelMap();
				      Usuario usuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
				      
				      comentarios =servicioClienteCombos.obtenerComentariosdeCombo(idcombo);
				      Combo combo=servicioClienteCombos.obtenerComboPorId(idcombo);
				      Integer CantidadPositivos=servicioClienteCombos.obtenerPositivosCombo(idcombo);//Cantidad de MeGusta que posee el combo
				      Integer CantidadNegativos=servicioClienteCombos.obtenerNegativosCombo(idcombo);//cantidad de no me gusta
				      boolean resultado = servicioClienteCombos.validaValoracion(idcombo,usuario.getId());//valida si el cliente ya hizo una valoracion al combo
	                  boolean resultadoComentario = servicioClienteCombos.validaComentario(idcombo,usuario.getId());//valida si el cliente ya realizo ujn comentario al combo
				
	                   modelo.put("estadoComentario",resultadoComentario);
				       modelo.put("comentarios",comentarios);
				       modelo.put("combo", combo);
				       modelo.put("positivos",CantidadPositivos);
				       modelo.put("negativos", CantidadNegativos);
				       modelo.put("resultado", resultado);
		
				      return new ModelAndView("verDetalle",modelo);
			 }	
			
			return new ModelAndView("login");
		}
		
		//el valor de retorno del método no debe ser interpretado por Spring como el nombre lógico de una vista.
		//esto se consigue con @ResponseBody. El valor de retorno es un String
		@RequestMapping(value = "/valorarcombos", method = RequestMethod.POST,consumes= "application/json")
		  public @ResponseBody String CalificaCombos(@RequestBody ValorarDAO data,HttpServletRequest request) {
			
			    Usuario usuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
				servicioClienteCombos.valorar(usuario.getId(),data.getIdcombo(),data.isValidacion());
			
			  return null;
			}
		
		@RequestMapping(value = "/guardarComentario", method = RequestMethod.POST,consumes= "application/json")
		  public @ResponseBody String recibeComentarioCombo(@RequestBody ComentarDAO data,HttpServletRequest request) {		
		      	     
			         Usuario usuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("userId"));
			         servicioClienteCombos.guardarComentario(usuario.getId(),data.getIdcombo(),data.getComentario());
				    		
			  return null;
			}
}
