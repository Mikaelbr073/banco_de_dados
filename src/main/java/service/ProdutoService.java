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
	public void remove(Produto produto) {
		manager = EMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		dao.remover(produto);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Produto atualizar(Produto produto) {

		manager = EMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		dao.atualizar(produto);
		manager.getTransaction().commit();
		manager.close();
		return produto;
	}

	@Override
	public List<Produto> listarTodos() {
		manager = EMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		List<Produto> produtosCadastradado = dao.recuperarTodos();
		manager.getTransaction().commit();
		manager.close();
		return produtosCadastradado;

	}

	@Override
	public Produto recuperarPorId(long id) {
		manager = EMFactory.getInstance().getEntityManager();
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		Produto produtoRecuperado = dao.recuperarPorId(id);
		manager.getTransaction().commit();
		manager.close();
		return produtoRecuperado;
	}

}