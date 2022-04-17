package builder;

import model.entity.Cliente;
import model.entity.Fisico;

public class ClienteBuilder {
	
	private String nome;
	
	private ClienteBuilder() {}
	
	public static ClienteBuilder umCliente() {
		return new ClienteBuilder();
	}
	
	public ClienteBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Cliente build() {
		Fisico cliente = new Fisico();
		cliente.setNome(nome);
		return cliente;
	}

}
