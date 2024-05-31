package Modelo;

public class modeloCliente extends modeloPersona {

    private int iDCliente;
    private int Ruc;


    public modeloCliente(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo, int RUC){
        super(nombre, apellido, DNI, iD, direccion, telefono, correo);
        this.iDCliente = iD;
        this.Ruc = RUC;
    }

    public int getIDCliente() {
        return this.iDCliente;
    }

    public void setIDCliente(int iDCliente) {
        this.iDCliente = iDCliente;
    }

    public int getRuc() {
        return this.Ruc;
    }

    public void setRuc(int Ruc) {
        this.Ruc = Ruc;
    }

}
