package com.ipartek.formacion.spring.restaurantapp.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Reserva(Long id, @NotNull @NotBlank @Size(min = 3, max = 50) String nombre,
			@Email @Size(max = 50) String email,
			@NotNull @NotBlank @Pattern(regexp = "^\\d{9}$") @Size(max = 9) String telefono,
			@NotNull LocalDateTime fechaHora, @NotNull @Min(1) @Max(10) Integer numeroPersonas,
			@Size(max = 2000) String comentarios) {
		this(id, null, nombre, email, telefono, fechaHora, numeroPersonas, comentarios);
	}

	@NotNull
	@ManyToOne
	@JsonBackReference
	private Usuario usuario;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 50)
	private String nombre;
	
	@Email
	@Size(max = 50)
	private String email;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^\\d{9}$")
	@Column(columnDefinition = "CHAR(9)")
	@Size(max = 9)
	private String telefono;
	
	@NotNull
	// Pasado al fichero de configuración global: @DateTimeFormat(iso = ISO.DATE_TIME) // yyyy-MM-ddTHH:mm:ss
	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHora;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 10)
	private Integer numeroPersonas;
	
	@Lob // TEXT
	@Size(max = 2000)
	private String comentarios;
}
