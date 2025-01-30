package modelo.entidades;

import java.io.Serializable;

public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	public Empleado() {
	}

	private int idEmpleado;
	private String cedula;
	private String nombre;
	private String telefono;
	private String cargo;
	private String idSucursal;

	public Empleado(int idEmpleado, String cedula, String nombre, String telefono, String cargo, String idSucursal) {
		super();
		this.idEmpleado = idEmpleado;
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.cargo = cargo;
		this.idSucursal = idSucursal;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}
}
