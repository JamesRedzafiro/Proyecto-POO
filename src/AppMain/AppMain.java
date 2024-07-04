package AppMain;

import javax.swing.SwingUtilities;

import Vista.Interfaz.*;

public class AppMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // new vistaCompra().setVisible(true);
                //new vistaPedido().setVisible(true);
                //new VistaRegistrarFuncionario().setVisible(true);
                //new vistaRegistrarCliente().setVisible(true);
                // new vistaBuscarCliente().setVisible(true);
                // new vistaContacto().setVisible(true);
                //new VistaAgregarProducto().setVisible(true);
                new VistaLogin().setVisible(true);
            }
        });
    }
}
