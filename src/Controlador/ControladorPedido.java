package Controlador;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBDRegistrarProducto;

public class ControladorPedido {

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
    
        ConexionBDRegistrarProducto conexion = new ConexionBDRegistrarProducto();
    
        try {

            // Verificar si el IDCliente existe en la base de datos
            if (!conexion.existeCliente(iDCliente)) {
            JOptionPane.showMessageDialog(null, "El IDCliente especificado no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            // Obtener iDProducto y precioProducto según el nombre del producto
            int iDProducto = conexion.obtenerIDProducto(nombre);
            double precioProducto = conexion.obtenerPrecioProducto(nombre);
            double totalPrecio = cantidad * precioProducto;
    
            // Añadir fila a la tabla
            model.addRow(new Object[]{model.getRowCount() + 1, nombre, cantidad, iDProducto, iDCliente, totalPrecio, new java.util.Date()});
            
            // Limpiar campos
            nombreComboBox.setSelectedIndex(-1);
            cantidadField.setText("");
            //iDClienteField.setText("");
    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la información del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void guardarProducto(DefaultTableModel model) {
        ConexionBDRegistrarProducto conexion = new ConexionBDRegistrarProducto();
        int rowCount = model.getRowCount();
        
        boolean datosGuardados = true;
        
        try {
            conexion.iniciarConexion(); // Iniciar transacción
            
            for (int i = 0; i < rowCount; i++) {
                //String iDProducto = model.getValueAt(i, 1).toString();
                String nombre = model.getValueAt(i, 1).toString();
                String volumen = model.getValueAt(i,2).toString();
                String precio = model.getValueAt(i, 3).toString();
                String sabor = model.getValueAt(i, 4).toString();
                java.util.Date fechaRegistroUtil = (java.util.Date) model.getValueAt(i, 5);
                java.sql.Date fechaRegistroDate = new java.sql.Date(fechaRegistroUtil.getTime());
                
                try {
                    // Insertar primero en modeloPersona
                    conexion.insertarProducto( nombre, volumen, precio, sabor, fechaRegistroDate);
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
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    
}
