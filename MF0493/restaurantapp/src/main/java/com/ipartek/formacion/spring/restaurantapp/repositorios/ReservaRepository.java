package com.ipartek.formacion.spring.restaurantapp.repositorios;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;

@RepositoryRestResource(path = "reservas", collectionResourceRel = "reservas")
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
	Set<Reserva> findByNombreContainsIgnoreCaseOrderByFechaHora(String nombre);
	Set<Reserva> findByFechaHoraBetweenOrderByFechaHora(LocalDateTime inicio, LocalDateTime fin);
	
	Reserva findByTelefonoAndFechaHora(String telefono, @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime fechaHora);
	
	@Query("select r.nombre from Reserva r where r.id = :id")
	String getNombreById(Long id);
}
