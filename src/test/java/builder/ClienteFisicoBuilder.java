package builder;

import java.util.List;

import model.entity.Cliente;
import model.entity.Dependente;
import model.entity.Fisico;

public class ClienteFisicoBuilder {

	private String nome;
	private Dependente dependente;

	private ClienteFisicoBuilder() {
	}

	public static ClienteFisicoBuilder umCliente() {
		return new ClienteFisicoBuilder();
	}

	public ClienteFisicoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClienteFisicoBuilder comDependente(String nome, Dependente dependente) {
		this.nome = nome;
		this.dependente = dependente;
		return this;
	}

	public Cliente build() {
		Fisico cliente = new Fisico();
		cliente.setNome(nome);
		List<Dependente> dependenteBanco = cliente.getDependentes();
		dependenteBanco.add(dependente);
		cliente.setDependentes(dependenteBanco);
		return cliente;
	}

}
