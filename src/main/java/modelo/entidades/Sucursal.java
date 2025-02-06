package modelo.entidades;

import java.io.Serializable;

public class Sucursal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idSucursal;
	private String nombre; 
	private String direccion;
	
	
	public Sucursal() {
		
	}
	
	public Sucursal(String idSucursal, String nombre, String direccion) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
