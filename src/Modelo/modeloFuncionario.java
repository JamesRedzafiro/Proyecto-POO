package Modelo;

public class modeloFuncionario extends modeloPersona {
    
    private int iDFuncionario;
    private String puesto;

    public modeloFuncionario(String nombre, String apellido, int DNI, int iD, String direccion, int telefono, String correo,String puesto){
        super(nombre, apellido, DNI, iD, direccion, telefono, correo);
        this.iDFuncionario = iD;
        this.puesto = puesto;
    }

    public int getIDFuncionario() {
        return this.iDFuncionario;
    }

    public void setIDFuncionario(int iDFuncionario) {
        this.iDFuncionario = iDFuncionario;
    }

    public String getPuesto(){
        return this.puesto;
    }

    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
}
