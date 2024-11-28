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

    // Visualizar todas las ventas
    public List<Venta> obtenerTodasLasVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta venta = new Venta(rs.getInt("id"), rs.getString("producto"), rs.getDouble("precio"), rs.getString("fecha"));
                ventas.add(venta);
            }
        }
        return ventas;
    }

    // Visualizar todas las ventas en un periodo específico
    public List<Venta> obtenerVentasPorPeriodo(String fechaInicio, String fechaFin) throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE fecha BETWEEN ? AND ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, fechaInicio);
            pstmt.setString(2, fechaFin);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Venta venta = new Venta(rs.getInt("id"), rs.getString("producto"), rs.getDouble("precio"), rs.getString("fecha"));
                    ventas.add(venta);
                }
            }
        }
        return ventas;
    }
}
