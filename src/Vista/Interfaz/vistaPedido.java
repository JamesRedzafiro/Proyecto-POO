package Vista.Interfaz;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.*;
import Vista.ImagenFondo;

public class vistaPedido extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    public static double sumaTotal = 0.0;
    public static JLabel totalLabel;

    public vistaPedido() {
        this.setTitle("EMPRESA SOCOSANI: Pedido de Compra");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 725, 500);

        // Asegúrate de que el contenido de la ventana no esté cubierto por el fondo del panel
        setLayout(new BorderLayout());

        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));

        this.setLocationRelativeTo(null);
        ComponentesVistaPedido();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void inicializarTotalLabel(JPanel panel) {
        totalLabel = ControladorInterfaz.agregarEtiqueta(panel, "00.00", new Font("Aptos Black", Font.BOLD, 20), 200, 400, 250, 40);
    }

    public static void actualizarTotalLabel() {
        totalLabel.setText(String.format("%.2f", sumaTotal));
    }

    private void ComponentesVistaPedido() {
        JComboBox<String> productoBox;
        JTextField cantidaField;
        JTextField idClienteField;

        ImagenFondo PanelVistaPedido = new ImagenFondo("/Imagenes/fondo-socosani.png");
        PanelVistaPedido.setLayout(null);
        this.getContentPane().add(PanelVistaPedido);

        // Crear el modelo de la tabla
        model = new DefaultTableModel();
        // Crear la tabla con el modelo
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        PanelVistaPedido.add(scrollPane);

        String[] columnas = {"N° Pedido", "Nombre", "Cantidad", "iDProducto", "iDCliente", "Total Pedido", "Fecha Pedido"};
        ControladorInterfaz.configurarTabla(model, table, scrollPane, PanelVistaPedido, 15, 130, 675, 250, columnas);

        // Producto
        JLabel productoJLabel = new JLabel("Nombre del Producto:");
        productoJLabel.setFont(new Font("Aptos Black", Font.BOLD, 20));
        productoJLabel.setBounds(15, 0, 225, 35);
        PanelVistaPedido.add(productoJLabel);

        // ComboBox Lista Productos
        List<String> nombresProductos = ControladorRegistrarProducto.obtenerNombresProductos();
        productoBox = ControladorInterfaz.agregarComboBox(PanelVistaPedido, nombresProductos, 15, 35, 225, 35);

        // Cantidad
        ControladorInterfaz.agregarEtiqueta(PanelVistaPedido, "Cantidad de Productos:", new Font("Aptos Black", Font.BOLD, 20), 260, 0, 225, 35);
        cantidaField = ControladorInterfaz.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.PLAIN, 20), 260, 35, 225, 35);

        // ID Cliente
        ControladorInterfaz.agregarEtiqueta(PanelVistaPedido, "ID Cliente", new Font("Aptos Black", Font.BOLD, 20), 505, 0, 225, 35);
        idClienteField = ControladorInterfaz.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.PLAIN, 20), 505, 35, 185, 35);

        // Total
        ControladorInterfaz.agregarEtiqueta(PanelVistaPedido, "Total Pedido: S/. ", new Font("Aptos Black", Font.BOLD, 20), 20, 400, 250, 40);
        
        // Inicializar totalLabel
        inicializarTotalLabel(PanelVistaPedido);

        // Botones
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnRegistrar.setBounds(35, 80, 140, 40);
        btnRegistrar.setFocusPainted(false);
        PanelVistaPedido.add(btnRegistrar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnActualizar.setBounds(300, 80, 140, 40);
        btnActualizar.setFocusPainted(false);
        PanelVistaPedido.add(btnActualizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnCancelar.setBounds(535, 80, 140, 40);
        btnCancelar.setFocusPainted(false);
        PanelVistaPedido.add(btnCancelar);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnEnviar.setBounds(550, 400, 140, 40);
        btnEnviar.setFocusPainted(false);
        PanelVistaPedido.add(btnEnviar);

        JButton btnContacto = new JButton("Contactanos");
        btnContacto.setFont(new Font("Aptos Black", Font.BOLD, 20));
        btnContacto.setBounds(375, 400, 160, 40);
        btnContacto.setFocusPainted(false);
        PanelVistaPedido.add(btnContacto);

        // Agregar listeners a los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorPedido.registrarPedido(model, productoBox, cantidaField, idClienteField);
            }
        });

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorPedido controladorPedido = new ControladorPedido();
                controladorPedido.guardarPedido(model);
            }
        });

    }
}
