/**
 * 
 */
package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO", columnDefinition = "INTEGER")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALOR", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private double valor;

	@ManyToOne(cascade = CascadeType.ALL)
	private PedidoProduto pedidoProduto;

	@JoinTable(name = "PRODUTO_FORNECEDOR", joinColumns = {
			@JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID_PRODUTO") }, inverseJoinColumns = {
					@JoinColumn(name = "FORNECEDOR_ID", referencedColumnName = "ID_FORNECEDOR") })
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Fornecedor> fornecedorCollection = new ArrayList<>();

	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public PedidoProduto getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(PedidoProduto pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}

	public Collection<Fornecedor> getFornecedorCollection() {
		return fornecedorCollection;
	}

	public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
		this.fornecedorCollection = fornecedorCollection;
	}

	public void adicionaFornecedor(Fornecedor novoFornecedor) {
		this.fornecedorCollection.add(novoFornecedor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fornecedorCollection == null) ? 0 : fornecedorCollection.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pedidoProduto == null) ? 0 : pedidoProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fornecedorCollection == null) {
			if (other.fornecedorCollection != null)
				return false;
		} else if (!fornecedorCollection.equals(other.fornecedorCollection))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pedidoProduto == null) {
			if (other.pedidoProduto != null)
				return false;
		} else if (!pedidoProduto.equals(other.pedidoProduto))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

}
