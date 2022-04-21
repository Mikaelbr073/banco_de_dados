package service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.ProdutoBuilder;
import dao.ClienteDAO;
import dao.TestEMFactory;
import model.entity.Cliente;
import model.entity.Fornecedor;
import model.entity.Produto;

class PedidoServiceTest {

	private EntityManager manager;
	private Produto produtoTest;
	private Cliente clienteTest;
	private ClienteDAO daoCliente;
	private ProdutoService serviceProduto;
	private Long idProduto;
	private Long idCliente;

	@BeforeEach
	public void before() {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Sony");
		serviceProduto = new ProdutoService();

		Produto novoProduto = ProdutoBuilder.umProduto().comNomeValor("PS2", 2000).build();
		novoProduto.adicionaFornecedor(fornecedor);
		produtoTest = serviceProduto.cadastrar(novoProduto);
		cadastrarClienteTest();
		System.out.println(produtoTest);
	}

	// @AfterEach
	public void after() {
		manager = TestEMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		manager.getTransaction().begin();
		Cliente clienteBD = daoCliente.buscaPorId(idCliente);
		daoCliente.removeCliente(clienteBD);
		serviceProduto.remove(serviceProduto.recuperarPorId(idProduto));
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	void naoDeveSalvarPedidoSemSaldoNaCarteira() {
//		PedidoService servicePedido = new PedidoService();
//		Pedido pedido = new Pedido();
//		LocalDate data = LocalDate.now();
//		Endereco endereco = new Endereco();
//		endereco.setEndCep("555555");
//		endereco.setEndCidade("Capoieras");
//		endereco.setEndRua("Av.Cabral");
//		pedido = PedidoBuilder.umPedido().completo(endereco, data, clienteTest, 100).build();
//		pedido.adicionaProdutoLista(produtoTest);
//		assertNotNull(servicePedido.cadastrar(pedido));
	}

	private void cadastrarClienteTest() {
		ClienteService serviceCliente = new ClienteService();
		clienteTest = ClienteFisicoBuilder.umCliente().comNome("Yudi").build();
		serviceCliente.cadastrar(clienteTest);
		System.out.println(clienteTest.getId());
	}

}
