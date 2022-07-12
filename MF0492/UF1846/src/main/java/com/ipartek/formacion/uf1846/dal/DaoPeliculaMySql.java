package com.ipartek.formacion.uf1846.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.uf1846.modelos.Genero;
import com.ipartek.formacion.uf1846.modelos.Pelicula;

public class DaoPeliculaMySql implements DaoPelicula {
	private String url, user, password;

	public DaoPeliculaMySql(String url, String user, String password, String driver) {
		this.url = url;
		this.user = user;
		this.password = password;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido encontrar el driver de MySQL", e);
		}
	}

	private Connection conectar() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DalException("No se ha podido realizar la conexión", e);
		}
	}

	@Override
	public Iterable<Pelicula> obtenerTodos() {
		try (Connection con = conectar();
				CallableStatement cst = con.prepareCall("call peliculas_obtener_todos()");
				ResultSet rs = cst.executeQuery()) {
			ArrayList<Pelicula> peliculas = new ArrayList<>();

			Pelicula pelicula;
			Genero genero;

			while (rs.next()) {
				genero = new Genero(rs.getLong("genero_id"), rs.getString("genero"));
				pelicula = new Pelicula(rs.getLong("pelicula_id"), rs.getString("titulo"), rs.getBigDecimal("precio"),
						genero);

				peliculas.add(pelicula);
			}

			return peliculas;
		} catch (SQLException e) {
			throw new DalException("Ha habido un problema al obtener los registros", e);
		}
	}

	@Override
	public Pelicula obtenerPorId(Long id) {
		try (Connection con = conectar();
				CallableStatement cst = con.prepareCall("call peliculas_obtener_por_id(?)");) {

			cst.setLong(1, id);

			try (ResultSet rs = cst.executeQuery()) {
				Pelicula pelicula = null;
				Genero genero;

				if (rs.next()) {
					genero = new Genero(rs.getLong("genero_id"), rs.getString("genero"));
					pelicula = new Pelicula(rs.getLong("pelicula_id"), rs.getString("titulo"),
							rs.getBigDecimal("precio"), genero);
				}

				return pelicula;
			}
		} catch (SQLException e) {
			throw new DalException("Ha habido un problema al obtener el registro " + id, e);
		}
	}

	@Override
	public Pelicula insertar(Pelicula pelicula) {
		try (Connection con = conectar(); CallableStatement cst = con.prepareCall("call peliculas_insertar(?,?,?)");) {

			cst.setString(1, pelicula.getTitulo());
			cst.setBigDecimal(2, pelicula.getPrecio());
			cst.setLong(3, pelicula.getGenero().getId());

			try (ResultSet rs = cst.executeQuery()) {
				if (rs.next()) {
					pelicula.setId(rs.getLong(1));
				}

				return pelicula;
			} catch (Exception e) {
				throw new DalException("No se ha podido obtener el id generado", e);
			}
		} catch (SQLException e) {
			throw new DalException("Ha habido un problema al insertar el registro " + pelicula, e);
		}
	}

	@Override
	public Pelicula modificar(Pelicula pelicula) {
		try (Connection con = conectar();
				CallableStatement cst = con.prepareCall("call peliculas_modificar(?,?,?,?)");) {

			cst.setLong(1, pelicula.getId());
			cst.setString(2, pelicula.getTitulo());
			cst.setBigDecimal(3, pelicula.getPrecio());
			cst.setLong(4, pelicula.getGenero().getId());

			int numeroRegistrosModificados = cst.executeUpdate();
			
			if(numeroRegistrosModificados != 1) {
				throw new DalException("Error de concurrencia en modificación");
			}
			
			return pelicula;
		} catch (SQLException e) {
			throw new DalException("Ha habido un problema al insertar el registro " + pelicula, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = conectar();
				CallableStatement cst = con.prepareCall("call peliculas_borrar(?)");) {

			cst.setLong(1, id);

			int numeroRegistrosModificados = cst.executeUpdate();
			
			if(numeroRegistrosModificados != 1) {
				throw new DalException("Error de concurrencia en borrado");
			}
			
		} catch (SQLException e) {
			throw new DalException("Ha habido un problema al borrar el registro " + id, e);
		}
	}

}
