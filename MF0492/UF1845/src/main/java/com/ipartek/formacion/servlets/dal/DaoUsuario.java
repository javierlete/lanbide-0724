package com.ipartek.formacion.servlets.dal;

import com.ipartek.formacion.servlets.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	default Usuario obtenerPorEmail(String email) {
		throw new DalException("NO IMPLEMENTADO");
	}
}
