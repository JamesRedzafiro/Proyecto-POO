package Controlador;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.net.URL;

public class ControladorVista {

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
        panel.add(campoTexto);
    }

    public static void agregarBoton(JPanel panel, String texto, String iconPath, int xLabel, int yLabel, int widthLabel, int heightLabel, int xButton, int yButton, int widthButton, int heightButton) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Aptos Black", Font.BOLD, 15));
        etiqueta.setBounds(xLabel, yLabel, widthLabel, heightLabel);
        panel.add(etiqueta);

        JButton boton = new JButton();
        URL iconURL = ControladorVista.class.getResource(iconPath);
        if (iconURL != null) {
            ImageIcon icono = new ImageIcon(iconURL);
            boton.setIcon(icono);
        } else {
            System.err.println("No se encontró el icono: " + iconPath);
            boton.setText("Icono no encontrado");
        }
        boton.setFont(new Font("Aptos Black", Font.BOLD, 20));
        boton.setBounds(xButton, yButton, widthButton, heightButton);
        panel.add(boton);
    }

    public static void agregarBotonInferior(JPanel panel, String iconPath, int x, int y, int width, int height) {
        JButton boton = new JButton();
        URL iconURL = ControladorVista.class.getResource(iconPath);
        if (iconURL != null) {
            ImageIcon icono = new ImageIcon(iconURL);
            boton.setIcon(icono);
        } else {
            System.err.println("No se encontró el icono: " + iconPath);
            boton.setText("Icono no encontrado");
        }
        boton.setFont(new Font("Aptos Black", Font.ITALIC, 25));
        boton.setBounds(x, y, width, height);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(boton);
    }
}
