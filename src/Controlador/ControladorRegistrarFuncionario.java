package Controlador;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBDCliente;

public class ControladorRegistrarFuncionario {

    
    public static void registrarFuncionario(DefaultTableModel model, JTextField nombreField, JTextField apellidoField, JTextField dniField, JTextField direccionField, JTextField puestoField, JTextField telefonoField, JTextField correoField) {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String dni = dniField.getText();
        String direccion = direccionField.getText();
        String puesto = puestoField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();
    
        // Validar datos
        if (!ValidarInformacion.validarNombre(nombre) || !ValidarInformacion.validarNombre(apellido)|| !ValidarInformacion.validarNombre(puesto)) {
            JOptionPane.showMessageDialog(null, "El nombre, apellido y puesto deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDNI(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
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
    
        // Obtener la fecha actual en el formato java.sql.Date
        Date fechaRegistro = new Date(System.currentTimeMillis());
    
        // Añadir fila a la tabla
        model.addRow(new Object[]{model.getRowCount() + 1, nombre, apellido, dni, direccion, puesto, telefono, correo, fechaRegistro});
    
        // Limpiar campos
        nombreField.setText("");
        apellidoField.setText("");
        dniField.setText("");
        direccionField.setText("");
        puestoField.setText("");
        telefonoField.setText("");
        correoField.setText("");
    }

    public static void actualizarFuncionario(DefaultTableModel model, JTable table, JTextField nombreField, JTextField apellidoField, JTextField dniField, JTextField idClienteField, JTextField direccionField, JTextField puestoField, JTextField telefonoField, JTextField correoField) {
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
        String puesto = puestoField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();
        
        // Validar datos
        if (!ValidarInformacion.validarNombre(nombre) || !ValidarInformacion.validarNombre(apellido)) {
            JOptionPane.showMessageDialog(null, "El nombre y apellido deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ValidarInformacion.validarDNI(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 números sin espacios", "Error", JOptionPane.ERROR_MESSAGE);
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
        model.setValueAt(puesto, selectedRow, 6);
        model.setValueAt(telefono, selectedRow, 7);
        model.setValueAt(correo, selectedRow, 8);
        model.setValueAt(new java.util.Date(), selectedRow, 9);
        
        // Limpiar campos
        nombreField.setText("");
        apellidoField.setText("");
        dniField.setText("");
        idClienteField.setText("");
        direccionField.setText("");
        puestoField.setText("");
        telefonoField.setText("");
        correoField.setText("");
    }

    public static void eliminarFuncionario(DefaultTableModel model, JTable table) {
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

    
    public static void guardarDatosFuncionario(DefaultTableModel model) {
        int rowCount = model.getRowCount();
    
        for (int i = 0; i < rowCount; i++) {
            String nombre = model.getValueAt(i, 1).toString();
            String apellido = model.getValueAt(i, 2).toString();
            String dniStr = model.getValueAt(i, 3).toString();
            String direccion = model.getValueAt(i, 4).toString();
            String puesto = model.getValueAt(i, 5).toString();
            String telefonoStr = model.getValueAt(i, 6).toString();
            String correo = model.getValueAt(i, 7).toString();
            java.sql.Date fechaRegistro = (java.sql.Date) model.getValueAt(i, 8);
    
            try {
                ConexionBDCliente conexion = new ConexionBDCliente();
                conexion.agregarDatosFuncionario(nombre, apellido, dniStr, direccion, telefonoStr, correo, puesto);
                model.removeRow(i); // Eliminar fila después de insertar datos
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos en la fila " + i + ": " + e.getMessage());
            }
        }
    }
    
    
    
    
    
    
    
    
    
}

