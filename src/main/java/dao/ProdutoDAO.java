package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Produto;

/**
 * @author JJunio
 *
 */
public class ProdutoDAO {

	private GenericDAO<Produto> dao;

	public ProdutoDAO(EntityManager manager) {
		dao = new GenericDAO<Produto>(manager, Produto.class);
	}

	public Produto adiciona(Produto produto) {
		return dao.adiciona(produto);
	}

	public void removeProduto(Produto produto) {
		dao.remove(produto);
	}

	public Produto atualizar(Produto produto) {
		return dao.atualiza(produto);
	}

	public Produto recuperarPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public List<Produto> recuperarTodos() {
		return dao.listaTodos();
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
