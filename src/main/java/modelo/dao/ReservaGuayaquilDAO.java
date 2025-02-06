package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Reserva;
import modelo.entidades.ReservaMascota;
import modelo.entidades.ReservaServicio;

public class ReservaGuayaquilDAO {
	public ReservaGuayaquilDAO() {}

	public List<Reserva> getReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, fechaReserva, estado, idCliente, idSucursal, idEmpleado FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.ReservaGuayaquil";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setFechaReserva(rs.getDate("fechaReserva"));
            reserva.setEstado(rs.getString("estado"));
            reserva.setIdCliente(rs.getInt("idCliente"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reserva.setIdEmpleado(rs.getInt("idEmpleado"));
            reservas.add(reserva);
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reservas;
    }

	public boolean deleteReservaGuayaquil(int idReserva) throws SQLException {
	    boolean eliminado = false;
	    
	    // Sentencias SQL para cada tabla
	    String sqlDeleteServicio = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio WHERE idReserva = ?";
	    String sqlDeleteMascota  = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota WHERE idReserva = ?";
	    String sqlDeleteReserva  = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva WHERE idReserva = ?";
	    
	    Connection conn = null;
	    PreparedStatement pstmtServicio = null;
	    PreparedStatement pstmtMascota = null;
	    PreparedStatement pstmtReserva = null;
	    
	    try {
	        // Obtener la conexión
	        conn = BddConnectionGuayaquil.getConexion();
	        
	        // Desactivar el autoCommit para controlar la transacción manualmente
	        conn.setAutoCommit(false);
	        
	        // Preparar y ejecutar la eliminación en ReservaServicioQuito
	        pstmtServicio = conn.prepareStatement(sqlDeleteServicio);
	        pstmtServicio.setInt(1, idReserva);
	        pstmtServicio.executeUpdate();
	        
	        // Preparar y ejecutar la eliminación en ReservaMascotaQuito
	        pstmtMascota = conn.prepareStatement(sqlDeleteMascota);
	        pstmtMascota.setInt(1, idReserva);
	        pstmtMascota.executeUpdate();
	        
	        // Preparar y ejecutar la eliminación en ReservaQuito (tabla padre)
	        pstmtReserva = conn.prepareStatement(sqlDeleteReserva);
	        pstmtReserva.setInt(1, idReserva);
	        int filasAfectadas = pstmtReserva.executeUpdate();
	        
	        // Confirmar la transacción
	        conn.commit();
	        
	        // Se considera eliminado si se afectó al menos 1 fila en la tabla padre
	        eliminado = (filasAfectadas > 0);
	    } catch (SQLException e) {
	        // En caso de error, hacer rollback de la transacción
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        // Restaurar el autoCommit a su valor por defecto (true) y cerrar los recursos
	        if (conn != null) {
	            try {
	                conn.setAutoCommit(true);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        BddConnectionGuayaquil.cerrar(pstmtServicio);
	        BddConnectionGuayaquil.cerrar(pstmtMascota);
	        BddConnectionGuayaquil.cerrar(pstmtReserva);
	        BddConnectionGuayaquil.cerrar(); // Cierra la conexión
	    }
	    
	    return eliminado;
	}
	
    public boolean insertReservaDistribuidaBoolean(Reserva reserva) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva (fechaReserva, estado, idCliente, idSucursal, idEmpleado) VALUES (?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);

        pstmt.setDate(1, new java.sql.Date(reserva.getFechaReserva().getTime()));
        pstmt.setString(2, reserva.getEstado());
        pstmt.setInt(3, reserva.getIdCliente());
        pstmt.setString(4, reserva.getIdSucursal());
        pstmt.setInt(5, reserva.getIdEmpleado());

        int filasAfectadas = pstmt.executeUpdate();
        insertado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return insertado;
    }
    public Reserva insertReservaDistribuida(Reserva reserva) throws SQLException {
	    String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva (fechaReserva, estado, idCliente, idSucursal, idEmpleado) VALUES (?, ?, ?, ?, ?)";
	    String _SQL_SELECT_ID = "SELECT MAX(idReserva) FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva WHERE idCliente = ? AND idSucursal = ?";

	    Connection conn = BddConnectionGuayaquil.getConexion();
	    PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);
	    
	    pstmt.setDate(1, new java.sql.Date(reserva.getFechaReserva().getTime()));
	    pstmt.setString(2, reserva.getEstado());
	    pstmt.setInt(3, reserva.getIdCliente());
	    pstmt.setString(4, reserva.getIdSucursal());
	    pstmt.setInt(5, reserva.getIdEmpleado());

	    int filasAfectadas = pstmt.executeUpdate();
	    BddConnectionGuayaquil.cerrar(pstmt); // Cerramos solo el PreparedStatement

	    if (filasAfectadas > 0) {
	        PreparedStatement pstmtSelect = conn.prepareStatement(_SQL_SELECT_ID);
	        pstmtSelect.setInt(1, reserva.getIdCliente());
	        pstmtSelect.setString(2, reserva.getIdSucursal());
	        
	        ResultSet rs = pstmtSelect.executeQuery();
	        if (rs.next()) {
	            reserva.setIdReserva(rs.getInt(1));
	        }

	        BddConnectionGuayaquil.cerrar(rs);
	        BddConnectionGuayaquil.cerrar(pstmtSelect);
	    }

	    // No cerramos la conexión aquí, la cerramos después de todas las inserciones
	    return reserva;
	}

    public boolean updateReservaDistribuida(Reserva reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva SET fechaReserva = ?, estado = ?, idCliente = ?, idEmpleado = ? WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setDate(1, new java.sql.Date(reserva.getFechaReserva().getTime()));
        pstmt.setString(2, reserva.getEstado());
        pstmt.setInt(3, reserva.getIdCliente());
        pstmt.setInt(4, reserva.getIdEmpleado());
        pstmt.setInt(5, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return actualizado;
    }

    public boolean deleteReservaDistribuida(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return eliminado;
    }

    public Reserva getReservaById(int idReserva) throws SQLException {
        Reserva reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, fechaReserva, estado, idCliente, idSucursal, idEmpleado FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idReserva);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            reserva = new Reserva();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setFechaReserva(rs.getDate("fechaReserva"));
            reserva.setEstado(rs.getString("estado"));
            reserva.setIdCliente(rs.getInt("idCliente"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reserva.setIdEmpleado(rs.getInt("idEmpleado"));
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reserva;
    }

    public List<ReservaMascota> getReservasMascota() throws SQLException {
        List<ReservaMascota> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, idMascota, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            ReservaMascota reserva = new ReservaMascota();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdMascota(rs.getInt("idMascota"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reservas.add(reserva);
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reservas;
    }

    public boolean insertReservaMascota(ReservaMascota reserva) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota (idReserva, idMascota, idSucursal) VALUES (?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);

        pstmt.setInt(1, reserva.getIdReserva());
        pstmt.setInt(2, reserva.getIdMascota());
        pstmt.setString(3, reserva.getIdSucursal());

        int filasAfectadas = pstmt.executeUpdate();
        insertado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return insertado;
    }

    public boolean updateReservaMascota(ReservaMascota reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota SET idMascota = ?, idSucursal = ? WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setInt(1, reserva.getIdMascota());
        pstmt.setString(2, reserva.getIdSucursal());
        pstmt.setInt(3, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return actualizado;
    }

    public boolean deleteReservaMascota(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return eliminado;
    }

    public ReservaMascota getReservaMascotaById(int idReserva) throws SQLException {
        ReservaMascota reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, idMascota, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaMascota WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idReserva);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            reserva = new ReservaMascota();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdMascota(rs.getInt("idMascota"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reserva;
    }
    
    
    
    public List<ReservaServicio> getReservasServicio() throws SQLException {
        List<ReservaServicio> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, idServicio, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            ReservaServicio reserva = new ReservaServicio();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdServicio(rs.getInt("idServicio"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reservas.add(reserva);
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reservas;
    }

    public boolean insertReservaServicio(ReservaServicio reserva) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio (idReserva, idServicio, idSucursal) VALUES (?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);

        pstmt.setInt(1, reserva.getIdReserva());
        pstmt.setInt(2, reserva.getIdServicio());
        pstmt.setString(3, reserva.getIdSucursal());

        int filasAfectadas = pstmt.executeUpdate();
        insertado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return insertado;
    }

    public boolean updateReservaServicio(ReservaServicio reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio SET idServicio = ?, idSucursal = ? WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setInt(1, reserva.getIdServicio());
        pstmt.setString(2, reserva.getIdSucursal());
        pstmt.setInt(3, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return actualizado;
    }

    public boolean deleteReservaServicio(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return eliminado;
    }

    public ReservaServicio getReservaServicioById(int idReserva) throws SQLException {
        ReservaServicio reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, idServicio, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReservaServicio WHERE idReserva = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idReserva);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            reserva = new ReservaServicio();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdServicio(rs.getInt("idServicio"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return reserva;
    }
    
    
}
