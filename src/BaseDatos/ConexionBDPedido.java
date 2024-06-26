package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBDPedido extends ConexionBD {

    public ConexionBDPedido() {
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

    public int insertarPedido(int iDPedido, int iDCliente, Date fechaPedido, String estado) throws SQLException {
        String query = "INSERT INTO pedido (iDCliente, fechaPedido, estado) VALUES (?, ?, ?)";
        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            //stmt.setInt(1, iDPedido);
            stmt.setInt(1, iDCliente);
            stmt.setDate(2, fechaPedido);
            stmt.setString(3, estado);
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

    public void insertarDetallePedido(int iDPedido, int iDProducto, int cantidad, Double precio, Double total) throws SQLException {
        String query = "INSERT INTO detallePedido (iDPedido, iDProducto, cantidad, precio, total) VALUES (?, ?, ?, ?, ?)";
        iniciarConexion();
        Connection connection = getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, iDPedido);
            stmt.setInt(2, iDProducto);
            stmt.setInt(3, cantidad);
            stmt.setDouble(4, precio);
            stmt.setDouble(5, total);
            stmt.addBatch();
            
            stmt.executeBatch();
        } finally {
            confirmarConexion();
            cerrarConexion();
        }
    }

    public static void eliminarPedido(int iDPedido) {
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;
        PreparedStatement pstmtDetalle = null;
        PreparedStatement pstmtPedido = null;

        try {
            conexion = conexionBD.getConnection();
            conexion.setAutoCommit(false); // Iniciar transacción

            // Eliminar registros de detallePedido
            String sqlDetalle = "DELETE FROM detallePedido WHERE iDPedido = ?";
            pstmtDetalle = conexion.prepareStatement(sqlDetalle);
            pstmtDetalle.setInt(1, iDPedido);
            pstmtDetalle.executeUpdate();

            // Eliminar registro de pedido
            String sqlPedido = "DELETE FROM pedido WHERE iDPedido = ?";
            pstmtPedido = conexion.prepareStatement(sqlPedido);
            pstmtPedido.setInt(1, iDPedido);
            pstmtPedido.executeUpdate();

            conexion.commit(); // Confirmar transacción
            System.out.println("Pedido y detalles eliminados correctamente.");
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback(); // Revertir transacción en caso de error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            System.out.println("Error al eliminar el pedido: " + e.getMessage());
        } finally {
            if (pstmtDetalle != null) {
                try {
                    pstmtDetalle.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmtPedido != null) {
                try {
                    pstmtPedido.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.setAutoCommit(true);
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    

}
