package com.ipartek.formacion.holamundo;

public class SalidaConsola implements Salida {

	@Override
	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}

}
