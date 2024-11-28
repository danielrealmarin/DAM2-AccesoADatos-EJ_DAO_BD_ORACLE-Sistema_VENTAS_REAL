package DAO;

import Utils.Articulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {

    private Connection conexion;

    public ArticuloDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Visualizar todos los artículos
    public List<Articulo> obtenerTodosLosArticulos() throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM articulos";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Articulo articulo = new Articulo(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"));
                articulos.add(articulo);
            }
        }
        return articulos;
    }

    // Insertar un nuevo artículo
    public boolean insertarArticulo(Articulo articulo) throws SQLException {
        String sql = "INSERT INTO articulos (nombre, precio, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, articulo.getNombre());
            pstmt.setDouble(2, articulo.getPrecio());
            pstmt.setString(3, articulo.getDescripcion());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }
}
