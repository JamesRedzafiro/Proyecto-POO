package Modelo;

public class modeloChofer extends modeloPersona{

    private String licencia;
    private int iDChofer;
    private String placaVehiculo;

    public modeloChofer(String nombre, String apellido, int DNI, int iD,String direccion, int telefono, String correo, String licencia, String placaVehiculo){
        super(nombre, apellido, DNI, iD, direccion, telefono, correo);
        this.iDChofer = iD;
        this.licencia = licencia;
        this.placaVehiculo = placaVehiculo;
    }

    public String getLicencia() {
        return this.licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getIDChofer() {
        return this.iDChofer;
    }

    public void setIDChofer(int iDChofer) {
        this.iDChofer = iDChofer;
    }

    public String getPlacaVehiculo() {
        return this.placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
    
}
