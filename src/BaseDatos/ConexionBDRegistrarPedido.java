package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.*;

public class ConexionBDRegistrarPedido extends ConexionBD {

    public ConexionBDRegistrarPedido() {
        super();
    }

    public int obtenerUltimoIDPedido() throws SQLException {
        String query = "SELECT MAX(iDPedido) AS ultimoID FROM modeloPedido";
        iniciarConexion();
        Connection connection = getConnection();
        int ultimoID = 0;

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                ultimoID = rs.getInt("ultimoID");
            }
        } finally {
            cerrarConexion();
        }

        return ultimoID;
    }

    public int insertarPedido(modeloPedido pedido) throws SQLException {
        String query = "INSERT INTO Pedidos (iDCliente, fechaPedido, estado) VALUES (?, ?, ?)";
        iniciarConexion();
        Connection connection = getConnection();
        int iDPedido = 0;

        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getCliente().getIDCliente());
            stmt.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            stmt.setString(3, pedido.getEstado());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    iDPedido = generatedKeys.getInt(1);
                }
            }
        } finally {
            confirmarConexion();
            cerrarConexion();
        }

        return iDPedido;
    }

    public void insertarDetallePedido(int iDPedido, List<modeloPedido> pedidos) throws SQLException {
        String query = "INSERT INTO detallePedidos (iDPedido, iDProducto, cantidad, precio, total) VALUES (?, ?, ?, ?, ?)";
        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (modeloPedido pedido : pedidos) {
                stmt.setInt(1, iDPedido);
                stmt.setInt(2, pedido.getProducto().getIDProducto());
                stmt.setInt(3, pedido.getCantidad());
                stmt.setDouble(4, pedido.getProducto().getPrecio());
                stmt.setDouble(5, pedido.getTotalPedido());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } finally {
            confirmarConexion();
            cerrarConexion();
        }
    }

    public modeloProducto obtenerProductoPorID(int iDProducto) throws SQLException {
        String query = "SELECT * FROM modeloProducto WHERE iDProducto = ?";
        iniciarConexion();
        Connection connection = getConnection();
        modeloProducto producto = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, iDProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new modeloProducto(
                        rs.getInt("iDProducto"),
                        rs.getString("nombre"),
                        rs.getFloat("volumen"),
                        rs.getFloat("precio"),
                        rs.getString("sabor")
                    );
                }
            }
        } finally {
            cerrarConexion();
        }

        return producto;
    }

    public modeloCliente obtenerClientePorID(int iDCliente) throws SQLException {
        String query = "SELECT c.iDCliente, p.nombre, p.apellido, p.DNI, c.iD, p.direccion, p.telefono, p.correo, c.Ruc " +
                       "FROM modeloCliente c " +
                       "JOIN modeloPersona p ON c.iD = p.iD " +
                       "WHERE c.iDCliente = ?";
        iniciarConexion();
        Connection connection = getConnection();
        modeloCliente cliente = null;
    
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, iDCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new modeloCliente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("DNI"),
                        rs.getInt("iD"),
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("correo"),
                        rs.getInt("Ruc")
                    );
                    cliente.setIDCliente(rs.getInt("iDCliente"));
                }
            }
        } finally {
            cerrarConexion();
        }
    
        return cliente;
    }
    
}
