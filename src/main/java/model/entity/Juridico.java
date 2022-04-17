package model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author JJunio
 *
 */
@Entity
@DiscriminatorValue("juridico")
public class Juridico extends Cliente {

	private static final long serialVersionUID = 3825011440909954347L;

	@Column(name = "CNPJ", columnDefinition = "VARCHAR(50)")
	private String cnpj;

	@Column(name = "INSCRICAO_ESTADUAL", columnDefinition = "VARCHAR(50)")
	private String inscricaoEstadual;

	public Juridico() {

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

}
