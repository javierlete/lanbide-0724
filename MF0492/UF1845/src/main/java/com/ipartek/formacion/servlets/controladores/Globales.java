package com.ipartek.formacion.servlets.controladores;

import com.ipartek.formacion.servlets.dal.DaoUsuario;
import com.ipartek.formacion.servlets.dal.DaoUsuarioMemoria;

public class Globales {
	static final DaoUsuario DAO = DaoUsuarioMemoria.getInstancia(); 
}
