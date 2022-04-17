package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Pedido;
import model.entity.Produto;

public class PedidoDAOTest {

	EntityManager manager;
	PedidoDAO dao;

	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new PedidoDAO(manager);
		manager.getTransaction().begin();
	}

	@AfterEach
	public void after() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void deveSalvarProdutoComNomeValor() {
		/*Pedido novoProduto = PedidoBuilder.umPedido().cliente("SSD Sandisk",300).build();
		dao.adiciona(novoProduto);
		assertNotNull(novoProduto.getId());*/
	}

	@Test
	public void deveSalvarProdutoCompleto() {
		/*Pedido novoProduto = PedidoBuilder.umPedido().completo("João da Silva").build();
		dao.adiciona(novoProduto);
		assertNotNull(novoProduto.getId());*/
	}

}
