package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase para demostrar la sintaxis de Java
 * 
 * @author javierlete
 *
 */
public class Sintaxis {
	/**
	 * Método de entrada de la aplicación
	 * @param args Argumentos de línea de comandos
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("Sintaxis"); // Saca sintaxis por pantalla
		
		/* Tipos de variables
		 * Primitivas
		 */
		
		// int a = null; // No se puede hacer
		int x = 5;
		int y = x;
		
		x = 7;
		
		System.out.println(x);
		System.out.println(y);
		
		long l = 123123123123l;
		
		System.out.println(l);
		
		Integer i = null;
		System.out.println(i);
		
		i = 6; //new Integer(6);
		
		// STRING
		
		String nombre = new String("Javier");
		String nombre2 = new String("Javier");
		
		System.out.println(nombre);
		System.out.println(nombre2);
		
		System.out.println(nombre == nombre2);
		System.out.println(nombre.equals(nombre2));
		
		System.out.println(nombre.toUpperCase());
		
		// FECHAS
		
		Date d = new Date();
		
		System.out.println(d.getYear() + 1900);
		System.out.println(d.getMonth() + 1);
		System.out.println(d.getDate());
		
		System.out.println(d);
		
		Calendar c = new GregorianCalendar();
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DATE));
		
		System.out.println(c);
		
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonth());
		System.out.println(ldt.getDayOfMonth());
		
		System.out.println(ldt);
	}
}











