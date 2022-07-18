package com.ipartek.formacion.holamundo;

public class HolaMundo {

	public static void main(String[] args) {
		Fabrica f = new FabricaImpl();
		
		Salida s = f.getSalida();
		Proveedor p = f.getProveedor();
		
		s.mostrar(p.getMensaje());
	}

}
