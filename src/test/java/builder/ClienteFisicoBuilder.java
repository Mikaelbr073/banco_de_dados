package builder;

import model.entity.Cliente;
import model.entity.Fisico;

public class ClienteFisicoBuilder {
	
	private String nome;
	
	private ClienteFisicoBuilder() {}
	
	public static ClienteFisicoBuilder umCliente() {
		return new ClienteFisicoBuilder();
	}
	
	public ClienteFisicoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Cliente build() {
		Fisico cliente = new Fisico();
		cliente.setNome(nome);
		return cliente;
	}

}
