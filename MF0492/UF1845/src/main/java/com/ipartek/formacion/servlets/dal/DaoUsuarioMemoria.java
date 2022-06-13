package com.ipartek.formacion.servlets.dal;

import java.util.TreeMap;

import com.ipartek.formacion.servlets.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {
	private static final TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "javier@lete.net", "contra"));
		usuarios.put(2L, new Usuario(2L, "pepe@perez.net", "pepe"));
		usuarios.put(3L, new Usuario(3L, "juan@gonzalez.net", "juan"));
	}

	// SINGLETON
	private DaoUsuarioMemoria() {
	}

	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();

	public static DaoUsuarioMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}
	
	
}
