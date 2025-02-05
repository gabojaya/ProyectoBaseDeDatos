package modelo.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BddConnectionGuayaquil {

    private static Connection conn = null;

    private BddConnectionGuayaquil() {
        
        String servidor = "LUZUJ\\MSSQLSERVER1";
        String puerto = "1433"; 
        String database = "sucursalGuayaquil";
        String usuario = "sa"; 
        String password = "P@ssw0rd"; 
        
        String url = "jdbc:sqlserver://" + servidor + ":" + puerto + ";databaseName=" + database + ";encrypt=true;trustServerCertificate=true";

        try {
            
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        if (conn == null) {
            new BddConnectionGuayaquil();
        }
        return conn;
    }

    public static void cerrar(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void cerrar(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cerrar() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
