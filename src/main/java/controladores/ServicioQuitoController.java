package controladores;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/ServicioQuitoController")
public class ServicioQuitoController extends HttpServlet {

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
		case "solicitarModificarServicio":
			this.solicitarModificarServicio(req, resp);
			break;
		case "modificarServicio":
			this.modificarServicio(req, resp);
			break;
		case "agregarServicio":
			this.agregarServicio(req, resp);
			break;
		case "eliminarServicio":
			this.eliminarServicio(req, resp);
			break;
		case "solicitarAgregarServicio":
			this.solicitarAgregarServicio(req, resp);
			break;

		}
	}

	private void solicitarAgregarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("jsp/UIO/servicios/servicioIngreso.jsp").forward(req, resp);

	}

	private void solicitarModificarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idServicio = Integer.parseInt(req.getParameter("idServicio"));

		ServicioQuitoDAO servicioQDAO = new ServicioQuitoDAO();
		Servicio servicioQuito;
		try {
			servicioQuito = servicioQDAO.getServicioById(idServicio);
			System.out.println("Servicio obtenido: " + servicioQuito.getNombre());
			req.setAttribute("servicioQuito", servicioQuito);
			req.getRequestDispatcher("jsp/UIO/servicios/servicioTabla.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void modificarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 // Obtener parámetros del formulario
	    int idServicio = Integer.parseInt(req.getParameter("idServicio"));
	    String nombre = req.getParameter("nombre");
	    String descripcion = req.getParameter("descripcion");
	    Double precio = Double.parseDouble(req.getParameter("salario"));

	    
	 // Crear objeto Cliente con los datos del formulario
	    Servicio servicio = new Servicio();
	    servicio.setIdServicio(idServicio);
	    servicio.setNombre(nombre);
	    servicio.setDescripcion(descripcion);
	    servicio.setPrecio(precio);
	    
	 // Llamar al DAO para actualizar el cliente en la base de datos
	    ServicioQuitoDAO servicioDAO = new ServicioQuitoDAO();
	    boolean actualizado = false;
	    try {
	        actualizado = servicioDAO.updateServicioDistribuido(servicio);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    

	    if (actualizado) {
	        resp.sendRedirect("QuitoViewController?ruta=solicitarServiciosQuito"); 
	    } else {
	        req.setAttribute("error", "No se pudo actualizar el cliente.");
	        req.getRequestDispatcher("/jsp/UIO/modificarCliente.jsp").forward(req, resp);
	    }
	}

	private void agregarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Obtener los parámetros del formulario
	    String nombre = req.getParameter("nombre");
	    String descripcion = req.getParameter("Descripcion");
	    Double precio = Double.parseDouble(req.getParameter("salario"));
	    String idSucursal = req.getParameter("sucursal");

	    // Crear un objeto Cliente con los datos obtenidos
	    Servicio servicio = new Servicio();

	    servicio.setNombre(nombre);
	    servicio.setDescripcion(descripcion);
	    servicio.setPrecio(precio);
	    servicio.setIdSucursal(idSucursal);

	    // Crear una instancia del DAO de ClienteQuito
	    ServicioQuitoDAO servicioQuitoDAO = new ServicioQuitoDAO();

	    try {
	        // Llamar al método para insertar el cliente en la base de datos
	        boolean insertado = servicioQuitoDAO.insertServicioDistribuido(servicio);

	        if (insertado) {
	            // Redirigir al usuario a una página de éxito (por ejemplo, la lista de clientes)
	            resp.sendRedirect("QuitoViewController?ruta=solicitarServiciosQuito");
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

	private void eliminarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idServicio = Integer.parseInt(req.getParameter("idServicio"));
		ServicioQuitoDAO servicioDAO = new ServicioQuitoDAO();
		try {
			servicioDAO.deleteServicioDistribuido(idServicio);

			req.getRequestDispatcher("jsp/UIO/servicios/servicios.jsp").forward(req, resp);
		} catch (SQLException e) {
			req.setAttribute("error", "No se pudo eliminar el empleados.");
			req.getRequestDispatcher("/jsp/UIO/listaClientes.jsp").forward(req, resp);
			e.printStackTrace();
		}

	}

}
