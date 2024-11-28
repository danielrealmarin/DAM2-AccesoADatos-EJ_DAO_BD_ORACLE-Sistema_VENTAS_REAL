import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_conexion_oracle {

    public static void main(String[] args) {
        // URL de conexión a la base de datos Oracle
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String username = "mario";  // Usuario de la base de datos
        String password = "mario1"; // Contraseña de la base de datos

        // Usamos try-with-resources para cerrar automáticamente la conexión
        try (Connection conexion = DriverManager.getConnection(url, username, password)) {
            // Aquí puedes realizar las operaciones con la base de datos
            System.out.println("Conexión exitosa a la base de datos");

            // Ejemplo de operación de base de datos (como una consulta)
            // Puedes agregar aquí operaciones como visualización de ventas o inserción de artículos.

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
