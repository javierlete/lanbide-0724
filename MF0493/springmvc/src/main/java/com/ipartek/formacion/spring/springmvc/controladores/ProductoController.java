package com.ipartek.formacion.spring.springmvc.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springmvc.entidades.Producto;

@Controller
@RequestMapping("/admin/producto")
public class ProductoController {
	@GetMapping
	// Paso producto simplemente para que se cree un producto vacío para poder rellenar
	// el th:object inicial
	public String mostrarFormulario(Producto producto) {
		// Devolvemos el nombre de una vista que se completa con un prefijo y sufijo
		// /templates/producto.html
		return "producto";
	}
	
	@PostMapping
	// @Valid lanza la validación de todos los atributos de producto
	// Deja el resultado en el bindingResult que tiene que estar necesariamente
	// después del objeto que valida
	public String recibirFormulario(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "producto";
		}
		
		return "producto-detalle";
	}
}
