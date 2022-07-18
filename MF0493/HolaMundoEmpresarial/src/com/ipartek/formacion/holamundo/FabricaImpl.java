package com.ipartek.formacion.holamundo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class FabricaImpl implements Fabrica {

	private Salida salida;
	private Proveedor proveedor;

	public FabricaImpl() {
		try {
			Properties props = new Properties();
			props.load(FabricaImpl.class.getClassLoader().getResourceAsStream("fabrica.properties"));

			String pSalida = props.getProperty("salida");
			String pProveedor = props.getProperty("proveedor");

			salida = (Salida) Class.forName(pSalida).getDeclaredConstructor().newInstance();
			proveedor = (Proveedor) Class.forName(pProveedor).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Proveedor getProveedor() {
		return proveedor;
	}

	@Override
	public Salida getSalida() {
		return salida;
	}

}
