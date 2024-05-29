package Vista;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorVista;


public class vistaRegistrarCliente extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

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
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        ControladorVista.configurarTablaRegistarCliente(model, table, scrollPane, PanelVistaCompra,15, 515, 1055, 325);

        //Ingresar los Datos

        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Nombre:", new Font("Aptos Black", Font.BOLD, 20), 10, 5, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 30, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Apellidos:", new Font("Aptos Black", Font.BOLD, 20), 10, 75, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 100, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "DNI:", new Font("Aptos Black", Font.BOLD, 20), 10, 135, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 160, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "IDCliente:", new Font("Aptos Black", Font.BOLD, 20), 10, 195, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 220, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Dirección:", new Font("Aptos Black", Font.BOLD, 20), 10, 255, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 280, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "RUC:", new Font("Aptos Black", Font.BOLD, 20), 10, 315, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 340, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Teléfono:", new Font("Aptos Black", Font.BOLD, 20), 10, 375, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 400, 550, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Correo:", new Font("Aptos Black", Font.BOLD, 20), 10, 435, 430, 25);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 5, 460, 550, 35);
        
        //Botones
        ControladorVista.agregarBoton(PanelVistaCompra, "Registrar", 740, 385, 75, 35, 740, 415, "check.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Actualizar", 828, 385, 75, 35, 825, 415,"actualizar.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Cancelar", 915, 385, 75, 35, 910, 415,"x.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Guardar", 1000, 385, 75, 35, 995, 415,"guardar.png");
    }
}



