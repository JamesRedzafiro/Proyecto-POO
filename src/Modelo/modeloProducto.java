package Modelo;

public class modeloProducto {
    
    private int iDProducto;
    private String nombre;
    private double volumen;
    private double precio;
    private String sabor;

    // Constructor de la clase Producto
    public modeloProducto(int iDProducto,String nombre, double volumen, double precio, String sabor) {
        this.iDProducto = iDProducto;
        this.nombre = nombre;
        this.volumen = volumen;
        this.precio = precio;
        this.sabor = sabor;
    }

    // Métodos getter y setter para marca, volumen, precio y sabor
    public int getIDProducto() {
        return iDProducto;
    }

    public void setIDProducto(int iDProducto){
        this.iDProducto = iDProducto;
    }
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Producto: { Código: " + iDProducto +
               ", Nombre: '" + nombre + '\'' +
               ", Volumen: " + volumen +
               ", Precio: " + precio +
               ", Sabor: '" + sabor + '\'' +
               " }";
    }

}

    
    


