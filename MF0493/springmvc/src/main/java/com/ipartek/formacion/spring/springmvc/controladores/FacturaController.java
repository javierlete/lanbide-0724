package com.ipartek.formacion.spring.springmvc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springmvc.repositorios.FacturaRepository;

@Controller
@RequestMapping("/admin/facturas")
public class FacturaController {
	@Autowired
	private FacturaRepository repo;
	
	@GetMapping
	public String obtenerFacturas(Model modelo) {
		modelo.addAttribute("facturas", repo.findAll());
		return "facturas";
	}
	
	@GetMapping("{id}")
	public String obtenerFactura(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("factura", repo.findById(id).orElse(null));
		return "factura";
	}
}
