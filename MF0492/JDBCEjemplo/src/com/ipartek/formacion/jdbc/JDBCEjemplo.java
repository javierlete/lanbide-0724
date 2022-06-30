package com.ipartek.formacion.jdbc;

import java.sql.*;

public class JDBCEjemplo {
	private static final String URL = "jdbc:mysql://localhost:3306/uf1846m";
	private static final String USER = "root";
	private static final String PASS = "admin";

	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT id, email, password FROM usuarios WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);

		while (rs.next()) {
			System.out.println(rs.getLong("id") + "\t" + rs.getString("email") + "\t" + rs.getString("password"));
		}

		PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
		
		Long id = 2L;
		
		pst.setLong(1, id);
		
		rs = pst.executeQuery();

		if (rs.next()) {
			System.out.println(rs.getLong("id") + "\t" + rs.getString("email") + "\t" + rs.getString("password"));
		}
		
		pst = con.prepareStatement(SQL_INSERT);
		
		pst.setString(1, "nuevo@nuevez.net");
		pst.setString(2, "nuevo");
		
		int numeroRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		pst = con.prepareStatement(SQL_UPDATE);
		
		pst.setString(1, "modificado@nuevez.net");
		pst.setString(2, "modificadez");
		pst.setLong(3, 3L);
		
		numeroRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		pst = con.prepareStatement(SQL_DELETE);
		
		pst.setLong(1, 3L);
		
		numeroRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
	}
}
