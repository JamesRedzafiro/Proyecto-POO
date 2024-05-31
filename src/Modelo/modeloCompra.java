package Modelo;

public class modeloCompra {

    private modeloCliente Cliente;
    private modeloProducto Producto;
    private modeloFuncionario Funcionario;

    
    public modeloCompra(modeloCliente cliente, modeloProducto producto, modeloFuncionario funcionario) {
        this.Cliente = cliente;
        this.Producto = producto;
        this.Funcionario = funcionario;
    }

    // Métodos getter y setter para Cliente, Producto y Funcionario
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
    

