package com.ipartek.formacion.mf0492.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.mf0492.modelos.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DaoUsuarioMySql implements DaoUsuario {

	private String url, user, pass, driver;

	@Override
	public Usuario buscarPorNickname(String nickname) {
		try {
			Class.forName(driver);

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement ps = con
							.prepareStatement("SELECT id, nickname, password WHERE nickname = ?")) {
				ps.setString(1, nickname);

				try (ResultSet rs = ps.executeQuery()) {

					Usuario usuario = null;
					
					if (rs.next()) {
						// Al crear un objeto de tipo builder, podemos rellenar los campos
						// con un método para cada uno.
						// Para terminar la construcción del objeto, se debe llamar a build();
						usuario = Usuario.builder().id(rs.getLong("id")).nickname(rs.getString("nickname")).password(rs.getString("password")).build();
					}

					return usuario;
				}
			} catch (SQLException e) {
				throw new DalException("No se ha podido buscar el usuario", e);
			}
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver", e);
		}

	}

}
