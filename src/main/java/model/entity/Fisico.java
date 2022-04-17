package model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author JJunio
 *
 */
@Entity
@DiscriminatorValue("fisico")
public class Fisico extends Cliente {

	private static final long serialVersionUID = -6835610410337029141L;

	@Column(name = "RG", length = 50)
	private String rg;

	@Column(name = "CPF", length = 11)
	private String cpf;

	public Fisico() {
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
