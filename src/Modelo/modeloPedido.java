package Modelo;

public class modeloPedido {

    private int cantidad;
    private String fecha;
    private modeloCliente Cliente;
    private modeloProducto Producto;

    public modeloPedido(int cantidad, String fecha, modeloCliente cliente, modeloProducto producto){
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.Cliente = cliente;
        this.Producto = producto;
    }

    public modeloProducto getProducto() {
        return Producto;
    }

    public void setProducto(modeloProducto producto) {
        this.Producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 
    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public modeloCliente getCliente() {
        return Cliente;
    }

    public void setCliente(modeloCliente cliente) {
        this.Cliente = cliente;
    }
}
