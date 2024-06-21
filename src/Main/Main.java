package Main;
import javax.swing.SwingUtilities;

import Vista.Interfaz.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new vistaCompra().setVisible(true);
                new vistaPedido().setVisible(true);
                //new vistaRegistrarCliente().setVisible(true);
                //new vistaBuscarCliente().setVisible(true);
                //new vistaContacto().setVisible(true);
                //new VistaAgregarProducto().setVisible(true);
            }
        });
    }
}
