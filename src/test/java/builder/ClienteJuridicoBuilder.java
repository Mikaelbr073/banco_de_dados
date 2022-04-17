package builder;

import model.entity.Cliente;
import model.entity.Juridico;

public class ClienteJuridicoBuilder {
	
	private String razaoSocial;
	
	private ClienteJuridicoBuilder() {}
	
	public static ClienteJuridicoBuilder umCliente() {
		return new ClienteJuridicoBuilder();
	}
	
	public ClienteJuridicoBuilder comRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}
	
	public Cliente build() {
		Juridico cliente = new Juridico();
		cliente.setNome(razaoSocial);
		return cliente;
	}

}
