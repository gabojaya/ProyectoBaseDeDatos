package modelo.entidades;

import java.io.Serializable;

public class ReservaMascota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ReservaMascota() {
		
	}
	
	private int idReserva;
	private int idMascota;
	private int idSucursal;

	public ReservaMascota(int idReserva, int idMascota, int idSucursal) {
		super();
		this.idReserva = idReserva;
		this.idMascota = idMascota;
		this.idSucursal = idSucursal;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	
}
