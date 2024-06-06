package Vista.Interfaz;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorInterfaz;
import Controlador.ControladorVista;
import Vista.ImagenFondo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaRegistrarCliente extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField dniField;
    private JTextField idClienteField;
    private JTextField direccionField;
    private JTextField rucField;
    private JTextField telefonoField;
    private JTextField correoField;
    private JButton registrarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton guardarButton;

    public vistaRegistrarCliente() {
        this.setTitle("EMPRESA SOCOSANI:   Registrar Cliente");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 1100, 900);

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

        String [] columnas = {"N° Registro", "Nombre", "Apellido", "DNI", "iDCliente", "Direccion", "RUC", "Telefono", "Correo", "Fecha Registro"};
        ControladorInterfaz.configurarTabla(model, table, scrollPane, PanelVistaCompra, 15, 515, 1055, 325, columnas);

        // Ingresar los Datos
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Nombre:", new Font("Aptos Black", Font.BOLD, 20), 10, 5, 430, 25);
        nombreField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 30, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Apellidos:", new Font("Aptos Black", Font.BOLD, 20), 10, 75, 430, 25);
        apellidoField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 100, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "DNI:", new Font("Aptos Black", Font.BOLD, 20), 10, 135, 430, 25);
        dniField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 160, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "IDCliente:", new Font("Aptos Black", Font.BOLD, 20), 10, 195, 430, 25);
        idClienteField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 220, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Dirección:", new Font("Aptos Black", Font.BOLD, 20), 10, 255, 430, 25);
        direccionField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 280, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "RUC:", new Font("Aptos Black", Font.BOLD, 20), 10, 315, 430, 25);
        rucField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 340, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Teléfono:", new Font("Aptos Black", Font.BOLD, 20), 10, 375, 430, 25);
        telefonoField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 400, 550, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Correo:", new Font("Aptos Black", Font.BOLD, 20), 10, 435, 430, 25);
        correoField = ControladorInterfaz.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 460, 550, 35);

        // Botones
        registrarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Registrar", 740, 385, 75, 35, 740, 415, "check.png");
        actualizarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Actualizar", 828, 385, 75, 35, 825, 415, "actualizar.png");
        eliminarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Eliminar", 915, 385, 75, 35, 910, 415, "x.png");
        guardarButton = ControladorInterfaz.agregarBoton(PanelVistaCompra, "Guardar", 1000, 385, 75, 35, 995, 415, "guardar.png");

        // Añadir ActionListener para el botón registrar
        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControladorVista.registrarCliente(model, nombreField, apellidoField, dniField, idClienteField, direccionField, rucField, telefonoField, correoField);
            }
        });

        // ActionListener para el botón "Actualizar"
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVista.actualizarCliente(model, table, nombreField, apellidoField, dniField, idClienteField, direccionField, rucField, telefonoField, correoField);
            }
        });

        // ActionListener para el botón "Eliminar"
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVista.eliminarCliente(model, table);
            }
        });

        // ActionListener para el botón "Guardar"
        // guardarButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         ControladorVista.guardarCliente(model, table);
        //     }
        //});


    }

    
}
