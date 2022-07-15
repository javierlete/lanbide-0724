package com.ipartek.formacion.mf0492.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0492.modelos.Area;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DaoAreaMySql implements DaoArea {

	private String url, user, pass, driver;

	@Override
	public Iterable<Area> buscarPorCodigoPostal(String codigoPostal) {
		try {
			Class.forName(driver);

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement ps = con
							.prepareStatement("SELECT id, municipio, codigo_postal WHERE codigo_postal LIKE ?")) {
				ps.setString(1, codigoPostal);

				ArrayList<Area> areas;

				try (ResultSet rs = ps.executeQuery()) {
					areas = new ArrayList<>();

					Area area;

					while (rs.next()) {
						// new Area(rs.getLong("id"), rs.getString("municipio"),
						// rs.getString("codigo_postal"));
						area = Area.builder().id(rs.getLong("id")).municipio(rs.getString("municipio"))
								.codigoPostal(rs.getString("codigo_postal")).build();

						areas.add(area);
					}

					return areas;
				}
			} catch (SQLException e) {
				throw new DalException("No se ha podido buscar el municipio", e);
			}
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver", e);
		}

	}

}
