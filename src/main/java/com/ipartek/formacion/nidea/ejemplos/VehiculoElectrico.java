package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {

	private float potencia; // Kw

	public VehiculoElectrico() {
		super();
		this.potencia = 0;
		System.out.println("Instanciado VehiculoElectrico");

	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {

		// super.arrancar();
		System.out.println("Pulsar el boton encendido.");
	}

	public VehiculoElectrico(float potencia) {
		this(); // hay que cambiar el por defecto super() por this()
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString() + " VehiculoElectrico [potencia=" + potencia + "]";
	}

}
