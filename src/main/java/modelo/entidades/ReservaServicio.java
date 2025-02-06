package modelo.entidades;

import java.io.Serializable;

public class ReservaServicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ReservaServicio() {
		
	}

	
	private int idReserva;
	private int idServicio;
	private String idSucursal;


	public ReservaServicio(int idReserva, int idServicio, String idSucursal) {
		super();
		this.idReserva = idReserva;
		this.idServicio = idServicio;
		this.idSucursal = idSucursal;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}

	
	
	
}
