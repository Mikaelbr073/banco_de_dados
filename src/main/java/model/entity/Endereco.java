package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author JJunio
 *
 */
@Embeddable
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = -6369783934108846224L;

	@Column(name = "END_CEP", columnDefinition = "CHAR(8)")
	private String endCep;

	@Column(name = "END_RUA", columnDefinition = "VARCHAR(255)")
	private String endRua;

	@Column(name = "END_CIDADE", columnDefinition = "VARCHAR(255)")
	private String endCidade;

	public Endereco() {
	}

	public String getEndCep() {
		return endCep;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}

	public String getEndRua() {
		return endRua;
	}

	public void setEndRua(String endRua) {
		this.endRua = endRua;
	}

	public String getEndCidade() {
		return endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}
	
	
}
