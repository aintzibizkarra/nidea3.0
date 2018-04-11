package com.ipartek.formacion.nidea.ejemploHerencia;

public class Rectangulo extends ObjetoGrafico {

	private int lado;

	public Rectangulo() {
		super();
		this.lado = 4;
		System.out.println("Instanciando rectangulo nuevo.");
	}

	public Rectangulo(int lado) {
		super();
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	@Override
	public void dibujar() {
		System.out.println("Dibujamos el rectangulo");

	}

	@Override
	public String toString() {
		return super.toString() + " rectangulo [lado=" + lado + "]";
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub

	}

}
