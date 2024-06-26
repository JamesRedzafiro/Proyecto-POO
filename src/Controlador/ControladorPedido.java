package Controlador;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.*;

import Vista.Interfaz.vistaPedido;

public class ControladorPedido {

    private static int ultimoIDPedido = 1;

    // Método para inicializar el último ID de pedido desde la base de datos
    public static void inicializarUltimoIDPedido() {
        ConexionBDPedido conexionPedido = new ConexionBDPedido();
        try {
            ultimoIDPedido = conexionPedido.obtenerUltimoIDPedido();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registrarPedido(DefaultTableModel model, JComboBox<String> nombreComboBox, JTextField cantidadField, JTextField iDClienteField) {
        String nombre = (String) nombreComboBox.getSelectedItem();
        String cantidadStr = cantidadField.getText();
        String iDClienteStr = iDClienteField.getText();
    
        if (!ValidarInformacion.validarInt(cantidadStr)) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarInt(iDClienteStr)) {
            JOptionPane.showMessageDialog(null, "El IDCliente debe contener solo números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        int cantidad = Integer.parseInt(cantidadStr);
        int iDCliente = Integer.parseInt(iDClienteStr);
    
        ConexionBDProducto conexionProducto = new ConexionBDProducto();
        ConexionBDCliente conexionCliente = new ConexionBDCliente();
    
        try {
            // Verificar si el IDCliente existe en la base de datos
            if (!conexionCliente.existeCliente(iDCliente)) {
                JOptionPane.showMessageDialog(null, "El IDCliente especificado no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener iDProducto y precioProducto según el nombre del producto
            int iDProducto = conexionProducto.obtenerIDProducto(nombre);
            double precioProducto = conexionProducto.obtenerPrecioProducto(nombre);
            double totalPrecio = cantidad * precioProducto;
    
            // Añadir fila a la tabla
            model.addRow(new Object[]{model.getRowCount() + 1, nombre, cantidad, iDProducto, iDCliente, totalPrecio, new java.util.Date()});
            
            // Actualizar suma total y totalLabel
            vistaPedido.sumaTotal += totalPrecio;
            vistaPedido.actualizarTotalLabel();
    
            // Limpiar campos
            nombreComboBox.setSelectedIndex(-1);
            cantidadField.setText("");
            // iDClienteField.setText("");
    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la información del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void guardarPedido(DefaultTableModel model) {
        ConexionBDPedido conexion = new ConexionBDPedido();
        int rowCount = model.getRowCount();
        boolean datosGuardados = true;
    
        try {
            conexion.iniciarConexion(); // Iniciar transacción

            // Obtener el iDCliente y la fecha del primer registro (asumimos que son los mismos para todos)
            int iDCliente = Integer.parseInt(model.getValueAt(0, 4).toString());
            java.util.Date fechaRegistroUtil = (java.util.Date) model.getValueAt(0, 6);
            java.sql.Date fechaRegistroDate = new java.sql.Date(fechaRegistroUtil.getTime());

            // Insertar el pedido una vez
            int iDPedido = conexion.insertarPedido(0, iDCliente, fechaRegistroDate, "Pendiente");

            // Recorrer las filas del modelo de la tabla e insertar los detalles del pedido
            for (int i = 0; i < rowCount; i++) {
                int iDProducto = Integer.parseInt(model.getValueAt(i, 3).toString()); // Columna del iDProducto en la tabla
                int cantidad = Integer.parseInt(model.getValueAt(i, 2).toString()); // Columna de la cantidad en la tabla
                double totalPrecio = Double.parseDouble(model.getValueAt(i, 5).toString()); // Columna del total en la tabla
                double precio = totalPrecio / cantidad; // Calcular el precio unitario
    
                try {
                    conexion.insertarDetallePedido(iDPedido, iDProducto, cantidad, precio, totalPrecio);
                    JOptionPane.showMessageDialog(null, "Datos insertados correctamente en la base de datos.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos: " + ex.getMessage());
                    datosGuardados = false;
                    conexion.revertirConexion();
                    break;
                }
            }
    
            if (datosGuardados) {
                conexion.confirmarConexion();
                model.setRowCount(0); // Limpiar todas las filas del modelo de tabla después de guardar los datos
                vistaPedido.sumaTotal = 0;
                vistaPedido.actualizarTotalLabel();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el pedido: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }
}
