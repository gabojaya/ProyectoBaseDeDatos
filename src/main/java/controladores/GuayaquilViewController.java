package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ClienteGuayaquilDAO;
import modelo.dao.ClienteQuitoDAO;
import modelo.entidades.Cliente;

@WebServlet("/GuayaquilViewController")
public class GuayaquilViewController extends HttpServlet {

	/**
	 * 
	 */
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
		case "solicitarClientesGuayaquil":
			this.solicitarClientesGuayaquil(req, resp);
			break;
		case "solicitarInicioGuayaquil":
			this.solicitarInicioGuayaquil(req, resp);
			break;
		case "solicitarReservaGuayaquil":
			this.solicitarReservaGuayaquil(req, resp);
			break;
		case "solicitarHistorialGuayaquil":
			this.solicitarHistorialGuayaquil(req, resp);
			break;
		case "solicitarEmpleadosGuayaquil":
			this.solicitarEmpleadosGuayaquil(req, resp);
			break;
		case "solicitarServiciosGuayaquil":
			this.solicitarServiciosGuayaquil(req, resp);
			break;
			
		}
	}
	
	

	private void solicitarServiciosGuayaquil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/GYE/servicios/servicios.jsp").forward(req, resp);
		
	}

	private void solicitarEmpleadosGuayaquil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("jsp/GYE/empleados/empleados.jsp").forward(req, resp);
		
	}

	private void solicitarHistorialGuayaquil(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/GYE/historial/historial.jsp").forward(req, resp);
		
	}

	private void solicitarReservaGuayaquil(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/GYE/reservas/reservas.jsp").forward(req, resp);
		
	}

	private void solicitarInicioGuayaquil(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/GYE/inicio.jsp").forward(req, resp);
		
	}

	private void solicitarClientesGuayaquil(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro a solicitar clientes");
		ClienteGuayaquilDAO clienteGDAO = new ClienteGuayaquilDAO();

            try {
				List<Cliente> clientesGuayaquil = clienteGDAO.getClientesGuayaquil();
				
	            if (!clientesGuayaquil.isEmpty()) {
	                System.out.println("Clientes de Guayaquil:");
	                for (Cliente cliente : clientesGuayaquil) {
	                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
	                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
	                }
	            }
				
				
				req.setAttribute("clientesGuayaquil", clientesGuayaquil);
				req.getRequestDispatcher("jsp/GYE/clientes/clientes.jsp").forward(req, resp);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	

}
