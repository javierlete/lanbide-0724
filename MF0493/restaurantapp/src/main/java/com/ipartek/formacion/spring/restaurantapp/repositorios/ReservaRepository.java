package com.ipartek.formacion.spring.restaurantapp.repositorios;

import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.Set;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
	Set<Reserva> findByNombreContainsIgnoreCaseOrderByFechaHora(String nombre);
	Set<Reserva> findByFechaHoraBetweenOrderByFechaHora(LocalDateTime inicio, LocalDateTime fin);
}
