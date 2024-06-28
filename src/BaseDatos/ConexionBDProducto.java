package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConexionBDProducto extends ConexionBD {

    public ConexionBDProducto() {
        super();
    }

    public void insertarProducto(String nombre, double volumen, double precio, String sabor, java.sql.Date fechaRegistro) throws SQLException {
        String query = "INSERT INTO modeloProducto (nombre, volumen, precio, sabor, fechaRegistro) VALUES (?, ?, ?, ?, ?)";
        
        Connection connection = getConnection();
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, volumen);
            stmt.setDouble(3, precio);
            stmt.setString(4, sabor);
            stmt.setDate(5, fechaRegistro);
            stmt.executeUpdate();
            
            // Confirmar transacción
            connection.commit();
        } catch (SQLException e) {
            // Revertir transacción en caso de error
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    

    public List<String> obtenerNombresProductos() throws SQLException {
        List<String> nombresProductos = new ArrayList<>();
        String query = "SELECT nombre FROM modeloProducto";

        iniciarConexion();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nombresProductos.add(rs.getString("nombre"));
            }
        } finally {
            cerrarConexion();
        }
        return nombresProductos;
    }

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
}
