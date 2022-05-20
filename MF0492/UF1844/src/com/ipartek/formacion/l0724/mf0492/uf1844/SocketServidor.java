package com.ipartek.formacion.l0724.mf0492.uf1844;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("ARRANCANDO SERVIDOR EN 1234");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			pw.println("Bienvenido al servidor MAYUSCULATOR");
			
			String texto = sc.nextLine();
			
			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			System.out.println("Ha habido un problema de comunicación");
		}
	}
}
