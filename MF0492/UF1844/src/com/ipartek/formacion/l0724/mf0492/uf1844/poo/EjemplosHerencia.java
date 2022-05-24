package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class EjemplosHerencia {

	public static void main(String[] args) {
		Empleado e = new Empleado("Nombre1", "Apellido1", "12346578Z");

		// Generalización siempre posible
		// Un empleado es siempre una persona por definición
		Persona p = e;

		System.out.println(p == e);

		System.out.println(p.getNombreCompleto());

		// System.out.println(p.getNif()); // NO SE PUEDE

		System.out.println(p);

		// La particularización sólo es posible en ciertos casos
		// No toda persona es un empleado
		// Debo confirmar con un casting
		Empleado e2 = (Empleado) p;

		System.out.println(e2.getNif());

		Persona p2 = new Persona();

		if (p2 instanceof Empleado) {
			Empleado e3 = (Empleado) p2;

			System.out.println(e3.getNif());
		} else {
			System.out.println("No es un empleado");
		}
	}
}
