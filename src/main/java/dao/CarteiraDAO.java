package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Carteira;

/**
 * @author JJunio
 *
 */
public class CarteiraDAO {

	private GenericDAO<Carteira> dao;

	public CarteiraDAO(EntityManager manager) {
		dao = new GenericDAO<Carteira>(manager, Carteira.class);
	}

	public Carteira adiciona(Carteira carteira) {
		return dao.adiciona(carteira);
	}

	public void removeCarteira(Carteira carteira) {
		dao.remove(carteira);
	}
	
	public Carteira atulizaCarteira(Carteira carteira) {
		return dao.atualiza(carteira);
	}
	
	public Carteira recuperarPorId(Long id) {
		return dao.buscaPorId(id);
	}
	
	public List<Carteira> listarTodos(){
		return dao.listaTodos();
	}
	

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
