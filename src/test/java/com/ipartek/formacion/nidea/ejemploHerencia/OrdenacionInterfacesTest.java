package com.ipartek.formacion.nidea.ejemploHerencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class OrdenacionInterfacesTest {

	static ArrayList<Ordenable> coleccion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		coleccion = new ArrayList<Ordenable>();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		coleccion = null;
	}

	@Before
	public void setUp() throws Exception {

		Perro e1 = new Perro();

		Silla e2 = new Silla();
		e2.setNumPatas(1);

		Perro e3 = new Perro();
		e3.setNumVacunas(0);

		Silla e4 = new Silla();
		e4.setNumPatas(9);

		coleccion.add(e1);
		coleccion.add(e2);
		coleccion.add(e3);
		coleccion.add(e4);

	}

	@After
	public void tearDown() throws Exception {
		coleccion = null;
	}

	@Test
	public void testBubbleSort() {
		Utilidades.bubbleSort(coleccion);

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(3).getValor());
		assertEquals(9, coleccion.get(9).getValor());

		Ordenable elemento = coleccion.get(0);
		// El elemento que me viene, al no saber de que tipo es, hay que castear a un
		// tipo u otro
		// Comprobamos que siempre vienen Perros o Sillas (en este caso)
		// InstanceOf comprueba si es una clase de ese objeto
		if (elemento instanceof Perro) {

			Perro p = (Perro) elemento;

		} else if (elemento instanceof Silla) {

			Silla s = (Silla) elemento;

		} else {
			fail("NO esperabamos esta clase de objetos");
		}

	}

	@Test
	public void testColectionSort() {

		// Ordena de menor a mayor
		Collections.sort(coleccion, new ComparatorOrdenables());

		assertEquals(0, coleccion.get(0).getValor());
		assertEquals(1, coleccion.get(1).getValor());
		assertEquals(3, coleccion.get(3).getValor());
		assertEquals(9, coleccion.get(9).getValor());

		// Ordena de mayor a menor
		Collections.reverse(coleccion);

		assertEquals(9, coleccion.get(0).getValor());
		assertEquals(3, coleccion.get(1).getValor());
		assertEquals(1, coleccion.get(3).getValor());
		assertEquals(0, coleccion.get(9).getValor());
	}

}
