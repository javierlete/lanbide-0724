package com.ipartek.formacion.mf0492.controladores;

import com.ipartek.formacion.mf0492.dal.DaoArea;
import com.ipartek.formacion.mf0492.dal.DaoAreaMySql;
import com.ipartek.formacion.mf0492.dal.DaoConsulta;
import com.ipartek.formacion.mf0492.dal.DaoConsultaMySql;
import com.ipartek.formacion.mf0492.dal.DaoUsuario;
import com.ipartek.formacion.mf0492.dal.DaoUsuarioMySql;

public class Globales {
	private static final String URL = "jdbc:mysql://localhost:3306/mf0492";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	static final String VISTAS = "/WEB-INF/vistas";
	
	static final DaoArea DAO_AREA = new DaoAreaMySql(URL, USER, PASS, DRIVER);
	static final DaoConsulta DAO_CONSULTA = new DaoConsultaMySql(URL, USER, PASS, DRIVER);
	static final DaoUsuario DAO_USUARIO = new DaoUsuarioMySql(URL, USER, PASS, DRIVER);
	
}
