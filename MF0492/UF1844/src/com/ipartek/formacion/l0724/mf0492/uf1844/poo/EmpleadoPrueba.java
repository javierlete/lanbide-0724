package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class EmpleadoPrueba {

	public static void main(String[] args) {
		Empleado e = new Empleado("Nuevo", "Nuevez", "12345678A");
		
		System.out.println(e);
		
		e.setNombre("Empleado");
		e.setApellido("Empleadez");
		e.setNif("12345678Z");
		
		System.out.println(e);
		
		System.out.println(e.getNombreCompleto(Persona.CON_COMA));
		
		System.out.println(e.getNif());
	}

}
