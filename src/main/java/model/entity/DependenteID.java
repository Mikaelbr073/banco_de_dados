package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author JJunio
 *
 */
@Embeddable
public class DependenteID implements Serializable {

	private static final long serialVersionUID = -5594799384399913271L;

	@Column(name = "RG", nullable = false, columnDefinition = "VARCHAR(50)")
	private String rg;

	@Column(name = "ID_CLIENTE", nullable = false , columnDefinition = "INTEGER")
	private long id;

	public DependenteID() {
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		DependenteID other = (DependenteID) obj;
		if (id != other.id)
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

}
