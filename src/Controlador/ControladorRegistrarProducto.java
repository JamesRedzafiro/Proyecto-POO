package Controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBDRegistrarCliente;
import BaseDatos.ConexionBDRegistrarProducto;

public class ControladorRegistrarProducto {

    public static void registrarProducto(DefaultTableModel model, JTextField iDProductoField, JTextField nombreField, JTextField volumenField, JTextField precioField, JTextField saborField) {
        String iDProducto = iDProductoField.getText();
        String nombre = nombreField.getText();
        String volumen = volumenField.getText();
        String precio = precioField.getText();
        String sabor = saborField.getText();
        
        // Validar datos
        if (!ValidarInformacion.validarInt(iDProducto)) {
            JOptionPane.showMessageDialog(null, "El IDProducto debe contener solo números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarNombre(nombre) || !ValidarInformacion.validarNombre(sabor)) {
            JOptionPane.showMessageDialog(null, "El nombre y sabor deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!ValidarInformacion.validarDouble(volumen)) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener exactamente 10 dígitos y empezar con 1 o 2", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDouble(precio)) {
            JOptionPane.showMessageDialog(null, "El teléfono debe contener exactamente 9 dígitos que empiecen con 9", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         
        // Añadir fila a la tabla
        model.addRow(new Object[]{model.getRowCount() + 1, iDProducto, nombre, volumen, precio, sabor, new java.util.Date()});
        
        // Limpiar campos
        nombreField.setText("");
        iDProductoField.setText("");
        volumenField.setText("");
        precioField.setText("");
        saborField.setText("");
    
    }

    public static void guardarProducto(DefaultTableModel model) {
        ConexionBDRegistrarProducto conexion = new ConexionBDRegistrarProducto();
        int rowCount = model.getRowCount();
        
        boolean datosGuardados = true;
        
        try {
            conexion.iniciarConexion(); // Iniciar transacción
            
            for (int i = 0; i < rowCount; i++) {
                String iDProducto = model.getValueAt(i, 1).toString();
                String nombre = model.getValueAt(i, 2).toString();
                String volumen = model.getValueAt(i, 3).toString();
                String precio = model.getValueAt(i, 4).toString();
                String sabor = model.getValueAt(i, 5).toString();
                java.util.Date fechaRegistroUtil = (java.util.Date) model.getValueAt(i, 6);
                java.sql.Date fechaRegistroDate = new java.sql.Date(fechaRegistroUtil.getTime());
                
                try {
                    // Insertar primero en modeloPersona
                    conexion.insertarProducto(iDProducto, nombre, volumen, precio, sabor, fechaRegistroDate);
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
