package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	private static final String CARPETA = "ficheros";
	private static final String FICHERO = CARPETA + "/datos.txt";
	// Generado por el Refactor/Extract Constant
	private static final boolean APPEND = true;

	public static void main(String[] args) throws IOException  {
//		String ruta = "C:\\nuevos\\trabajos.txt";
		
//		System.out.println(ruta);
		
		File carpeta = new File(CARPETA);
		
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		// Al ponerlo da error, y usaremos la opción "Add throws"
		
		// Al poner true en la parte de APPEND queda poco claro
		// por lo que usamos Refactor/Extract Constant
		FileWriter fw = new FileWriter(FICHERO, APPEND);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Escrito desde Java");
		pw.println("Otra línea");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(FICHERO);
		Scanner sc = new Scanner(fr);
		
		while(sc.hasNextLine()) {
			System.out.println("Leído del fichero: " + sc.nextLine());
		}
		
		sc.close();
		fr.close();
	}

}
