package com.ipartek.formacion.spring.restaurantapp.servicios;

// Este import hay que introducirlo a mano
// No nos lo da el Organize Imports (CTRL-SHIFT-O)
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;

@SpringBootTest
public class ReservaServiceTest {
	@Autowired
	// Siempre utilizamos a la hora de declarar interfaces
	// si están disponibles en lugar de las clases que implementan
	private ReservaService servicio;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private List<Object[]> registros;

	@BeforeEach
	void antesDeCadaMetodo() {
		registros = new ArrayList<>();

		registros.add(new Object[] { 1L, "Javi", null, "123456789", LocalDateTime.of(2011, 1, 1, 1, 1), 2, null });
		registros.add(new Object[] { 2L, "Pepe", null, "987654321", LocalDateTime.of(2012, 2, 2, 2, 2), 3, null });
		registros.add(new Object[] { 3L, "Juan", null, "147384729", LocalDateTime.of(2013, 3, 3, 3, 3), 5, null });
		registros.add(new Object[] { 4L, "Pedro", null, "184637463", LocalDateTime.of(2014, 4, 4, 4, 4), 2, null });

		jdbc.execute("TRUNCATE reservas");
		jdbc.batchUpdate(
				"INSERT INTO reservas (id, nombre, email, telefono, fecha_hora, numero_personas, comentarios) VALUES (?,?,?,?,?,?,?)",
				registros);
	}
	
	@Test
	void listar() {
		Iterable<Reserva> reservas = servicio.listar();
		
		Iterator<Reserva> iterator = reservas.iterator();
		
		int contador = 0;
		
		while(iterator.hasNext()) {
			iterator.next();
			contador++;
		}
		
		assertNotNull(reservas);
		assertEquals(4, contador);
	}
	
	@Test
	void crear() {
		Reserva reserva = new Reserva(null, "Javier", null, "123456789", LocalDateTime.now(), 2, null);
		Reserva recibida = servicio.crear(reserva);
		
		assertNotNull(recibida);
		assertNotNull(recibida.getId());
		assertEquals(reserva, recibida);
	}
}
