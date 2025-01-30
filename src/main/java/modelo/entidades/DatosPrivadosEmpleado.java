package modelo.entidades;

import java.io.Serializable;

public class DatosPrivadosEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	public DatosPrivadosEmpleado() {
		
	}
	
	private int idEmpleado;
	private String direccion;
	private String email;
	private double salario;
	private String contrasena;

	public DatosPrivadosEmpleado(int idEmpleado, String direccion, String email, double salario, String contrasena) {
		super();
		this.idEmpleado = idEmpleado;
		this.direccion = direccion;
		this.email = email;
		this.salario = salario;
		this.contrasena = contrasena;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
	
}
