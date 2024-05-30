package Controlador;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.net.URL;

public class ControladorVista {

    //Tabla Compra
    public static void configurarTablaVenta(DefaultTableModel model, JTable table, JScrollPane scrollPane, JPanel panel, int x, int y, int ancho, int alto) {
        model.addColumn("ID");
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Total");

        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        //scrollPane.setBounds(15, 210, 850, 290);
        scrollPane.setBounds(x, y, ancho, alto);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);
    }

    //Tabla Pedido de Venta
    public static void configurarTablaPedido(DefaultTableModel model, JTable table, JScrollPane scrollPane, JPanel panel,int x, int y, int ancho, int alto) {
        model.addColumn("N° Pedido");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Fecha Entrega");

        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        //scrollPane.setBounds(15, 130, 675, 250);
        scrollPane.setBounds(x, y, ancho, alto);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

    }

    //Tabla Registrar Cliente
    public static void configurarTablaRegistarCliente(DefaultTableModel model, JTable table, JScrollPane scrollPane, JPanel panel,int x, int y, int ancho, int alto) {
        model.addColumn("N° Registro");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("iDCliente");
        model.addColumn("Dirección");
        model.addColumn("Ruc");
        model.addColumn("Teléfono");
        model.addColumn("Correo");
        model.addColumn("Fecha de Registro");

        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        //scrollPane.setBounds(15, 130, 675, 250);
        scrollPane.setBounds(x, y, ancho, alto);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);
    }

    //Tabla Buscar

    public static void agregarEtiqueta(JPanel panel, String texto, Font font, int x, int y, int width, int height) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(font);
        etiqueta.setBounds(x, y, width, height);
        panel.add(etiqueta);
    }

    public static void agregarCampoTexto(JPanel panel, Font font, int x, int y, int width, int height) {
        JTextField campoTexto = new JTextField();
        campoTexto.setFont(font);
        campoTexto.setBounds(x, y, width, height);
        // Establecer la alineación del texto a la izquierda
        campoTexto.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
        // Asegurarse de que el texto esté alineado en la parte superior
        campoTexto.setAlignmentY(JTextArea.TOP_ALIGNMENT);
        panel.add(campoTexto);
    }

    public static void agregarBoton(JPanel panel, String texto, int xLabel, int yLabel, int widthLabel,int heightLabel,int xButton,int yButton, String nombreIcon) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Aptos Black", Font.BOLD, 15));
        etiqueta.setBounds(xLabel, yLabel, widthLabel, heightLabel);
        panel.add(etiqueta);

        JButton btnJButton = new JButton();
        URL iconURL = ControladorVista.class.getResource("/Imagenes/" + nombreIcon); // Ajusta la ruta de la imagen
        if (iconURL != null) {
            ImageIcon btnIcono = new ImageIcon(iconURL);
            btnJButton.setIcon(btnIcono); // Establece el icono en el botón
        } else {
            System.err.println("No se encontró el icono: " + nombreIcon);
            btnJButton.setText("Icono no encontrado");
        }
        btnJButton.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnJButton.setBounds(xButton, yButton, 75, 75);
        panel.add(btnJButton);
    }

    public static void agregarBotonInferior(JPanel panel, int x, int y, int width, int height,String nombreIcon) {
        JButton btnJButton = new JButton();
        URL iconURL = ControladorVista.class.getResource("/Imagenes/" + nombreIcon); // Ajusta la ruta de la imagen
        if (iconURL != null) {
            ImageIcon btnIcono = new ImageIcon(iconURL);
            btnJButton.setIcon(btnIcono); // Establece el icono en el botón
        } else {
            System.err.println("No se encontró el icono: " + nombreIcon);
            btnJButton.setText("Icono no encontrado");
        }
        btnJButton.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnJButton.setBounds(x, y, width, height);
        panel.add(btnJButton);
    }

    public static void agregarComboBox(JPanel panel, String[] cadena, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(cadena);
        comboBox.setFont(new Font("Aptos Black", Font.BOLD, 20));
        comboBox.setBounds(x, y, width, height);
        panel.add(comboBox);
    }

}
