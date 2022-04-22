package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */
@Entity
@Table(name = "PEDIDO_PRODUTO")
@IdClass(PedidoProduto.class)
public class PedidoProduto implements Serializable {

	private static final long serialVersionUID = -1271951994985822730L;

	@Id
	@JoinColumn(name = "PEDIDO_ID_PRODUTO", referencedColumnName = "ID_PRODUTO", columnDefinition = "INTEGER")
	private Long idProduto;

	@Id
	@JoinColumn(name = "PEDIDO_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", columnDefinition = "INTEGER")
	private Long idCliente;

//	@EmbeddedId
//	private PedidoProdutoId id;

	@Column(name = "VALOR_UNIDADE", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private double valorUnidade = 0.0;

	@Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
	private int qtd = 1;

	public PedidoProduto() {
	}

	public PedidoProduto(double valorUnidade, int qtd) {
		this.valorUnidade = valorUnidade;
		this.qtd = qtd;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}


}
