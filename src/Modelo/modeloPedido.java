package Modelo;

public class modeloPedido {

    private String Producto;
    private int Cantidad;
    private Float Precio;
    private String Fecha;
    private modeloCliente Cliente;


    public modeloPedido(String Producto,int Cantidad, Float Precio, String Fecha, modeloCliente cliente){
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Fecha = Fecha;
        this.Cliente = cliente;
    }

    public String getProducto() {
        return this.Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Float getPrecio() {
        return this.Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public modeloCliente getCliente() {
        return Cliente;
    }

    public void setCliente(modeloCliente cliente) {
        this.Cliente = cliente;
    }
}
