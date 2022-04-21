package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builder.ClienteJuridicoBuilder;
import model.entity.Cliente;

public class ClienteJuridicoDAOTest {
	
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
	public void deveSalvarCliente() {
		Cliente novoCliente = ClienteJuridicoBuilder.umCliente().comRazaoSocial("IFPE Autarquia Federal").build();
        dao.adiciona(novoCliente);
        assertNotNull(novoCliente.getId());
	}
	
	@Test
	public void deveEncontrarPeloId() {
		Cliente novoCliente = ClienteJuridicoBuilder.umCliente().comRazaoSocial("IFPE Autarquia Federal").build();
	    dao.adiciona(novoCliente);
		
	    Cliente cleinteDoBanco = dao.buscaPorId(novoCliente.getId());
	    assertNotNull(cleinteDoBanco);
	    assertEquals(novoCliente.getNome(), cleinteDoBanco.getNome());
	}
	
	@Test
	public void naoDeveEncontrarPeloId() {
		Cliente clienteDoBanco = dao.buscaPorId(-1l);
	    assertNull(clienteDoBanco);
	}
	
	@Test
	public void deveDeletarUmCliente() {
		Cliente novoCliente = ClienteJuridicoBuilder.umCliente().comRazaoSocial("IFPE Autarquia Federal").build();
	    
		dao.adiciona(novoCliente);
		
		Long idCliente = novoCliente.getId();
		
	    dao.removeCliente(novoCliente);
	    
	    manager.flush();
	    
	    Cliente clienteDoBanco = dao.buscaPorId(idCliente);
	    assertNull(clienteDoBanco);
	}
	
	@Test
	public void deveAtualizarUmCliente() {
		Cliente novoCliente = ClienteJuridicoBuilder.umCliente().comRazaoSocial("IFPE Autarquia Federal").build();
		dao.adiciona(novoCliente);
		
		Long idCliente = novoCliente.getId();
		
		novoCliente.setNome("Instituto Federal de Pernambuco");
	    dao.atualiza(novoCliente);
	    
	    manager.flush();
	    
	    Cliente clienteDoBanco = dao.buscaPorId(idCliente);
	    assertNotNull(clienteDoBanco);
	    assertEquals("Instituto Federal de Pernambuco", clienteDoBanco.getNome());
	}

}
