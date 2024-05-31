package Vista.Interfaz;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorVista;
import Vista.ImagenFondo;

public class vistaCompra extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    public vistaCompra() {
        this.setTitle("EMPRESA SOCOSANI:   Formulario de Venta");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 900, 625);

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

        String [] columnas = {"ID","Producto","Precio","Cantidad","Total"};
        ControladorVista.configurarTabla(model, table, scrollPane, PanelVistaCompra,15, 210, 850, 290,columnas);

        // Datos Funcionario
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Datos del Funcionario:", new Font("Aptos Black", Font.BOLD, 20), 10, 5, 430, 20);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "ID", new Font("Aptos Black", Font.BOLD, 15), 15, 30, 50, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Nombre", new Font("Aptos Black", Font.BOLD, 15), 100, 30, 150, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Apellido", new Font("Aptos Black", Font.BOLD, 15), 260, 30, 150, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 15, 65, 75, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 100, 65, 150, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 260, 65, 175, 35);

        // Datos Cliente
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Datos del Cliente:", new Font("Aptos Black", Font.BOLD, 20), 450, 5, 400, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "ID", new Font("Aptos Black", Font.BOLD, 15), 455, 30, 50, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Descripción", new Font("Aptos Black", Font.BOLD, 15), 540, 30, 150, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "RUC", new Font("Aptos Black", Font.BOLD, 15), 750, 30, 150, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 455, 65, 75, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 540, 65, 200, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 750, 65, 115, 35);

        // Datos Productos
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Datos del Producto:", new Font("Aptos Black", Font.BOLD, 20), 15, 100, 400, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "ID", new Font("Aptos Black", Font.BOLD, 15), 15, 130, 80, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Descripción", new Font("Aptos Black", Font.BOLD, 15), 110, 130, 150, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Precio", new Font("Aptos Black", Font.BOLD, 15), 270, 130, 100, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Stock", new Font("Aptos Black", Font.BOLD, 15), 355, 130, 75, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Cantidad", new Font("Aptos Black", Font.BOLD, 15), 465, 130, 150, 35);
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Total Venta", new Font("Aptos Black", Font.BOLD, 15), 550, 130, 150, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 15, 160, 85, 35); //ID
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 110, 160, 150, 35); //Descripción
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 270, 160, 75, 35); //Precio 
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 355, 160, 100, 35); // Stock
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 465, 160, 75, 35); //Cantidad
        ControladorVista.agregarCampoTexto(PanelVistaCompra, new Font("Aptos Black", Font.PLAIN, 20), 550, 160, 125, 35); //Total venta

        // Botones
        // Botones Superiores
        ControladorVista.agregarBoton(PanelVistaCompra, "Agregar", 700, 100, 75, 35, 690, 130, "check.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Eliminar", 790, 100, 75, 35, 780, 130, "eliminar.png");


        //Botones Parte baja
        ControladorVista.agregarBotonInferior(PanelVistaCompra, 345, 510, 75, 75, "nuevo.png");
        ControladorVista.agregarBotonInferior(PanelVistaCompra, 435, 510, 75, 75, "guardar.png");
        ControladorVista.agregarBotonInferior(PanelVistaCompra, 525, 510, 75, 75, "x.png");

        //Esto se usará en el ControladorCompra
        String total = "Total: S/.          ";
        Double numero = 0.00;
        DecimalFormat df = new DecimalFormat("0.00");
        String numeroFormato = df.format(numero);
        String Total = total + numeroFormato;
        
        JTextField totalVentaJTextField = new JTextField(Total);
        totalVentaJTextField.setEditable(false);
        totalVentaJTextField.setFocusable(false);
        totalVentaJTextField.setFont(new Font("Aptops Black",Font.ITALIC,25));
        totalVentaJTextField.setBounds(615, 535, 250, 35);
        PanelVistaCompra.add(totalVentaJTextField);

    }
}
