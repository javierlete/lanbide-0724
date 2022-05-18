package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.math.BigInteger;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MAX_VALUE + 1);
		
		System.out.println(factorial(10000));
		System.out.println(factorialNoRecursivo(100000));
	}

	private static BigInteger factorial(int i) {
		if (i == 1) { return BigInteger.ONE; }
		return new BigInteger(String.valueOf(i)).multiply(factorial(i - 1));
	}
	
	private static BigInteger factorialNoRecursivo(int i) {
		BigInteger total = BigInteger.ONE;
		
		for(; i > 0; i--) {
			total = total.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return total;
	}

	// Factorial de 5: 5!
	// 5! = 5 * 4 * 3 * 2 * 1
	// 5! = 5 * 4!
	// 4! = 4 * 3!
	// 3! = 3 * 2!
	// 2! = 2 * 1!
	// 1! = 1
}
