package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.accesodatos;

// Data Access Object
// CRUD: Create, Retrieve, Update, Delete 
// (Altas, bajas, modificaciones y consultas)
public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(Long id);
}
