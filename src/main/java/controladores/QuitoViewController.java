package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ClienteQuitoDAO;
import modelo.entidades.Cliente;

@WebServlet("/QuitoViewController")
public class QuitoViewController extends HttpServlet {

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
		case "solicitarClientesQuito":
			this.solicitarClientesQuito(req, resp);
			break;
		case "solicitarInicioQuito":
			this.solicitarInicioQuito(req, resp);
			break;
		case "solicitarReservaQuito":
			this.solicitarReservaQuito(req, resp);
			break;
		case "solicitarHistorialQuito":
			this.solicitarHistorialQuito(req, resp);
			break;
		case "solicitarEmpleadosQuito":
			this.solicitarEmpleadosQuito(req, resp);
			break;
		case "solicitarServiciosQuito":
			this.solicitarServiciosQuito(req, resp);
			break;
		case "solicitarDatosPrivadosQuito":
			this.solicitarDatosPrivadosQuito(req, resp);
			break;
			
		case "solicitarSucursales":
			this.solicitarSucursales(req, resp);
			break;
			
		
		}
	}

	private void solicitarSucursales(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/sucursales.jsp").forward(req, resp);
		
	}

	private void solicitarDatosPrivadosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/privado/privado.jsp").forward(req, resp);
		
	}

	private void solicitarServiciosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/servicios/servicios.jsp").forward(req, resp);
		
	}

	private void solicitarEmpleadosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("jsp/UIO/empleados/empleados.jsp").forward(req, resp);
		
	}

	private void solicitarHistorialQuito(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/historial/historial.jsp").forward(req, resp);
		
	}

	private void solicitarReservaQuito(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/reservas/reservas.jsp").forward(req, resp);
		
	}

	private void solicitarInicioQuito(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/inicio.jsp").forward(req, resp);
		
	}

	private void solicitarClientesQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro a solicitar clientes");
		ClienteQuitoDAO clienteQDAO = new ClienteQuitoDAO();

            try {
				List<Cliente> clientesQuito = clienteQDAO.getClientesQuito();
				
	            if (!clientesQuito.isEmpty()) {
	                System.out.println("Clientes de Quito:");
	                for (Cliente cliente : clientesQuito) {
	                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
	                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
	                }
	            }
				
				
				req.setAttribute("clientesQuito", clientesQuito);
				req.getRequestDispatcher("jsp/UIO/clientes/clientes.jsp").forward(req, resp);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	

}
