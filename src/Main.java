import javax.swing.SwingUtilities;

import Vista.vistaBuscarCliente;
import Vista.vistaContacto;
import Vista.vistaCompra;
import Vista.vistaPedido;
import Vista.vistaRegistrarCliente;

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
            }
        });
    }
}
