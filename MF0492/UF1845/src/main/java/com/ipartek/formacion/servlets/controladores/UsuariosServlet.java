package com.ipartek.formacion.servlets.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.servlets.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Cerebro de la aplicación
// Recoge la información de las peticiones
// Crea objetos del MODELO
// Llama a la lógica de negocio
// En el caso de no existir, llamará directamente al DAO

@WebServlet("/usuarios")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario(1L, "javier@lete.net", "javier"));
		usuarios.add(new Usuario(2L, "pepe@perez.net", "pepe"));
		usuarios.add(new Usuario(3L, "juan@gonzalez.net", "juan"));

// Empaqueta datos para la siguiente vista
		request.setAttribute("usuarios", usuarios);
// Redirecciona a la siguiente vista
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
