package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.EMFactory;
import dao.ProdutoDAO;
import model.entity.Produto;

/**
 * @author JJunio
 *
 */
public class ProdutoService implements Service<Produto> {

	EntityManager manager;
	ProdutoDAO dao;

	@Override
	public Produto cadastrar(Produto t) {
		manager = EMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		dao.adiciona(t);
		manager.getTransaction().commit();
		manager.close();
		return t;
	}

	@Override
	public void remove(Produto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produto atualizar(Produto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto recuperarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
