package modelo.entidades;

import java.io.Serializable;

public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	public Servicio() {
	}

	private int idServicio;
	private String nombre;
	private String descripcion;
	private double precio;
	private int idSucursal;

	public Servicio(int idServicio, String nombre, String descripcion, double precio, int idSucursal) {
		super();
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.idSucursal = idSucursal;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

}
