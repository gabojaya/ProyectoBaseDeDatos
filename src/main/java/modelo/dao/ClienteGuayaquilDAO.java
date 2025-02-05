package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Cliente;

public class ClienteGuayaquilDAO {
	public ClienteGuayaquilDAO() {

	}
	
	public List<Cliente> getClientesGuayaquil() throws SQLException {
        List<Cliente> clientesG = new ArrayList<>();

        // Consulta SQL para obtener los clientes desde la base de datos remota
        String _SQL_GET_ALL = "SELECT idCliente, cedula, nombre, telefono, email, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.ClienteGuayaquil";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
        	Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setCedula(rs.getString("cedula"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setEmail(rs.getString("email"));
            cliente.setIdSucursal(rs.getString("idSucursal"));

            clientesG.add(cliente);
        }

        // Cerrar recursos
        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return clientesG;
    }
	
	// Método para insertar un cliente en la base de datos
    public boolean insertClienteGuayaquil(Cliente cliente) throws SQLException {
        boolean insertado = false;

        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.ClienteGuayaquil (idCliente, cedula, nombre, telefono, email, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_INSERT);
            pstmt.setInt(1, cliente.getIdCliente());
            pstmt.setString(2, cliente.getCedula());
            pstmt.setString(3, cliente.getNombre());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setString(5, cliente.getEmail());
            pstmt.setString(6, cliente.getIdSucursal());

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
    
    public boolean insertClienteDistribuido(Cliente cliente) throws SQLException {
        boolean insertado = false;

        // SQL para insertar en la vista VistaCliente
        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].[sucursalGuayaquil].[dbo].[VistaCliente] (cedula, nombre, telefono, email, idSucursal) VALUES (?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;
        

        try {
            pstmt = conn.prepareStatement(_SQL_INSERT);
            pstmt.setString(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getIdSucursal());

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
    
    public Cliente getClienteById(int idCliente) throws SQLException {
        Cliente cliente = null;

        String _SQL_GET_BY_ID = "SELECT idCliente, cedula, nombre, telefono, email, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.ClienteGuayaquil WHERE idCliente = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
            pstmt.setInt(1, idCliente);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setIdSucursal(rs.getString("idSucursal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BddConnectionGuayaquil.cerrar(rs);
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return cliente;
    }
    

    public boolean updateClienteDistribuido(Cliente cliente) throws SQLException {
        boolean actualizado = false;

        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaCliente " +
                             "SET nombre = ?, telefono = ?, email = ? " +
                             "WHERE idCliente = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_UPDATE);
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setInt(4, cliente.getIdCliente());

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

    
    public boolean deleteClienteDistribuido(int idCliente) throws SQLException {
        boolean eliminado = false;

        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaCliente WHERE idCliente = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_DELETE);
            pstmt.setInt(1, idCliente);

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
