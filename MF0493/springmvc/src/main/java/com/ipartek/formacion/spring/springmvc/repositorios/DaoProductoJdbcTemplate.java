package com.ipartek.formacion.spring.springmvc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springmvc.entidades.Producto;

@Repository
public class DaoProductoJdbcTemplate implements DaoProducto {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return jdbc.query("SELECT * FROM productos", new BeanPropertyRowMapper<Producto>(Producto.class));
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM productos WHERE id = ?", new BeanPropertyRowMapper<Producto>(Producto.class), id);
	}

	@Override
	public Producto insertar(Producto producto) {
		jdbc.update("INSERT INTO productos (nombre, precio, fecha_caducidad, stock) VALUES (?,?,?,?)", producto.getNombre(), producto.getPrecio(), producto.getFechaCaducidad(), producto.getStock());
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		jdbc.update("UPDATE productos SET nombre=?, precio=?, fecha_caducidad=?, stock=? WHERE id = ?", producto.getNombre(), producto.getPrecio(), producto.getFechaCaducidad(), producto.getStock(), producto.getId());
		return producto;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM productos WHERE id=?", id);
	}

}
