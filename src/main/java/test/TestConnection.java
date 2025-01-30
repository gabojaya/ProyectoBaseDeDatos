package test;


import java.sql.SQLException;
import java.util.List;

import modelo.dao.ClienteDAO;
import modelo.entidades.Cliente;

public class TestConnection {
	public static void main(String[] args) {
//		// Probar la conexión a la base de datos 'sucursalQuito'
//		Connection conn = null;
//
//		try {
//			// Obtener la conexión
//			conn = BddConnectionQuito.getConexion();
//
//			if (conn != null) {
//				System.out.println("Conexión exitosa a la base de datos 'sucursalQuito'.");
//
//				// Ejecutar una consulta básica para probar
//				String sql = "SELECT 1 AS resultado";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//
//				while (rs.next()) {
//					int resultado = rs.getInt("resultado");
//					System.out.println("Resultado de la consulta: " + resultado);
//				}
//
//				// Cerrar recursos
//				BddConnectionQuito.cerrar(rs);
//				BddConnectionQuito.cerrar(pstmt);
//			} else {
//				System.out.println("No se pudo establecer la conexión.");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// Asegurarse de cerrar la conexión
//			BddConnectionQuito.cerrar();
//		}

		ClienteDAO clienteGuayaquilDAO = new ClienteDAO();

		try {
            List<Cliente> clientes = clienteGuayaquilDAO.getClientesGuayaquil();
            if (!clientes.isEmpty()) {
                System.out.println("Clientes de Guayaquil:");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
                }
            } else {
                System.out.println("No se encontraron clientes.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		ClienteDAO clienteG = new ClienteDAO();

		Cliente nuevoCliente = new Cliente(11, "1234567890", "Pedro López", "0987654321", "pedro@example.com", "Guayaquil");

        try {
            boolean insertado = clienteG.insertClienteGuayaquil(nuevoCliente);
            if (insertado) {
                System.out.println("Cliente insertado correctamente.");
            } else {
                System.out.println("Error al insertar el cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}
}
