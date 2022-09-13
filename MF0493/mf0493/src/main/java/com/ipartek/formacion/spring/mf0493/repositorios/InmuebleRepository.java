package com.ipartek.formacion.spring.mf0493.repositorios;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;

@RepositoryRestResource(collectionResourceRel = "inmuebles", path = "inmuebles")
public interface InmuebleRepository extends PagingAndSortingRepository<Inmueble, Long> {
	Set<Inmueble> findByPrecioBetween(BigDecimal min, BigDecimal max);
	Set<Inmueble> findByTipo(Tipo tipo);
	Set<Inmueble> findByDescripcionContainingOrDireccionContaining(String nombre, String direccion);
	
	@Query( 
			"SELECT i FROM Inmueble i WHERE i.precio BETWEEN COALESCE(:min, 0) AND COALESCE(:max, 1000000000000000000) AND (:tipo is null OR i.tipo = :tipo) AND (i.descripcion like CONCAT('%', :texto, '%') OR i.direccion like CONCAT('%', :texto, '%'))")
	Set<Inmueble> findByMinMaxTipoNombreDireccion(BigDecimal min, BigDecimal max, Tipo tipo, String texto);
	
	@RestResource(exported = false)
	void deleteById(Long id);
}
