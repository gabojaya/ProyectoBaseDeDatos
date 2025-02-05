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

	private void ruteador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		case "solicitarModificarCliente":
			this.solicitarModificarCliente(req, resp);
			break;
		case "modificarCliente":
			this.modificarCliente(req, resp);
			break;
		case "eliminarCliente":
			this.eliminarCliente(req, resp);
			break;
		case "solicitarAgregarCliente":
			this.solicitarAgregarCliente(req, resp);
			break;
		case "agregarCliente":
			this.agregarCliente(req, resp);
			break;

		}
	}

	private void agregarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Obtener los parámetros del formulario
		String cedula = req.getParameter("cedula");
		String nombre = req.getParameter("nombre");
		String telefono = req.getParameter("telefono");
		String email = req.getParameter("email");
		String idSucursal = req.getParameter("sucursal");

		// Crear un objeto Cliente con los datos obtenidos
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);
		cliente.setIdSucursal(idSucursal);

		// Crear una instancia del DAO de ClienteQuito
		ClienteGuayaquilDAO clienteGuayaquilDAO = new ClienteGuayaquilDAO();

		try {
			// Llamar al método para insertar el cliente en la base de datos
			boolean insertado = clienteGuayaquilDAO.insertClienteDistribuido(cliente);

			if (insertado) {
				// Redirigir al usuario a una página de éxito (por ejemplo, la lista de
				// clientes)
				resp.sendRedirect("GuayaquilViewController?ruta=solicitarClientesGuayaquil");
			} else {
				// Si la inserción falla, redirigir a una página de error o mostrar un mensaje
				req.setAttribute("error", "No se pudo agregar el cliente.");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// Manejo de excepciones SQL
			e.printStackTrace();
			req.setAttribute("error", "Error al insertar el cliente en la base de datos.");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}

	}

	private void solicitarAgregarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/GYE/clientes/clienteIngreso.jsp").forward(req, resp);

	}

	private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));

		ClienteGuayaquilDAO clienteDAO = new ClienteGuayaquilDAO();
		boolean eliminado = false;

		try {
			eliminado = clienteDAO.deleteClienteDistribuido(idCliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (eliminado) {
			resp.sendRedirect("GuayaquilViewController?ruta=solicitarClientesGuayaquil");
		} else {
			req.setAttribute("error", "No se pudo eliminar el cliente.");
			req.getRequestDispatcher("/jsp/UIO/listaClientes.jsp").forward(req, resp);
		}
	}

	private void modificarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Obtener parámetros del formulario
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		String nombre = req.getParameter("nombre");
		String telefono = req.getParameter("telefono");
		String email = req.getParameter("email");

		// Crear objeto Cliente con los datos del formulario
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);

		// Llamar al DAO para actualizar el cliente en la base de datos
		ClienteGuayaquilDAO clienteGDAO = new ClienteGuayaquilDAO();
		boolean actualizado = false;
		try {
			actualizado = clienteGDAO.updateClienteDistribuido(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (actualizado) {
			resp.sendRedirect("GuayaquilViewController?ruta=solicitarClientesGuayaquil");
		} else {
			req.setAttribute("error", "No se pudo actualizar el cliente.");
			req.getRequestDispatcher("/jsp/UIO/modificarCliente.jsp").forward(req, resp);
		}

	}

	private void solicitarModificarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		ClienteGuayaquilDAO clienteGDAO = new ClienteGuayaquilDAO();
		Cliente clienteQuito;
		try {
			clienteQuito = clienteGDAO.getClienteById(idCliente);
			System.out.println("Cliente obtenido: " + clienteQuito.getNombre());
			req.setAttribute("clienteQuito", clienteQuito);
			req.getRequestDispatcher("jsp/GYE/clientes/clienteTabla.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void solicitarServiciosGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/GYE/servicios/servicios.jsp").forward(req, resp);

	}

	private void solicitarEmpleadosGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("jsp/GYE/empleados/empleados.jsp").forward(req, resp);

	}

	private void solicitarHistorialGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/GYE/historial/historial.jsp").forward(req, resp);

	}

	private void solicitarReservaGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/GYE/reservas/reservas.jsp").forward(req, resp);

	}

	private void solicitarInicioGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/GYE/inicio.jsp").forward(req, resp);

	}

	private void solicitarClientesGuayaquil(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro a solicitar clientes");
		ClienteGuayaquilDAO clienteGDAO = new ClienteGuayaquilDAO();

		try {
			List<Cliente> clientesGuayaquil = clienteGDAO.getClientesGuayaquil();

			if (!clientesGuayaquil.isEmpty()) {
				System.out.println("Clientes de Guayaquil:");
				for (Cliente cliente : clientesGuayaquil) {
					System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - "
							+ cliente.getNombre() + " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - "
							+ cliente.getIdSucursal());
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
