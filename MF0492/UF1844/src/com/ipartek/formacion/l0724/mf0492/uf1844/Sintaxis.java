package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

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
//		arrays();
//		colecciones();
//		conversiones();
		excepciones();
	}

	@SuppressWarnings("null")
	private static void excepciones() {
		int d, a = 5, b = 2;

		System.out.println("Vamos a hacer una división");

		try {
			String s = null;

			s.toUpperCase();

			int[] arr = new int[2];

			arr[2] = 5;

			b = 2;

			d = a / b;

			System.out.println(d);
		} catch (ArithmeticException e) {
			System.out.println("Error en la división");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Se nos ha escapado el dato de rango");
		} finally {
			System.out.println("Me vas a ver por mis...");
		}
//		catch (Exception e) {
//			System.out.println("Error no esperado");
//			System.out.println(e.getMessage());
//		}
//		
		System.out.println("Gracias por su atención");
	}

	@SuppressWarnings("unused")
	private static void conversiones() {
		// Conversiones entre tipos primitivos
		int i = 5;
		double d = (double) i;
		i = (int) d;

		// Conversión a texto de tipo primitivo
		String s = String.valueOf(i);

		// Conversión de un objeto (que no sea primitivo) a texto
		LocalDate ld = LocalDate.now();
		s = ld.toString(); // .toString()

		// Conversión de String a tipo primitivo
		s = "5";

		i = Integer.parseInt(s);

		s = "NO";

		@SuppressWarnings("unused")
		boolean b = "SI".equalsIgnoreCase(s.trim());

		@SuppressWarnings("unused")
		char c = s.trim().charAt(0);

		// Conversión de String a LocalDate
		s = "2020-10-20";

		ld = LocalDate.parse(s);

		System.out.println(ld.getYear());

		s = "01/10/2020";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ld = LocalDate.parse(s, dtf);

		DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy");
		System.out.println(ld.format(formatoLargo));
	}

	@SuppressWarnings({ "unchecked", "removal", "unused" })
	private static void colecciones() {
		// < Java5
		@SuppressWarnings("rawtypes")
		Vector v = new Vector();

		v.add(new Integer(5));
		v.add(new Date());
		v.add("Lalaralalaaa");

		for (int i = 0; i < v.size(); i++) {
			if (i == 2) {
				String s = (String) v.elementAt(i);
				System.out.println(s.toUpperCase());
			}

			System.out.println(v.elementAt(i));
		}

		// >= Java 5
		List<Integer> al = new ArrayList<Integer>(); // Java 8 -> new ArrayList<>();

		al.add(6);
		al.add(10);
		al.add(14);
		al.add(6);

		al.remove(1);

		for (Integer i : al) {
			System.out.println(i);
		}

		// Java 10 var hs = new HashSet<String>();
		Set<String> hs = new HashSet<String>();

		hs.add("Uno");
		hs.add("Dos");
		hs.add("Uno");
		hs.add("Tres");

		for (String s : hs) {
			System.out.println(s);
		}

		Map<String, LocalDate> tm = new TreeMap<String, LocalDate>();

		// Coloca un elemento en una posición
		// Si en dicha posición ya había un elemento previo
		// machaca el anterior
		tm.put("Principio curso", LocalDate.of(2022, 3, 28));
		tm.put("Fin curso", LocalDate.of(2022, 9, 8));

		for (String clave : tm.keySet()) {
			System.out.println("La clave " + clave + " tiene el valor " + tm.get(clave) + ".");
			System.out.println(
					String.format("La clave %s tiene el valor %2$te de %2$tB de %2$tY.", clave, tm.get(clave)));
			System.out.printf("La clave %s tiene el valor %2$te de %2$tB de %2$tY.\n", clave, tm.get(clave));
		}
	}

	@SuppressWarnings("unused")
	private static void arrays() {
		int[] arr;
		arr = new int[2];

		arr[0] = 10;
		arr[1] = 3;
		// arr[2] = 20; // No me lo permite en ejecución

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		for (int dato : arr) {
			System.out.println(dato);
		}

		char[][] tablero = new char[8][8];

		tablero[0][0] = 'T';
		tablero[0][1] = 'C';
		tablero[1][0] = 'P';

		tablero[7][7] = 't';

		char ficha;

		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				ficha = tablero[x][y];

				if (ficha == '\0') {
					ficha = '.';
				}
				// print no hace salto de línea como println
				System.out.print(ficha + " ");
			}
			System.out.println();
		}

		arr = new int[] { 1, 3, 5, 7, 3, 2, 3 };

		tablero = new char[][] { { 'T', 'C', '.', '.', '.', '.', '.', '.' }, { 'P', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', 'p', '.', '.' }, { '.', '.', '.', '.', '.', '.', 'c', 't' }, };

		for (char[] fila : tablero) {
			for (char f : fila) {
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

		while (c <= 5) {
			System.out.println(c++);
		}

		c = 1;

		do {
			System.out.println(c++);
		} while (c <= 5);

		for (int i = 1; i <= 5; i++) {
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
