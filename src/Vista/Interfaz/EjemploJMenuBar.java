package Vista.Interfaz;

import javax.swing.*;

public class EjemploJMenuBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JMenuBar");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Menú");
        JMenuItem itemAbrir = new JMenuItem("Adrian");
        JMenuItem itemGuardar = new JMenuItem("Carlos");
        JMenuItem itemSalir = new JMenuItem("Erick");
        JMenuItem itemRecargar = new JMenuItem("James");

        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemRecargar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);
        

        menuBar.add(menuArchivo);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
