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
		case "solicitarGuayaquilQuito":
			this.solicitarGuayaquilQuito(req, resp);
			break;
			
		
		}
	}

	private void solicitarGuayaquilQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro a solicitar clientes");
		ClienteGuayaquilDAO clienteQDAO = new ClienteGuayaquilDAO();

            try {
				List<Cliente> clientesGuayaquil = clienteQDAO.getClientesGuayaquil();
				
	            if (!clientesGuayaquil.isEmpty()) {
	                System.out.println("Clientes de Guayaquil:");
	                for (Cliente cliente : clientesGuayaquil) {
	                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
	                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
	                }
	            }
				
				
				req.setAttribute("clientesGuayaquil", clientesGuayaquil);
				req.getRequestDispatcher("jsp/UIO/clientes/clientes.jsp").forward(req, resp);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	

}
