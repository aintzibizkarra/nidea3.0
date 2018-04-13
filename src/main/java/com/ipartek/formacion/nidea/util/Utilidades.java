package com.ipartek.formacion.nidea.util;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.nidea.ejemploHerencia.Ordenable;

public class Utilidades {

	/**
	 * Metodo estatico para poder usarse desde la propia clase sin tener que
	 * instanciar un Objeto.<br>
	 * Limpia los caracteres vacios " " de una cadena String. <br>
	 * Hacemos trim(), ademas de sustituir todos los espacios en blanco por uno
	 * unico, ej:<br>
	 * " hola que hace " => "Hola que hace"
	 * 
	 * @param cadena
	 * @return En caso de Null retorna cadena vacia
	 */
	public static String limpiarEspacios(String cadena) {

		String resul = "";
		if (cadena != null) {
			resul = cadena.trim();
			resul = resul.replaceAll("\\s+ ", " ");

		}
		return resul;

	}

	/**
	 * Ordenar una coleccion con el algoritmo de bubblesort, ordena de menor a mayor
	 * basandose en el metodo getValor de la interfaz Ordenable
	 * 
	 * @see package com.ipartek.formacion.nidea.ejemploHerencia.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos a ordenar
	 * @return en caso de null retornamos una lista vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();

		if (coleccion != null) {

			resul = coleccion;
			int n = coleccion.size();
			Ordenable temp;

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (coleccion.get(j - 1).getValor() > coleccion.get(j).getValor()) {
						temp = coleccion.get(j - 1);
						coleccion.remove(j - 1);
						coleccion.add(j, temp);
					}
				}
			}
		}
		return resul;
	}
}
