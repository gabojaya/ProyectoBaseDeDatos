package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Servicio;

public class ServicioGuayaquilDAO {

	 public ServicioGuayaquilDAO() {
	    }
	    
	    public List<Servicio> getServiciosGuayaquil() throws SQLException {
	        List<Servicio> servicios = new ArrayList<>();

	        String _SQL_GET_ALL = "SELECT idServicio, nombre, descripcion, precio, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.ServicioGuayaquil";

	        Connection conn = BddConnectionGuayaquil.getConexion();
	        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Servicio servicio = new Servicio();
	            servicio.setIdServicio(rs.getInt("idServicio"));
	            servicio.setNombre(rs.getString("nombre"));
	            servicio.setDescripcion(rs.getString("descripcion"));
	            servicio.setPrecio(rs.getDouble("precio"));
	            servicio.setIdSucursal(rs.getString("idSucursal"));

	            servicios.add(servicio);
	        }

	        BddConnectionGuayaquil.cerrar(rs);
	        BddConnectionGuayaquil.cerrar(pstmt);
	        BddConnectionGuayaquil.cerrar();

	        return servicios;
	    }
	    
	    public boolean insertServicioDistribuido(Servicio servicio) throws SQLException {
	        boolean insertado = false;

	        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaServicio (nombre, descripcion, precio, idSucursal) VALUES (?, ?, ?, ?)";

	        Connection conn = BddConnectionGuayaquil.getConexion();
	        PreparedStatement pstmt = null;

	        try {
	            pstmt = conn.prepareStatement(_SQL_INSERT);
	            pstmt.setString(1, servicio.getNombre());
	            pstmt.setString(2, servicio.getDescripcion());
	            pstmt.setDouble(3, servicio.getPrecio());
	            pstmt.setString(4, servicio.getIdSucursal());

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
	    
	    public boolean updateServicioDistribuido(Servicio servicio) throws SQLException {
	        boolean actualizado = false;

	        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaServicio " +
	                             "SET nombre = ?, descripcion = ?, precio = ? " +
	                             "WHERE idServicio = ?";

	        Connection conn = BddConnectionGuayaquil.getConexion();
	        PreparedStatement pstmt = null;

	        try {
	            pstmt = conn.prepareStatement(_SQL_UPDATE);
	            pstmt.setString(1, servicio.getNombre());
	            pstmt.setString(2, servicio.getDescripcion());
	            pstmt.setDouble(3, servicio.getPrecio());
	            pstmt.setInt(4, servicio.getIdServicio());

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
	    
	    public boolean deleteServicioDistribuido(int idServicio) throws SQLException {
	        boolean eliminado = false;

	        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaServicio WHERE idServicio = ?";

	        Connection conn = BddConnectionGuayaquil.getConexion();
	        PreparedStatement pstmt = null;

	        try {
	            pstmt = conn.prepareStatement(_SQL_DELETE);
	            pstmt.setInt(1, idServicio);

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
	    
	    public Servicio getServicioById(int idServicio) throws SQLException {
	        Servicio servicio = null;

	        String _SQL_GET_BY_ID = "SELECT idServicio, nombre, descripcion, precio, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaServicio WHERE idServicio = ?";

	        Connection conn = BddConnectionGuayaquil.getConexion();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
	            pstmt.setInt(1, idServicio);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                servicio = new Servicio();
	                servicio.setIdServicio(rs.getInt("idServicio"));
	                servicio.setNombre(rs.getString("nombre"));
	                servicio.setDescripcion(rs.getString("descripcion"));
	                servicio.setPrecio(rs.getDouble("precio"));
	                servicio.setIdSucursal(rs.getString("idSucursal"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            BddConnectionGuayaquil.cerrar(rs);
	            BddConnectionGuayaquil.cerrar(pstmt);
	            BddConnectionGuayaquil.cerrar();
	        }

	        return servicio;
	    }
	
}
