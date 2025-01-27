package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.bdd.BddConnectionQuito;

public class TestConnection {
    public static void main(String[] args) {
        // Probar la conexión a la base de datos 'sucursalQuito'
        Connection conn = null;

        try {
            // Obtener la conexión
            conn = BddConnectionQuito.getConexion();

            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos 'sucursalQuito'.");

                // Ejecutar una consulta básica para probar
                String sql = "SELECT 1 AS resultado";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    int resultado = rs.getInt("resultado");
                    System.out.println("Resultado de la consulta: " + resultado);
                }

                // Cerrar recursos
                BddConnectionQuito.cerrar(rs);
                BddConnectionQuito.cerrar(pstmt);
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Asegurarse de cerrar la conexión
            BddConnectionQuito.cerrar();
        }
    }
}
