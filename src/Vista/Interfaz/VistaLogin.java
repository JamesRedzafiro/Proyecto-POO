package Vista.Interfaz;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;

import Controlador.ControladorInterfaz;
import Vista.Fuentes;
import Vista.ImagenFondo;

public class VistaLogin extends JFrame {
  
    private JTextField iDUsuarioField;
    private JPasswordField contrasenaField;

    private JButton btnIngresar;
    private JButton btnSalir;
    private JButton btnContacto;

    public VistaLogin() {
        this.setTitle("EMPRESA SOCOSANI: Login");
        this.setFont(Fuentes.getRobotoFont(35, Font.BOLD));
        this.setBounds(0, 0, 550, 300);
        setLayout(new BorderLayout());
        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));
        this.setLocationRelativeTo(null);

        ComponentesVistaLogin();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ComponentesVistaLogin() {
        ImagenFondo PanelVistaLogin = new ImagenFondo("/Imagenes/fondo-socosani.png");
        PanelVistaLogin.setLayout(null);
        PanelVistaLogin.setOpaque(true); // Asegurar la opacidad del panel principal
        this.getContentPane().add(PanelVistaLogin);


        // Ingresar los Datos
        ControladorInterfaz.agregarEtiqueta(PanelVistaLogin, "USUARIO:", Fuentes.getRobotoFont(24, Font.ITALIC), 10, 10, 200, 30);
        iDUsuarioField = ControladorInterfaz.agregarCampoTexto(PanelVistaLogin, Fuentes.getRobotoFont(20, Font.PLAIN), 5, 45, 200, 35);
        ControladorInterfaz.agregarEtiqueta(PanelVistaLogin, "CONTRASEÑA:", Fuentes.getRobotoFont(24, Font.ITALIC), 10, 100, 200, 30);
        contrasenaField = new JPasswordField();
        contrasenaField.setFont(Fuentes.getRobotoFont(30, Font.ITALIC));
        contrasenaField.setBounds(5, 135, 200, 35);
        PanelVistaLogin.add(contrasenaField);

        // Botones
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(Fuentes.getPlaywriteFont(20, Font.ITALIC));
        btnIngresar.setBounds(370, 44, 145, 35);
        btnIngresar.setBackground(Color.decode("#4CAF50")); // Color en formato HEX
        btnIngresar.setForeground(Color.WHITE); // Color del texto en blanco
        btnIngresar.setBorderPainted(false); // Sin borde pintado
        btnIngresar.setFocusPainted(false); // Sin enfoque pintado
        PanelVistaLogin.add(btnIngresar);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(Fuentes.getPlaywriteFont(20, Font.ITALIC));
        btnSalir.setBounds(370, 135, 145, 35);
        btnSalir.setBackground(Color.decode("#F44336")); // Color en formato HEX
        btnSalir.setForeground(Color.WHITE); // Color del texto en blanco
        btnSalir.setBorderPainted(false); // Sin borde pintado
        btnSalir.setFocusPainted(false); // Sin enfoque pintado
        PanelVistaLogin.add(btnSalir);

        btnContacto = new JButton("¿Olvidaste la contraseña?");
        btnContacto.setFont(Fuentes.getPlaywriteFont(10, Font.ITALIC));
        btnContacto.setBounds(5, 180, 160, 30);
        btnContacto.setBackground(Color.decode("#2196F3")); // Color en formato HEX
        btnContacto.setForeground(Color.WHITE); // Color del texto en blanco
        btnContacto.setBorderPainted(false); // Sin borde pintado
        btnContacto.setFocusPainted(false); // Sin enfoque pintado
        PanelVistaLogin.add(btnContacto);

        // Añadir ActionListener para el botón registrar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        // ActionListener para el botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        // ActionListener para el botón Contacto
        btnContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
    }
}
