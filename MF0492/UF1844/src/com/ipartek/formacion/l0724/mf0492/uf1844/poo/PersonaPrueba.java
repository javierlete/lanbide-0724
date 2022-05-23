package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class PersonaPrueba {

	public static void main(String[] args) {
		Persona p = new Persona();
		
		p.setNombre("Javier");
		p.setApellido("Lete");
		
		System.out.println(p);
		System.out.println(p.getNombre() + " " + p.getApellido());
		
		Persona p2 = new Persona(2L, "Pepe", "Pérez");
		
		System.out.println(p2.getNombre() + " " + p2.getApellido());
		
		Persona p3 = new Persona();
		
		p3.setId(3L);
		p3.setNombre("Juan");
		p3.setApellido("Lanas");
		
		System.out.println(p3.getNombre() + " " + p3.getApellido());
		
		Persona p4 = new Persona(4L, "asdfasd", "asdfasdf");
		
		System.out.println(p4.getId() + ":" + p4.getNombre() + " " + p4.getApellido());
		
		Persona p5 = new Persona();
		
		System.out.println(p5.getId() + ":" + p5.getNombre() + " " + p5.getApellido());
		
		Persona p6 = new Persona("Nombre", "Completez");
		
		System.out.println(p6.getNombreCompleto());
		
		System.out.println(p6.getNombreCompleto(Persona.CON_COMA));
		
		Persona p7 = new Persona(p6);

		p6.setNombre("Cambiado");
		
		System.out.println(p6.getNombreCompleto());
		System.out.println(p7.getNombreCompleto());
	}

}
