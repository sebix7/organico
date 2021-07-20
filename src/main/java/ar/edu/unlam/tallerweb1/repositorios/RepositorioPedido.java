package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Combo;
import ar.edu.unlam.tallerweb1.modelo.ComboCarro;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioPedido {

	void guardarPedido(Pedido pedido);
	List<Pedido> obtenerPedidosDelCliente(Long clienteId);
	List<ComboCarro> obtenerComboCarrosVinculadosAlPedido(Long carroId);
	Pedido buscarPedidoPorId(Long idpedido);
	void actualizar(Pedido pedido);
	List<Pedido> obtenerTodosLosPedidos();
	List<Pedido> obtenerPedidosCancelados();


}
