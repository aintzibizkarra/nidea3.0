package com.ipartek.formacion.nidea.model;

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

}
