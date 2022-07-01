package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.servlets.dal.DalException;
import com.ipartek.formacion.servlets.dal.DaoFabrica;
import com.ipartek.formacion.servlets.dal.DaoReserva;
import com.ipartek.formacion.servlets.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO_USUARIO;
	static final DaoReserva DAO_RESERVA;
	private static final String CONFIGURACION = "configuracion.properties"; 
	
	static {
		try {
			// Diccionario clave/valor
			Properties props = new Properties();
			props.load(Globales.class.getClassLoader().getResourceAsStream(CONFIGURACION));
			
			String tipo = props.getProperty("dal.tipodao");
			String url = props.getProperty("dal.url");
			String user = props.getProperty("dal.user");
			String pass = props.getProperty("dal.pass");
			String driver = props.getProperty("dal.driver");
			
			DaoFabrica fabrica = new DaoFabrica(tipo, url, user, pass, driver);
			
			DAO_USUARIO = fabrica.getDaoUsuario();
			DAO_RESERVA = fabrica.getDaoReserva();
		} catch (IOException e) {
			throw new DalException("No se ha podido obtener la configuración");
		}
	}
}
