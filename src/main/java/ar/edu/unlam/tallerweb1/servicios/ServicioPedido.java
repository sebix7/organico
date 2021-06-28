package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface ServicioPedido {
	
	void guardarPedido(Pedido pedido);
	List<Pedido> obtenerPedidosDelCliente(Long clienteId);
	List<Combo> consultarCombosDelPedido(Long carroId);

}