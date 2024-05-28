package Modelo;

public class modeloPedido {

    String Producto;
    int Cantidad;
    Float Precio;
    String Fecha;

    public modeloPedido(String Producto,int Cantidad, Float Precio, String Fecha){
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Fecha = Fecha;
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
}
