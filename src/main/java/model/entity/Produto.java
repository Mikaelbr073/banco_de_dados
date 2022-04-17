/**
 * 
 */
package model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "ID_PRODUTO",  columnDefinition = "INTEGER")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALOR", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private double valor;

	@JoinTable(name = "PRODUTO_FORNECEDOR", joinColumns = {
			@JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID_PRODUTO") }, inverseJoinColumns = {
					@JoinColumn(name = "FORNECEDOR_ID", referencedColumnName = "ID_FORNECEDOR") })
	@ManyToMany
	private Collection<Fornecedor> fornecedorCollection; 
	

	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collection<Fornecedor> getFornecedorCollection() {
		return fornecedorCollection;
	}

	public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
		this.fornecedorCollection = fornecedorCollection;
	}
	
	
	

}
