package BaseDatos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBDRegistrarCliente extends ConexionBD {

    public ConexionBDRegistrarCliente() {
        super(); // Llama al constructor de la clase base
    }

    // Método para insertar datos en la tabla modeloPersona
    public void insertarPersona(String id, String nombre, String apellido, String dni, String direccion, String telefono, String correo, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloPersona (iD, nombre, apellido, DNI, direccion, telefono, correo, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("La conexión no está inicializada correctamente.");
            }

            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, dni); // DNI debe ser tratado como String (NVARCHAR)
            stmt.setString(5, direccion); // Asumiendo que 'direccion' es un String
            stmt.setString(6, telefono);
            stmt.setString(7, correo);
            stmt.setDate(8, fechaRegistro);
    
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null && !stmt.isClosed()) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null && !stmt.isClosed()) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Cerrar el statement en un bloque finally para asegurar la liberación de recursos
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        }
    }

    // Obtener el último ID de cliente de la base de datos
    public int getLastIdCliente() throws SQLException {
        int lastIdCliente = 0;
        String query = "SELECT MAX(iDCliente) AS lastId FROM modeloCliente";
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            if (rs.next()) {
                lastIdCliente = rs.getInt("lastId");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Cerrar el ResultSet y el statement en un bloque finally para asegurar la liberación de recursos
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        }
        
        return lastIdCliente;
    }
}