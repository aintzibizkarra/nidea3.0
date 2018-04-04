package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialController
 */
@WebServlet("/backoffice/materiales")
public class MaterialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "";
	private Alert alert = new Alert();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Material> materiales = new ArrayList<Material>();
		Alert alert = null;
		try {
			String search = request.getParameter("search");
			System.out.println("Filtro de busqueda: " + search);
			// Enviar como atributo la lista de materiales
			MaterialDAO dao = MaterialDAO.getInstance();
			materiales = dao.getAll();

		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();

		} finally {

			request.setAttribute("alert", alert);
			request.setAttribute("material", materiales);
			request.getRequestDispatcher("materiales/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
