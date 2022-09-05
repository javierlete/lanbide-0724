package com.ipartek.formacion.spring.restaurantapp.repositorios;

import static org.junit.jupiter.api.Assertions.*; // Necesario para poder usar los métodos assert...

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;


@SpringBootTest
class ReservaRepositoryTest {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private ReservaRepository repo;
	
	private List<Object[]> registros;
	
	@BeforeEach
	void antesDeCadaMetodo() {
		registros = new ArrayList<>();
		
		registros.add(new Object[] {1L, "Javi", null, "123456789", LocalDateTime.of(2011, 1, 1, 1, 1), 2, null});
		registros.add(new Object[] {2L, "Pepe", null, "987654321", LocalDateTime.of(2012, 2, 2, 2, 2), 3, null});
		registros.add(new Object[] {3L, "Juan", null, "147384729", LocalDateTime.of(2013, 3, 3, 3, 3), 5, null});
		registros.add(new Object[] {4L, "Pedro", null, "184637463", LocalDateTime.of(2014, 4, 4, 4, 4), 2, null});
		
		jdbc.execute("TRUNCATE reservas");
		jdbc.batchUpdate("INSERT INTO reservas (id, nombre, email, telefono, fecha_hora, numero_personas, comentarios) VALUES (?,?,?,?,?,?,?)", registros);
	}
	
	@Test
	void insercionTest() {
		Reserva aInsertar = new Reserva(null, "Javier", null, "123456789", LocalDateTime.now(), 2, null);
		repo.save(aInsertar);
		
		Reserva recogido = repo.findById(5L).orElse(null);
		
		assertNotNull(recogido);
		assertEquals(aInsertar, recogido);
	}
	
	@Test
	void buscarPorNombreTest() {
		Set<Reserva> reservas = repo.findByNombreContainsIgnoreCaseOrderByFechaHora("Pepe");
		
		assertNotNull(reservas);
		assertEquals(1, reservas.size(), "No se ha recibido un sólo registro");
		
		Reserva reserva = reservas.iterator().next();
		Object[] datos = registros.get(1);
		
		Reserva reservaEsperada = new Reserva((Long)datos[0], (String)datos[1], (String)datos[2], (String)datos[3], (LocalDateTime)datos[4], (Integer)datos[5], (String)datos[6]);
		assertEquals(reservaEsperada, reserva);
	}
}
