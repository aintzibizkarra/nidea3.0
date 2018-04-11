package com.ipartek.formacion.nidea.ejemploHerencia;

public final class CirculoColoreado extends Circulo {
	private String color;

	public CirculoColoreado() {
		super();
		this.color = "rojo";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void dibujar() {
		super.dibujar();
	}
}
