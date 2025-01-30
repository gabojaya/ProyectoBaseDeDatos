package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionQuito;
import modelo.entidades.Cliente;

public class ClienteQuitoDAO {
	public ClienteQuitoDAO() {

	}
	
	public List<Cliente> getClientesQuito() throws SQLException {
        List<Cliente> clientesG = new ArrayList<>();

        // Consulta SQL para obtener los clientes desde la base de datos remota
        String _SQL_GET_ALL = "SELECT idCliente, cedula, nombre, telefono, email, idSucursal FROM [CASA].sucursalQuito.dbo.ClienteQuito";

        Connection conn = BddConnectionQuito.getConexion();
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
        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return clientesG;
    }
	
	// Método para insertar un cliente en la base de datos
    public boolean insertClienteQuito(Cliente cliente) throws SQLException {
        boolean insertado = false;

        String _SQL_INSERT = "INSERT INTO [CASA].sucursalQuito.dbo.ClienteQuito (idCliente, cedula, nombre, telefono, email, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = BddConnectionQuito.getConexion();
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
        	BddConnectionQuito.cerrar(pstmt);
        	BddConnectionQuito.cerrar();
        }

        return insertado;
    }
    
    public boolean insertClienteDistribuido(Cliente cliente) throws SQLException {
        boolean insertado = false;

        // SQL para insertar en la vista VistaCliente
        String _SQL_INSERT = "INSERT INTO [CASA].sucursalQuito.dbo.VistaCliente (cedula, nombre, telefono, email, idSucursal) VALUES (?, ?, ?, ?, ?)";

        Connection conn = BddConnectionQuito.getConexion();
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
        	BddConnectionQuito.cerrar(pstmt);
        	BddConnectionQuito.cerrar();
        }

        return insertado;
    }
    
	
	
}
