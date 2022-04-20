package service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.PedidoBuilder;
import builder.ProdutoBuilder;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import dao.TestEMFactory;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Pedido;
import model.entity.PedidoProduto;
import model.entity.Produto;

class PedidoServiceTest {

	EntityManager manager;
	PedidoDAO daoPedido;
	ClienteDAO daoCliente;
	ProdutoDAO daoProduto;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		daoPedido = new PedidoDAO(manager);
		daoCliente = new ClienteDAO(manager);
		daoProduto = new ProdutoDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	void naoDeveSalvarPedidoSemSaldoNaCarteira() {
		PedidoService servicePedido = new PedidoService();
		Pedido pedido = new Pedido();
		LocalDate data = LocalDate.now();
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Cliente cliente = ClienteFisicoBuilder.umCliente().comNome("José").build();
		daoCliente.adiciona(cliente);
		System.out.println(cliente.getId() + "--------------id CLIENTE");
		Produto produto = ProdutoBuilder.umProduto().comNomeValor("Caneta", 323232).build();
		daoProduto.adiciona(produto);
		pedido = PedidoBuilder.umPedido().completo(endereco, data, cliente, 100).build();
		pedido.setPedidoProduto(new PedidoProduto(200, 2));
		assertNotNull(servicePedido.cadastrar(pedido));
	}

}
