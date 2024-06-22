package Controlador;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBDRegistrarProducto;

public class ControladorPedido {

    public static void registrarPedido(DefaultTableModel model, JComboBox<String> nombreField, JTextField cantidadField, JTextField iDProductoField, 
                                       JTextField iDClienteField) {
                                        
        String nombre = (String) nombreField.getSelectedItem();
        String cantidadStr = cantidadField.getText();
        String iDProductoStr = iDProductoField.getText();
        String iDClienteStr = iDClienteField.getText();

        if (!ValidarInformacion.validarInt(cantidadStr)) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarInt(iDProductoStr) || !ValidarInformacion.validarInt(iDClienteStr)) {
            JOptionPane.showMessageDialog(null, "El IDProducto y el IDCliente deben contener solo números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad = Integer.parseInt(cantidadStr);
        int iDProducto = Integer.parseInt(iDProductoStr);
        int iDCliente = Integer.parseInt(iDClienteStr);
        
        ConexionBDRegistrarProducto conexion = new ConexionBDRegistrarProducto();

        try {
            conexion.iniciarConexion();
            double precioProducto = conexion.obtenerPrecioProducto(iDProducto);
            double totalPrecio = cantidad * precioProducto;
            
            // Añadir fila a la tabla
            model.addRow(new Object[]{model.getRowCount() + 1, nombre, cantidad, iDProducto, iDCliente, totalPrecio, new java.util.Date()});
            
            // Limpiar campos
            nombreField.setSelectedIndex(-1);
            cantidadField.setText("");
            iDProductoField.setText("");
            iDClienteField.setText("");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el precio del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexion.closeConnection();
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
                    conexion.rollbackTransaction();
                    break;
                }
            }
            
            if (datosGuardados) {
                conexion.commitTransaction();
                model.setRowCount(0); // Limpiar todas las filas del modelo de tabla después de guardar los datos
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos: " + e.getMessage());
        } finally {
            conexion.closeConnection();
        }
    }

    
}
