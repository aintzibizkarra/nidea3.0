package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Usuarios;
import com.ipartek.formacion.nidea.util.Utilidades;

public class UsuarioDAO implements Persistible<Usuarios> {

	private static UsuarioDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instacias (objetos)
	private UsuarioDAO() {

	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	// otra prueba para evitar instanciación múltiple
	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	public ArrayList<Usuarios> checkUsuario(String nombre, String password) {

		ArrayList<Usuarios> usuarioConectado = new ArrayList<Usuarios>();

		String sql = "SELECT id, nombre, password, id_rol FROM usuario WHERE nombre = '?'" + nombre + "password = '?'"
				+ password;
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, nombre);
			pst.setString(2, password);

			try (ResultSet rs = pst.executeQuery()) {
				Usuarios u = null;
				while (rs.next()) {
					u = mapper(rs);
					usuarioConectado.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return usuarioConectado;

	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	public ArrayList<Usuarios> getAll() {

		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		String sql = "SELECT id, nombre, password,id_rol FROM usuario ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Usuarios u = null;
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public ArrayList<Usuarios> getByName(String search) {

		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		String sql = "SELECT id, nombre, password FROM usurio WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + search + "%");
			try (ResultSet rs = pst.executeQuery()) {
				Usuarios u = null;
				while (rs.next()) {
					u = mapper(rs);
					lista.add(u);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Usuarios getById(int id) {
		Usuarios usuario = null;
		String sql = "";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					usuario = mapper(rs);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public boolean save(Usuarios pojo) {
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

	private boolean modificar(Usuarios pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean crear(Usuarios pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sql = "DELETE FROM `usuario` WHERE  `id`= ?;";

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
	public Usuarios mapper(ResultSet rs) throws SQLException {
		Usuarios u = null;
		if (rs != null) {
			u = new Usuarios();
			u.setNombre((rs.getString("nombre")));
			u.setId(rs.getInt("id"));
			u.setPassword((rs.getString("password")));
		}

		return u;
	}
}
