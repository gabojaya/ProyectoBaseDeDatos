package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionQuito;
import modelo.entidades.Reserva;
import modelo.entidades.ReservaMascota;
import modelo.entidades.ReservaServicio;

public class ReservaQuitoDAO {
	public ReservaQuitoDAO() {}

	public List<Reserva> getReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, fechaReserva, estado, idCliente, idSucursal, idEmpleado FROM [ACERDERONNY].sucursalQuito.dbo.ReservaQuito";

        Connection conn = BddConnectionQuito.getConexion();
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

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reservas;
    }

	public Reserva insertReservaDistribuida(Reserva reserva) throws SQLException {
	    String _SQL_INSERT = "INSERT INTO [ACERDERONNY].sucursalQuito.dbo.VistaReserva (fechaReserva, estado, idCliente, idSucursal, idEmpleado) VALUES (?, ?, ?, ?, ?)";
	    String _SQL_SELECT_ID = "SELECT MAX(idReserva) FROM [ACERDERONNY].sucursalQuito.dbo.VistaReserva WHERE idCliente = ? AND idSucursal = ?";

	    Connection conn = BddConnectionQuito.getConexion();
	    PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);
	    
	    pstmt.setDate(1, new java.sql.Date(reserva.getFechaReserva().getTime()));
	    pstmt.setString(2, reserva.getEstado());
	    pstmt.setInt(3, reserva.getIdCliente());
	    pstmt.setString(4, reserva.getIdSucursal());
	    pstmt.setInt(5, reserva.getIdEmpleado());

	    int filasAfectadas = pstmt.executeUpdate();
	    BddConnectionQuito.cerrar(pstmt); // Cerramos solo el PreparedStatement

	    if (filasAfectadas > 0) {
	        PreparedStatement pstmtSelect = conn.prepareStatement(_SQL_SELECT_ID);
	        pstmtSelect.setInt(1, reserva.getIdCliente());
	        pstmtSelect.setString(2, reserva.getIdSucursal());
	        
	        ResultSet rs = pstmtSelect.executeQuery();
	        if (rs.next()) {
	            reserva.setIdReserva(rs.getInt(1));
	        }

	        BddConnectionQuito.cerrar(rs);
	        BddConnectionQuito.cerrar(pstmtSelect);
	    }

	    // No cerramos la conexión aquí, la cerramos después de todas las inserciones
	    return reserva;
	}



    public boolean updateReservaDistribuida(Reserva reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [ACERDERONNY].sucursalQuito.dbo.VistaReserva SET fechaReserva = ?, estado = ?, idCliente = ?, idEmpleado = ? WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setDate(1, new java.sql.Date(reserva.getFechaReserva().getTime()));
        pstmt.setString(2, reserva.getEstado());
        pstmt.setInt(3, reserva.getIdCliente());
        pstmt.setInt(4, reserva.getIdEmpleado());
        pstmt.setInt(5, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return actualizado;
    }

    public boolean deleteReservaDistribuida(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [ACERDERONNY].sucursalQuito.dbo.VistaReserva WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return eliminado;
    }

    public Reserva getReservaById(int idReserva) throws SQLException {
        Reserva reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, fechaReserva, estado, idCliente, idSucursal, idEmpleado FROM [ACERDERONNY].sucursalQuito.dbo.VistaReserva WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
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

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reserva;
        
    }
    public List<ReservaMascota> getReservasMascota() throws SQLException {
        List<ReservaMascota> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, idMascota, idSucursal FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaMascota";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            ReservaMascota reserva = new ReservaMascota();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdMascota(rs.getInt("idMascota"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reservas.add(reserva);
        }

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reservas;
    }

    public boolean insertReservaMascota(ReservaMascota reserva) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [ACERDERONNY].sucursalQuito.dbo.VistaReservaMascota (idReserva, idMascota, idSucursal) VALUES (?, ?, ?)";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);

        pstmt.setInt(1, reserva.getIdReserva());
        pstmt.setInt(2, reserva.getIdMascota());
        pstmt.setString(3, reserva.getIdSucursal());

        int filasAfectadas = pstmt.executeUpdate();
        insertado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return insertado;
    }

    public boolean updateReservaMascota(ReservaMascota reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [ACERDERONNY].sucursalQuito.dbo.VistaReservaMascota SET idMascota = ?, idSucursal = ? WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setInt(1, reserva.getIdMascota());
        pstmt.setString(2, reserva.getIdSucursal());
        pstmt.setInt(3, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return actualizado;
    }

    public boolean deleteReservaMascota(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaMascota WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return eliminado;
    }

    public ReservaMascota getReservaMascotaById(int idReserva) throws SQLException {
        ReservaMascota reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, idMascota, idSucursal FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaMascota WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idReserva);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            reserva = new ReservaMascota();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdMascota(rs.getInt("idMascota"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
        }

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reserva;
    }
    
    
    
    public List<ReservaServicio> getReservasServicio() throws SQLException {
        List<ReservaServicio> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, idServicio, idSucursal FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaServicio";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            ReservaServicio reserva = new ReservaServicio();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdServicio(rs.getInt("idServicio"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
            reservas.add(reserva);
        }

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reservas;
    }

    public boolean insertReservaServicio(ReservaServicio reserva) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [ACERDERONNY].sucursalQuito.dbo.VistaReservaServicio (idReserva, idServicio, idSucursal) VALUES (?, ?, ?)";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_INSERT);

        pstmt.setInt(1, reserva.getIdReserva());
        pstmt.setInt(2, reserva.getIdServicio());
        pstmt.setString(3, reserva.getIdSucursal());

        int filasAfectadas = pstmt.executeUpdate();
        insertado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return insertado;
    }

    public boolean updateReservaServicio(ReservaServicio reserva) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [ACERDERONNY].sucursalQuito.dbo.VistaReservaServicio SET idServicio = ?, idSucursal = ? WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_UPDATE);

        pstmt.setInt(1, reserva.getIdServicio());
        pstmt.setString(2, reserva.getIdSucursal());
        pstmt.setInt(3, reserva.getIdReserva());

        int filasAfectadas = pstmt.executeUpdate();
        actualizado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return actualizado;
    }

    public boolean deleteReservaServicio(int idReserva) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaServicio WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_DELETE);
        pstmt.setInt(1, idReserva);

        int filasAfectadas = pstmt.executeUpdate();
        eliminado = (filasAfectadas > 0);

        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return eliminado;
    }

    public ReservaServicio getReservaServicioById(int idReserva) throws SQLException {
        ReservaServicio reserva = null;
        String _SQL_GET_BY_ID = "SELECT idReserva, idServicio, idSucursal FROM [ACERDERONNY].sucursalQuito.dbo.VistaReservaServicio WHERE idReserva = ?";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idReserva);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            reserva = new ReservaServicio();
            reserva.setIdReserva(rs.getInt("idReserva"));
            reserva.setIdServicio(rs.getInt("idServicio"));
            reserva.setIdSucursal(rs.getString("idSucursal"));
        }

        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return reserva;
    }
    
    
    
    
    
    
    
    
}
