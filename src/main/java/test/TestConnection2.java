package test;


import java.sql.SQLException;
import java.util.List;

import modelo.dao.ClienteQuitoDAO;
import modelo.dao.ClienteGuayaquilDAO;
import modelo.entidades.Cliente;

public class TestConnection2 {
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

//		ClienteGuayaquilDAO clienteGuayaquilDAO = new ClienteGuayaquilDAO();
//
//		try {
//            List<Cliente> clientes = clienteGuayaquilDAO.getClientesGuayaquil();
//            if (!clientes.isEmpty()) {
//                System.out.println("Clientes de Guayaquil:");
//                for (Cliente cliente : clientes) {
//                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
//                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
//                }
//            } else {
//                System.out.println("No se encontraron clientes.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//		
		
//		ClienteDAO clienteG = new ClienteDAO();
//
//		Cliente nuevoCliente = new Cliente(11, "1234567890", "Pedro López", "0987654321", "pedro@example.com", "Guayaquil");
//
//        try {
//            boolean insertado = clienteG.insertClienteGuayaquil(nuevoCliente);
//            if (insertado) {
//                System.out.println("Cliente insertado correctamente.");
//            } else {
//                System.out.println("Error al insertar el cliente.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
		
		ClienteQuitoDAO clienteQDAO = new ClienteQuitoDAO();

		try {
            List<Cliente> clientesQuito = clienteQDAO.getClientesQuito();
            if (!clientesQuito.isEmpty()) {
                System.out.println("Clientes de Guayaquil:");
                for (Cliente cliente : clientesQuito) {
                    System.out.println(cliente.getIdCliente() + " - " + cliente.getCedula() + " - " + cliente.getNombre() +
                            " - " + cliente.getTelefono() + " - " + cliente.getEmail() + " - " + cliente.getIdSucursal());
                }
            } else {
                System.out.println("No se encontraron clientes.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
//		Cliente cliente = new Cliente();
//		cliente.setCedula("1712345678");
//		cliente.setNombre("Johan Baños");
//		cliente.setTelefono("0998765432");
//		cliente.setEmail("johan@example.com");
//		cliente.setIdSucursal("Quito");  // O "Guayaquil" según corresponda
//
//		ClienteQuitoDAO clienteDAO = new ClienteQuitoDAO();
//		try {
//		    boolean insertado = clienteDAO.insertClienteDistribuido(cliente);
//		    if (insertado) {
//		        System.out.println("Cliente insertado correctamente.");
//		    } else {
//		        System.out.println("Error al insertar el cliente.");
//		    }
//		} catch (SQLException e) {
//		    // Si hay un error, se imprime el mensaje de la excepción
//		    System.out.println("Error en la base de datos: " + e.getMessage());
//		    e.printStackTrace();
//		}
//		
		
		
	}
}
