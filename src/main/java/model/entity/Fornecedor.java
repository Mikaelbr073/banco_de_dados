package model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Mikaelbr073
 *
 */

@Table(name = "FORNECEDOR")
@Entity
public class Fornecedor implements Serializable {
	

	private static final long serialVersionUID = 6207687502040970484L;
	
	@Column(name = "ID_FORNECEDOR", columnDefinition = "INTEGER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "fornecedorCollection")
	private Collection<Produto> produtoCollection;
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	
	
	
	

}
