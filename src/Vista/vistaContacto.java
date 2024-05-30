package Vista;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorVista;


public class vistaContacto extends JFrame {

    private DefaultTableModel model;
    private JTable table;


    public vistaContacto() {

        this.setTitle("EMPRESA SOCOSANI:   Contáctanos");
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

        
        // Crear la tabla con el modelo
        table = new JTable(model);

        // Configurar la transparencia de la tabla y sus celdas
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);

        ControladorVista.agregarEtiqueta(PanelVistaPedido, "Escriba su dirección de correo:",new Font("Aptos Black", Font.BOLD, 20),5, 5, 450, 35);
        ControladorVista.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.BOLD, 20), 5, 40, 450, 35);
        ControladorVista.agregarEtiqueta(PanelVistaPedido, "Escriba su mensaje:",new Font("Aptos Black", Font.BOLD, 20),5, 80, 450, 35);
        ControladorVista.agregarCampoTexto(PanelVistaPedido, new Font("Aptos Black", Font.BOLD, 20), 5, 120, 450, 120);

    }

}