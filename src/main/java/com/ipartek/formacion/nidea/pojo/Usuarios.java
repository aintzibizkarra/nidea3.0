package com.ipartek.formacion.nidea.pojo;

public class Usuarios {

	private int id;
	private String nombre;
	private String password;
	private Rol rol;

	public Usuarios() {
		super();
		this.nombre = "";
		this.id = -1;
		this.password = "";
		this.rol = new Rol();

	}

	public Usuarios(int id2, String nombre2) {
		this();
		this.id = id2;
		this.nombre = nombre2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String usuario) {
		this.nombre = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}

}
