import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_conexion_oracle {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","mario","mario1");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
        }

    }
}