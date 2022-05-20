package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("ARRANCANDO CLIENTE");

		try (Socket s = new Socket("localhost", 1234);
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			String texto = sc.nextLine();

			System.out.println(texto);
			
			pw.println("Javier");
			
			texto = sc.nextLine();
			
			System.out.println(texto);
		} catch (IOException e) {
			System.out.println("Ha habido un problema de comunicación");
		}
	}
}
