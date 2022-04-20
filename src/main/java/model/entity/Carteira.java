package model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author JJunio
 *
 */
@Entity
@Table(name = "CARTEIRA")
public class Carteira implements Serializable {

	private static final long serialVersionUID = 4312826459536005744L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARTEIRA")
	private long id;

	@Column(name = "SALDO", nullable = false, columnDefinition = "DOUBLE PRECISION")
	private Double saldo = 0.0;

	@Column(name = "PONTOS", nullable = false, columnDefinition = "INTEGER")
	private int pontos = 0;

	@OneToOne
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
	private Cliente cliente;

	public Carteira() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void atualizaPontosCarteira(int pontos) {
		this.pontos += pontos;
	}

	public void atualizaSaldoCarteira(double valorPedido) {
		this.saldo -= valorPedido;

	}

}
