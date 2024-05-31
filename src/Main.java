import javax.swing.SwingUtilities;

import Vista.Interfaz.vistaBuscarCliente;
import Vista.Interfaz.vistaCompra;
import Vista.Interfaz.vistaContacto;
import Vista.Interfaz.vistaPedido;
import Vista.Interfaz.vistaRegistrarCliente;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new vistaCompra().setVisible(true);
                new vistaPedido().setVisible(true);
                //new vistaRegistrarCliente().setVisible(true);
                //new vistaBuscarCliente().setVisible(true);
                // new vistaContacto().setVisible(true);
            // 
        }
        });
    }
}
