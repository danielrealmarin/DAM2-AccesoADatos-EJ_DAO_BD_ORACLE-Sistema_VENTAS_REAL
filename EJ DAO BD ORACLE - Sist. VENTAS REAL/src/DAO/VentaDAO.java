package DAO;

import Utils.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {

    private Connection conexion;

    public VentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Obtener todas las ventas
    public void obtenerTodasLasVentas() {
        String sql = "SELECT * FROM ventas";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String producto = rs.getString("producto");
                double precio = rs.getDouble("precio");
                Date fecha = rs.getDate("fecha");
                System.out.println("Venta ID: " + id + ", Producto: " + producto + ", Precio: " + precio + ", Fecha: " + fecha);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ventas: " + e.getMessage());
        }
    }

    public void obtenerVentasPorPeriodo(Date inicio, Date fin) {
        String sql = "SELECT * FROM ventas WHERE fecha BETWEEN ? AND ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setDate(1, inicio);
            pstmt.setDate(2, fin);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String producto = rs.getString("producto");
                    double precio = rs.getDouble("precio");
                    Date fecha = rs.getDate("fecha");
                    System.out.println("Venta ID: " + id + ", Producto: " + producto + ", Precio: " + precio + ", Fecha: " + fecha);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ventas por periodo: " + e.getMessage());
        }
    }
}
