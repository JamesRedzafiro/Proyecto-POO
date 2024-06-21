package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:sqlserver://JamesRed\\localhost:1433;databaseName=BaseDatosSocosani;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "Nadeko575.";
    protected Connection conn;  // Cambiado a protected para permitir acceso en subclases
    protected PreparedStatement stmt;  // Cambiado a protected para permitir acceso en subclases
    
    // Método para iniciar una conexión
    public void iniciarConexion() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.setAutoCommit(false); // Deshabilitar auto-commit para iniciar la transacción
    }

    // Método para confirmar la transacción
    public void commitTransaction() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.commit();
        }
    }

    // Método para revertir la transacción
    public void rollbackTransaction() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar la conexión
    public void closeConnection() {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
