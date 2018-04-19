package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Rol;
import com.ipartek.formacion.nidea.util.Utilidades;

public class RolDAO implements Persistible<Rol> {

	private static RolDAO INSTANCE = null;

	public RolDAO() {

	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}
	}

	// otra prueba para evitar instanciación múltiple
	public static RolDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> lista = new ArrayList<Rol>();
		String sql = "SELECT id, nombre FROM rol ORDER BY id ASC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Rol r = null;
			while (rs.next()) {
				r = mapper(rs);
				lista.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public ArrayList<Rol> getByName(String search) {
		ArrayList<Rol> lista = new ArrayList<Rol>();
		String sql = "SELECT id, nombre FROM rol WHERE nombre LIKE ? ORDER BY id ASC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + search + "%");
			try (ResultSet rs = pst.executeQuery()) {
				Rol r = null;
				while (rs.next()) {
					r = mapper(rs);
					lista.add(r);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Rol getById(int id) {
		Rol rol = null;
		String sql = "SELECT `id`, `nombre` FROM `rol` WHERE `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					rol = mapper(rs);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rol;
	}

	@Override
	public boolean save(Rol pojo) {
		boolean resul = false;

		// Sanear el nombre (para meter datos no incorrectos en la BD)
		pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre()));
		if (pojo != null) {
			try {
				if (pojo.getId() == -1) {
					resul = crear(pojo);
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			try {
				resul = modificar(pojo);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return resul;
	}

	private boolean modificar(Rol pojo) {
		boolean resul = false;
		String sql = "UPDATE `rol` SET `nombre`= ?  WHERE  `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, pojo.getNombre().trim());

			pst.setInt(2, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private boolean crear(Rol pojo) {
		boolean resultado = false;
		String sql = "INSERT INTO `rol` (`nombre`) VALUES (?); ";
		// PreparedStatement.RETURN_GENERATED_KEYS me devuelve las claves generadas. El
		// prepareStatement permite un segundo parametro
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, pojo.getNombre());

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {

				// Recuperar ID generado de forma automatica
				try (ResultSet rs = pst.getGeneratedKeys();) {
					while (rs.next()) {
						pojo.setId(rs.getInt(1));
						resultado = true;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sql = "DELETE FROM `rol` WHERE  `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Rol mapper(ResultSet rs) throws SQLException {
		Rol r = null;
		if (rs != null) {
			r = new Rol();
			r.setNombre(rs.getString("nombre"));
			r.setId(rs.getInt("id"));

		}

		return r;
	}

}
