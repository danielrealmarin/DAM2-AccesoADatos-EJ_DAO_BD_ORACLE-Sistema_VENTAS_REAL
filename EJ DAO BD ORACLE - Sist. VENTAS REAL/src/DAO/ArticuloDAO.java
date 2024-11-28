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
    public void obtenerTodosLosArticulos() {
        String sql = "SELECT * FROM articulos";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
                System.out.println("Artículo ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Descripción: " + descripcion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener artículos: " + e.getMessage());
        }
    }


    // Insertar un nuevo artículo
    public void insertarArticulo(String nombre, double precio, String descripcion) {
        String sql = "INSERT INTO articulos (id, nombre, precio, descripcion) VALUES (seq_articulos.NEXTVAL, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setString(3, descripcion);
            pstmt.executeUpdate();
            System.out.println("Artículo insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar artículo: " + e.getMessage());
        }
    }



}
