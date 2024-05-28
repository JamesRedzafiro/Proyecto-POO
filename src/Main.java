import javax.swing.SwingUtilities;

import Vista.vistaCompra;
import Vista.vistaPedido;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vistaCompra().setVisible(true);
                new vistaPedido().setVisible(true);
            }
        });
    }
}
