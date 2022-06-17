package com.ipartek.formacion.servlets.controladores;

import com.ipartek.formacion.servlets.dal.DaoFabrica;
import com.ipartek.formacion.servlets.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO = new DaoFabrica("memoria").getDaoUsuario();
}
