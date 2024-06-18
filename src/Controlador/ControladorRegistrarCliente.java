package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBDprueba;

public class ControladorRegistrarCliente {

    public static void registrarCliente(DefaultTableModel model, JTextField nombreField, JTextField apellidoField, JTextField dniField, JTextField idClienteField, JTextField direccionField, JTextField rucField, JTextField telefonoField, JTextField correoField) {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dni = dniField.getText();
        String idCliente = idClienteField.getText();
        String direccion = direccionField.getText();
        String ruc = rucField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();
        
        // Validar datos
        if (!ValidarInformacion.validarNombreApellido(nombre) || !ValidarInformacion.validarNombreApellido(apellido)) {
            JOptionPane.showMessageDialog(null, "El nombre y apellido deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDNI(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarRUC(ruc)) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener exactamente 10 dígitos y empezar con 1 o 2", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "El teléfono debe contener exactamente 9 dígitos que empiecen con 9", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo electrónico debe contener '@' y terminar en '.com'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Añadir fila a la tabla
        model.addRow(new Object[]{model.getRowCount() + 1, nombre, apellido, dni, idCliente, direccion, ruc, telefono, correo, new java.util.Date()});
        
        // Limpiar campos
        nombreField.setText("");
        apellidoField.setText("");
        dniField.setText("");
        idClienteField.setText("");
        direccionField.setText("");
        rucField.setText("");
        telefonoField.setText("");
        correoField.setText("");
    }

    public static void actualizarCliente(DefaultTableModel model, JTable table, JTextField nombreField, JTextField apellidoField, JTextField dniField, JTextField idClienteField, JTextField direccionField, JTextField rucField, JTextField telefonoField, JTextField correoField) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dni = dniField.getText();
        String idCliente = idClienteField.getText();
        String direccion = direccionField.getText();
        String ruc = rucField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();
        
        // Validar datos
        if (!ValidarInformacion.validarNombreApellido(nombre) || !ValidarInformacion.validarNombreApellido(apellido)) {
            JOptionPane.showMessageDialog(null, "El nombre y apellido deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDNI(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarRUC(ruc)) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener exactamente 10 dígitos y empezar con 1 o 2", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "El teléfono debe contener exactamente 9 dígitos que empiecen con 9", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo electrónico debe contener '@' y terminar en '.com'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar la fila seleccionada
        model.setValueAt(nombre, selectedRow, 1);
        model.setValueAt(apellido, selectedRow, 2);
        model.setValueAt(dni, selectedRow, 3);
        model.setValueAt(idCliente, selectedRow, 4);
        model.setValueAt(direccion, selectedRow, 5);
        model.setValueAt(ruc, selectedRow, 6);
        model.setValueAt(telefono, selectedRow, 7);
        model.setValueAt(correo, selectedRow, 8);
        model.setValueAt(new java.util.Date(), selectedRow, 9);
        
        // Limpiar campos
        nombreField.setText("");
        apellidoField.setText("");
        dniField.setText("");
        idClienteField.setText("");
        direccionField.setText("");
        rucField.setText("");
        telefonoField.setText("");
        correoField.setText("");
    }

    public static void eliminarCliente(DefaultTableModel model, JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Eliminar la fila seleccionada
        model.removeRow(selectedRow);
        // Actualizar los valores de la columna "N° Registro"
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
    }

    public static void guardarCliente(DefaultTableModel model) {
        ConexionBDprueba conexion = new ConexionBDprueba();
        int rowCount = model.getRowCount();
        
        // Variable para determinar si todos los registros se guardaron correctamente
        boolean todosGuardados = true;
        
        try {
            conexion.beginTransaction(); // Iniciar transacción
            
            // Recorremos cada fila del modelo de tabla
            for (int i = 0; i < rowCount; i++) {
                String nombre = model.getValueAt(i, 1).toString();
                String apellido = model.getValueAt(i, 2).toString();
                String dniStr = model.getValueAt(i, 3).toString();
                String direccion = model.getValueAt(i, 4).toString();
                String telefonoStr = model.getValueAt(i, 5).toString();
                String correo = model.getValueAt(i, 6).toString();
                String idClienteStr = model.getValueAt(i, 7).toString();
                String rucStr = model.getValueAt(i, 8).toString();
        
                // Obtener el último ID de cliente de la base de datos
                int ultimoIdCliente = conexion.getLastIdCliente();
                int nuevoIdCliente = ultimoIdCliente + 1;
                String idCliente = String.valueOf(nuevoIdCliente); // Convertir a String
        
                try {
                    // Insertar datos en la base de datos usando la conexión establecida
                    conexion.insertarPersona(idCliente, nombre, apellido, dniStr, direccion, telefonoStr, correo);
                    conexion.insertarCliente(idCliente, idClienteStr, rucStr);
                    conexion.insertarUsuario(idCliente, idCliente, dniStr); // idUsuario es igual a idCliente, contraseña es el DNI
                    
                    JOptionPane.showMessageDialog(null, "Datos insertados correctamente en la base de datos.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar persona en la base de datos: " + ex.getMessage());
                    todosGuardados = false; // Marcar que no se guardó este registro
                    conexion.rollbackTransaction(); // Deshacer transacción en caso de error
                    break; // Salir del bucle si hay un error
                }
            }
            
            if (todosGuardados) {
                conexion.commitTransaction(); // Confirmar transacción si todos los registros se guardaron correctamente
                model.setRowCount(0); // Limpiar todas las filas del modelo de tabla después de guardar los datos
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos: " + e.getMessage());
        } finally {
            conexion.closeConnection(); // Cerrar conexión al finalizar
        }
    }
    

    
}
