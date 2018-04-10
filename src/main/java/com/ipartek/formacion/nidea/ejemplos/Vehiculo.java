package com.ipartek.formacion.nidea.ejemplos;

public abstract class Vehiculo {

	private int puertas;
	private String color;

	public Vehiculo() {
		super(); // java.lang.object
		this.puertas = 3;
		this.color = "Blanco";
		System.out.println("Instanciando vehiculo nuevo.");

	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract void arrancar();

	public void encenderLuces() {
		System.out.println("Luces encendidas.");
	}

	@Override
	public String toString() {
		return "Vehiculo [puertas=" + puertas + ", color=" + color + "]";
	}

}
