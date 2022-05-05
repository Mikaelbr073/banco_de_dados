package model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */
@Entity
@Table(name = "PEDIDO_PRODUTO")
public class PedidoProduto implements Serializable {

	private static final long serialVersionUID = -1271951994985822730L;

	@EmbeddedId
	private PedidoProdutoId id;

	
	@OneToOne
	@MapsId("id_pedido")
	private Pedido pedido;

	@OneToOne
	@MapsId("id_produto")
	private Produto produtos;

//	
//	@JoinColumn(name = "PEDIDO_ID_PRODUTO", referencedColumnName = "ID_PRODUTO", columnDefinition = "INTEGER")
//	private Long idProduto;
//
//	
//	@JoinColumn(name = "PEDIDO_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", columnDefinition = "INTEGER")
//	private Long idCliente;

	@Column(name = "VALOR_UNIDADE", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private double valorUnidade = 0.0;

	@Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
	private int qtd = 1;

	public PedidoProduto() {
	}

	public PedidoProdutoId getId() {
		return id;
	}

	public void setId(PedidoProdutoId id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public double getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + qtd;
		long temp;
		temp = Double.doubleToLongBits(valorUnidade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProduto other = (PedidoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (qtd != other.qtd)
			return false;
		if (Double.doubleToLongBits(valorUnidade) != Double.doubleToLongBits(other.valorUnidade))
			return false;
		return true;
	}

}
