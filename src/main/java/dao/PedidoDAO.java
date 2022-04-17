package dao;

import javax.persistence.EntityManager;

import model.entity.Pedido;

/**
 * @author JJunio
 *
 */
public class PedidoDAO{

	private GenericDAO<Pedido> dao;
	
	public PedidoDAO(EntityManager manager){
		dao = new GenericDAO<Pedido>(manager, Pedido.class);
	}
	
	public Pedido adiciona(Pedido p) {
		return dao.adiciona(p);
	}
	
	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
