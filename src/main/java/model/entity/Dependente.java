package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author JJunio
 *
 */
@Entity
public class Dependente implements Serializable {

	private static final long serialVersionUID = 2619551837284016339L;

	@EmbeddedId
	private DependenteID id;

	@Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(255)")
	private String nome;

	public Dependente() {

	}

	public DependenteID getId() {
		return id;
	}

	public void setId(DependenteID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
