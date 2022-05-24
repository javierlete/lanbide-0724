package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class EspacioPrueba {
	public static void main(String[] args) {
		Espacio espacio = new Espacio("Centro comercial");
		
		Persona persona = new Persona("Persona", "Personaz");
		
		espacio.entrar(new Persona("Nombrez"));
		espacio.entrar(new Persona("Nombre", "Apellidez"));
		espacio.entrar(new Persona());
		espacio.entrar(persona);
		espacio.entrar(persona);
		
		Espacio espacio2 = new Espacio(espacio);
		
		for(Persona p: espacio.getPersonas()) {
			System.out.println(p.getNombreCompleto());
		}
		
		espacio.salir(persona);
		
		for(Persona p: espacio.getPersonas()) {
			System.out.println(p);
		}
		
		System.out.println(espacio);
		
		for(Persona p: espacio2.getPersonas()) {
			System.out.println(p);
		}
	}
}
