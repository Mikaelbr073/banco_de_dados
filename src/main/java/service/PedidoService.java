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

	public PedidoService() {

	}

	@Override
	public Pedido cadastrar(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		daoPedido = new PedidoDAO(manager);
		manager.getTransaction().begin();
		System.out.println(verificarSaldoCarteira(pedido));
		daoPedido.adiciona(pedido);
		manager.getTransaction().commit();
		manager.close();
		return pedido;
	}

	private boolean verificarSaldoCarteira(Pedido pedido) {
		manager = EMFactory.getInstance().getEntityManager();
		CarteiraDAO daoCarteira = new CarteiraDAO(manager);
		double valorPedido = pedido.getValorTotal();
		Carteira carteiraCliente = daoCarteira.procurarPorCliente(pedido.getCliente());
		System.out.println(valorPedido);
		System.out.println(carteiraCliente.getSaldo());
		return carteiraCliente.getSaldo() >= valorPedido;
	}

	private int calculaPontosPedido(double valorTotal) {
		int pontos = (int) (valorTotal / 10);
		return pontos;
	}

	private void atualizaSaldoCarteira() {

	}

	private void atualizaPontosCarteira() {

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
