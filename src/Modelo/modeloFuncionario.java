package Modelo;

public class modeloFuncionario extends modeloPersona {
    
    private int iDFuncionario;

    public modeloFuncionario(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo){
        super(nombre, apellido, DNI, iD, direccion, telefono, correo);
        this.iDFuncionario = iD;
    }

    public int getIDFuncionario() {
        return this.iDFuncionario;
    }

    public void setIDFuncionario(int iDFuncionario) {
        this.iDFuncionario = iDFuncionario;
    }
}
