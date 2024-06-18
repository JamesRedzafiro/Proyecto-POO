package Modelo;

public class modeloCompra {

    private int iDCompra;
    private modeloCliente Cliente;
    private modeloProducto Producto;
    private modeloFuncionario Funcionario;

    public modeloCompra(int iDCompra,modeloCliente cliente, modeloProducto producto, modeloFuncionario funcionario) {
        this.iDCompra = iDCompra;
        this.Cliente = cliente;
        this.Producto = producto;
        this.Funcionario = funcionario;
    }

    // Métodos getter y setter para Cliente, Producto y Funcionario
    public int getIDCompra(){
        return this.iDCompra;
    }
    public void setIdCompra(int iDCompra){
        this.iDCompra = iDCompra;
    }

    public modeloCliente getCliente() {
        return Cliente;
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

    public modeloFuncionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(modeloFuncionario funcionario) {
        this.Funcionario = funcionario;
    }
}
    

