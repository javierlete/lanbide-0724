package com.ipartek.formacion.servlets.dal;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new DalException("NO IMPLEMENTADO");
	}
}
