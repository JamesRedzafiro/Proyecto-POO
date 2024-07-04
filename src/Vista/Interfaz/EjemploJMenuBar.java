package Vista.Interfaz;

import javax.swing.*;

public class EjemploJMenuBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JMenuBar");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemRecargar = new JMenuItem("Recargar");

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
