package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static void pf(String formato, Object... objects) {
		System.out.printf(formato, objects);
	}

	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static void pl() {
		System.out.println();
	}

	public static void p(Object o) {
		System.out.print(o);
	}

	public static void errorPl(Object o) {
		System.err.println(o);
	}

	public static LocalDate pedirLocalDate(String mensaje) {
		boolean repetir = true;
		String texto;
		LocalDate ld = null;

		do {
			try {
				texto = pedirString(mensaje + " (AAAA-MM-DD)");

				if (texto == null || texto.trim().length() == 0) {
					return null;
				}

				ld = LocalDate.parse(texto);
				repetir = false;
			} catch (DateTimeParseException e) {
				pl("No es una fecha válida");
			}
		} while (repetir);

		return ld;
	}

	public static BigDecimal pedirBigDecimal(String mensaje) {
		boolean repetir = true;
		String texto;
		BigDecimal bd = null;

		do {
			try {
				texto = pedirString(mensaje);

				if (texto == null || texto.trim().length() == 0) {
					return null;
				}

				bd = new BigDecimal(texto);
				repetir = false;
			} catch (NumberFormatException e) {
				pl("No es un número");
			}
		} while (repetir);

		return bd;

//		p(mensaje + ": ");
//		return new BigDecimal(sc.nextLine());
	}

	public static String pedirString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}

	public static long pedirLong(String mensaje) {
		boolean repetir = true;
		String texto;
		Long l = null;

		do {
			try {
				texto = pedirString(mensaje);
				l = Long.parseLong(texto);
				repetir = false;
			} catch (NumberFormatException e) {
				pl("No es un número");
			}
		} while (repetir);

		return l;
	}

	public static int pedirInt(String mensaje) {
		boolean repetir = true;
		String texto;
		Integer i = null;

		do {
			try {
				texto = pedirString(mensaje);
				i = Integer.parseInt(texto);
				repetir = false;
			} catch (NumberFormatException e) {
				pl("No es un número");
			}
		} while (repetir);

		return i;
		// p(mensaje + ": ");
		// int i = sc.nextInt();
		// // Hacemos un nextLine para que se "coma" el enter que queda sin recoger
		// después del
		// // entero.
		// sc.nextLine();
		// return i;
	}
}
