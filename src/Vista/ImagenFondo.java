package Vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImagenFondo extends JPanel {
    protected Image fondoImagen;

    public ImagenFondo(String imagePath) {
        // Carga la imagen de fondo
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            fondoImagen = new ImageIcon(imageUrl).getImage();
        } else {
            System.err.println("No se pudo encontrar la imagen en la ruta especificada: " + imagePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Rellena el fondo con color blanco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibuja la imagen de fondo centrada
        if (fondoImagen != null) {
            int imgWidth = fondoImagen.getWidth(this);
            int imgHeight = fondoImagen.getHeight(this);
            int x = (getWidth() - imgWidth) / 2;
            int y = (getHeight() - imgHeight) / 2;
            g.drawImage(fondoImagen, x, y, this);
        }
    }
}
