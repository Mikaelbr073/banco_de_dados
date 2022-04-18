package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.PedidoBuilder;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Pedido;

public class PedidoDAOTest {

	EntityManager manager;
	PedidoDAO dao;
	Cliente cliente;
	ClienteDAO dao2;
	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new PedidoDAO(manager);
		dao2 = new ClienteDAO(manager);
		manager.getTransaction().begin();
		cliente = ClienteFisicoBuilder.umCliente().comNome("João da Silva").build();
		dao2.adiciona(cliente);		
	}

	@AfterEach
	public void after() {
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	public void deveSalvarPedidoComEnderecoData() {
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Pedido novoPedido = PedidoBuilder.umPedido().comEnderecoData(endereco,LocalDate.now(),cliente).build();
		dao.adiciona(novoPedido);
		assertNotNull(novoPedido.getId());
	}

	@Test
	public void deveSalvarPedidoCompleto() {
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Pedido novoPedido = PedidoBuilder.umPedido().completo(endereco,LocalDate.now(),cliente, 345.7).build();
		dao.adiciona(novoPedido);
		assertNotNull(novoPedido.getId());
	
	}

}
