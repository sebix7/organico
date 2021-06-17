package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCombo;



@Controller
public class ControladorIndex {
	private ServicioCombo ServicioComboDao;
	
	@Autowired
	public ControladorIndex(ServicioCombo ServicioComboDao) {
		this.ServicioComboDao = ServicioComboDao;
	}
	
	@RequestMapping("/index")
	public ModelAndView verIndex() {

		List<Combo> combos = this.ServicioComboDao.consultarCombos();
		
			ModelMap modelo = new ModelMap();
				if(combos.size() == 0) {
					String mensaje = "No hay combos En La Web Aun";
					modelo.put("mensaje", mensaje);
				} else {
					modelo.put("combos", combos);
				}
				return new ModelAndView("index", modelo);
			}
		

}
