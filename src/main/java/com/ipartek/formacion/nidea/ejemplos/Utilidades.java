package com.ipartek.formacion.nidea.ejemplos;

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

		String cadena1 = "               hola que hace           ";
		return cadena1.trim();

	}
}
