package com.ipartek.formacion.nidea.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class UtilidadesTest {

	@Test
	public void testLimpiarEspacios() {
		assertEquals("hola que hace", Utilidades.limpiarEspacios("             hola           que hace            "));
		assertEquals("", Utilidades.limpiarEspacios(null));
	}

}
