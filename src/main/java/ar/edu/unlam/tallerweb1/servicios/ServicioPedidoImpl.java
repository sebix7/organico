package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComboCarro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioPedido")
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	
	private RepositorioPedido repositorioPedido;
	private RepositorioComboCarro repositorioComboCarro;
	
	@Autowired
	public ServicioPedidoImpl(RepositorioPedido repositorioPedido, RepositorioComboCarro repositorioComboCarro){
		this.repositorioPedido = repositorioPedido;
		this.repositorioComboCarro = repositorioComboCarro;
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		this.repositorioPedido.guardarPedido(pedido);
	}

	@Override
	public List<Pedido> obtenerPedidosDelCliente(Long clienteId) {
		return this.repositorioPedido.obtenerPedidosDelCliente(clienteId);
	}

	@Override
	public List<Combo> consultarCombosDelPedido(Long carroId) {
		List<Combo> combos = new ArrayList<Combo>();
		List<ComboCarro> combocarros = repositorioPedido.obtenerComboCarrosVinculadosAlPedido(carroId);
		for (ComboCarro comboCarro : combocarros) {
			for (int i = 0; i < comboCarro.getCantidad(); i++) {
				 Combo combo = comboCarro.getCombo();
				 combos.add(combo);
			}
		}
		return combos;
	}

}
