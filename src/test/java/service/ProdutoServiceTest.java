package service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import dao.TestEMFactory;
import model.entity.Fornecedor;
import model.entity.Produto;

class ProdutoServiceTest {

	EntityManager manager;
	ProdutoDAO daoProduto;
	FornecedorDAO daoFornecedor;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		daoProduto = new ProdutoDAO(manager);
		daoFornecedor = new FornecedorDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	void naoDeveCadastarProdutoSemPreco() {
		ProdutoService serviceProduto = new ProdutoService();
		Fornecedor fornecedorApple = new Fornecedor();
		fornecedorApple.setNome("Apple");
		Produto produto = new Produto();
		produto.setNome("Iphone");
		produto.setDescricao("Muito caro");
		assertNull(serviceProduto.cadastrar(produto));

	}

	@Test
	void naoDeveCadastarProdutoSemFornecedor() {

		ProdutoService serviceProduto = new ProdutoService();
		Produto produto = new Produto();
		produto.setNome("Iphone");
		produto.setDescricao("Muito caro");
		assertNull(serviceProduto.cadastrar(produto));

	}

	@Test
	void naoDeveCadastarProdutoSemNome() {

		ProdutoService serviceProduto = new ProdutoService();
		Fornecedor fornecedorApple = new Fornecedor();
		fornecedorApple.setNome("Apple");
		Produto produto = new Produto();
		produto.setDescricao("Muito caro");
		produto.setValor(12000);
		assertNull(serviceProduto.cadastrar(produto));

	}

	@Test
	void deveCadastarProduto() {

		ProdutoService serviceProduto = new ProdutoService();
		Fornecedor fornecedorApple = new Fornecedor();
		fornecedorApple.setNome("Apple");
		Produto produto = new Produto();
		produto.setNome("Iphone");
		produto.setDescricao("Muito caro");
		produto.setValor(12000);
		produto.adicionaFornecedor(fornecedorApple);
		System.out.println(produto.getNome());
		System.out.println(produto.getValor());
		System.out.println(produto.getFornecedorCollection().isEmpty());
		System.out.println(produto.getId());
		assertNotNull(serviceProduto.cadastrar(produto).getId());

	}

}
