package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.PedidoBuilder;
import model.entity.Carteira;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Fornecedor;
import model.entity.Pedido;
import model.entity.Produto;

public class PedidoDAOTest {

	EntityManager manager;
	PedidoDAO daoPedido;
	Cliente cliente;
	ClienteDAO daoCliente;
	ProdutoDAO daoProduto;
	CarteiraDAO daoCarteira;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		daoPedido = new PedidoDAO(manager);
		daoCliente = new ClienteDAO(manager);
		daoProduto = new ProdutoDAO(manager);
		daoCarteira = new CarteiraDAO(manager);
		manager.getTransaction().begin();
		cliente = ClienteFisicoBuilder.umCliente().comNome("João da Silva").build();
		Carteira carteira = new Carteira();
		daoCarteira.adiciona(carteira);
		cliente.setCarteira(carteira);
		daoCliente.adiciona(cliente);
	}

	@AfterEach
	public void after() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void deveSalvarPedidoComEnderecoData() {
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Pedido novoPedido = PedidoBuilder.umPedido().comEnderecoData(endereco, LocalDate.now(), cliente).build();
		daoPedido.adiciona(novoPedido);
		assertNotNull(novoPedido.getId());
	}

	@Test
	public void deveSalvarPedidoCompleto() {
		Endereco endereco = new Endereco();
		endereco.setEndCep("555555");
		endereco.setEndCidade("Capoieras");
		endereco.setEndRua("Av.Cabral");
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Samsung");
		Produto smartphone = new Produto();
		smartphone.setNome("S22");
		smartphone.setValor(5000);
		daoProduto.adiciona(smartphone);
		Pedido novoPedido = PedidoBuilder.umPedido().completo(endereco, LocalDate.now(), cliente, smartphone).build();
//		PedidoProduto pedidoProduto = new PedidoProduto();
//		pedidoProduto.setQtd(1);
//		pedidoProduto.setValorUnidade(smartphone.getValor());
//		novoPedido.setPedidoProduto(pedidoProduto);
		daoPedido.adiciona(novoPedido);
		System.out.println(novoPedido.toString());
		assertNotNull(novoPedido.getId());

	}

}
