package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO implements Persistible<Material> {

	private static MaterialDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instacias (objetos)
	private MaterialDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaterialDAO();
		}
	}

	// otra prueba para evitar instanciación múltiple
	public static MaterialDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();
		String sql = "SELECT id, nombre, precio FROM material ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			/**
			 * Class.forName("com.mysql.jdbc.Driver"); final String URL =
			 * "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno"; con =
			 * DriverManager.getConnection(URL);
			 */

			Material m = null;
			while (rs.next()) {
				m = mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Material getById(int id) {
		Material material = null;
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					material = mapper(rs);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

	@Override
	public boolean save(Material pojo) {
		boolean resul = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionManager.getConnection();
			String sql = "INSERT INTO `material` (`nombre`, `precio`) VALUES (?, ?);";
			pst = con.prepareStatement(sql);
			int affetedRows = pst.executeUpdate();
			pst.setString(1, pojo.getNombre());
			pst.setFloat(2, pojo.getPrecio());

			if (affetedRows == 1) {
				resul = true;

			}
		} catch (Exception e) {

		} finally {
			try {

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return resul;

	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionManager.getConnection();
			String sql = "DELETE FROM `material` WHERE  `id`= ?;";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resul;

	}

	@Override
	public Material mapper(ResultSet rs) throws SQLException {
		Material m = null;
		if (rs != null) {
			m = new Material();
			m.setNombre(rs.getString("nombre"));
			m.setId(rs.getInt("id"));
			m.setPrecio(rs.getFloat("precio"));
		}

		return m;
	}

}
