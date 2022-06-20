package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.servlets.dal.DalException;
import com.ipartek.formacion.servlets.dal.DaoFabrica;
import com.ipartek.formacion.servlets.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO;
	private static final String CONFIGURACION = "configuracion.properties"; 
	
	static {
		try {
			// Diccionario clave/valor
			Properties props = new Properties();
			props.load(Globales.class.getClassLoader().getResourceAsStream(CONFIGURACION));
			
			String tipo = props.getProperty("dal.tipodao");
			
			DAO = new DaoFabrica(tipo).getDaoUsuario();
		} catch (IOException e) {
			throw new DalException("No se ha podido obtener la configuración");
		}
	}
}
