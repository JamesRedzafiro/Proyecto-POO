package BaseDatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConexionBDRegistrarProducto extends ConexionBD {


    public ConexionBDRegistrarProducto() {
        super(); // Llama al constructor de la clase base
    }

    // Método para insertar datos en la tabla modeloPersona
    public void insertarProducto( String nombre, String volumen, String precio, String sabor, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloProducto (nombre, volumen, precio, sabor, fechaRegistro) VALUES (?, ?, ?, ?, ?)";
        
        try {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("La conexión no está inicializada correctamente.");
            }

            stmt = conn.prepareStatement(query);
            //stmt.setString(1, iDProducto);
            stmt.setString(1, nombre);
            stmt.setString(2, volumen);
            stmt.setString(3, precio); 
            stmt.setString(4, sabor); 
            stmt.setDate(5, fechaRegistro);
    
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
    
    
    public List<String> obtenerNombresProductos() throws SQLException {
        List<String> nombresProductos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM modeloProducto"; // Consulta SQL para obtener nombres de productos

        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                nombresProductos.add(rs.getString("nombre"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return nombresProductos; // Devolver lista de nombres de productos
    }

    // Método para obtener el precio del producto
    public double obtenerPrecioProducto(int iDProducto) throws SQLException {
        double precio = 0.0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT precio FROM modeloProducto WHERE iDProducto = ?";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, iDProducto);
            rs = stmt.executeQuery();
            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return precio;
    }
    
}
