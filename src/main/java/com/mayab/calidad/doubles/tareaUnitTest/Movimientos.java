package com.mayab.calidad.doubles.tareaUnitTest;

public class Movimientos {
	int id;
	float comision;
	float cantidad;
	
	public Movimientos(int id, float comision, float cantidad) {
		super();
		this.id = id;
		this.comision = comision;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
