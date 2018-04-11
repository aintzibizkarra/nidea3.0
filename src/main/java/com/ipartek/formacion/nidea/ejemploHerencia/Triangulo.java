package com.ipartek.formacion.nidea.ejemploHerencia;

public class Triangulo extends ObjetoGrafico {
	public int angulo;

	public Triangulo() {
		super();
		this.angulo = 0;
		System.out.println("Instanciando triangulo nuevo.");
	}

	public Triangulo(int angulo) {
		super();
		this.angulo = angulo;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	@Override
	public String toString() {
		return super.toString() + " Triangulo [angulo=" + angulo + "]";
	}

	@Override
	public void dibujar() {
		System.out.println("Dibujamos un triangulo");

	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub

	}

}
