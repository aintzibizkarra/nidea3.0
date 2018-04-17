package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();

	/*
	 * private static final String USER =
	 * "SELECT nombre FROM usuario WHERE nombre = '?'"; private static final String
	 * PASS = "SELECT password FROM usuario";
	 */

	private static final int SESSION_EXPIRATION = -1; // no expira

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// recojo los parametros que el usuario mete en el login
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			if (usuario.equalsIgnoreCase(usuario) && password.equals(password)) {

				// Guardar usuario en sesion
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);

				//
				/**
				 * Tiempo de expiracion, tambien se puede configurar en web.xml si le das un
				 * valor negativo nunca expira
				 * <session-config><session-timeout>-1</session-timeout></session-config>
				 * 
				 */
				session.setMaxInactiveInterval(SESSION_EXPIRATION);

				view = "backoffice/index.jsp";
				alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);
			} else {

				view = "login.jsp";
				alert = new Alert("Credenciales incorrectas, prueba de nuevo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
