package Modelo;

public class ejemploUsuario{

    
    public static void main(String[] args) {

        modeloUsuario Usuario1 = new modeloUsuario("James", "Piñas", 72450085, 1011271, "Ventanilla", 930975180, "james.pinas@gmail.com", "james575");

        String infoUsuario = modeloUsuario.InfoUsuario(Usuario1);
        System.out.println(infoUsuario);
    
    }
        
}

