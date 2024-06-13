package Main;

public class sqlprueba {


    public static void main(String[] args) {
        

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("El driver JDBC para SQL Server está instalado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("El driver JDBC para SQL Server no está instalado.");
        }
        
    }
    
}
