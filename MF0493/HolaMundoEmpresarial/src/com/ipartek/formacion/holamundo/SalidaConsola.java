package com.ipartek.formacion.holamundo;

import org.springframework.stereotype.Component;

public class SalidaConsola implements Salida {

	@Override
	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

}
