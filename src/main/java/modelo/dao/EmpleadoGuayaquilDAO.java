package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;

import modelo.entidades.DatosPrivadosEmpleado;
import modelo.entidades.Empleado;

public class EmpleadoGuayaquilDAO {
    public EmpleadoGuayaquilDAO() {
    }
    
    public List<Empleado> getEmpleadosGuayaquil() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        String _SQL_GET_ALL = "SELECT idEmpleado, cedula, nombre, telefono, cargo, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.DatosEmpleadoGuayaquil";

        Connection conn = BddConnectionGuayaquil.getConexion();
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

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return empleados;
    }
    
    public boolean insertEmpleadoDistribuido(Empleado empleado) throws SQLException {
        boolean insertado = false;

        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosEmpleado (idEmpleado, cedula, nombre, telefono, cargo, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
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
        	BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return insertado;
    }
    
    public boolean updateEmpleadoDistribuido(Empleado empleado) throws SQLException {
        boolean actualizado = false;

        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosEmpleado " +
                             "SET nombre = ?, telefono = ?, cargo = ? " +
                             "WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
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
        	BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return actualizado;
    }
    
    public boolean deleteEmpleadoDistribuido(int idEmpleado) throws SQLException {
        boolean eliminado = false;

        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosEmpleado WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_DELETE);
            pstmt.setInt(1, idEmpleado);

            int filasAfectadas = pstmt.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return eliminado;
    }
    
    public Empleado getEmpleadoById(int idEmpleado) throws SQLException {
        Empleado empleado = null;

        String _SQL_GET_BY_ID = "SELECT idEmpleado, cedula, nombre, telefono, cargo, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosEmpleado WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
            pstmt.setInt(1, idEmpleado);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setCedula(rs.getString("cedula"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setIdSucursal(rs.getString("idSucursal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BddConnectionGuayaquil.cerrar(rs);
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return empleado;
    }

    public DatosPrivadosEmpleado getDatosPrivadosById(int idEmpleado) throws SQLException {
        DatosPrivadosEmpleado empleado = null;

        String _SQL_GET_PRIVADOS = "SELECT idEmpleado, direccion, email, salario, contrasena FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosPrivadosEmpleado WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(_SQL_GET_PRIVADOS);
            pstmt.setInt(1, idEmpleado);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                empleado = new DatosPrivadosEmpleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setEmail(rs.getString("email"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setContrasena(rs.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionGuayaquil.cerrar(rs);
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return empleado;
    }
    
    public boolean insertDatosPrivadosEmpleado(DatosPrivadosEmpleado empleado) throws SQLException {
        boolean insertado = false;

        String _SQL_INSERT_PRIVADOS = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosPrivadosEmpleado " +
                                      "(idEmpleado, direccion, email, salario, contrasena) VALUES (?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_INSERT_PRIVADOS);
            pstmt.setInt(1, empleado.getIdEmpleado());
            pstmt.setString(2, empleado.getDireccion());
            pstmt.setString(3, empleado.getEmail());
            pstmt.setDouble(4, empleado.getSalario());
            pstmt.setString(5, empleado.getContrasena());

            int filasAfectadas = pstmt.executeUpdate();
            insertado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return insertado;
    }

    public boolean updateDatosPrivadosEmpleado(DatosPrivadosEmpleado empleado) throws SQLException {
        boolean actualizado = false;

        String _SQL_UPDATE_PRIVADOS = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosPrivadosEmpleado " +
                                      "SET direccion = ?, email = ?, salario = ?, contrasena = ? " +
                                      "WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_UPDATE_PRIVADOS);
            pstmt.setString(1, empleado.getDireccion());
            pstmt.setString(2, empleado.getEmail());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setString(4, empleado.getContrasena());
            pstmt.setInt(5, empleado.getIdEmpleado());

            int filasAfectadas = pstmt.executeUpdate();
            actualizado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return actualizado;
    }
    
    public boolean deleteDatosPrivadosEmpleado(int idEmpleado) throws SQLException {
        boolean eliminado = false;

        String _SQL_DELETE_PRIVADOS = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaDatosPrivadosEmpleado WHERE idEmpleado = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_DELETE_PRIVADOS);
            pstmt.setInt(1, idEmpleado);

            int filasAfectadas = pstmt.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return eliminado;
    }
    
 


}
