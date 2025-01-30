package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Cliente;

public class ClienteDAO {
	public ClienteDAO() {

	}
	
	public List<Cliente> getClientesGuayaquil() throws SQLException {
        List<Cliente> clientesG = new ArrayList<>();

        // Consulta SQL para obtener los clientes desde la base de datos remota
        String _SQL_GET_ALL = "SELECT idCliente, cedula, nombre, telefono, email, idSucursal FROM [CASA].sucursalGuayaquil.dbo.ClienteGuayaquil";

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

        String _SQL_INSERT = "INSERT INTO [CASA].sucursalGuayaquil.dbo.ClienteGuayaquil (idCliente, cedula, nombre, telefono, email, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

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
    
    
	
	
}
