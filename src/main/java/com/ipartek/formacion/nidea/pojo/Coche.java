package com.ipartek.formacion.nidea.pojo;

public class Coche implements AutoCloseable {

	public Coche() {
		super();
		System.out.println("Creamos Coche.");
	}

	public void conducir() {
		System.out.println("brum brum estamos conduciendo.");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Paramos coche.");

	}

	public static void main(String[] args) {
		// Si declaramos un objeto que implemente la interfaz Autoclosable
		// dentro de los parentesis del TRY, cuando llega al FINALLY se ejecuta de
		// forma automatica su metodo "close()" => Recurso de Java 7

		try (Coche c = new Coche()) {
			System.out.println("Empezamos programa.");
			c.conducir();

		} catch (Exception e) {
			System.out.println("Tenemos una excepcion");
		} finally {
			System.out.println("Finalizamos");
		}
	}

}
