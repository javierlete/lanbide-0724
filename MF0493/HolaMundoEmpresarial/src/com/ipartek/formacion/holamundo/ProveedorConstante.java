package com.ipartek.formacion.holamundo;

import org.springframework.stereotype.Component;

@Component
public class ProveedorConstante implements Proveedor {

	@Override
	public String getMensaje() {
		return "Hola Mundo";
	}

}
