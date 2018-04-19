package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.RolDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Rol;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/backoffice/rol")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert;

	private static final String VIEW_INDEX = "roles/index.jsp";
	private static final String VIEW_FORM = "roles/form.jsp";
	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;

	private RolDAO daoRol;

	// Parametros del rol
	private int id;
	private String nombre;

	// parametros comunes
	private String search; // buscador por nombre del material
	private int op; // Operacion a realizar

	@Override
	public void destroy() {
		daoRol = null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoRol = RolDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Unimos las peticiones doGet y doPost, hacemos aqui lo mismo para ambos
	 * metodos!!!!
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		alert = null;

		try {
			recogerParametros(request);

			switch (this.op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_BUSQUEDA:
				buscar(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;
			default:
				listar(request);
				break;
			}
		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(VIEW_INDEX).forward(request, response);
		}

	}

	private void listar(HttpServletRequest request) {
		ArrayList<Rol> rol = new ArrayList<Rol>();
		rol = daoRol.getAll();
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void guardar(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Rol> rol = new ArrayList<Rol>();
		rol = daoRol.getByName(search);
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {
		if (daoRol.delete(id)) {
			alert = new Alert("Rol Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("No se puedo eliminar el rol seleccionado. ", Alert.TIPO_WARNING);
		}
		listar(request);

	}

	private void mostrarFormulario(HttpServletRequest request) {
		Rol rol = new Rol();
		if (id > -1) {
			rol = daoRol.getById(id);

		} else {

		}
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void recogerParametros(HttpServletRequest request) {
		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));

		} else {
			op = 0;
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = -1;
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");

		} else {
			nombre = "";
		}

	}

}
