package com.ipartek.formacion.mf0492.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ipartek.formacion.mf0492.modelos.Consulta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DaoConsultaMySql implements DaoConsulta {

	private String url, user, pass, driver;
	
	@Override
	public Consulta insertar(Consulta consulta) {
		try {
			Class.forName(driver);

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement ps = con
							.prepareStatement("INSERT INTO consultas (fecha, busqueda, usuarios_id) VALUES (?,?,?)")) {
				ps.setObject(1, consulta.getFecha());
				ps.setString(2, consulta.getBusqueda());
				ps.setLong(3, consulta.getUsuario().getId());

				ps.executeUpdate();
				
				return consulta;
			} catch (SQLException e) {
				throw new DalException("No se ha podido insertar la consulta", e);
			}
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver", e);
		}
		
		
	}

}
