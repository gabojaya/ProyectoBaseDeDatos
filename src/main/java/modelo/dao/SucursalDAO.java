package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConnectionQuito;
import modelo.entidades.Sucursal;

public class SucursalDAO {

	public SucursalDAO() {

	}
	
	public List<Sucursal> getSucursales() throws SQLException {
        List<Sucursal> sucursalesG = new ArrayList<>();

        // Consulta SQL para obtener los clientes desde la base de datos remota
        String _SQL_GET_ALL = "SELECT idSucursal, nombre, direccion FROM [ACERDERONNY].sucursalQuito.dbo.ClienteQuito";

        Connection conn = BddConnectionQuito.getConexion();
        PreparedStatement pstmt = conn.prepareStatement(_SQL_GET_ALL);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
        	Sucursal sucursal = new Sucursal();
        	sucursal.setIdSucursal(rs.getString("idSucursal"));
        	sucursal.setNombre(rs.getString("nombre"));
        	sucursal.setDireccion(rs.getString("direccion"));


            sucursalesG.add(sucursal);
        }

        // Cerrar recursos
        BddConnectionQuito.cerrar(rs);
        BddConnectionQuito.cerrar(pstmt);
        BddConnectionQuito.cerrar();

        return sucursalesG;
    }
	
}