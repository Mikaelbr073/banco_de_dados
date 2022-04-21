package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteFisicoBuilder;
import builder.ProdutoBuilder;
import model.entity.Cliente;
import model.entity.Fornecedor;
import model.entity.Produto;

class PedidoServiceTest {

	private Produto produtoTest;
	private Cliente clienteTest;
	private ProdutoService serviceProduto;
	private Long idProduto;
	private Long idCliente;
	ClienteService serviceCliente;

	@BeforeEach
	public void before() {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Sony");
		serviceProduto = new ProdutoService();

		Produto novoProduto = ProdutoBuilder.umProduto().comNomeValor("PS2", 2000).build();
		novoProduto.adicionaFornecedor(fornecedor);
		produtoTest = serviceProduto.cadastrar(novoProduto);

		serviceCliente = new ClienteService();
		clienteTest = ClienteFisicoBuilder.umCliente().comNome("Yudi").build();
		serviceCliente.cadastrar(clienteTest);
		idProduto = produtoTest.getId();
		idCliente = clienteTest.getId();

	}

	@AfterEach
	public void after() {
		serviceCliente.remove(serviceCliente.recuperarPorId(idCliente));
		serviceProduto.remove(serviceProduto.recuperarPorId(idProduto));
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

}
