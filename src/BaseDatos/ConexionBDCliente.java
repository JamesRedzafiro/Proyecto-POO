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
    public void insertarPersona(String id, String nombre, String apellido, String dni, String direccion, String telefono, String correo, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloPersona (iD, nombre, apellido, DNI, direccion, telefono, correo, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
           
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, dni); 
            stmt.setString(5, direccion); 
            stmt.setString(6, telefono);
            stmt.setString(7, correo);
            stmt.setDate(8, fechaRegistro);
    
            stmt.executeUpdate();
    
        } finally {
            cerrarConexion();
        }
    }
    
    // Método para insertar datos en la tabla modeloCliente
    public void insertarCliente(String idCliente, String id, String ruc) throws SQLException {
        String query = "INSERT INTO modeloCliente (iDCliente, iD, Ruc) VALUES (?, ?, ?)";

        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, idCliente);
            stmt.setString(2, id);
            stmt.setString(3, ruc);

            stmt.executeUpdate();

        } finally {
            cerrarConexion();
        }
    }

    // Método para insertar datos en la tabla modeloUsuario
    public void insertarUsuario(String idUsuario, String id, String contrasena) throws SQLException {
        String query = "INSERT INTO modeloUsuario (iDUsuario, iD, contrasena) VALUES (?, ?, ?)";

        iniciarConexion();
        Connection connection = getConnection();
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idUsuario);
            stmt.setString(2, id);
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
