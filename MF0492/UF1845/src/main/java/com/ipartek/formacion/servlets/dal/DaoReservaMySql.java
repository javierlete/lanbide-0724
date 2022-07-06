package com.ipartek.formacion.servlets.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.ipartek.formacion.servlets.modelos.Reserva;


class DaoReservaMySql implements DaoReserva {
	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, nombre, email, telefono, fecha_hora, numero_personas, comentarios FROM reservas";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email = ?";
	
	private static final String SQL_INSERT = "INSERT INTO reservas (nombre, email, telefono, fecha_hora, numero_personas, comentarios) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE reservas SET nombre = ?, email = ?, telefono = ?, fecha_hora = ?, numero_personas = ?, comentarios  = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM reservas WHERE id = ?";

	public DaoReservaMySql(String url, String user, String pass, String driver) {
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
	public Iterable<Reserva> obtenerTodos() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();

			ArrayList<Reserva> reservas = new ArrayList<>();
			Reserva reserva;

			while (rs.next()) {
				reserva = new Reserva(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), (LocalDateTime)rs.getObject("fecha_hora"), rs.getInt("numero_personas"), rs.getString("comentarios"));
				reservas.add(reserva);
			}

			return reservas;
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
	public Reserva obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				Reserva reserva = null;

				if (rs.next()) {
					reserva = new Reserva(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), (LocalDateTime)rs.getObject("fecha_hora"), rs.getInt("numero_personas"), rs.getString("comentarios"));
				}

				return reserva;
			}
		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Reserva insertar(Reserva reserva) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, reserva.getNombre());
			pst.setString(2, reserva.getEmail());
			pst.setString(3, reserva.getTelefono());
			pst.setObject(4, reserva.getFechaHora());
			pst.setInt(5, reserva.getNumeroPersonas());
			pst.setString(6, reserva.getComentarios());

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
			    reserva.setId(rs.getLong(1));
			}
			
			return reserva;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar el registro", e);
		}
	}

	@Override
	public Reserva modificar(Reserva reserva) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, reserva.getNombre());
			pst.setString(2, reserva.getEmail());
			pst.setString(3, reserva.getTelefono());
			pst.setObject(4, reserva.getFechaHora());
			pst.setInt(5, reserva.getNumeroPersonas());
			pst.setString(6, reserva.getComentarios());
			pst.setLong(7, reserva.getId());

			if(pst.executeUpdate() != 1) {
				throw new DalException("No se ha encontrado la reserva a modificar");
			}
			
			return reserva;
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
				throw new DalException("No se ha encontrado el reserva a borrar");
			}
			
		} catch (SQLException e) {
			throw new DalException("No se ha podido modificar el registro", e);
		}
	}

	@Override
	public Iterable<Reserva> obtenerPorEmail(String email) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {
			pst.setString(1, email);
			
			try (ResultSet rs = pst.executeQuery()) {
				Reserva reserva = null;

				ArrayList<Reserva> reservas = new ArrayList<>();
				
				while (rs.next()) {
					reserva = new Reserva(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), (LocalDateTime)rs.getObject("fecha_hora"), rs.getInt("numero_personas"), rs.getString("comentarios"));
					reservas.add(reserva);
				}

				return reservas;
			}
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los registros", e);
		}
	}
}
