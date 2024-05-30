package Modelo;

public class modeloProducto {
    private String marca;
    private double volumen;
    private double precio;
    private String sabor;

    // Constructor de la clase Producto
    public modeloProducto(String marca, double volumen, double precio, String sabor) {
        this.marca = marca;
        this.volumen = volumen;
        this.precio = precio;
        this.sabor = sabor;
    }

    // Métodos getter y setter para marca, volumen, precio y sabor
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

