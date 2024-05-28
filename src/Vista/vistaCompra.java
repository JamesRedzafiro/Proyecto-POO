package Vista;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorVista;

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
        ControladorVista.configurarTablaVenta(model, table, scrollPane, PanelVistaCompra,15, 210, 850, 290);

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
        JLabel btnAgregarJLabel =new JLabel("Agregar");
        btnAgregarJLabel.setFont(new Font("Aptos Black",Font.BOLD,15));
        btnAgregarJLabel.setBounds(700, 100, 75, 35);
        PanelVistaCompra.add(btnAgregarJLabel);

        JButton btnAgregar = new JButton();
        ImageIcon btnAgregarIcono = new ImageIcon(getClass().getResource("/Imagenes/check.png")); // Ajusta la ruta de la imagen
        btnAgregar.setIcon(btnAgregarIcono);
        btnAgregar.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnAgregar.setBounds(690, 130, 75, 75); // Ajusta el tamaño para que la imagen y el texto quepan
        btnAgregar.setHorizontalTextPosition(SwingConstants.RIGHT); // Posiciona el texto a la derecha de la imagen
        PanelVistaCompra.add(btnAgregar);

        JLabel btnEliminarJLabel = new JLabel("Eliminar");
        btnEliminarJLabel.setFont(new Font("Aptos Black",Font.BOLD,15));
        btnEliminarJLabel.setBounds(790, 100, 75, 35);
        PanelVistaCompra.add(btnEliminarJLabel);

        JButton btnEliminar = new JButton();
        ImageIcon btnEliminarIcono = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png")); // Ajusta la ruta de la imagen
        btnEliminar.setIcon(btnEliminarIcono);
        btnEliminar.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnEliminar.setBounds(780, 130, 75, 75);
        PanelVistaCompra.add(btnEliminar);

        //Botones Parte baja
        JButton btnNuevo = new JButton();
        ImageIcon btnNuevoIcono = new ImageIcon(getClass().getResource("/Imagenes/nuevo.png")); // Ajusta la ruta de la imagen
        btnNuevo.setIcon(btnNuevoIcono);
        btnNuevo.setFont(new Font("Aptos Black",Font.ITALIC,25));
        btnNuevo.setBounds(345, 510, 75, 75);
        btnNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
        PanelVistaCompra.add(btnNuevo);

        JButton btnGuardar = new JButton();
        ImageIcon btnGuardarIcono = new ImageIcon(getClass().getResource("/Imagenes/guardar.png"));
        btnGuardar.setIcon(btnGuardarIcono);
        btnGuardar.setFont(new Font("Aptops Black",Font.ITALIC,25));
        btnGuardar.setBounds(435, 510, 75, 75);
        btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
        PanelVistaCompra.add(btnGuardar);

        JButton btnCancelar = new JButton();
        ImageIcon btnCancelarIcono = new ImageIcon(getClass().getResource("/Imagenes/x.png"));
        btnCancelar.setIcon(btnCancelarIcono);
        btnCancelar.setFont(new Font("Aptops Black",Font.ITALIC,25));
        btnCancelar.setBounds(525, 510, 75, 75);
        btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
        PanelVistaCompra.add(btnCancelar);

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
