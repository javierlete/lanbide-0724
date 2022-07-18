package com.ipartek.formacion.holamundo;

public class SalidaConsolaAdornada implements Salida {

	@Override
	public void mostrar(String mensaje) {
		System.out.println("--------");
		System.out.println(mensaje);
		System.out.println("--------");
	}

}
