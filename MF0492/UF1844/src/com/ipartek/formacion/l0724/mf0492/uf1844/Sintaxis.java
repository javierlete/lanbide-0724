package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.math.BigDecimal;
import java.math.BigInteger;
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
	 * 
	 * @param args Argumentos de línea de comandos
	 */

	public static void main(String[] args) {
//		tipos();
//		operadores();
//		estructurasDeControl();
		arrays();
	}

	private static void arrays() {
		int[] arr;
		arr = new int[2];
		
		arr[0] = 10;
		arr[1] = 3;
		// arr[2] = 20; // No me lo permite en ejecución
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(int dato: arr) {
			System.out.println(dato);
		}
		
		char[][] tablero = new char[8][8];
		
		tablero[0][0] = 'T';
		tablero[0][1] = 'C';
		tablero[1][0] = 'P';
		
		tablero[7][7] = 't';
		
		char ficha;
		
		for(int x = 0; x < tablero.length; x++) {
			for(int y = 0; y < tablero[x].length; y++) {
				ficha = tablero[x][y];
				
				if(ficha == '\0') {
					ficha = '.';
				}
				// print no hace salto de línea como println
				System.out.print(ficha + " ");
			}
			System.out.println();
		}
		
		arr = new int[]{ 1, 3, 5, 7, 3, 2, 3 };
		
		tablero  = new char[][] {
			{ 'T', 'C', '.', '.', '.', '.', '.', '.' },
			{ 'P', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', 'p', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', 'c', 't' },
		};
		
		for(char[] fila: tablero) {
			for(char f: fila) {
				System.out.print(f + " ");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	private static void estructurasDeControl() {
		// Condicionales

		int x = 5;

		if (x >= 5) {
			System.out.println("Es mayor o igual que 5");
		} else if (x >= 3) {
			System.out.println("Es mayor o igual que 3");
		} else {
			System.out.println("Es menor que 3");
		}

		String opcion = "borrar";

		switch (opcion) {
		case "borrar":
			System.out.println("Borrar");
			break;
		case "añadir":
			System.out.println("Añadir");
			break;
		default:
			System.out.println("No reconocida");
		}
		
		// REPETITIVAS
		
		int c = 1;
		
		while(c <= 5) {
			System.out.println(c++);
		}
		
		c = 1;
		
		do {
			System.out.println(c++);
		} while(c <= 5);
		
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
//		int i = 1;
//		while(i <= 5) {
//			System.out.println(i);
//			i++;
//		}
	}

	@SuppressWarnings("unused")
	private static void operadores() {
		// ARITMÉTICOS

		int x = 5, y = 6;

		// % Resto de la división entera
		System.out.println(x % 3);

		// ^ NO es un operador aritmético, sino lógico (XOR)
		System.out.println(x ^ y);

		// La forma de hacer potencia es con Math.pow
		System.out.println(Math.pow(x, y));

		// COMPARACIÓN

		System.out.println(x < y);

//		System.out.println(1 <= x <= 10); // No se puede

		// LÓGICOS

		System.out.println(1 <= x && x <= 10);

		// ASIGNACIÓN

		System.out.println(x = y = 0);

		// INCREMENTO / DECREMENTO

		x = 0;
		System.out.println("x++ = " + x++);
		System.out.println("x = " + x);
		x = 0;
		System.out.println("++x = " + ++x);
		System.out.println("x = " + x);

		// TERNARIO

		boolean b = false;
		System.out.println(b ? "VERDADERO" : "FALSO");

		int c = 33, d = 10;

		System.out.println(c > d ? c : d);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	private static void tipos() {
		System.out.println("Sintaxis"); // Saca sintaxis por pantalla

		/*
		 * Tipos de variables Primitivas
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

		i = 6; // new Integer(6);

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

		// BigDecimal y BigInteger

		double d1 = 5.6;
		double d2 = 5.8;

		double dr = d1 + d2;

		System.out.println(dr);

		BigDecimal bd1 = new BigDecimal("5.6");
		BigDecimal bd2 = new BigDecimal("5.8");

		BigDecimal bdr = bd1.add(bd2);

		System.out.println(bdr);

		long l1 = Long.MAX_VALUE;

		BigInteger bi1 = new BigInteger("9123123123123123123123");

		System.out.println(l1);
		System.out.println(bi1);
	}
}
