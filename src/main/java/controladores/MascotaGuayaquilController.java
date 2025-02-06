package controladores;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.EmpleadoGuayaquilDAO;
import modelo.dao.MascotaGuayaquilDAO;
import modelo.entidades.DatosPrivadosEmpleado;
import modelo.entidades.Empleado;
import modelo.entidades.Mascota;

@WebServlet("/MascotaGuayaquilController")
public class MascotaGuayaquilController extends HttpServlet {
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
		case "solicitarModificarMascota":
			this.solicitarModificarMascota(req, resp);
			break;
		case "modificarMascota":
			this.modificarMascota(req, resp);
			break;
		case "eliminarMascota":
			this.eliminarMascota(req, resp);
			break;
		case "agregarMascota":
			this.agregarMascota(req, resp);
			break;
		case "solicitarAgregarMascota":
			this.solicitarAgregarMascota(req, resp);
			break;

		}
	}

	private void modificarMascota(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Obtener los parámetros del formulario
		int idMascota = Integer.parseInt(req.getParameter("idMascota"));
		String nombre = req.getParameter("nombre");
		String especie = req.getParameter("especie");
		String raza = req.getParameter("raza");
		int edad = Integer.parseInt(req.getParameter("edad"));
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		String idSucursal = req.getParameter("idSucursal");

		// Crear un objeto Mascota con los datos obtenidos
		Mascota mascota = new Mascota();
		mascota.setIdMascota(idMascota);
		mascota.setNombre(nombre);
		mascota.setEspecie(especie);
		mascota.setRaza(raza);
		mascota.setEdad(edad);
		mascota.setIdCliente(idCliente);
		mascota.setIdSucursal(idSucursal);

		// Usar el DAO para actualizar la mascota en la base de datos
		MascotaGuayaquilDAO mascotaDAO = new MascotaGuayaquilDAO();
		try {
			boolean actualizado = mascotaDAO.updateMascotaDistribuido(mascota);

			// Redirigir según el resultado de la actualización
			if (actualizado) {
				resp.sendRedirect("GuayaquilViewController?ruta=verMascotas&idCliente=" + idCliente);
			} else {
				// Mostrar un mensaje de error si no se pudo actualizar
				req.setAttribute("error", "No se pudo actualizar la mascota.");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// Manejo de excepciones
			e.printStackTrace();
			req.setAttribute("error", "Hubo un error al actualizar la mascota.");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}

	private void solicitarAgregarMascota(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		req.setAttribute("idCliente", idCliente);
		req.getRequestDispatcher("jsp/GYE/mascota/mascotaIngreso.jsp").forward(req, resp);

	}

	private void agregarMascota(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Obtener parámetros del formulario
			String nombre = req.getParameter("nombre");
			String especie = req.getParameter("especie");
			String raza = req.getParameter("raza");
			int edad = Integer.parseInt(req.getParameter("edad"));
			int idCliente = Integer.parseInt(req.getParameter("idCliente"));
			String idSucursal = req.getParameter("idSucursal");

			// Crear objeto Mascota
			Mascota nuevaMascota = new Mascota();
			nuevaMascota.setNombre(nombre);
			nuevaMascota.setEspecie(especie);
			nuevaMascota.setRaza(raza);
			nuevaMascota.setEdad(edad);
			nuevaMascota.setIdCliente(idCliente);
			nuevaMascota.setIdSucursal(idSucursal);
			// Insertar en la BD
			MascotaGuayaquilDAO mascotaDAO = new MascotaGuayaquilDAO();
			boolean insertado = mascotaDAO.insertMascotaDistribuido(nuevaMascota);

			if (insertado) {
				resp.sendRedirect("GuayaquilViewController?ruta=verMascotas&idCliente=" + idCliente);
			} else {
				req.setAttribute("errorMensaje", "Error al agregar la mascota.");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/GYE/agregarMascota.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			throw new ServletException("Error al agregar mascota", e);
		}

	}

	private void eliminarMascota(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// Obtener el ID de la mascota desde los parámetros
			int idMascota = Integer.parseInt(req.getParameter("idMascota"));
			int idCliente = Integer.parseInt(req.getParameter("idCliente")); // Para redireccionar correctamente

			// Llamar al método DAO para eliminar
			MascotaGuayaquilDAO mascotaDAO = new MascotaGuayaquilDAO();
			boolean eliminado = mascotaDAO.deleteMascotaDistribuido(idMascota);

			if (eliminado) {
				resp.sendRedirect("GuayaquilViewController?ruta=verMascotas&idCliente=" + idCliente);
			} else {
				req.setAttribute("errorMensaje", "Error al eliminar la mascota.");
				RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/GYE/listaMascotas.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			throw new ServletException("Error al eliminar la mascota", e);
		}

	}

	private void solicitarModificarMascota(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idMascota = Integer.parseInt(req.getParameter("idMascota"));

		MascotaGuayaquilDAO mascotaGDAO = new MascotaGuayaquilDAO();
		Mascota mascotaGuayaquil;

		try {
			mascotaGuayaquil = mascotaGDAO.getMascotaPorId(idMascota);

			req.setAttribute("mascota", mascotaGuayaquil);

			req.getRequestDispatcher("jsp/GYE/mascota/mascotaEdit.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
