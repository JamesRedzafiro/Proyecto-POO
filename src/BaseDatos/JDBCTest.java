package BaseDatos;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("El controlador JDBC está disponible.");
        } catch (ClassNotFoundException e) {
            System.out.println("El controlador JDBC no está disponible. Asegúrate de que jdbc.jar esté en tu classpath.");
        }
    }
}
