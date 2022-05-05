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
		this.manager = EMFactory.getInstance().getEntityManager();
		daoPedido = new PedidoDAO(manager);
	}

	@Override
	public Pedido cadastrar(Pedido pedido) {

		try {
			manager.getTransaction().begin();
			if (pedidoValido(pedido)) {
				daoPedido.adiciona(pedido);
				manager.getTransaction().commit();
				return pedido;
			}
			manager.getTransaction().rollback();
			manager.close();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			return null;
		}

		return null;
	}

	private boolean pedidoValido(Pedido pedido) {
		if (pedido.getCliente().getId() != null && !pedido.getProdutos().isEmpty()) {
			if (verificarSaldoCarteira(pedido)) {
				int pontosObtidos = calculaPontosPedido(pedido.getValorTotal());
				if (atualizaPontosCarteira(pontosObtidos, pedido) && atualizaSaldoCarteira(pedido)) {
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
		double valorPedido = pedido.getValorTotal();
		Carteira carteiraCliente = pedido.getCliente().getCarteira();
		return carteiraCliente.getSaldo() >= valorPedido;
	}

	private int calculaPontosPedido(double valorTotal) {
		int pontos = (int) (valorTotal / 10);
		return pontos;
	}

	private boolean atualizaSaldoCarteira(Pedido pedido) {
		try {
			pedido.getCliente().getCarteira().atualizaSaldoCarteira(pedido.getValorTotal());
		} catch (Exception e) {

		}
		return false;
	}

	private boolean atualizaPontosCarteira(int pontos, Pedido pedido) {
		try {
			pedido.getCliente().getCarteira().atualizaPontosCarteira(pontos);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void remove(Pedido pedido) {
		try {
			manager.getTransaction().begin();
			daoPedido.remover(pedido);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
		}
	}

	@Override
	public Pedido atualizar(Pedido pedido) {
		try {
			manager.getTransaction().begin();
			daoPedido.atulizar(pedido);
			manager.getTransaction().commit();
			return pedido;
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
		}
		return null;
	}

	@Override
	public List<Pedido> listarTodos() {
		try {
			manager.getTransaction().begin();
			return daoPedido.listarTodos();
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Pedido recuperarPorId(long id) {
		try {
			manager.getTransaction().begin();
			manager.close();
			return daoPedido.recuperarPorId(id);
		} catch (Exception e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
		}
		return null;
	}
}
