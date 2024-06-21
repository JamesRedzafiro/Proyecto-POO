package Controlador;

public class ValidarInformacion {

    public static boolean validarNombre(String texto) {
        return texto.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+"); // Solo letras y caracteres acentuados
    }

    public static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}$"); // Exactamente 8 dígitos
    }

    public static boolean validarRUC(String ruc) {
        return ruc.matches("^[1-2]\\d{10}$"); // Empieza con 1 o 2 y tiene exactamente 10 dígitos
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("^9\\d{8}$"); // Empieza con 9 y tiene exactamente 9 dígitos
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches(".+@.+\\.com$"); // Contiene @ y termina en .com
    }
    
    public static boolean validarDouble(String decimal) {
        // Verifica que el volumen sea un número positivo con 2 decimales
        return decimal.matches("\\d+\\.\\d{2}");
    }

    public static boolean validarInt(String input) {
        return input.matches("^\\d+$"); // Verifica que la cadena contenga solo dígitos
    }
    
    

}