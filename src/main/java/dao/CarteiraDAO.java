package dao;

import javax.persistence.EntityManager;

import model.entity.Carteira;

/**
 * @author JJunio
 *
 */
public class CarteiraDAO {

	private GenericDAO<Carteira> dao;

	public CarteiraDAO(EntityManager manager){
		dao = new GenericDAO<Carteira>(manager, Carteira.class);
	}

	public Carteira adiciona(Carteira c) {
		return dao.adiciona(c);
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
