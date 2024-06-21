package Vista.Interfaz;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controlador.ControladorInterfaz;
import Vista.ImagenFondo;


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
        String [] columnas ={"N° Registro","Nombre","Apellido","DNI","iDCliente","Direccion","RUC","Telefono","Correo","Fecha Registro"};
        ControladorInterfaz.configurarTabla(model, table, scrollPane, PanelVistaCompra,15, 200, 1055, 300,columnas);

        //Ingresar los Datos

        String [] cadena = {"iDCliente","Nombre","Apellido","Dni","RUC","Dirección"};
        ArrayList<String> arrayListCadena = new ArrayList<>(Arrays.asList(cadena));
        ControladorInterfaz.agregarEtiqueta(PanelVistaCompra, "Escoja Método de Busqueda:", new Font("Aptos Black", Font.BOLD, 20), 10, 15, 430, 35);
        ControladorInterfaz.agregarComboBox(PanelVistaCompra, arrayListCadena, 15, 80, 200, 35);
        ControladorInterfaz.agregarCampoTexto(PanelVistaCompra,new Font("Aptos Black", Font.BOLD, 20), 15, 140, 250, 35);

        ControladorInterfaz.agregarBoton(PanelVistaCompra, "Buscar",710, 70, 75, 35, 700, 100, "check.png");
        ControladorInterfaz.agregarBoton(PanelVistaCompra, "Actualizar", 802, 70, 75, 35, 800, 100, "actualizar.png");
        ControladorInterfaz.agregarBoton(PanelVistaCompra, "Eliminar", 905, 70, 75, 35, 900, 100, "eliminar.png");


    }
}



