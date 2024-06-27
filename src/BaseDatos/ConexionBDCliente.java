package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBDCliente extends ConexionBD {

    public ConexionBDCliente() {
        super(); // Llama al constructor de la clase base
    }

    // Método para insertar datos en la tabla modeloPersona
    public int insertarPersona(String nombre, String apellido, String dni, String direccion, String telefono, String correo, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloPersona (nombre, apellido, DNI, direccion, telefono, correo, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int generatedId = 0;

        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, dni);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, correo);
            stmt.setDate(7, fechaRegistro);

            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } finally {
            cerrarConexion();
        }

        return generatedId;
    }
    
    // Método para insertar datos en la tabla modeloCliente
    public void insertarCliente(int idCliente, int idPersona, String ruc) throws SQLException {
        String query = "INSERT INTO modeloCliente (iDCliente, iD, Ruc) VALUES (?, ?, ?)";

        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idPersona);
            stmt.setString(3, ruc);
            stmt.executeUpdate();
        } finally {
            cerrarConexion();
        }
    }

    // Método para insertar datos en la tabla modeloUsuario
    public void insertarUsuario(int idUsuario, int idPersona, String contrasena) throws SQLException {
        String query = "INSERT INTO modeloUsuario (iDUsuario, iD, contrasena) VALUES (?, ?, ?)";

        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idPersona);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
        } finally {
            cerrarConexion();
        }
    }

    // Obtener el último ID de cliente de la base de datos
    public int getLastIdCliente() throws SQLException {
        int lastIdCliente = 0;
        String query = "SELECT MAX(iDCliente) AS lastId FROM modeloCliente";
        ResultSet rs = null;

        iniciarConexion();
        Connection connection = getConnection();
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            if (rs.next()) {
                lastIdCliente = rs.getInt("lastId");
            }
        } finally {
            cerrarConexion();
        }
        
        return lastIdCliente;
    }

    // Método para verificar si un iDCliente existe en la base de datos
    public boolean existeCliente(int iDCliente) throws SQLException {
        boolean existe = false;
        String query = "SELECT COUNT(*) AS count FROM modeloCliente WHERE iDCliente = ?";

        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, iDCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                existe = (count > 0);
            }
        } finally {
            cerrarConexion();
        }
        return existe;
    }

    // Método para verificar si un iDPersona existe en la base de datos
    public boolean existePersona(int idPersona) throws SQLException {
        boolean existe = false;
        String query = "SELECT COUNT(*) AS count FROM modeloPersona WHERE iD = ?";

        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPersona);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                existe = (count > 0);
            }
        } finally {
            cerrarConexion();
        }
        return existe;
    }
}
