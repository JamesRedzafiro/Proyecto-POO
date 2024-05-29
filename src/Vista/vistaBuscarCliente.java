package Vista;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorVista;


public class vistaBuscarCliente extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    public vistaBuscarCliente() {
        this.setTitle("EMPRESA SOCOSANI:   Buscar Cliente");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 1100, 550);

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
        ControladorVista.configurarTablaRegistarCliente(model, table, scrollPane, PanelVistaCompra,15, 200, 1055, 300);

        //Ingresar los Datos

        String [] cadena = {"iDCliente","Nombre","Apellido","Dni","RUC","Dirección"};
        ControladorVista.agregarEtiqueta(PanelVistaCompra, "Escoja Método de Busqueda:", new Font("Aptos Black", Font.BOLD, 20), 10, 15, 430, 35);
        ControladorVista.agregarComboBox(PanelVistaCompra, cadena, 15, 80, 200, 35);
        ControladorVista.agregarCampoTexto(PanelVistaCompra,new Font("Aptos Black", Font.BOLD, 20), 15, 140, 250, 35);

        ControladorVista.agregarBoton(PanelVistaCompra, "Buscar",710, 70, 75, 35, 700, 100, "check.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Actualizar", 802, 70, 75, 35, 800, 100, "actualizar.png");
        ControladorVista.agregarBoton(PanelVistaCompra, "Eliminar", 905, 70, 75, 35, 900, 100, "eliminar.png");


    }
}



