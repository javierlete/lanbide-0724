package com.ipartek.formacion.spring.restaurantapp.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@DateTimeFormat(iso = ISO.DATE_TIME) // yyyy-MM-ddTHH:mm:ss
	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHora;
	
	@Min(value = 1)
	@Max(value = 10)
	private Integer numeroPersonas;
	
	@Lob // TEXT
	@Size(max = 2000)
	private String comentarios;
}
