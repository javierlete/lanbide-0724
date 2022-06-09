package com.ipartek.formacion.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String op = request.getParameter("op");

		double ad = Double.parseDouble(a);
		double bd = Double.parseDouble(b);

		double res;

		switch (op) {
		case "+":
			res = ad + bd;
			break;
		case "-":
			res = ad - bd;
			break;
		case "*":
			res = ad * bd;
			break;
		case "/":
			res = ad / bd;
			break;
		default:
			throw new ServletException("No se ha identificado la operación");
		}
		
		response.setContentType("text/plain");
		response.getWriter().println(res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
