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
	
	public Mascota(int idMascota, String nombre, String especie, String raza, int edad) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
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
	
	
}
