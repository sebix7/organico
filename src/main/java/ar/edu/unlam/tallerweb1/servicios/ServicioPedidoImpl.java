package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioPedido")
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
	
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	public ServicioPedidoImpl(RepositorioPedido repositorioPedido){
		this.repositorioPedido = repositorioPedido;
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		this.repositorioPedido.guardarPedido(pedido);
	}
	
	

}
