package modelo.entidades;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Cliente() {
		
	}
	
	private int idCliente;
	private String cedula;
	private String nombre; 
	private String telefono;
	private String email;
	private String idSucursal;
	
	

	public Cliente(int idCliente, String cedula, String nombre, String telefono, String email, String idSucursal) {
		super();
		this.idCliente = idCliente;
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.idSucursal = idSucursal;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
	
}
