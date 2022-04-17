package dao;

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

	public Fornecedor adiciona(Fornecedor f) {
		return dao.adiciona(f);
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
