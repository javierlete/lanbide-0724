package com.ipartek.formacion.spring.mf0493.servicios;

import java.math.BigDecimal;

import com.ipartek.formacion.spring.mf0493.entidades.Inmueble;
import com.ipartek.formacion.spring.mf0493.entidades.Inmueble.Tipo;

public interface InmuebleService {
	Iterable<Inmueble> rangoDePrecio(BigDecimal min, BigDecimal max);
	Iterable<Inmueble> alquilerVentaOTodas(Tipo tipo);
	Iterable<Inmueble> nombreODireccion(String texto);
	
	Iterable<Inmueble> buscador(BigDecimal min, BigDecimal max, Tipo tipo, String texto);
}
