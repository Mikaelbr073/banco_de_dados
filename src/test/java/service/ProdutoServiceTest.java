package service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.TestEMFactory;
import model.entity.Fornecedor;
import model.entity.Produto;

class ProdutoServiceTest {

	EntityManager manager;
	ProdutoDAO dao;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	void test() {
		Fornecedor fornecedorApple = new Fornecedor();
		fornecedorApple.setNome("Apple");
		Produto produto = new Produto();
		produto.setNome("Iphone");
		produto.setDescricao("Muito caro");
		produto.setValor(12000);
		dao.adiciona(produto);
		
	}

}
