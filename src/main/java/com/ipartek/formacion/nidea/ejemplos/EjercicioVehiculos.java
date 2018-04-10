package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {

		/*
		 * No se pueden crear Objetos de una CLASE ABSTRACTA
		 * 
		 * Vehiculo rayoMcQueen = new Vehiculo();
		 * System.out.println(rayoMcQueen.toString());
		 */
		System.out.println("-------------------------------------");

		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println(tesla.toString());

		System.out.println("-------------------------------------");

		System.out.println("Tesla");
		System.out.println("color: " + tesla.getColor());

	}

}
