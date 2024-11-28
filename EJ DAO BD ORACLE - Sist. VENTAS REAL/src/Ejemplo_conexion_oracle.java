import DAO.ArticuloDAO;
import DAO.VentaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_conexion_oracle {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String username = "mario";
        String password = "mario1";

        try (Connection conexion = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexión exitosa a la base de datos");

            // Crear instancias de los DAO
            VentaDAO ventaDAO = new VentaDAO(conexion);

            // Visualizar todas las ventas
            ventaDAO.obtenerTodasLasVentas();

            // Visualizar ventas en un periodo
            Date inicio = Date.valueOf("2023-12-01");
            Date fin = Date.valueOf("2023-12-04");
            ventaDAO.obtenerVentasPorPeriodo(inicio, fin);

            // Visualizar todos los artículos
            ArticuloDAO articuloDAO = new ArticuloDAO(conexion);
            articuloDAO.obtenerTodosLosArticulos();

            // Insertar un nuevo artículo
            articuloDAO.insertarArticulo("Camiseta PSG 2023", 69.99, "Camiseta oficial del PSG temporada 2023");

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
