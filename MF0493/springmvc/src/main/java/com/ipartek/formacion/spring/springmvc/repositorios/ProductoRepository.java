package com.ipartek.formacion.spring.springmvc.repositorios;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springmvc.entidades.Producto;

// CrudRepository = Dao
// ProductoRepository = DaoProducto
// Implementación hecha automáticamente por Spring = DaoProductoMySql
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Iterable<Producto> findByNombre(String nombre);
	Iterable<Producto> findByFechaCaducidadLessThan(LocalDate fecha);
	
	// Consulta en JPQL (una especie de SQL orientado a objetos)
	// Existe la opción nativeQuery = true para usar consultas nativas de SQL puro
	@Query("select p from Producto p where p.fechaCaducidad < LocalDate.now()")
	Iterable<Producto> buscarCaducados();
}
