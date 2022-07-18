package com.ipartek.formacion.holamundo;

import java.util.*;

public class ProveedorConsola implements Proveedor {

	@SuppressWarnings("resource")
	@Override
	public String getMensaje() {
		return new Scanner(System.in).nextLine();
	}

}
