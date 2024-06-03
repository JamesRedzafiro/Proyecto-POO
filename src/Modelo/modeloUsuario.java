package Modelo;

public class modeloUsuario extends modeloPersona{

    private int iDUsuario;
    private String contrasena;

    public modeloUsuario(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo, String contrasena){
        super(nombre, apellido,iD, DNI, direccion, telefono, correo);
        this.iDUsuario = iD;
        this.contrasena = contrasena;
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
        if (contrasena.length() >= 8 && contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")) {
            this.contrasena = contrasena;
        } else {
            System.out.println("La contraseña debe tener al menos 8 caracteres y contener al menos una letra mayúscula, una letra minúscula y un número.");
        }
    }
    
    public String InfoUsuario() {
        return "Usuario: " + getNombre() + " " + getApellido() + "\n" +
               "Cedula: " + getDNI() + "\n" +
               "ID Usuario: " + iDUsuario + "\n" +
               "Direccion: " + getDireccion() + "\n" +
               "Numero de telefono: " + getTelefono() + "\n" +
               "Correo electronico: " + getCorreo() + "\n" +
               "Contraseña: " + contrasena;
    }

    public static String InfoUsuario(modeloUsuario usuario) {
        return "Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + "\n" +
               "Cedula: " + usuario.getDNI() + "\n" +
               "ID Usuario: " + usuario.getIDUsuario() + "\n" +
               "Direccion: " + usuario.getDireccion() + "\n" +
               "Numero de telefono: " + usuario.getTelefono() + "\n" +
               "Correo electronico: " + usuario.getCorreo() + "\n" +
               "Contraseña: " + usuario.getContrasena();
    }
}
