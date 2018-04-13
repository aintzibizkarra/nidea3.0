package com.ipartek.formacion.nidea.pojo;

public class Usuarios {

	private int id;
	private String usuario;

	public Usuarios() {
		super();
		this.usuario = "";
		this.id = -1;

	}

	public Usuarios(int id2, String usuario2) {
		this();
		this.id = id2;
		this.usuario = usuario2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", usuario=" + usuario + "]";
	}

}
