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
import modelo.dao.EmpleadoQuitoDAO;
import modelo.dao.ServicioQuitoDAO;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Servicio;

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
	
	private void agregarCliente(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
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
	    ClienteQuitoDAO clienteQuitoDAO = new ClienteQuitoDAO();

	    try {
	        // Llamar al método para insertar el cliente en la base de datos
	        boolean insertado = clienteQuitoDAO.insertClienteDistribuido(cliente);

	        if (insertado) {
	            // Redirigir al usuario a una página de éxito (por ejemplo, la lista de clientes)
	            resp.sendRedirect("QuitoViewController?ruta=solicitarClientesQuito");
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

	private void solicitarAgregarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/clientes/clienteIngreso.jsp").forward(req, resp);
		
	}

	private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int idCliente = Integer.parseInt(req.getParameter("idCliente"));

	    ClienteQuitoDAO clienteDAO = new ClienteQuitoDAO();
	    boolean eliminado = false;

	    try {
	        eliminado = clienteDAO.deleteClienteDistribuido(idCliente);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (eliminado) {
	        resp.sendRedirect("QuitoViewController?ruta=solicitarClientesQuito"); 
	    } else {
	        req.setAttribute("error", "No se pudo eliminar el cliente.");
	        req.getRequestDispatcher("/jsp/UIO/listaClientes.jsp").forward(req, resp);
	    }
	}

	private void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
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
	    ClienteQuitoDAO clienteDAO = new ClienteQuitoDAO();
	    boolean actualizado = false;
	    try {
	        actualizado = clienteDAO.updateClienteDistribuido(cliente);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    

	    if (actualizado) {
	        resp.sendRedirect("QuitoViewController?ruta=solicitarClientesQuito"); 
	    } else {
	        req.setAttribute("error", "No se pudo actualizar el cliente.");
	        req.getRequestDispatcher("/jsp/UIO/modificarCliente.jsp").forward(req, resp);
	    }

		
	}

	private void solicitarModificarCliente(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		ClienteQuitoDAO clienteQDAO = new ClienteQuitoDAO();
		Cliente clienteQuito;
		try {
			clienteQuito = clienteQDAO.getClienteById(idCliente);
			System.out.println("Cliente obtenido: " + clienteQuito.getNombre());
			req.setAttribute("clienteQuito", clienteQuito);
			req.getRequestDispatcher("jsp/UIO/clientes/clienteTabla.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void solicitarSucursales(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/sucursales.jsp").forward(req, resp);
		
	}

	private void solicitarDatosPrivadosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/privado/privado.jsp").forward(req, resp);
		
	}

	private void solicitarServiciosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Entro a solicitar empleados");
		ServicioQuitoDAO servicioQuito = new ServicioQuitoDAO();


			List<Servicio> serviciosQuito;
			try {
				serviciosQuito = servicioQuito.getServiciosQuito();
				
				if (!serviciosQuito.isEmpty()) {
					System.out.println("Empleados de Quito:");
					for (Servicio servicio : serviciosQuito) {
						System.out.println(servicio.getNombre() + " - " + servicio.getDescripcion() + " - "
								+ servicio.getPrecio());
					}
				}
				
				req.setAttribute("serviciosQuito", serviciosQuito);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		req.getRequestDispatcher("jsp/UIO/servicios/servicios.jsp").forward(req, resp);
		
	}

	private void solicitarEmpleadosQuito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entro a solicitar empleados");
		EmpleadoQuitoDAO empleadosQuito = new EmpleadoQuitoDAO();


			List<Empleado> empleadoQuito;
			try {
				empleadoQuito = empleadosQuito.getEmpleadosQuito();
				
				if (!empleadoQuito.isEmpty()) {
					System.out.println("Empleados de Quito:");
					for (Empleado empleado : empleadoQuito) {
						System.out.println(empleado.getIdEmpleado() + " - " + empleado.getCedula() + " - "
								+ empleado.getNombre() + " - " + empleado.getTelefono() + " - " + " - "
								+ empleado.getIdSucursal());
					}
				}
				
				req.setAttribute("empleadoQuito", empleadoQuito);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

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
