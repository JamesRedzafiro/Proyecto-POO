package Modelo;

public class modeloCliente {

    private String nombre;
    private String apellido;
    private int DNI;
    private int iDCliente;
    private String direccion;
    private int Ruc;
    private int telefono;
    private String correo;

    public modeloCliente(String nombre, String apellido, int DNI, int iDCliente, String direccion,int RUC, int telefono, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.iDCliente = iDCliente;
        this.direccion = direccion;
        this.Ruc = RUC;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getIDCliente() {
        return this.iDCliente;
    }

    public void setIDCliente(int iDCliente) {
        this.iDCliente = iDCliente;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRuc() {
        return this.Ruc;
    }

    public void setRuc(int Ruc) {
        this.Ruc = Ruc;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
