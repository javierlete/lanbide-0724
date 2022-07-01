package com.ipartek.formacion.servlets.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.servlets.modelos.Usuario;


class DaoUsuarioMySql implements DaoUsuario {
	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	public DaoUsuarioMySql(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		// Esto sólo es necesario en proyectos web
		try {
			// Cargamos la clase que corresponde al driver de mysql
			// para que esté disponible para el DriverManager
			// porque no lo encuentra en las aplicaciones web,
			// aunque sí lo haga en aplicaciones de consola o escritorio
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha encontrado el driver de base de datos", e);
		}
	}

	// Antes de Java7 se tenían que gestionar los cierres de esta manera
	@Override
	public Iterable<Usuario> obtenerTodos() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();

			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los registros", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
			    usuario.setId(rs.getLong(1));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar el registro", e);
		}
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setLong(3, usuario.getId());

			if(pst.executeUpdate() != 1) {
				throw new DalException("No se ha encontrado el usuario a modificar");
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new DalException("No se ha podido modificar el registro", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			
			pst.setLong(1, id);

			if(pst.executeUpdate() != 1) {
				throw new DalException("No se ha encontrado el usuario a borrar");
			}
			
		} catch (SQLException e) {
			throw new DalException("No se ha podido modificar el registro", e);
		}
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {
			pst.setString(1, email);
			
			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

}
