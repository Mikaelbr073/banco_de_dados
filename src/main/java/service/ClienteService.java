package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ClienteDAO;
import dao.EMFactory;
import model.entity.Carteira;
import model.entity.Cliente;

/**
 * @author JJunio
 *
 */
public class ClienteService implements Service<Cliente> {

	private EntityManager manager = EMFactory.getInstance().getEntityManager();
	private ClienteDAO daoCliente;

	public ClienteService() {
		daoCliente = new ClienteDAO(manager);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		try {
			manager.getTransaction().begin();
			Carteira carteira = new Carteira();
			cliente.setCarteira(carteira);
			daoCliente.adiciona(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			return null;
		}
		return cliente;

	}

	@Override
	public void remove(Cliente cliente) {

		try {
			manager.getTransaction().begin();
			daoCliente.removeCliente(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}

		}

	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		try {
			manager.getTransaction().begin();
			daoCliente.atualiza(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			return null;

		}		
		return cliente;
	}

	@Override
	public List<Cliente> listarTodos() {
		try {
			manager.getTransaction().begin();
			return daoCliente.listaTodos();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			return null;
		}			
		
	}

	@Override
	public Cliente recuperarPorId(long id) {
		try {
			manager.getTransaction().begin();
			return daoCliente.buscaPorId(id);
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			return null;
		}	
		
	}

}
