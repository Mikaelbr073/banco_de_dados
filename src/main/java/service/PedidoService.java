package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.ClienteDAO;
import dao.EMFactory;
import dao.PedidoDAO;
import model.entity.Pedido;

/**
 * @author JJunio
 *
 */
public class PedidoService implements Service<Pedido> {

	EntityManager manager;
	PedidoDAO dao;

	@Override
	public Pedido cadastrar(Pedido t) {
		manager = EMFactory.getInstance().getEntityManager();
		dao = new PedidoDAO(manager);
		manager.getTransaction().begin();
		dao.adiciona(t);
		manager.getTransaction().commit();
		manager.close();
		return t;
	}

	@Override
	public void remove(Pedido t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido atualizar(Pedido t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido recuperarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
