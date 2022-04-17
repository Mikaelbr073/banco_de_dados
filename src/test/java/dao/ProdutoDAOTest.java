package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ProdutoBuilder;
import model.entity.Produto;

public class ProdutoDAOTest {

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
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void deveSalvarProdutoComNomeValor() {
		Produto novoProduto = ProdutoBuilder.umProduto().comNomeValor("SSD Sandisk",300).build();
		dao.adiciona(novoProduto);
		assertNotNull(novoProduto.getId());
	}

	@Test
	public void deveSalvarProdutoCompleto() {
		Produto novoProduto = ProdutoBuilder.umProduto().completo("Arroz", 56, "É bom").build();
		dao.adiciona(novoProduto);
		assertNotNull(novoProduto.getId());
	}

}
