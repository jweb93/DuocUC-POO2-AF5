package dao;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepartidorDAO {

    public String guardar(String nombre){
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.executeUpdate();

            return "Éxtio al guardar el repartidor en la base de datos.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar el repartidor en la base de datos.";
        }
    }

    public ArrayList<Repartidor> listarTodos(){
        String sql = "SELECT * FROM repartidor";
        ArrayList<Repartidor> repartidores = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                repartidores.add(new Repartidor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return repartidores;
    }

    // Necesitamos un método que obtenga el objeto Repartidor de BBDD mediante su id.
    // Esto con la finalidad de facilitar la lectura de entregas desde BBDD
    public Repartidor getRepartidorByID(int id){
        String sql = "SELECT * FROM repartidor WHERE id = ?";
        Repartidor repartidor = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery())     {
                if (rs.next()){
                    repartidor = new Repartidor(
                            rs.getInt("id"),
                            rs.getString("nombre")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return repartidor;
    }
}
