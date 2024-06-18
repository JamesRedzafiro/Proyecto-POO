package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexionBDprueba {

    // Cadena de conexión a tu base de datos
    private static final String URL = "jdbc:sqlserver://JamesRed\\localhost:1433;databaseName=BaseDatosSocosani;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "Nadeko575.";

    // Método para insertar datos en la tabla modeloPersona
    public void insertarPersona(int id, String nombre, String apellido, int dni, String direccion, int telefono, String correo) {
        String query = "INSERT INTO modeloPersona (iD, nombre, apellido, DNI, direccion, telefono, correo) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setInt(4, dni);
            stmt.setString(5, direccion);
            stmt.setInt(6, telefono);
            stmt.setString(7, correo);

            stmt.executeUpdate();
            System.out.println("Datos insertados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }

    public void eliminarPersona(int id){
        String query = "DELETE FROM modeloPersona WHERE iD = ?";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)
            ) 
        {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Persona eliminada correctamente.");
        } catch (SQLException e) {
                    System.out.println("Error SQL: " + e.getMessage());
        }
    }

    public int getLastIdCliente() {
        int lastIdCliente = 0;
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(iD) AS lastId FROM modeloPersona") // Ajusta la consulta según tu tabla
        ) {
            if (rs.next()) {
                lastIdCliente = rs.getInt("lastId");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        return lastIdCliente;
    }
}

