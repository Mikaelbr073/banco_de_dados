package service;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.PedidoBuilder;
import dao.ClienteDAO;
import dao.TestEMFactory;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Pedido;

class PedidoServiceTest {

	EntityManager manager;
	ClienteDAO dao;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new ClienteDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	void naoDeveSalvarPedidoSemSaldoNaCarteira() {
		PedidoService service = new PedidoService();
		Cliente cliente = ClienteFisicoBuilder.umCliente().comNome("João da Silva").build();
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Pedido pedido = PedidoBuilder.umPedido().completo(endereco, LocalDate.now(), cliente, 100.0).build();
		service.cadastrar(pedido);
	}

}
