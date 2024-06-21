package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBD;
import BaseDatos.ConexionBDRegistrarProducto;

public class ControladorRegistrarProducto {

    public static void registrarProducto(DefaultTableModel model, JTextField nombreField, JTextField volumenField, JTextField precioField, JTextField saborField) {
        //String iDProducto = iDProductoField.getText();
        String nombre = nombreField.getText();
        String volumen = volumenField.getText();
        String precio = precioField.getText();
        String sabor = saborField.getText();
        
        // Validar datos
        //if (!ValidarInformacion.validarInt(iDProducto)) {
        //    JOptionPane.showMessageDialog(null, "El IDProducto debe contener solo números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
        //    return;
        //}

        if (!ValidarInformacion.validarNombre(nombre) || !ValidarInformacion.validarNombre(sabor)) {
            JOptionPane.showMessageDialog(null, "El nombre y sabor deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!ValidarInformacion.validarDouble(volumen)) {
            JOptionPane.showMessageDialog(null, "El volumen deben tener dos decimales", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDouble(precio)) {
            JOptionPane.showMessageDialog(null, "El precio debe tener dos decimales", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         
        // Añadir fila a la tabla
        model.addRow(new Object[]{model.getRowCount() + 1, nombre, volumen, precio, sabor, new java.util.Date()});
        
        // Limpiar campos
        nombreField.setText("");
        //iDProductoField.setText("");
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

    

    public static List<String> obtenerNombresProductos() {
        List<String> nombresProductos = null;
        ConexionBDRegistrarProducto conexionBD = new ConexionBDRegistrarProducto();
        try {
            conexionBD.iniciarConexion();
            nombresProductos = conexionBD.obtenerNombresProductos(); // Aquí se llama al método de instancia
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores o mensaje al usuario si falla la conexión
        } finally {
            conexionBD.closeConnection();
        }
        return nombresProductos;
    }
    
    
    
}
