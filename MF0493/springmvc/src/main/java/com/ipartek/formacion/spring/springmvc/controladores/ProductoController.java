package com.ipartek.formacion.spring.springmvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springmvc.entidades.Producto;

@Controller
@RequestMapping("/admin/producto")
public class ProductoController {
	@GetMapping
	public String mostrarFormulario() {
		return "producto";
	}
	
	@PostMapping
	public String recibirFormulario(Producto producto) {
		// System.out.println(producto);
		return "producto-detalle";
	}
}
