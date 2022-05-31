package com.ipartek.formacion.lb0724.mf0492.uf1844.ejemplo.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static void errorPl(Object o) {
		System.err.println(o);
	}
	
	public static LocalDate pedirLocalDate(String mensaje) {
		return LocalDate.parse(pedirString(mensaje));
	}
	
	public static BigDecimal pedirBigDecimal(String mensaje) {
		return new BigDecimal(pedirString(mensaje));
//		p(mensaje + ": ");
//		return new BigDecimal(sc.nextLine());
	}
	
	public static String pedirString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}
	
	public static long pedirLong(String mensaje) {
		String texto = pedirString(mensaje);
		return Long.parseLong(texto);
	}
	
	public static int pedirInt(String mensaje) {
		String texto = pedirString(mensaje);
		return Integer.parseInt(texto);
//		p(mensaje + ": ");
//		int i = sc.nextInt();
//		// Hacemos un nextLine para que se "coma" el enter que queda sin recoger después del
//		// entero.
//		sc.nextLine();
//		return i;
	}
}
