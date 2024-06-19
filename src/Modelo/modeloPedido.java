package Modelo;

import java.util.Date;

public class modeloPedido {

    private int iDPedido;
    private int cantidad;
    private Date fecha;
    private modeloCliente Cliente;
    private modeloProducto Producto;
    

    public modeloPedido(int iDPedido, int cantidad, Date fecha, modeloCliente cliente, modeloProducto producto){
        this.iDPedido = iDPedido;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.Cliente = cliente;
        this.Producto = producto;
    }

    public int getIDPedido(){
        return iDPedido;
    }

    public void setIDPedido(int iDPedido){
        this.iDPedido = iDPedido;
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
 
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public modeloCliente getCliente() {
        return Cliente;
    }

    public void setCliente(modeloCliente cliente) {
        this.Cliente = cliente;
    }
}
