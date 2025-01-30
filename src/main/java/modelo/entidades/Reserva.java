package modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Reserva() {}
	
	private int idReserva;
	private Date fechaReserva;
	private String estado;
	private int idCliente;
	private String idSucursal;
	private int idEmpleado;

	public Reserva(int idReserva, Date fechaReserva, String estado, int idCliente, String idSucursal, int idEmpleado) {
		super();
		this.idReserva = idReserva;
		this.fechaReserva = fechaReserva;
		this.estado = estado;
		this.idCliente = idCliente;
		this.idSucursal = idSucursal;
		this.idEmpleado = idEmpleado;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	
	
}
