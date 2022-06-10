package com.ipartek.formacion.servlets.modelos;

import java.util.Objects;

// Con qué tipos de datos quiero trabajar
// Pueden ser tipos recibidos de los formularios
// o también tipos que queremos visualizar en las pantallas
// No dependen de ninguna API que no sea la estándar
// (No se usará javax.servlet, jakarta.servlet...)

// POJOs (Plain Old Java Objects)

public class Usuario {
	private Long id;
	private String email;
	private String password;
	
	public Usuario(Long id, String email, String password) {
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
