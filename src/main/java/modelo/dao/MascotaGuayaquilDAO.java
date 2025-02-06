package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionGuayaquil;
import modelo.entidades.Mascota;

public class MascotaGuayaquilDAO {
    public MascotaGuayaquilDAO() {
    }

    // Obtener todas las mascotas
    public List<Mascota> getMascotas() throws SQLException {
        List<Mascota> mascotas = new ArrayList<>();
        String _SQL_GET_ALL = "SELECT idMascota, nombre, especie, raza, edad, idCliente, idSucursal FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.MascotaGuayaquil";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Mascota mascota = new Mascota();
            mascota.setIdMascota(rs.getInt("idMascota"));
            mascota.setNombre(rs.getString("nombre"));
            mascota.setEspecie(rs.getString("especie"));
            mascota.setRaza(rs.getString("raza"));
            mascota.setEdad(rs.getInt("edad"));
            mascota.setIdCliente(rs.getInt("idCliente"));
            mascota.setIdSucursal(rs.getString("idSucursal"));
            mascotas.add(mascota);
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return mascotas;
    }
 // Obtener mascotas por idCliente
    public List<Mascota> getMascotasPorCliente(int idCliente) throws SQLException {
        List<Mascota> mascotas = new ArrayList<>();
        String _SQL_GET_BY_CLIENTE = "SELECT idMascota, nombre, especie, raza, edad, idCliente, idSucursal " +
                                     "FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.MascotaGuayaquil WHERE idCliente = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_CLIENTE);
        pstmt.setInt(1, idCliente);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Mascota mascota = new Mascota();
            mascota.setIdMascota(rs.getInt("idMascota"));
            mascota.setNombre(rs.getString("nombre"));
            mascota.setEspecie(rs.getString("especie"));
            mascota.setRaza(rs.getString("raza"));
            mascota.setEdad(rs.getInt("edad"));
            mascota.setIdCliente(rs.getInt("idCliente"));
            mascota.setIdSucursal(rs.getString("idSucursal"));
            mascotas.add(mascota);
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return mascotas;
    }


    // Insertar una nueva mascota
    public boolean insertMascotaDistribuido(Mascota mascota) throws SQLException {
        boolean insertado = false;
        String _SQL_INSERT = "INSERT INTO [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaMascota (nombre, especie, raza, edad, idCliente, idSucursal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_INSERT);
            pstmt.setString(1, mascota.getNombre());
            pstmt.setString(2, mascota.getEspecie());
            pstmt.setString(3, mascota.getRaza());
            pstmt.setInt(4, mascota.getEdad());
            pstmt.setInt(5, mascota.getIdCliente());
            pstmt.setString(6, mascota.getIdSucursal());

            int filasAfectadas = pstmt.executeUpdate();
            insertado = (filasAfectadas > 0);
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return insertado;
    }

    // Actualizar una mascota
    public boolean updateMascotaDistribuido(Mascota mascota) throws SQLException {
        boolean actualizado = false;
        String _SQL_UPDATE = "UPDATE [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaMascota SET nombre = ?, especie = ?, raza = ?, edad = ?, idCliente = ? WHERE idMascota = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_UPDATE);
            pstmt.setString(1, mascota.getNombre());
            pstmt.setString(2, mascota.getEspecie());
            pstmt.setString(3, mascota.getRaza());
            pstmt.setInt(4, mascota.getEdad());
            pstmt.setInt(5, mascota.getIdCliente());
            pstmt.setInt(6, mascota.getIdMascota());

            int filasAfectadas = pstmt.executeUpdate();
            actualizado = (filasAfectadas > 0);
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return actualizado;
    }

    // Eliminar una mascota
    public boolean deleteMascotaDistribuido(int idMascota) throws SQLException {
        boolean eliminado = false;
        String _SQL_DELETE = "DELETE FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.VistaMascota WHERE idMascota = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(_SQL_DELETE);
            pstmt.setInt(1, idMascota);

            int filasAfectadas = pstmt.executeUpdate();
            eliminado = (filasAfectadas > 0);
        } finally {
            BddConnectionGuayaquil.cerrar(pstmt);
            BddConnectionGuayaquil.cerrar();
        }

        return eliminado;
    }
    
 // Obtener una mascota por idMascota
    public Mascota getMascotaPorId(int idMascota) throws SQLException {
        Mascota mascota = null;
        String _SQL_GET_BY_ID = "SELECT idMascota, nombre, especie, raza, edad, idCliente, idSucursal " +
                                "FROM [LUZUJ\\MSSQLSERVER1].sucursalGuayaquil.dbo.MascotaGuayaquil WHERE idMascota = ?";

        Connection conn = BddConnectionGuayaquil.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_BY_ID);
        pstmt.setInt(1, idMascota);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            mascota = new Mascota();
            mascota.setIdMascota(rs.getInt("idMascota"));
            mascota.setNombre(rs.getString("nombre"));
            mascota.setEspecie(rs.getString("especie"));
            mascota.setRaza(rs.getString("raza"));
            mascota.setEdad(rs.getInt("edad"));
            mascota.setIdCliente(rs.getInt("idCliente"));
            mascota.setIdSucursal(rs.getString("idSucursal"));
        }

        BddConnectionGuayaquil.cerrar(rs);
        BddConnectionGuayaquil.cerrar(pstmt);
        BddConnectionGuayaquil.cerrar();

        return mascota;
    }

    
}
