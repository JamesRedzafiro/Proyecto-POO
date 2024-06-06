package Controlador;

import javax.swing.*;
import java.awt.Font;
import java.awt.color.*;
import java.awt.event.*;
import javafx.scene.paint.Color;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.ArrayList;


import java.net.URL;    

public class ControladorInterfaz {

     public static void configurarTabla(DefaultTableModel model, JTable table, JScrollPane scrollPane, JPanel panel, int x, int y, int ancho, int alto, String[] columnas) {
        // Establecer el modelo de tabla personalizado
        table.setModel(new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Object getValueAt(int row, int column) {
                return model.getValueAt(row, column);
            }

            @Override
            public int getColumnCount() {
                return model.getColumnCount();
            }

            @Override
            public String getColumnName(int column) {
                return model.getColumnName(column);
            }

            @Override
            public int getRowCount() {
                return model.getRowCount();
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                model.setValueAt(aValue, row, column);
            }
        });

        // Agregar columnas al modelo de tabla personalizado
        for (String columna : columnas) {
            model.addColumn(columna);
        }

        // Configurar la tabla
        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        // Establecer el estilo de la fuente en negrita
        table.setFont(table.getFont().deriveFont(Font.BOLD));

        // Establecer el color de fondo de la tabla
        table.setBackground(Color.WHITE);

        // Configurar el panel de desplazamiento y agregarlo al panel principal
        scrollPane.setBounds(x, y, ancho, alto);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); 
        panel.add(scrollPane);
    }
    

    public static JLabel agregarEtiqueta(JPanel panel, String texto, Font font, int x, int y, int width, int height) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(font);
        etiqueta.setBounds(x, y, width, height);
        panel.add(etiqueta);
        return etiqueta;
    }

    public static JTextField agregarCampoTexto(JPanel panel, Font font, int x, int y, int width, int height) {
        JTextField campoTexto = new JTextField();
        campoTexto.setFont(font);
        campoTexto.setBounds(x, y, width, height);
        // Establecer la alineación del texto a la izquierda
        campoTexto.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
        // Asegurarse de que el texto esté alineado en la parte superior
        campoTexto.setAlignmentY(JTextArea.TOP_ALIGNMENT);
        panel.add(campoTexto);
        return campoTexto;
    }

    public static JButton agregarBoton(JPanel panel, String texto, int xLabel, int yLabel, int widthLabel,int heightLabel,int xButton,int yButton, String nombreIcon) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Aptos Black", Font.BOLD, 15));
        etiqueta.setBounds(xLabel, yLabel, widthLabel, heightLabel);
        panel.add(etiqueta);

        JButton btnJButton = new JButton();
        URL iconURL = ControladorInterfaz.class.getResource("/Imagenes/" + nombreIcon); // Ajusta la ruta de la imagen
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
        return btnJButton;
    }

    public static JButton agregarBotonInferior(JPanel panel, int x, int y, int width, int height, String nombreIcon) {
        JButton btnJButton = new JButton();
        URL iconURL = ControladorInterfaz.class.getResource("/Imagenes/" + nombreIcon); // Ajusta la ruta de la imagen
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
        return btnJButton;
    }

    public static JComboBox<String> agregarComboBox(JPanel panel, String[] cadena, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(cadena);
        comboBox.setFont(new Font("Aptos Black", Font.BOLD, 20));
        comboBox.setBounds(x, y, width, height);
        panel.add(comboBox);
        return comboBox;
    }
}
