package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConexionBDRegistrarProducto extends ConexionBD {

    public ConexionBDRegistrarProducto() {
        super();  // Llamamos al constructor de la clase padre para inicializar la conexión
    }

    // Método para insertar datos en la tabla modeloPersona
    public void insertarProducto(String nombre, String volumen, String precio, String sabor, Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloProducto (nombre, volumen, precio, sabor, fechaRegistro) VALUES (?, ?, ?, ?, ?)";
        
        iniciarConexion();
        Connection connection = getConnection();
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, volumen);
            stmt.setString(3, precio); 
            stmt.setString(4, sabor); 
            stmt.setDate(5, fechaRegistro);
    
            stmt.executeUpdate();
            
        } finally {
            cerrarConexion();
        }
    }
    
    
    public List<String> obtenerNombresProductos() throws SQLException {
        List<String> nombresProductos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM modeloProducto"; // Consulta SQL para obtener nombres de productos

        try {
            iniciarConexion();
            Connection connection = getConnection();
            stmt = connection.prepareStatement(query);
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
    public double obtenerPrecioProducto(String nombreProducto) throws SQLException {
        iniciarConexion();
        Connection connection = getConnection();
        
        double precioProducto = 0.0;
        String query = "SELECT precio FROM modeloProducto WHERE nombre = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreProducto);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                precioProducto = resultSet.getDouble("precio");
            }
        } finally {
            cerrarConexion();
        }

        if (precioProducto == 0.0) {
            throw new SQLException("Precio del producto no encontrado");
        }

        return precioProducto;
    }
    
    public int obtenerIDProducto(String nombre) throws SQLException {
        iniciarConexion();
        Connection connection = getConnection();
        
        int iDProducto = -1;
        String query = "SELECT idProducto FROM modeloProducto WHERE nombre = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                iDProducto = resultSet.getInt("idProducto");
            }
        } finally {
            cerrarConexion();
        }

        if (iDProducto == -1) {
            throw new SQLException("Producto no encontrado");
        }

        return iDProducto;
    }

    public boolean existeCliente(int iDCliente) throws SQLException {
        boolean existe = false;
        String query = "SELECT COUNT(*) AS count FROM modeloCliente WHERE idCliente = ?";

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
}
