package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.util.Scanner;

public class LeerPorTeclado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime tu nombre: ");
		
		String nombre = sc.nextLine(); // System.console().readLine();
		
		System.out.println("Hola " + nombre);
		
		sc.close();
	}

}
