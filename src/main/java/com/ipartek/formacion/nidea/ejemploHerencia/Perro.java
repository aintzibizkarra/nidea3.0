package com.ipartek.formacion.nidea.ejemploHerencia;

public class Perro implements Ordenable {
	private int numVacunas;

	public Perro() {
		super();
		this.numVacunas = 4;

	}

	public int getNumVacunas() {
		return numVacunas;
	}

	public void setNumVacunas(int numVacunas) {
		this.numVacunas = numVacunas;
	}

	@Override
	public int getValor() {
		return this.numVacunas;
	}

}
