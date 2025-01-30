package modelo.entidades;

import java.io.Serializable;

public class ReservaMascota implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ReservaMascota() {
		
	}
	
	private int idReserva;
	private int idMascota;

	public ReservaMascota(int idReserva, int idMascota) {
		super();
		this.idReserva = idReserva;
		this.idMascota = idMascota;
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
	
}
