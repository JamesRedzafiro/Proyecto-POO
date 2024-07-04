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
        this.setBounds(0, 0, 550, 350);
        setLayout(new BorderLayout());
        this.setIconImages(Arrays.asList(new ImageIcon(getClass().getResource("/Imagenes/logo-socosani.png")).getImage()));
        this.setLocationRelativeTo(null);

        ComponentesVistaLogin();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ComponentesVistaLogin() {
        ImagenFondo PanelVistaLogin = new ImagenFondo("/Imagenes/fondo-socosani.png") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Rellena el fondo con color blanco
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
    
                // Dibuja la imagen de fondo a la derecha
                if (fondoImagen != null) {
                    int imgWidth = fondoImagen.getWidth(this);
                    int imgHeight = fondoImagen.getHeight(this);
                    int x = getWidth() - imgWidth; // Alinea la imagen a la derecha
                    int y = (getHeight() - imgHeight) / 2;
                    g.drawImage(fondoImagen, x, y, this);
                }
            }
        };       
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
        btnIngresar.setBounds(5, 200, 120, 35);
        btnIngresar.setBackground(Color.decode("#4CAF50")); 
        btnIngresar.setForeground(Color.WHITE); 
        btnIngresar.setBorderPainted(false); 
        btnIngresar.setFocusPainted(false); 
        btnIngresar.setHorizontalAlignment(SwingConstants.LEFT);
        PanelVistaLogin.add(btnIngresar);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(Fuentes.getPlaywriteFont(20, Font.ITALIC));
        btnSalir.setBounds(150, 200, 110, 35);
        btnSalir.setBackground(Color.decode("#F44336")); 
        btnSalir.setForeground(Color.WHITE); 
        btnSalir.setBorderPainted(false); 
        btnSalir.setFocusPainted(false); 
        //btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
        PanelVistaLogin.add(btnSalir);

        btnContacto = new JButton("¿Olvidaste la contraseña?");
        btnContacto.setFont(Fuentes.getPlaywriteFont(10, Font.ITALIC));
        btnContacto.setBounds(5, 260, 180, 30);
        btnContacto.setBackground(Color.decode("#2196F3")); 
        btnContacto.setForeground(Color.WHITE);
        btnContacto.setBorderPainted(false);
        btnContacto.setFocusPainted(false); 
        btnContacto.setHorizontalAlignment(SwingConstants.LEFT);
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
