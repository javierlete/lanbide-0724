package com.ipartek.formacion.spring.mf0493.servicios;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;

public interface InmuebleAdminService {
	Inmueble alta(Inmueble inmueble);
	Iterable<Inmueble> listado();
}
