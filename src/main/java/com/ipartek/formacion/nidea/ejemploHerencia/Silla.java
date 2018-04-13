package com.ipartek.formacion.nidea.ejemploHerencia;

public class Silla implements Ordenable {
	private int numPatas;

	public Silla() {
		super();
		this.numPatas = 0;
	}

	public int getNumPatas() {
		return numPatas;
	}

	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	@Override
	public String toString() {
		return "Silla [numPatas=" + numPatas + "]";
	}

	@Override
	public int getValor() {

		return this.numPatas;
	}

}
