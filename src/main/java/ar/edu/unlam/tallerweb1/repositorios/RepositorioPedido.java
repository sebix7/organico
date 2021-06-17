package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioPedido {

	public void guardarPedido(Pedido pedido);
	public List<Pedido> obtenerPedidosDelCliente(Long clienteId);

}
