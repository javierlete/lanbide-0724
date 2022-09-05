package com.ipartek.formacion.spring.restaurantapp.servicios;

import com.ipartek.formacion.spring.restaurantapp.entidades.Reserva;

public interface ReservaService {
	Iterable<Reserva> listar();
	Reserva crear(Reserva reserva);
}
