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

	public ProdutoService() {
		manager = EMFactory.getInstance().getEntityManager();
	}

	@Override
	public Produto cadastrar(Produto produto) {

		if (produtoValido(produto)) {
			dao = new ProdutoDAO(manager);
			manager.getTransaction().begin();
			dao.adiciona(produto);
			manager.getTransaction().commit();
			manager.close();
			return produto;
		}
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
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		dao.removeProduto(produto);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Produto atualizar(Produto produto) {
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		dao.atualizar(produto);
		manager.getTransaction().commit();
		manager.close();
		return produto;
	}

	@Override
	public List<Produto> listarTodos() {
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		List<Produto> produtosCadastradado = dao.recuperarTodos();
		manager.getTransaction().commit();
		manager.close();
		return produtosCadastradado;

	}

	@Override
	public Produto recuperarPorId(long id) {
		dao = new ProdutoDAO(manager);
		manager.getTransaction().begin();
		Produto produtoRecuperado = dao.recuperarPorId(id);
		manager.getTransaction().commit();
		manager.close();
		return produtoRecuperado;
	}

}