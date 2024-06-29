package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBDCliente extends ConexionBD {

    public ConexionBDCliente() {
        super(); // Llama al constructor de la clase base
    }

    public int insertarPersona(String nombre, String apellido, String dni, String direccion, String telefono, String correo, java.sql.Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloPersona (nombre, apellido, DNI, direccion, telefono, correo, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        iniciarConexion();
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
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
                return rs.getInt(1);
            } else {
                throw new SQLException("Error al obtener el ID generado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void insertarCliente(int idPersona, String ruc) throws SQLException {
        String query = "INSERT INTO modeloCliente (iDCliente, iD, Ruc) VALUES (?, ?, ?)";
        
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPersona);  // Usar idPersona como iDCliente
            stmt.setInt(2, idPersona);
            stmt.setString(3, ruc);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void insertarFuncionario(int idPersona, String puesto) throws SQLException {
        String query = "INSERT INTO modeloFuncionario (iDFuncionario, iD, puesto) VALUES (?, ?, ?)";

        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPersona);
            stmt.setInt(2, idPersona);
            stmt.setString(3, puesto);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
    }
    
    public void insertarUsuario(String idUsuario, int idPersona, String contrasena) throws SQLException {
        String query = "INSERT INTO modeloUsuario (iDUsuario, iD, contrasena) VALUES (?, ?, ?)";
        
        Connection connection = getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idUsuario);
            stmt.setInt(2, idPersona);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void agregarDatosCliente(String nombre, String apellido, String dni, String direccion, String telefono, String correo, String ruc) {
        ConexionBDCliente conexion = new ConexionBDCliente();
        
        try {
            conexion.iniciarConexion(); // Iniciar transacción
            
            // Insertar datos en modeloPersona y obtener el ID generado
            java.sql.Date fechaRegistro = new java.sql.Date(new java.util.Date().getTime());
            int idPersona = conexion.insertarPersona(nombre, apellido, dni, direccion, telefono, correo, fechaRegistro);
            
            // Insertar datos en modeloCliente usando el ID generado
            conexion.insertarCliente(idPersona, ruc);
            
            // Generar el IDUsuario concatenando nombre e idPersona
            String idUsuario = nombre + idPersona;
            
            // Insertar datos en modeloUsuario usando el IDUsuario generado
            conexion.insertarUsuario(idUsuario, idPersona, dni);
            
            conexion.confirmarConexion(); // Confirmar transacción
    
            // Mostrar datos insertados en un JOptionPane
            String message = String.format("Datos insertados correctamente:\n\n"
                    + "modeloPersona:\n"
                    + "ID: %d\n"
                    + "Nombre: %s\n"
                    + "Apellido: %s\n"
                    + "DNI: %s\n"
                    + "Dirección: %s\n"
                    + "Teléfono: %s\n"
                    + "Correo: %s\n"
                    + "Fecha de Registro: %s\n\n"
                    + "modeloCliente:\n"
                    + "IDCliente: %d\n"
                    + "ID: %d\n"
                    + "RUC: %s\n\n"
                    + "modeloUsuario:\n"
                    + "IDUsuario: %s\n"
                    + "ID: %d\n"
                    + "Contraseña: %s",
                    idPersona, nombre, apellido, dni, direccion, telefono, correo, fechaRegistro.toString(),
                    idPersona, idPersona, ruc,
                    idUsuario, idPersona, dni);
    
            JOptionPane.showMessageDialog(null, message);
    
        } catch (SQLException e) {
            try {
                conexion.revertirConexion(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al revertir la transacción: " + ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage());
        } finally {
            conexion.cerrarConexion(); // Cerrar la conexión
        }
    }

    public void agregarDatosFuncionario(String nombre, String apellido, String dni, String direccion, String telefono, String correo, String puesto) {
        ConexionBDCliente conexion = new ConexionBDCliente();
        
        try {
            conexion.iniciarConexion(); // Iniciar transacción
            
            // Insertar datos en modeloPersona y obtener el ID generado
            java.sql.Date fechaRegistro = new java.sql.Date(new java.util.Date().getTime());
            int idPersona = conexion.insertarPersona(nombre, apellido, dni, direccion, telefono, correo, fechaRegistro);
            
            // Insertar datos en modeloCliente usando el ID generado
            conexion.insertarFuncionario(idPersona, puesto);
            
            // Generar el IDUsuario concatenando nombre e idPersona
            String idUsuario = nombre + idPersona;
            
            // Insertar datos en modeloUsuario usando el IDUsuario generado
            conexion.insertarUsuario(idUsuario, idPersona, dni);
            
            conexion.confirmarConexion(); // Confirmar transacción
    
            // Mostrar datos insertados en un JOptionPane
            String message = String.format("Datos insertados correctamente:\n\n"
                    + "modeloPersona:\n"
                    + "ID: %d\n"
                    + "Nombre: %s\n"
                    + "Apellido: %s\n"
                    + "DNI: %s\n"
                    + "Dirección: %s\n"
                    + "Teléfono: %s\n"
                    + "Correo: %s\n"
                    + "Fecha de Registro: %s\n\n"
                    + "modeloFuncionario:\n"
                    + "IDCliente: %d\n"
                    + "ID: %d\n"
                    + "Puesto: %s\n\n"
                    + "modeloUsuario:\n"
                    + "IDUsuario: %s\n"
                    + "ID: %d\n"
                    + "Contraseña: %s",
                    idPersona, nombre, apellido, dni, direccion, telefono, correo, fechaRegistro.toString(),
                    idPersona, idPersona, puesto,
                    idUsuario, idPersona, dni);
    
            JOptionPane.showMessageDialog(null, message);
    
        } catch (SQLException e) {
            try {
                conexion.revertirConexion(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al revertir la transacción: " + ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage());
        } finally {
            conexion.cerrarConexion(); // Cerrar la conexión
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
