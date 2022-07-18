package com.ipartek.formacion.holamundo;

import org.springframework.stereotype.Component;

@Component
public class SalidaConsolaAdornada implements Salida {

	@Override
	public void mostrar(String mensaje) {
		System.out.println("--------");
		System.out.println(mensaje);
		System.out.println("--------");
	}

}
