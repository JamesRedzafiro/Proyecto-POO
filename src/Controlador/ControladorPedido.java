package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.*;
import Modelo.modeloCliente;
import Modelo.modeloPedido;
import Modelo.modeloProducto;
import Vista.Interfaz.vistaPedido;

public class ControladorPedido {

    private static int ultimoIDPedido = 0;

    // Método para inicializar el último ID de pedido desde la base de datos
    public static void inicializarUltimoIDPedido() {
        ConexionBDRegistrarPedido conexionPedido = new ConexionBDRegistrarPedido();
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
    
        ConexionBDRegistrarProducto conexionProducto = new ConexionBDRegistrarProducto();
        ConexionBDRegistrarCliente conexionCliente = new ConexionBDRegistrarCliente();
    
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
        ConexionBDRegistrarPedido conexion = new ConexionBDRegistrarPedido();
        List<modeloPedido> pedidos = new ArrayList<>();
    
        try {
            // Recorrer las filas del modelo de la tabla
            for (int i = 0; i < model.getRowCount(); i++) {
                int iDProducto = Integer.parseInt(model.getValueAt(i, 3).toString());
                int iDCliente = Integer.parseInt(model.getValueAt(i, 4).toString());
                int cantidad = Integer.parseInt(model.getValueAt(i, 2).toString());
                double totalPedido = Double.parseDouble(model.getValueAt(i, 5).toString());
                java.util.Date fechaPedido = (java.util.Date) model.getValueAt(i, 6);
    
                // Obtener detalles de producto y cliente desde la base de datos
                modeloProducto producto = conexion.obtenerProductoPorID(iDProducto);
                modeloCliente cliente = conexion.obtenerClientePorID(iDCliente);
    
                // Crear instancia de modeloPedido
                modeloPedido pedido = new modeloPedido(0, cantidad, fechaPedido, totalPedido, "Pendiente", cliente, producto);
                pedidos.add(pedido);
            }
    
            // Insertar el pedido y los detalles del pedido
            int iDPedido = conexion.insertarPedido(pedidos.get(0));
            for (modeloPedido pedido : pedidos) {
                pedido.setIDPedido(iDPedido);
            }
            conexion.insertarDetallePedido(iDPedido, pedidos);
    
            System.out.println("Pedido registrado exitosamente con ID: " + iDPedido);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el pedido: " + e.getMessage());
        }
    }
    
    

}
