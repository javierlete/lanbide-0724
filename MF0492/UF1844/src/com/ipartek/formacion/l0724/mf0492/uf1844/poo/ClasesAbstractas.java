package com.ipartek.formacion.l0724.mf0492.uf1844.poo;

public class ClasesAbstractas {

	public static void main(String[] args) {
		Number[] numeros = new Number[2];
		
		numeros[0] = 5; //new Integer(5);
		numeros[1] = 2.3; //new Double(2.3);
		
		for(Number n: numeros) {
			System.out.println(n.doubleValue());
		}
	}

}
