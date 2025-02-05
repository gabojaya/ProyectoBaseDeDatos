package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Reserva;

public class ReservaGuayaquilDAO {
	public ReservaGuayaquilDAO() {}

	public List<Reserva> getReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idReserva, fechaReserva, estado, idCliente, idSucursal, idEmpleado FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaReserva";

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

    public boolean insertReservaDistribuida(Reserva reserva) throws SQLException {
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
}
