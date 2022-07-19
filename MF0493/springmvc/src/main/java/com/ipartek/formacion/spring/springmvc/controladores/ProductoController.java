package com.ipartek.formacion.spring.springmvc.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springmvc.entidades.Producto;
import com.ipartek.formacion.spring.springmvc.repositorios.DaoProducto;

@Controller
@RequestMapping("/admin/productos")
public class ProductoController {
	@Autowired
	private DaoProducto dao;
	
	@GetMapping
	public String mostrarListado(Model modelo) {
		modelo.addAttribute("productos", dao.obtenerTodos());
		return "productos";
	}
	
	@GetMapping("/formulario")
	// Paso producto simplemente para que se cree un producto vacío para poder rellenar
	// el th:object inicial
	public String mostrarFormulario(Producto producto) {
		// Devolvemos el nombre de una vista que se completa con un prefijo y sufijo
		// /templates/producto.html
		return "producto";
	}
	
	@GetMapping("/formulario/{id}")
	public String mostrarFormularioConProducto(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", dao.obtenerPorId(id));
		return "producto";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		dao.borrar(id);
		return "redirect:/admin/productos";
	}
	
	@PostMapping("/formulario/*")
	// @Valid lanza la validación de todos los atributos de producto
	// Deja el resultado en el bindingResult que tiene que estar necesariamente
	// después del objeto que valida
	public String recibirFormulario(@Valid Producto producto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "producto";
		}
		
		if(producto.getId() != null) {
			dao.modificar(producto);
		} else {
			dao.insertar(producto);
		}
		
		return "redirect:/admin/productos";
		//return "producto-detalle";
	}
}
