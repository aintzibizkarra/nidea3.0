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

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.model.UsuarioDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialController
 */
@WebServlet("/backoffice/materiales")
public class MaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";
	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;

	private MaterialDAO daoMaterial;
	private UsuarioDAO daoUsuario;

	// Parametros del material
	private int id;
	private String nombre;
	private float precio;
	// parametros comunes
	private String search; // buscador por nombre del material
	private int op; // Operacion a realizar

	@Override
	/**
	 * Se ejecuta una unica vez que se llama al servlet
	 */
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		daoMaterial = MaterialDAO.getInstance();
		daoUsuario = UsuarioDAO.getInstance();
	}

	/**
	 * Se ejecuta cuando paramos tomcat o el servidor de aplicaciones
	 */
	@Override
	public void destroy() {
		daoMaterial = null;
		daoUsuario = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de ejecutar doGet o doPost");
		super.service(request, response); // llama al metodo doGet o doPost
		System.out.println("Despues de ejecutar doGet o doPost");
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
			dispatcher = request.getRequestDispatcher(VIEW_INDEX);

		} finally {

			request.setAttribute("alert", alert);
			// request.setAttribute("material", materiales);
			dispatcher.forward(request, response);
		}

	}

	private void guardar(HttpServletRequest request) {

		Material material = new Material();
		// Los recojo desde el formulario ya que ya estan mapeados.
		// Lo importante es el atributo name

		try {

			material.setId(id);
			material.setNombre(nombre);

			if (request.getParameter("precio") != null) {
				precio = Float.parseFloat(request.getParameter("precio"));
				material.setPrecio(precio);

			} else {
				if (daoMaterial.save(material)) {
					if (material.getNombre() == "") {
						alert = new Alert("Lo sentimos pero ya existe el nombre del material", Alert.TIPO_WARNING);
						if (material.getNombre().length() > 45) {
							alert = new Alert("El nombre del material debe contener un valor entre 1 y 45 caracteres",
									Alert.TIPO_WARNING);
						}
					} else {
						alert = new Alert("Material guardado", Alert.TIPO_PRIMARY);
					}

				} else {

					alert = new Alert("Lo sentimos pero ya existe el nombre del material", Alert.TIPO_WARNING);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			alert = new Alert("<b>" + request.getParameter("precio") + "</b> no es un precio correcto",
					Alert.TIPO_WARNING);
		}

		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = daoMaterial.getByName(search);
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {

		if (daoMaterial.delete(id)) {
			alert = new Alert("Material Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("No se puedo eliminar el material seleccionado. ", Alert.TIPO_WARNING);
		}
		listar(request);

	}

	private void mostrarFormulario(HttpServletRequest request) {

		Material material = new Material();
		if (id > -1) {
			material = daoMaterial.getById(id);

		} else {

		}

		request.setAttribute("usuarios", daoUsuario.getAll());
		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void listar(HttpServletRequest request) {

		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = daoMaterial.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	/**
	 * Recogemos todos los posibles parametros enviados
	 * 
	 * @param request
	 */
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

		/*
		 * if (request.getParameter("precio") != null) { precio =
		 * Math.abs(Float.parseFloat(request.getParameter("precio")));
		 * 
		 * } else { precio = 0; }
		 */

	}

}
