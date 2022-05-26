package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

import java.util.ArrayList;
import java.util.HashMap;

public class EjemplosHerencia {

	public static void main(String[] args) {
		Empleado e = new Empleado("Nombre1", "Apellido1", "12346578Z");

		// Generalización siempre posible
		// Un empleado es siempre una persona por definición
		Persona p = e;

		System.out.println(p == e);

		System.out.println(p.getNombreCompleto());

		// System.out.println(p.getNif()); // NO SE PUEDE

		System.out.println(p); // System.out.println(p.toString());

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
		
		Object o = e;
		
		System.out.println(o.getClass().getName());
		System.out.println(o.hashCode());
		System.out.println("Tipo Object, pero apuntando a Empleado: " + o);
		
		o = new Object();
		
		System.out.println(o.equals(o));
		System.out.println(o.toString());
		System.out.println(o);
		
		Persona per1 = new Persona();
		Persona per2 = new Persona();
		
		// La implementación de equals para Persona debe hacerse
		// de forma EXPLÍCITA porque si no la implementación utilizada
		// es la de Object que sólo hace per1 == per2
		// (Sólo daría true cuando per1 y per2 apuntan al MISMO objeto)
		System.out.println(per1.equals(per2));
		
		ArrayList<Persona> personas = new ArrayList<>();
		
		personas.add(per1);
		personas.add(new Persona("adfasdf"));
		personas.add(new Persona("OTRA"));
		
		personas.remove(new Persona("OTRA"));
		
		for(Persona persona: personas) {
			System.out.println(persona);
		}
		
		HashMap<Persona, Empleado> hm = new HashMap<>();
		
		hm.put(per1, e);
		hm.put(new Persona("UNO"), new Empleado("Javier", "Lete", "12345678Z"));
		
		System.out.println(hm.get(new Persona("UNO")));
		
		Espacio espacio = new Espacio("Bilbao");
		
		espacio.entrar(per2);
		espacio.entrar(new Persona("OTRA"));
		espacio.entrar(e);
		espacio.entrar(new Empleado("Yepa", "Yepez", "87654321Z"));
		
		for(Persona per: espacio.getPersonas()) {
			System.out.println(per);
		}
		
		String log = "";
		
		log += "Línea1\n";
//		log = new StringBuffer(log).append("Línea1\n").toString();
		
		log += "Línea2 " + per1 + "\n";
//		log = new StringBuffer(log).append("Línea2 ").append(per1).append("\n").toString();
		
		log += "Línea3 " + e + per2 + "\n";
//		log = new StringBuffer(log).append("Línea3 ").append(e).append(per2).append("\n").toString();
		
		System.out.println(log);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("Línea1\n");
		sb.append("Línea2 ").append(per1).append("\n");
		sb.append("Línea3 ").append(e).append(per2).append("\n");
		
		System.out.println(sb.toString());
	}
}
