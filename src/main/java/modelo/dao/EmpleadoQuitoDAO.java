package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionQuito;
import modelo.entidades.Empleado;

public class EmpleadoQuitoDAO {
    public EmpleadoQuitoDAO() {
    }
    
    public List<Empleado> getEmpleadosQuito() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        String _SQL_GET_ALL = "SELECT idEmpleado, cedula, nombre, telefono, cargo, idSucursal FROM [CASA].sucursalQuito.dbo.VistaDatosEmpleado";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(rs.getInt("idEmpleado"));
            empleado.setCedula(rs.getString("cedula"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setCargo(rs.getString("cargo"));
            empleado.setIdSucursal(rs.getString("idSucursal"));

            empleados.add(empleado);
        }

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return empleados;
    }
    
    public boolean insertEmpleado(Empleado empleado) throws SQLException {
        boolean insertado = false;

        String _SQL_INSERT = "INSERT INTO [CASA].sucursalQuito.dbo.VistaDatosEmpleado (idEmpleado, cedula, nombre, telefono, cargo, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_INSERT);
            pstmt.setInt(1, empleado.getIdEmpleado());
            pstmt.setString(2, empleado.getCedula());
            pstmt.setString(3, empleado.getNombre());
            pstmt.setString(4, empleado.getTelefono());
            pstmt.setString(5, empleado.getCargo());
            pstmt.setString(6, empleado.getIdSucursal());

            int filasAfectadas = pstmt.executeUpdate();
            insertado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionQuito.cerrar(pstmt);
            BddConnectionQuito.cerrar();
        }

        return insertado;
    }
    
    public boolean updateEmpleado(Empleado empleado) throws SQLException {
        boolean actualizado = false;

        String _SQL_UPDATE = "UPDATE [CASA].sucursalQuito.dbo.VistaDatosEmpleado " +
                             "SET nombre = ?, telefono = ?, cargo = ? " +
                             "WHERE idEmpleado = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_UPDATE);
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getTelefono());
            pstmt.setString(3, empleado.getCargo());
            pstmt.setInt(4, empleado.getIdEmpleado());

            int filasAfectadas = pstmt.executeUpdate();
            actualizado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionQuito.cerrar(pstmt);
            BddConnectionQuito.cerrar();
        }

        return actualizado;
    }
    
    public boolean deleteEmpleado(int idEmpleado) throws SQLException {
        boolean eliminado = false;

        String _SQL_DELETE = "DELETE FROM [CASA].sucursalQuito.dbo.VistaDatosEmpleado WHERE idEmpleado = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_DELETE);
            pstmt.setInt(1, idEmpleado);

            int filasAfectadas = pstmt.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionQuito.cerrar(pstmt);
            BddConnectionQuito.cerrar();
        }

        return eliminado;
    }
}
