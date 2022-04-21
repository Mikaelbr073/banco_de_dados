package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Fornecedor;

/**
 * @author JJunio
 *
 */
public class FornecedorDAO {

	private GenericDAO<Fornecedor> dao;

	public FornecedorDAO(EntityManager manager) {
		dao = new GenericDAO<Fornecedor>(manager, Fornecedor.class);
	}

	public Fornecedor adiciona(Fornecedor fornecedor) {
		return dao.adiciona(fornecedor);
	}

	public void removerFornecedor(Fornecedor fornecedor) {
		dao.remove(fornecedor);
	}

	public Fornecedor atulizar(Fornecedor fornecedor) {
		return dao.atualiza(fornecedor);

	}

	public Fornecedor recuperarPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public List<Fornecedor> recuperarTodos() {
		return dao.listaTodos();
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
