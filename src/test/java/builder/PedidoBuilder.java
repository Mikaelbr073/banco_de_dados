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
	private LocalDate data;
	private Endereco endereco;
	private Produto produto;
	
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
	public PedidoBuilder completo(Endereco endereco, LocalDate data, Cliente cliente, Produto produto) {
		this.endereco = endereco;
		this.data = data;
		this.cliente = cliente;
		this.produto = produto;
		return this;
		
	}
	
	public Pedido build() {
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setData(data);
		pedido.setEndereco(endereco);
		pedido.adicionaProdutoLista(produto);
		return pedido;
	}
	

	

}
