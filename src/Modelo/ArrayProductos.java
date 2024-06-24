/*
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ArrayProductos {

    private modeloProducto[] productosSocosani;
    private String[] nombreArray;

    public ArrayProductos() {
        // Inicialización de productos existentes
        inicializarProductos();
    }

    private void inicializarProductos() {
        modeloProducto AguaMineralClasica = new modeloProducto(1001, "Agua Mineral Clásica", 0.5, 1.5, "Sin Gas");
        modeloProducto AguaMineralGas = new modeloProducto(1002, "Agua Mineral con Gas", 0.5, 1.5, "Con Gas");
        modeloProducto AguaSaborPiña = new modeloProducto(1003, "Agua Piñita Dream", 0.5, 2.5, "Piña");
        modeloProducto AguaSaborNaranja = new modeloProducto(1004, "Agua Naranja Sunset", 0.5, 2.5, "Naranja");
        modeloProducto AguaSaborPera = new modeloProducto(1005, "Agua Pera Mix", 0.5, 2.5, "Pera");
        modeloProducto AguaSaborLimon = new modeloProducto(1006, "Agua Limon Chill", 0.5, 2.5, "Limon");
        modeloProducto AguaSaborManzana = new modeloProducto(1007, "Agua Manzanita", 0.5, 2.5, "Manzana");

        productosSocosani = new modeloProducto[] {
                AguaMineralClasica,
                AguaMineralGas,
                AguaSaborPiña,
                AguaSaborNaranja,
                AguaSaborPera,
                AguaSaborLimon,
                AguaSaborManzana
        };

        actualizarnombreArray();
    }

    public void actualizarnombreArray() {
        nombreArray = new String[productosSocosani.length];
        for (int i = 0; i < productosSocosani.length; i++) {
            nombreArray[i] = productosSocosani[i].getNombre();
        }
    }

    public String[] getNombreArray() {
        return nombreArray;
    }

    public void agregarProducto(modeloProducto nuevoProducto) {
        // Crear un nuevo array temporal para los productos
        modeloProducto[] nuevosProductos = new modeloProducto[productosSocosani.length + 1];

        // Copiar los productos existentes al nuevo array
        System.arraycopy(productosSocosani, 0, nuevosProductos, 0, productosSocosani.length);

        // Agregar el nuevo producto al final del nuevo array
        nuevosProductos[productosSocosani.length] = nuevoProducto;

        // Asignar el nuevo array de productos a la variable de instancia
        productosSocosani = nuevosProductos;

        // Actualizar el array de marcas
        actualizarnombreArray();
    }

    public void imprimirProductos() {
        System.out.println("Productos Socosani:");
        for (modeloProducto producto : productosSocosani) {
            System.out.println(producto);
        }
    }

    public void imprimirMarcas() {
        System.out.println("Lista de Marcas:");
        for (String marca : nombreArray) {
            System.out.println(marca);
        }
    }

    public static void main(String[] args) {
        ArrayProductos arrayProductos = new ArrayProductos();
        arrayProductos.imprimirProductos();
        arrayProductos.imprimirMarcas();

        // Agregar un nuevo producto
        modeloProducto nuevoProducto = new modeloProducto(1008, "Agua con Sabor a Mango", 0.5, 2.5, "Mango");
        arrayProductos.agregarProducto(nuevoProducto);

        // Volver a imprimir las marcas actualizadas
        System.out.println("\nMarcas después de agregar un nuevo producto:");
        arrayProductos.imprimirMarcas();
    }
}

*/