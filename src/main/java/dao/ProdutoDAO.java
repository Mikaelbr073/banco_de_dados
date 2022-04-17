package dao;

import javax.persistence.EntityManager;

import model.entity.Pedido;
import model.entity.Produto;

/**
 * @author JJunio
 *
 */
public class ProdutoDAO {

	private GenericDAO<Produto> dao;

	public ProdutoDAO(EntityManager manager){
		dao = new GenericDAO<Produto>(manager, Produto.class);
	}

	public Produto adiciona(Produto p) {
		return dao.adiciona(p);
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
