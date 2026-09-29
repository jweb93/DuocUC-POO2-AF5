
import dao.ConexionBD;
import controlador.GestorDatos;
import vista.VentanaPrincipal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase principal para ejecutar el programa
 */

public class Main {

    public static void main(String[] args) {
        GestorDatos gestorDatos = new GestorDatos();

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal(gestorDatos).setVisible(true);
        });

        try (Connection conn = ConexionBD.obtenerConexion()) {
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
