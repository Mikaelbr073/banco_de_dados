package model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */

@Embeddable
public class PedidoProdutoId implements Serializable {

	private static final long serialVersionUID = -3007998035373613663L;
	
	@Column(name = "ID_PRODUTO", nullable = false, columnDefinition = "INTEGER")
	private long id_produto;
	
	@Column(name = "ID_PEDIDO", nullable = false, columnDefinition = "INTEGER")
	private long id_pedido;
	
	
	public PedidoProdutoId() {}


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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_pedido, id_produto);
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
		return id_pedido == other.id_pedido && id_produto == other.id_produto;
	}
	
	
	
	
	
	
	
	

	
	
	
}
