package com.ipartek.formacion.servlets.dal;

import com.ipartek.formacion.servlets.modelos.Reserva;

public interface DaoReserva extends Dao<Reserva> {
	default Iterable<Reserva> obtenerPorEmail(String email) {
		throw new DalException("NO IMPLEMENTADO");
	};
}
