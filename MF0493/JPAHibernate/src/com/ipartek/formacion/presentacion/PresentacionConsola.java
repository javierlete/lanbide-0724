package com.ipartek.formacion.presentacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.ipartek.formacion.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PresentacionConsola {
	public static void main(String[] args) {
		// Sólo una vez por programa
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ipartek.formacion.entidades");
		
		// Uno por cada operación
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(new Producto(null, "Pantalla", new BigDecimal("123.5"), LocalDate.now(), 1));
		em.persist(new Producto(null, "Ratón", new BigDecimal("12.5"), LocalDate.now(), 1));
		
		List<Producto> productos = em.createQuery( "from Producto", Producto.class).getResultList();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		
		em.getTransaction().commit();
		
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Producto producto = em.find(Producto.class, 1L);
		
		System.out.println(producto);
		
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		producto = em.find(Producto.class, 1L);
		
		producto.setNombre("Modificado");
		producto.setStock(2000);
		
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		producto = em.find(Producto.class, 1L);
		
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		producto = new Producto(2L, "Modificado", new BigDecimal("12345.5"), LocalDate.now(), 5);
		
		em.merge(producto);
		
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.find(Producto.class, 2L));
		
		em.getTransaction().commit();
		em.close();

	}
}
