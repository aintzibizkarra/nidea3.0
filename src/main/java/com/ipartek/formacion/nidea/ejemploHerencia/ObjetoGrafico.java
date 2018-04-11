package com.ipartek.formacion.nidea.ejemploHerencia;

public abstract class ObjetoGrafico implements Imprimible {
	private int posicionX;
	private int posicionY;

	public ObjetoGrafico() {
		super();
		this.posicionX = 0;
		this.posicionY = 0;
		System.out.println("Instanciando objeto grafico nuevo.");
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public void moverA(int nuevaX, int nuevaY) {
		this.posicionX = nuevaX;
		this.posicionY = nuevaY;

		System.out.println("Movemos los objetos a las nuevas posiciones.");

	}

	public abstract void dibujar();

	@Override
	public String toString() {
		return "ObjetoGrafico [posicionX=" + posicionX + ", posicionY=" + posicionY + "]";
	}

}
