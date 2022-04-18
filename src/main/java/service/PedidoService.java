package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.CarteiraDAO;
import dao.EMFactory;
import dao.PedidoDAO;
import model.entity.Carteira;
import model.entity.Pedido;

/**
 * @author JJunio
 *
 */
public class PedidoService implements Service<Pedido> {

	EntityManager manager;
	PedidoDAO daoPedido;
	CarteiraDAO daoCarteira;

	@Override
	public Pedido cadastrar(Pedido t) {
		manager = EMFactory.getInstance().getEntityManager();
		daoPedido = new PedidoDAO(manager);
		manager.getTransaction().begin();
		daoPedido.adiciona(t);
		manager.getTransaction().commit();
		manager.close();
		return t;
	}
	
	
	private boolean verificarSaldoCarteira(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		CarteiraDAO daoCarteira = new CarteiraDAO(manager);
		double valorPedido = pedido.getValorTotal();
		Carteira carteiraCliente = procurarPorCliente(pedido.getCliente());
		return carteiraCliente.getSaldo() >= valorPedido;
	}

	
	
	@Override
	public void remove(Pedido t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido atualizar(Pedido t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido recuperarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
