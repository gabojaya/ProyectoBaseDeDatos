package modelo.entidades;

import java.io.Serializable;

public class Mascota implements Serializable{

	private static final long serialVersionUID = 1L;
	public Mascota() {
		
	}
	
	private int idMascota;
	private String nombre;
	private String especie; 
	private String raza;
	private int edad;
	private int idCliente;
	private int idSucursal;
	
	public Mascota(int idMascota, String nombre, String especie, String raza, int edad, int idCliente, int idSucursal) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
		this.idCliente = idCliente;
		this.idSucursal = idSucursal;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
}
