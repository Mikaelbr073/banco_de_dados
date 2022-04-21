package dao;

import java.util.List;

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
	
	public Pedido adiciona(Pedido pedido) {
		return dao.adiciona(pedido);
	}
	
	public void remover(Pedido pedido) {
		dao.remove(pedido);
	}
	
	public Pedido atulizar(Pedido pedido) {
		return dao.atualiza(pedido);
	}
	
	public Pedido recuperarPorId(Long id) {
		return dao.buscaPorId(id);
	}
	
	public List<Pedido> listarTodos(){
		return dao.listaTodos();
		}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
