package BaseDatos;

import java.sql.Date;
import java.sql.SQLException;

public class ConexionBDRegistrarProducto extends ConexionBD {


    public ConexionBDRegistrarProducto() {
        super(); // Llama al constructor de la clase base
    }

    // Método para insertar datos en la tabla modeloPersona
    public void insertarProducto(String iDProducto, String nombre, String volumen, String precio, String sabor, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloPersona (iDProducto, nombre, volumen, precio, sabor, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("La conexión no está inicializada correctamente.");
            }

            stmt = conn.prepareStatement(query);
            stmt.setString(1, iDProducto);
            stmt.setString(2, nombre);
            stmt.setString(3, volumen);
            stmt.setString(4, precio); 
            stmt.setString(5, sabor); 
            stmt.setDate(6, fechaRegistro);
    
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
    
    


    
}
