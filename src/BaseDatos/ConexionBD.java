package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BaseDatosSocosani;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "Nadeko575.";
    private Connection connection;
    protected Connection conn;  // Cambiado a protected para permitir acceso en subclases
    protected PreparedStatement stmt;  // Cambiado a protected para permitir acceso en subclases
    
    // Método para iniciar una conexión
    public void iniciarConexion() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    // Método para confirmar la transacción
    public void confirmarConexion() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.commit();
        }
    }

    // Método para revertir la transacción
    public void revertirConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Cerrar la conexión
    public void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
