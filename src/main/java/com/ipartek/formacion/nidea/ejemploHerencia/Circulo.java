package com.ipartek.formacion.nidea.ejemploHerencia;

public class Circulo extends ObjetoGrafico {
	private int radio;

	public Circulo() {
		super();
		this.radio = 0;
		System.out.println("Instanciamos el circulo");
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Circulo(int radio) {
		this();
		this.radio = radio;
	}

	public void dibujar() {
		System.out.println("Dibujamos un circulo");

	}

	@Override
	public String toString() {
		return super.toString() + " Circulo [radio=" + radio + "]";
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub

	}

}
