package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBDprueba {

    // Cadena de conexión a tu base de datos
    private static final String URL = "jdbc:sqlserver://JamesRed\\localhost:1433;databaseName=BaseDatosSocosani;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "Nadeko575.";
    private Connection conn;
    private PreparedStatement stmt;
    
    public ConexionBDprueba() {
        conn = null;
        stmt = null;
    }

    // Método para insertar datos en la tabla modeloPersona
    public void insertarPersona(String id, String nombre, String apellido, String dni, String direccion, String telefono, String correo) throws SQLException {
        String query = "INSERT INTO modeloPersona (iD, nombre, apellido, DNI, direccion, telefono, correo) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, dni); // DNI debe ser tratado como String (NVARCHAR)
            stmt.setString(5, direccion); // Asumiendo que 'direccion' es un String
            stmt.setString(6, telefono);
            stmt.setString(7, correo);

            stmt.executeUpdate();
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para insertar datos en la tabla modeloCliente
    public void insertarCliente(String idCliente, String id, String ruc) throws SQLException {
        String query = "INSERT INTO modeloCliente (iDCliente, iD, Ruc) VALUES (?, ?, ?)";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, idCliente);
            stmt.setString(2, id);
            stmt.setString(3, ruc);

            stmt.executeUpdate();
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Método para insertar datos en la tabla modeloUsuario
    public void insertarUsuario(String idUsuario, String id, String contrasena) throws SQLException {
        String query = "INSERT INTO modeloUsuario (iDUsuario, iD, contrasena) VALUES (?, ?, ?)";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, idUsuario);
            stmt.setString(2, id);
            stmt.setString(3, contrasena);

            stmt.executeUpdate();
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Obtener el último ID de cliente de la base de datos
    public int getLastIdCliente() throws SQLException {
        int lastIdCliente = 0;
        String query = "SELECT MAX(iDCliente) AS lastId FROM modeloCliente";
        
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lastIdCliente = rs.getInt("lastId");
            }
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null) {
                stmt.close();
            }
        }
        
        return lastIdCliente;
    }

    // Método para iniciar una transacción
    public void beginTransaction() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.setAutoCommit(false); // Deshabilitar auto-commit para iniciar la transacción
    }

    // Método para confirmar la transacción
    public void commitTransaction() throws SQLException {
        conn.commit();
    }

    // Método para revertir la transacción
    public void rollbackTransaction() {
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar la conexión
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
