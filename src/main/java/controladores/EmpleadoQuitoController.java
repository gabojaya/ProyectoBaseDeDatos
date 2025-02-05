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
import modelo.entidades.Cliente;
import modelo.entidades.DatosPrivadosEmpleado;
import modelo.entidades.Empleado;

@WebServlet("/EmpleadoQuitoController")
public class EmpleadoQuitoController extends HttpServlet{
	
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
		case "solicitarModificarEmpleado":
			this.solicitarModificarEmpleado(req, resp);
			break;
		case "modificarEmpleado":
			this.modificarEmpleado(req, resp);
			break;
		case "eliminarEmpleado":
			this.eliminarEmpleado(req, resp);
			break;
		case "solicitarAgregarEmpleado":
			this.solicitarAgregarEmpleado(req, resp);
			break;
		case "agregarEmpleado":
			this.agregarEmpleado(req, resp);
			break;

		}
	}
	
	private void eliminarEmpleado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int idEmpleado = Integer.parseInt(req.getParameter("idEmpleado"));

	    EmpleadoQuitoDAO empleadoDAO = new EmpleadoQuitoDAO();
	    boolean eliminado = false;

	    try {
	        eliminado = empleadoDAO.deleteEmpleadoDistribuido(idEmpleado);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (eliminado) {
	        resp.sendRedirect("QuitoViewController?ruta=solicitarEmpleadosQuito"); 
	    } else {
	        req.setAttribute("error", "No se pudo eliminar el empleados.");
	        req.getRequestDispatcher("/jsp/UIO/listaClientes.jsp").forward(req, resp);
	    }
	}

	private void agregarEmpleado(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// Obtener los parámetros del formulario
	    String cedula = req.getParameter("cedula");
	    String nombre = req.getParameter("nombre");
	    String telefono = req.getParameter("telefono");
	    String email = req.getParameter("email");
	    String direccion = req.getParameter("direccion");
	    String cargo = req.getParameter("cargo");
	    String salarioStr = req.getParameter("salario");
	    String contrasena = req.getParameter("contrasena");
	    String idSucursal = req.getParameter("sucursal");

	 // Validar y convertir salario
	    double salario = 0.0;
	    try {
	        salario = Double.parseDouble(salarioStr);
	    } catch (NumberFormatException e) {
	        req.setAttribute("error", "El salario ingresado no es válido.");
	        req.getRequestDispatcher("formularioEmpleado.jsp").forward(req, resp);
	        return;
	    }

	    // Crear objeto Empleado
	    Empleado empleado = new Empleado();
	    empleado.setCedula(cedula);
	    empleado.setNombre(nombre);
	    empleado.setTelefono(telefono);
	    empleado.setCargo(cargo); 
	    empleado.setIdSucursal(idSucursal);
	    System.out.println("ID Empleado:"+ empleado.getIdEmpleado());

	    // Crear una instancia del DAO de ClienteQuito
	    EmpleadoQuitoDAO empleadoQuitoDAO = new EmpleadoQuitoDAO();

	    try {
	        // Llamar al método para insertar el cliente en la base de datos
	        boolean insertado = empleadoQuitoDAO.insertEmpleadoDistribuido(empleado);

	        if (insertado) {
	        	
	        	DatosPrivadosEmpleado empleadoPrivado = new DatosPrivadosEmpleado();
	    	    empleadoPrivado.setIdEmpleado(empleado.getIdEmpleado());
	    	    empleadoPrivado.setSalario(salario);
	    	    empleadoPrivado.setEmail(email);
	    	    empleadoPrivado.setDireccion(direccion);
	    	    empleadoPrivado.setContrasena(contrasena);
	    	    
	    	    
	    	    
	            // Redirigir al usuario a una página de éxito (por ejemplo, la lista de clientes)
	            resp.sendRedirect("QuitoViewController?ruta=solicitarEmpleadosQuito");
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

	private void solicitarAgregarEmpleado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("jsp/UIO/empleados/empleadoIngreso.jsp").forward(req, resp);
		
	}
	
	private void modificarEmpleado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		 // Obtener parámetros del formulario
	    int idEmpleado = Integer.parseInt(req.getParameter("idEmpleado"));
	 // Obtener los parámetros del formulario
	    String cedula = req.getParameter("cedula");
	    String nombre = req.getParameter("nombre");
	    String telefono = req.getParameter("telefono");
	    String email = req.getParameter("email");
	    String direccion = req.getParameter("direccion");
	    String cargo = req.getParameter("cargo");
	    String salarioStr = req.getParameter("salario");
	    String contrasena = req.getParameter("contrasena");
	    String idSucursal = req.getParameter("sucursal");

	    // Crear objeto Cliente con los datos del formulario
	    Empleado empleado = new Empleado();
	    empleado.setIdEmpleado(idEmpleado);
	    empleado.setNombre(nombre);
	    empleado.setTelefono(telefono);
	    empleado.setCargo(cargo);
	    
	 // Llamar al DAO para actualizar el cliente en la base de datos
	    EmpleadoQuitoDAO empleadoDAO = new EmpleadoQuitoDAO();
	    boolean actualizado = false;
	    try {
	        actualizado = empleadoDAO.updateEmpleadoDistribuido(empleado);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    

	    if (actualizado) {
	        resp.sendRedirect("QuitoViewController?ruta=solicitarEmpleadosQuito"); 
	    } else {
	        req.setAttribute("error", "No se pudo actualizar el cliente.");
	        req.getRequestDispatcher("/jsp/UIO/modificarCliente.jsp").forward(req, resp);
	    }

		
	}

	private void solicitarModificarEmpleado(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		
		int idEmpleado = Integer.parseInt(req.getParameter("idEmpleado"));
		
		EmpleadoQuitoDAO empleadoQDAO = new EmpleadoQuitoDAO();
		Empleado empleadoQuito;
		try {
			empleadoQuito = empleadoQDAO.getEmpleadoById(idEmpleado);
			System.out.println("Empleado obtenido: " + empleadoQuito.getNombre());
			req.setAttribute("empleadoQuito", empleadoQuito);
			req.getRequestDispatcher("jsp/UIO/empleados/empleadoTabla.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
