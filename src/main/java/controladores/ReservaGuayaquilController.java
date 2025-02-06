package controladores;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ReservaGuayaquilDAO;
import modelo.entidades.Reserva;
import modelo.entidades.ReservaMascota;
import modelo.entidades.ReservaServicio;

@WebServlet("/ReservaGuayaquilController")
public class ReservaGuayaquilController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.ruteador(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.ruteador(req, resp);
	}
	
	private void ruteador(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Logica del control
		String ruta = (req.getParameter("ruta") == null) ? "listar" : req.getParameter("ruta");

		switch (ruta) {
		case "guardarReserva":
			this.guardarReserva(req, resp);
			break;
		case "eliminarReserva":
			this.eliminarReserva(req, resp);
			break;
		}
	}

	private void eliminarReserva(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int idReserva = Integer.parseInt(req.getParameter("idReserva"));
		 
		 ReservaGuayaquilDAO reserva = new ReservaGuayaquilDAO();
		 boolean reservaInsertada = false;
		 try {
			reservaInsertada = reserva.deleteReservaGuayaquil(idReserva);
			 req.getRequestDispatcher("GuayaquilViewController?ruta=solicitarHistorialGuayaquil").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
	}

	private void guardarReserva(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        // Obtener los parámetros del formulario
	        int idCliente = Integer.parseInt(req.getParameter("client"));
	        int idEmpleado = Integer.parseInt(req.getParameter("employee"));
	        int idServicio = Integer.parseInt(req.getParameter("service"));
	        int idMascota = Integer.parseInt(req.getParameter("mascota"));
	        
	        System.out.println("IdCliente: "+idCliente);
	        System.out.println("idEmpleado: "+idEmpleado);
	        System.out.println("idServicio: "+idServicio);
	        System.out.println("idMascota: "+idMascota);
	        
	        String idSucursal = "Guayaquil"; 

	        // Obtener la fecha actual para la reserva
	        java.util.Date date = new java.util.Date();
	        java.sql.Date fechaReserva = new java.sql.Date(date.getTime());

	        // Crear la reserva
	        Reserva reserva = new Reserva();
	        reserva.setIdCliente(idCliente);
	        reserva.setIdEmpleado(idEmpleado);
	        reserva.setFechaReserva(fechaReserva);
	        reserva.setEstado("Pendiente"); // Estado inicial
	        reserva.setIdSucursal(idSucursal);
	        
	        // Insertar la reserva en la base de datos
	        ReservaGuayaquilDAO reservaDAO = new ReservaGuayaquilDAO();
	        reserva = reservaDAO.insertReservaDistribuida(reserva); // Capturar la reserva con ID actualizado
	        
	        if (reserva.getIdReserva() > 0) { // Verificar si la reserva se creó correctamente
	            System.out.println("Reserva insertada con id: " + reserva.getIdReserva());

	            // Insertar la reserva de servicio
	            ReservaServicio reservaServicio = new ReservaServicio();
	            reservaServicio.setIdReserva(reserva.getIdReserva());
	            reservaServicio.setIdServicio(idServicio);
	            reservaServicio.setIdSucursal(idSucursal);

	            boolean servicioInsertado = reservaDAO.insertReservaServicio(reservaServicio);

	            // Insertar la reserva de mascota
	            ReservaMascota reservaMascota = new ReservaMascota();
	            reservaMascota.setIdReserva(reserva.getIdReserva());
	            reservaMascota.setIdMascota(idMascota);
	            reservaMascota.setIdSucursal(idSucursal);

	            boolean mascotaInsertada = reservaDAO.insertReservaMascota(reservaMascota);

	            if (servicioInsertado && mascotaInsertada) {
	                // Si la inserción de las reservas fue exitosa, redirigir a una página de éxito
	                req.getRequestDispatcher("GuayaquilViewController?ruta=solicitarReservaGuayaquil").forward(req, resp);
	            } else {
	                // Si alguna inserción falla, mostrar mensaje de error
	                resp.getWriter().write("Error al realizar la reserva.");
	            }
	        } else {
	            // Si la reserva no se insertó correctamente
	            resp.getWriter().write("Error al crear la reserva.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.getWriter().write("Error: " + e.getMessage());
	    }
	}


}
