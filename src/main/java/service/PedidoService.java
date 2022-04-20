package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.EMFactory;
import dao.PedidoDAO;
import model.entity.Carteira;
import model.entity.Pedido;

/**
 * @author JJunio
 *
 */
public class PedidoService implements Service<Pedido> {

	private EntityManager manager;
	private PedidoDAO daoPedido;

	public PedidoService() {
		daoPedido = new PedidoDAO(manager);
	}

	@Override
	public Pedido cadastrar(Pedido pedido) {
		if(pedidoValido(pedido)) {
			daoPedido.adiciona(pedido);
			manager.getTransaction().commit();
			manager.close();
			return pedido;
		}
		manager.getTransaction().rollback();
		manager.close();
		return null;
	}
	
	private boolean pedidoValido(Pedido pedido){
		manager = EMFactory.getInstance().getEntityManager();
		manager.getTransaction().begin();
		if (pedido.getCliente().getId() != null
				&& !pedido.getProdutos().isEmpty()) {
			if (verificarSaldoCarteira(pedido)) {
				int pontosObtidos = calculaPontosPedido(pedido.getValorTotal());
				if(atualizaPontosCarteira(manager, pontosObtidos, pedido)
						&& atualizaSaldoCarteira(manager, pedido)) {
					return true;
				}
				return false;
			} else {
				return false;
			}
		}
		return false;
	}

	private boolean verificarSaldoCarteira(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		double valorPedido = pedido.getValorTotal();
		Carteira carteiraCliente = pedido.getCliente().getCarteira();
		return carteiraCliente.getSaldo() >= valorPedido;
	}

	private int calculaPontosPedido(double valorTotal) {
		int pontos = (int) (valorTotal / 10);
		return pontos;
	}

	private boolean atualizaSaldoCarteira(EntityManager manager, Pedido pedido) {
		try {
			pedido.getCliente().getCarteira().atualizaSaldoCarteira(pedido.getValorTotal());
		} catch (Exception e) {

		}
		return false;
	}

	private boolean atualizaPontosCarteira(EntityManager manager, int pontos, Pedido pedido) {
		try {
			pedido.getCliente().getCarteira().atualizaPontosCarteira(pontos);
			return true;
		} catch (Exception e) {
			return false;
		}

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
