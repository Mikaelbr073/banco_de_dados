package service;

import java.util.List;

/**
 * @author JJunio
 *
 */
public interface Service<T> {
	
	T cadastrar(T t);
	void remove(T t);
	T atualizar(T t);
	List<T> listarTodos();
	T recuperarPorId(long id);

}
