package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.io.File;
import java.io.FileNotFoundException;
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

	public static void main(String[] args) {
//		String ruta = "C:\\nuevos\\trabajos.txt";

//		System.out.println(ruta);

		File carpeta = new File(CARPETA);

		if (!carpeta.exists()) {
			carpeta.mkdir();
		}

		FileWriter fw = null;
		PrintWriter pw = null;

		FileReader fr = null;
		Scanner sc = null;

		try {
			// Al ponerlo da error, y usaremos la opción "Surround with try catch"

			// Al poner true en la parte de APPEND queda poco claro
			// por lo que usamos Refactor/Extract Constant
			fw = new FileWriter(FICHERO, APPEND);
			pw = new PrintWriter(fw);

			pw.println("Escrito desde Java");
			pw.println("Otra línea");

			fr = new FileReader(FICHERO);
			sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				System.out.println("Leído del fichero: " + sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException e) {
			System.out.println("Ha habido un problema al intentar leer o escribir");
		} finally {
			if (pw != null) {
				pw.close();
			}

			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
				}
			}

			if (sc != null) {
				sc.close();
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
