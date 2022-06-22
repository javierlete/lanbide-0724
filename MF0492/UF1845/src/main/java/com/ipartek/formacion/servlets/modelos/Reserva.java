package com.ipartek.formacion.servlets.modelos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// La verificación de cada dato con null de manera que lance una excepción 
// puede ser muy recomendable para dejar bien claro cuando
// uno de los parámetros no se ha recibido (name incorrecto)

public class Reserva {
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private LocalDateTime fechaHora;
	private Integer numeroPersonas;
	private String comentarios;
	// private Set<Mesa> mesas = new HashSet<>();

	private Map<String, String> errores = new HashMap<>();

	public Reserva(Long id, String nombre, String email, String telefono, LocalDateTime fechaHora,
			Integer numeroPersonas, String comentarios) {
		setId(id);
		setNombre(nombre);
		setEmail(email);
		setTelefono(telefono);
		setFechaHora(fechaHora);
		setNumeroPersonas(numeroPersonas);
		setComentarios(comentarios);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 3) {
			errores.put("nombre", "El nombre debe tener 3 o más caracteres");
		}

		this.nombre = nombre.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
			throw new ModelosException("No he recibido el email");
		}

		if (email.trim().length() > 0 && !email.trim().matches("^\\w+@\\w+\\.\\w+$")) {
			errores.put("email", "Debes introducir un formato de email");
		}

		this.email = email.trim();
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null || !telefono.trim().matches("^\\d{9}$")) {
			errores.put("telefono", "El teléfono debe tener 9 dígitos");
		}

		this.telefono = telefono.trim();
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		if (fechaHora == null || fechaHora.isBefore(LocalDateTime.now())
				|| fechaHora.isAfter(LocalDateTime.now().plusMonths(1))) {
			errores.put("fechaHora", "No se pueden hacer reservas en el pasado ni de más de un mes");
		}

		this.fechaHora = fechaHora;
	}

	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(Integer numeroPersonas) {
		if (numeroPersonas == null || numeroPersonas < 1) {
			errores.put("numeroPersonas", "La reserva tiene que ser al menos para una persona");
		}

		this.numeroPersonas = numeroPersonas;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		if (comentarios == null) {
			throw new ModelosException("No se han recibido los comentarios");
		}
		
		this.comentarios = comentarios;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentarios, email, fechaHora, id, nombre, numeroPersonas, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(comentarios, other.comentarios) && Objects.equals(email, other.email)
				&& Objects.equals(fechaHora, other.fechaHora) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroPersonas, other.numeroPersonas)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", fechaHora=" + fechaHora + ", numeroPersonas=" + numeroPersonas + ", comentarios=" + comentarios
				+ ", errores=" + errores + "]";
	}

}
