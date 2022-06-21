package com.ipartek.formacion.servlets.dal;

import java.util.TreeMap;

import com.ipartek.formacion.servlets.modelos.Reserva;

class DaoReservaMemoria implements DaoReserva {
	private static final TreeMap<Long, Reserva> reservas = new TreeMap<>();

	@Override
	public Iterable<Reserva> obtenerTodos() {
		return reservas.values();
	}

	@Override
	public Reserva insertar(Reserva reserva) {
		Long id = reservas.size() > 0 ? reservas.lastKey() + 1L : 1L;
		reserva.setId(id);
		reservas.put(id, reserva);
		
		return reserva;
	}

}
