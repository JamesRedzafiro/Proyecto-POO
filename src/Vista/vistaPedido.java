package Vista;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.*;
import Controlador.ControladorVista;


public class vistaPedido extends JFrame{

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;


    public vistaPedido() {

        this.setTitle("EMPRESA SOCOSANI:   Pedido de Compra");
        this.setFont(new Font("Aptos Black",Font.BOLD,35));
        this.setBounds(0, 0, 725, 500);

        // Asegúrate de que el contenido de la ventana no esté cubierto por el fondo del panel
        setLayout(new BorderLayout());

        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));

        //C:\Users\James Red\Desktop\PROGRAMACION\Java\UTP-class\Proyecto_POO\Proyecto\src\Vista\ImagenFondo.java
        this.setLocationRelativeTo(null);
        ComponentesVistaPedido();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ComponentesVistaPedido(){

        //Usa ImagenFondo en lugar de JPanel
        ImagenFondo PanelVistaPedido = new ImagenFondo("/Imagenes/fondo-socosani.png");
        PanelVistaPedido.setLayout(null);
        this.getContentPane().add(PanelVistaPedido);

        // Crear el modelo de la tabla
        model = new DefaultTableModel();
        model.addColumn("N° Pedido");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Fecha Entrega");

        // Crear la tabla con el modelo
        table = new JTable(model);

        // Configurar la transparencia de la tabla y sus celdas
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        
        // Agregar la tabla a un JScrollPane
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 130, 675, 250);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        PanelVistaPedido.add(scrollPane);

        //Producto
        JLabel productoJLabel = new JLabel("Nombre del Producto:");
        productoJLabel.setFont(new Font("Aptos Black",Font.BOLD,20));
        productoJLabel.setBounds(15, 0, 225, 35);
        PanelVistaPedido.add(productoJLabel);

        String[] productos = {"agua1", "agua2", "agua3", "agua4", "agua5", "agua6", "agua7"};
        JComboBox<String> productoJComboBox = new JComboBox<>(productos);
        productoJComboBox.setFont(new Font("Aptos Black", Font.PLAIN, 20));
        productoJComboBox.setBounds(15, 35, 225, 35);
        PanelVistaPedido.add(productoJComboBox);

        //Cantidad
        ControladorVista.agregarEtiqueta(PanelVistaPedido, "Cantidad de Productos:", new Font("Aptos Black",Font.BOLD,20), 260, 0, 225, 35);
        ControladorVista.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.PLAIN, 20), 260, 35, 225, 35);

        //iD Cliente
        ControladorVista.agregarEtiqueta(PanelVistaPedido,"ID Cliente",new Font("Aptos Black",Font.BOLD,20),505, 0, 225, 35);
        ControladorVista.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.PLAIN, 20), 505, 35, 185, 35);

        //Total
        ControladorVista.agregarEtiqueta(PanelVistaPedido, "Total Pedido: S/. ", new Font("Aptos Black",Font.BOLD,20), 20, 400, 250, 40); 
        ControladorVista.agregarEtiqueta(PanelVistaPedido, "00.00", new Font("Aptos Black",Font.BOLD,20), 200, 400, 250, 40);
    

        //Botones
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnGuardar.setBounds(35, 80, 140, 40);
        PanelVistaPedido.add(btnGuardar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnActualizar.setBounds(300, 80, 140, 40);
        PanelVistaPedido.add(btnActualizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnCancelar.setBounds(535, 80, 140, 40);
        PanelVistaPedido.add(btnCancelar);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnEnviar.setBounds(550, 400, 140, 40);
        PanelVistaPedido.add(btnEnviar);

        JButton btnContacto = new JButton("Contactanos");
        btnContacto.setFont(new Font("Aptos Black",Font.BOLD,20));
        btnContacto.setBounds(375, 400, 160, 40);
        PanelVistaPedido.add(btnContacto);

        //Agregar listeners a los botones
        
        // btnGuardar.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         controladorPedido.guardarPedido();
        //     }
        // });
        
        // btnActualizar.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         actualizarPedido();
        //     }
        // });

        // btnCancelar.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         cancelarPedido();
        //     }
        // });

        // btnEnviar.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         enviarPedido();
        //         }
        // });
        
        
    }

}