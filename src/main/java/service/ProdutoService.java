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

	EntityManager manager = EMFactory.getInstance().getEntityManager();
	ProdutoDAO daoProduto;

	public ProdutoService() {
		daoProduto = new ProdutoDAO(manager);
	}

	@Override
	public Produto cadastrar(Produto produto) {

		if (produtoValido(produto)) {
			manager.getTransaction().begin();
			daoProduto.adiciona(produto);
			manager.getTransaction().commit();
			manager.close();
			return produto;
		}
		manager.getTransaction().rollback();
		manager.close();
		return null;

	}

	private boolean produtoValido(Produto produto) {

		if (!produto.getFornecedorCollection().isEmpty() && produto.getValor() != 0 && !produto.getNome().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(Produto produto) {
		try {
			manager.getTransaction().begin();
			daoProduto.removeProduto(produto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
				manager.close();
			}
		}

	}

	@Override
	public Produto atualizar(Produto produto) {
		try {
			manager.getTransaction().begin();
			daoProduto.atualizar(produto);
			manager.getTransaction().commit();
			manager.close();
			return produto;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
				manager.close();
			}
		}

		return null;

	}

	@Override
	public List<Produto> listarTodos() {

		try {
			manager.getTransaction().begin();
			return daoProduto.recuperarTodos();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
				manager.close();
			}
		}

		return null;

	}

	@Override
	public Produto recuperarPorId(long id) {

		try {
			manager.getTransaction().begin();
			return daoProduto.recuperarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
				manager.close();
			}
		}

		return null;

	}

}