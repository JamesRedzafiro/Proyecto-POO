package Controlador;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.*;

public class ControladorRegistrarProducto {

    public static void registrarProducto(DefaultTableModel model, JTextField nombreField, JTextField volumenField, JTextField precioField, JTextField saborField) {
        String nombre = nombreField.getText();
        String volumen = volumenField.getText();
        String precio = precioField.getText();
        String sabor = saborField.getText();

        // Validar datos
        if (!ValidarInformacion.validarNombre(nombre) || !ValidarInformacion.validarNombre(sabor)) {
            JOptionPane.showMessageDialog(null, "El nombre y sabor deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!ValidarInformacion.validarDouble(volumen)) {
            JOptionPane.showMessageDialog(null, "El volumen debe tener dos decimales", "Error", JOptionPane.ERROR_MESSAGE);
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
        volumenField.setText("");
        precioField.setText("");
        saborField.setText("");
    }

    public static void guardarProducto(DefaultTableModel model) {

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para guardar.");
            return;
        }
        ConexionBDProducto conexion = new ConexionBDProducto();
        int rowCount = model.getRowCount();
        boolean datosGuardados = true;
    
        try {
            conexion.iniciarConexion(); // Iniciar conexión
    
            for (int i = 0; i < rowCount; i++) {
                String nombre = model.getValueAt(i, 1).toString();
                double volumen = Double.parseDouble(model.getValueAt(i, 2).toString());
                double precio = Double.parseDouble(model.getValueAt(i, 3).toString());
                String sabor = model.getValueAt(i, 4).toString();
                java.util.Date fechaRegistroUtil = (java.util.Date) model.getValueAt(i, 5);
                java.sql.Date fechaRegistroDate = new java.sql.Date(fechaRegistroUtil.getTime());
    
                try {
                    // Imprimir consulta SQL para depuración
                    System.out.println("Intentando insertar producto: " + nombre);
                    
                    conexion.insertarProducto(nombre, volumen, precio, sabor, fechaRegistroDate);
                    System.out.println("Producto insertado: " + nombre);
                } catch (SQLException ex) {
                    System.out.println("Error al insertar en la base de datos: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos: " + ex.getMessage());
                    datosGuardados = false;
                    conexion.revertirConexion(); // Revertir transacción
                    break;
                }
            }
    
            if (datosGuardados) {
                conexion.confirmarConexion(); // Confirmar transacción
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente en la base de datos.");
                model.setRowCount(0); // Limpiar todas las filas del modelo de tabla después de guardar los datos
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }
    
    public static List<String> obtenerNombresProductos() {
        List<String> nombresProductos = null;
        ConexionBDProducto conexionBD = new ConexionBDProducto();
        try {
            conexionBD.iniciarConexion();
            nombresProductos = conexionBD.obtenerNombresProductos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de productos: " + e.getMessage());
        } finally {
            conexionBD.cerrarConexion();
        }
        return nombresProductos;
    }
}
