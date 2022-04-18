package service;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.PedidoBuilder;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.TestEMFactory;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Pedido;

class PedidoServiceTest {

	EntityManager manager;
	PedidoDAO dao;
	ClienteDAO daoCliente;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new PedidoDAO(manager);
		daoCliente = new ClienteDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	void naoDeveSalvarPedidoSemSaldoNaCarteira() {
		Pedido pedido = new Pedido();
		LocalDate data = LocalDate.now();
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Cliente cliente = ClienteFisicoBuilder.umCliente().comNome("José").build();
		daoCliente.adiciona(cliente);
		pedido = PedidoBuilder.umPedido().completo(endereco, data, cliente, 100).build();
		dao.adiciona(pedido);
		assertNull(pedido);
	}

}
