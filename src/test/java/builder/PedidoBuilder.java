package builder;

import java.time.LocalDate;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Pedido;
import model.entity.Produto;

/**
 * @author Mikaelbr073
 *
 */
public class PedidoBuilder {
	
	private Cliente cliente;
	private double valorTotal;
	private LocalDate data;
	private Endereco endereco;
	
	public PedidoBuilder() {}
	
	public static PedidoBuilder umPedido() {
		return new PedidoBuilder();
	}
	
	public PedidoBuilder comEnderecoData(Endereco endereco, LocalDate data, Cliente cliente) {
		this.endereco = endereco;
		this.data = data;
		this.cliente = cliente;
		return this;
		
	}
	public PedidoBuilder completo(Endereco endereco, LocalDate data, Cliente cliente, double valorTotal) {
		this.endereco = endereco;
		this.data = data;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		return this;
		
	}
	
	public Pedido build() {
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setData(data);
		pedido.setValorTotal(valorTotal);
		pedido.setEndereco(endereco);
		return pedido;
	}
	

	

}
