package com.ipartek.formacion.spring.springmvc.repositorios;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.springmvc.entidades.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{
	@Query("select f from Factura f join fetch f.cliente c join fetch c.usuario u join fetch u.rol r")
	Set<Factura> findAll();

	@Query("select f from Factura f join fetch f.cliente c join fetch f.productos p join fetch c.usuario u join fetch u.rol r where f.id = :id")
	Optional<Factura> findById(Long id);
}
