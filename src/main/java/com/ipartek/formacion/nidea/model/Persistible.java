package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Curso
 *
 * @param <P>
 *            POJO
 */

public interface Persistible<P> {

	/**
	 * Lista de una tabla de la bbdd ordenados por id de manera desc y limit 500
	 * 
	 * @return colleccion
	 */
	public ArrayList<P> getAll();

	/**
	 * Obtenemos detalle de un registro
	 * 
	 * @param id
	 *            identificador
	 * @return Registro si existe, null en caso contrario
	 */

	public P getById(int id);

	/**
	 * Guardamos un registro en la BBDD
	 * 
	 * Si el id del pojo es == -1 creamos, Si el id > -1 modificamos
	 * 
	 * @param pojo
	 * 
	 * @return
	 */

	public boolean save(P pojo);

	/**
	 * Eliminamos el registro por su identificador
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * Nos Mapea un resultado de la BBDD a un Pojo
	 * 
	 * @param rs
	 *            ResultSet 1 registro de la consulta
	 * @return Pojo con los valores del resultset o null si no hay valores
	 * @throws SQLException
	 */
	public P mapper(ResultSet rs) throws SQLException;

}
