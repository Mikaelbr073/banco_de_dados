package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entity.Carteira;
import model.entity.Cliente;

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
	
	public Carteira procurarPorCliente(Cliente cliente) {
		EntityManager em = EMFactory.getInstance().getEntityManager();
		String jpql = "SELECT c FROM carteira c WHERE c.id_cliente = ";
		TypedQuery<Carteira> consulta = em.createQuery(jpql + cliente.getId(), Carteira.class);
		List<Carteira> carteira = consulta.getResultList();
		em.close();
		return carteira.get(0);
		
	}
	

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}
}
