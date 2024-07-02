package Vista.Interfaz;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import Controlador.*;
import Vista.ImagenFondo;


public class VistaLogin extends JFrame {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    private JTextField iDUsuarioField;
    private JTextField contrasenaField;
    
    private JButton btnIngresar;
    private JButton btnSalir;
    private JButton btnContacto;


    public VistaLogin() {
        this.setTitle("EMPRESA SOCOSANI:   Login");
        this.setFont(new Font("Aptos Black", Font.BOLD, 35));
        this.setBounds(0, 0, 550, 350);
        setLayout(new BorderLayout());
        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));
        this.setLocationRelativeTo(null);
        ComponentesVistaLogin();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ComponentesVistaLogin() {
        ImagenFondo PanelVistaLogin = new ImagenFondo("/Imagenes/fondo-socosani.png");
        PanelVistaLogin.setLayout(null);
        this.getContentPane().add(PanelVistaLogin);

        // Crear el modelo de la tabla y configurar la tabla
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        // Configurar la transparencia de la tabla y sus celdas
        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);


        

        // Ingresar los Datos
        ControladorInterfaz.agregarEtiqueta(PanelVistaLogin, "USUARIO:", new Font("Roboto", Font.BOLD, 24), 25, 5, 200, 30);
        iDUsuarioField = ControladorInterfaz.agregarCampoTexto(PanelVistaLogin, new Font("Roboto", Font.PLAIN, 18), 25, 45, 300, 30);
        ControladorInterfaz.agregarEtiqueta(PanelVistaLogin, "CONTRASEÑA:", new Font("Roboto", Font.BOLD, 24), 25, 100, 200, 30);
        contrasenaField = new JPasswordField();
        contrasenaField.setFont(new Font("Roboto", Font.PLAIN, 18));
        contrasenaField.setBounds(25, 135, 300, 30);
        PanelVistaLogin.add(contrasenaField);

        // Botones
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("PlaywriteITModerna", Font.BOLD, 20));
        btnIngresar.setBounds(370, 35,160, 35);
        PanelVistaLogin.add(btnIngresar);                                                                     
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("PlaywriteITModerna", Font.BOLD, 20));
        btnSalir.setBounds(370, 120,160, 35);
        PanelVistaLogin.add(btnSalir);                                                                     
                                                                            
        JButton btnContacto = new JButton("Contactanos");
        btnContacto.setFont(new Font("PlaywriteITModerna", Font.BOLD, 20));
        btnContacto.setBounds(370, 250, 160, 35);
        PanelVistaLogin.add(btnContacto);


        // Añadir ActionListener para el botón registrar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // ActionListener para el botón "Buscar"
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        btnContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}