package Modelo;

public class modeloUsuario extends modeloPersona{

    private int iDUsuario;
    private String contrasena;

    public modeloUsuario(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo, String contraseña){
        super(nombre, apellido,iD, DNI, direccion, telefono, correo);
        this.iDUsuario = iD;
        this.contrasena = contraseña;
    }

    public int getIDUsuario() {
        return this.iDUsuario;
    }

    public void setIDUsuario(int iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
