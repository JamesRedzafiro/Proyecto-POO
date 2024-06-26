package Modelo;

import java.util.Date;

public class modeloPedido {

    private int iDPedido;
    private int cantidad;
    private Date fechaPedido;
    private double totalPedido;
    private String estado;
    private modeloCliente Cliente;
    private modeloProducto Producto;
    

    public modeloPedido(int iDPedido, int cantidad, Date fechaPedido,double totalPedido, String estado, modeloCliente cliente, modeloProducto producto){
        this.iDPedido = iDPedido;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.estado = estado;
        this.Cliente = cliente;
        this.Producto = producto;
    }

    public int getIDPedido(){
        return iDPedido;
    }

    public void setIDPedido(int iDPedido){
        this.iDPedido = iDPedido;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 
    public Date getFechaPedido() {
        return this.fechaPedido;
    }

    public void setFecha(Date fecha) {
        this.fechaPedido = fecha;
    }

    public double getTotalPedido() {
        return this.totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public modeloCliente getCliente() {
        return Cliente;
    }

    public void setEstado (String estado){
        this.estado=estado;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setCliente(modeloCliente cliente) {
        this.Cliente = cliente;
    }
    
    public modeloProducto getProducto() {
        return Producto;
    }

    public void setProducto(modeloProducto producto) {
        this.Producto = producto;
    }
}
