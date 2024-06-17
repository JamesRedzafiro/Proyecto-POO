package Modelo;

public class modeloPersona {

    private String nombre;
    private String apellido;
    private int DNI;
    private int iD;
    private String direccion;
    private int telefono;
    private String correo;

    public modeloPersona(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo) {
        setNombre(nombre);
        setApellido(apellido);
        setDNI(DNI);
        setID(iD);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El nombre solo debe contener letras");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        if (!apellido.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El apellido solo debe contener letras");
        }
        this.apellido = apellido;
    }

    public int getDNI() {
        return this.DNI;
    }

    public void setDNI(int DNI) {
        String dniString = String.valueOf(DNI);
        if (!dniString.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos");
        }
        this.DNI = DNI;
    }

    public int getID() {
        return this.iD;
    }

    public void setID(int iD) {
        // Validación para el ID
        this.iD = iD;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        // Validación para la dirección
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        String telefonoString = String.valueOf(telefono);
        if (!telefonoString.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono debe tener 9 dígitos");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        this.correo = correo;
    }
}