package Modelo;

public class modeloProducto {
    
    private int iDProducto;
    private String marca;
    private double volumen;
    private double precio;
    private String sabor;

    // Constructor de la clase Producto
    public modeloProducto(int iDProducto,String marca, double volumen, double precio, String sabor) {
        this.iDProducto = iDProducto;
        this.marca = marca;
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
       
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
}

