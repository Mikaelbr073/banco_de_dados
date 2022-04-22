package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/**
 * @author Mikaelbr073
 *
 */

@Embeddable
public class PedidoProdutoId implements Serializable {

	private static final long serialVersionUID = 2922433230633984016L;

	@GeneratedValue
	@Column(name = "ID_PRODUTO", nullable = false, columnDefinition = "INTEGER")
	private long id_produto;

	@GeneratedValue
	@Column(name = "ID_PEDIDO", nullable = false, columnDefinition = "INTEGER")
	private long id_pedido;

	public PedidoProdutoId() {
	}

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_pedido ^ (id_pedido >>> 32));
		result = prime * result + (int) (id_produto ^ (id_produto >>> 32));
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
		PedidoProdutoId other = (PedidoProdutoId) obj;
		if (id_pedido != other.id_pedido)
			return false;
		if (id_produto != other.id_produto)
			return false;
		return true;
	}

}
