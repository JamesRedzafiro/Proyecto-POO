package Vista.Interfaz;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import Controlador.*;
import Vista.ImagenFondo;


public class VistaAgregarProducto extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    private JTextField nombreField;
    private JTextField volumenField;
    private JTextField precioField;
    private JTextField saborField;
    private JButton registrarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton guardarButton;

    public VistaAgregarProducto() {
        this.setTitle("EMPRESA SOCOSANI:   Registrar Producto");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 675, 625);
        setLayout(new BorderLayout());
        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));
        this.setLocationRelativeTo(null);
        ComponentesVistaCompra();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ComponentesVistaCompra() {
        ImagenFondo PanelVistaCompra = new ImagenFondo("/Imagenes/fondo-socosani.png");
        PanelVistaCompra.setLayout(null);
        this.getContentPane().add(PanelVistaCompra);

        // Crear el modelo de la tabla y configurar la tabla
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        // Configurar la transparencia de la tabla y sus celdas
        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        String [] columnas = {"N° Registro", "Nombre", "Volumen", "Precio", "Sabor", "Fecha Registro"};
        ControladorInterfaz.configurarTabla(model, table, scrollPane, PanelVistaCompra, 15, 390, 625, 180, columnas);

        

        // Ingresar los Datos
        //ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "iDProducto:", new Font("Aptos Black", Font.BOLD, 20), 40, 5, 430, 25);
        //iDProductoField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 25, 30, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Nombre:", new Font("Aptos Black", Font.BOLD, 20), 40, 5, 430, 25);
        nombreField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 25, 30, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Volumen:", new Font("Aptos Black", Font.BOLD, 20), 40, 75, 430, 25);
        volumenField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 25, 100, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Precio:", new Font("Aptos Black", Font.BOLD, 20), 40, 135, 430, 25);
        precioField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 25, 160, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Sabor:", new Font("Aptos Black", Font.BOLD, 20), 40, 195, 430, 25);
        saborField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 25, 220, 550, 35);
        
        // Botones
        registrarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Registrar", 20, 265, 75, 35,
                                                                             20, 300, "check.png");
        actualizarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Actualizar", 108, 265, 75, 35,
                                                                             105, 300, "actualizar.png");
        eliminarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Eliminar", 450, 265, 75, 35,
                                                                             450, 300, "x.png");
        guardarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Guardar", 550, 265, 75, 35,
                                                                             550, 300, "guardar.png");

        // Añadir ActionListener para el botón registrar
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorRegistrarProducto.registrarProducto(model, nombreField, volumenField, precioField, saborField);
            }
        });

        // ActionListener para el botón "Buscar"
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ControladorRegistrarCliente.actualizarCliente(model, table, nombreField, apellidoField, dniField, idClienteField, direccionField, rucField, telefonoField, correoField);
            }
        });

        // ActionListener para el botón "Eliminar"
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ControladorRegistrarCliente.eliminarCliente(model, table);
            }
        });

        //ActionListener para el botón "Guardar"
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ControladorRegistrarProducto.guardarProducto(model);
            }
        });
    }
}