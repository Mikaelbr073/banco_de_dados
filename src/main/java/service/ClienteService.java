package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ClienteDAO;
import dao.EMFactory;
import dao.ProdutoDAO;
import model.entity.Cliente;

/**
 * @author JJunio
 *
 */
public class ClienteService implements Service<Cliente> {

	private EntityManager manager;
	private ClienteDAO daoCliente;

	public ClienteService() {
		daoCliente = new ClienteDAO(manager);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		manager.getTransaction().begin();
		daoCliente.adiciona(cliente);
		manager.getTransaction().commit();
		manager.close();
		return cliente;

	}

	@Override
	public void remove(Cliente cliente) {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		manager.getTransaction().begin();
		daoCliente.removeCliente(cliente);
		manager.getTransaction().commit();
		manager.close();

	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		manager.getTransaction().begin();
		daoCliente.atualiza(cliente);
		manager.getTransaction().commit();
		manager.close();
		return cliente;
	}

	@Override
	public List<Cliente> listarTodos() {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		return daoCliente.listaTodos();
	}

	@Override
	public Cliente recuperarPorId(long id) {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
		return daoCliente.buscaPorId(id);
	}

}
