package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ClienteDAO;
import dao.EMFactory;
import model.entity.Cliente;

/**
 * @author JJunio
 *
 */
public class ClienteService implements Service<Cliente> {

	private EntityManager manager;
	private ClienteDAO daoCliente;

	public ClienteService() {
		manager = EMFactory.getInstance().getEntityManager();
		daoCliente = new ClienteDAO(manager);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {

		manager.getTransaction().begin();
		daoCliente.adiciona(cliente);
		manager.getTransaction().commit();
		manager.close();
		return cliente;

	}

	@Override
	public void remove(Cliente t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente atualizar(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente recuperarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
