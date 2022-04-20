package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	
	@Column(name = "VALOR_UNIDADE", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private double valorUnidade = 0.0;
	
	@Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
	private int qtd = 1;
	
	
	public PedidoProduto() {}


	public PedidoProduto(double valorUnidade, int qtd) {
		this.valorUnidade = valorUnidade;
		this.qtd = qtd;
	}


	public PedidoProdutoId getId() {
		return id;
	}


	public void setId(PedidoProdutoId id) {
		this.id = id;
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
	
	

}
