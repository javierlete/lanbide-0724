package com.ipartek.formacion.spring.mf0493.repositorios;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;

public interface InmuebleRepository extends PagingAndSortingRepository<Inmueble, Long> {
	Set<Inmueble> findByPrecioBetween(BigDecimal min, BigDecimal max);
	Set<Inmueble> findByTipo(Tipo tipo);
	Set<Inmueble> findByDescripcionContainingOrDireccionContaining(String nombre, String direccion);
}
