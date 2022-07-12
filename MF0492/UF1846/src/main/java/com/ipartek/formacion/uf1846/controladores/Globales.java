package com.ipartek.formacion.uf1846.controladores;

import com.ipartek.formacion.uf1846.dal.DaoPelicula;
import com.ipartek.formacion.uf1846.dal.DaoPeliculaMySql;

class Globales {
	static DaoPelicula DAO = new DaoPeliculaMySql("jdbc:mysql://localhost:3306/ipartekflix", "ipartekflix", "contraseña", "com.mysql.cj.jdbc.Driver");
	static String VISTAS = "/WEB-INF/vistas";
}
