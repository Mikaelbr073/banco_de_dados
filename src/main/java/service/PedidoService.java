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

	private EntityManager manager;
	private PedidoDAO daoPedido;
	private CarteiraDAO daoCarteira;

	public PedidoService() {
		daoPedido = new PedidoDAO(manager);
		daoCarteira = new CarteiraDAO(manager);
	}

	@Override
	public Pedido cadastrar(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		manager.getTransaction().begin();
		System.out.println(verificarSaldoCarteira(pedido));
		if (verificarSaldoCarteira(pedido)) {
			daoPedido.adiciona(pedido);
			manager.getTransaction().commit();
			manager.close();
			return pedido;
		}
		return null;
	}

	private boolean verificarSaldoCarteira(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		double valorPedido = pedido.getValorTotal();
		Carteira carteiraCliente = pedido.getCliente().getCarteira();
		System.out.println(valorPedido);
		System.out.println(carteiraCliente.getSaldo());
		return carteiraCliente.getSaldo() >= valorPedido;
	}

	private int calculaPontosPedido(double valorTotal) {
		int pontos = (int) (valorTotal / 10);
		System.out.println("Calculando pontos");
		return pontos;
	}

	private boolean atualizaSaldoCarteira() {
		System.out.println("Atualizando Saldo");
		return false;
	}

	private boolean atualizaPontosCarteira() {
		System.out.println("Atualizando Pontos");
		return false;
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
