package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.UsuarioDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuarios;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final int ROL_USER_ADMIN = 1;
	private static final int ROL_USER_NORMAL = 2;

	private static final String VIEW_BACKOFFICE = "backoffice/index.jsp";
	private static final String VIEW_FRONTOFFICE = "frontoffice/index.jsp";
	private static final String VIEW_LOGIN = "login.jsp";

	private String view = "";
	private Alert alert = new Alert();

	private UsuarioDAO daoUsuario;

	private static final int SESSION_EXPIRATION = -1; // no expira

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();

	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// recojo los parametros que el usuario mete en el login
			String nombre = request.getParameter("usuario");
			String password = request.getParameter("password");
			Usuarios usu = daoUsuario.check(nombre, password);

			if (usu != null) {

				// Guardar usuario en sesion
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usu);

				session.setMaxInactiveInterval(SESSION_EXPIRATION);

				if (usu.getRol().getId() == ROL_USER_ADMIN) {
					view = VIEW_BACKOFFICE;

				} else {
					view = VIEW_FRONTOFFICE;

				}
				alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);

			} else {

				view = VIEW_LOGIN;
				alert = new Alert("Credenciales incorrectas, prueba de nuevo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_LOGIN;
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
