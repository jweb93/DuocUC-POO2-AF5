package dao;

import modelo.Direccion;
import modelo.EstadoPedido;
import modelo.Pedido;
import modelo.TipoPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO {

    // Para crear un nuevo pedido en BBDD se necesita direccion, tipo y estado
    public String guardar(Direccion direccion, TipoPedido tipoPedido, EstadoPedido estadoPedido){
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, direccion.serializar());
            stmt.setString(2, tipoPedido.getDescripcion());
            stmt.setString(3, estadoPedido.getDescripcion());

            stmt.executeUpdate();
            return "Éxito al guardar el pedido en la base de datos.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar el pedido en la base de datos.";
        }
    }

    public ArrayList<Pedido> listarTodos(){
        String sql = "SELECT * FROM pedido";
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Direccion direccion;
                try{
                    String[] datos = rs.getString("direccion").split("\\|");
                    direccion = new Direccion(datos[0], Integer.parseInt(datos[1]), datos[2]);

                    pedidos.add(new Pedido (
                            rs.getInt("id"),
                            direccion,
                            TipoPedido.desdeTexto(rs.getString("tipo")),
                            EstadoPedido.desdeTexto(rs.getString("estado")))
                    );
                }catch (NumberFormatException e){
                    System.out.println("Error en el formato numérico de direccion");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    // Necesitamos un método que obtenga el objeto Pedido de BBDD mediante su id.
    // Esto con la finalidad de facilitar la lectura de entregas desde BBDD
    public Pedido getPedidoByID(int id){
        String sql = "SELECT * FROM pedido WHERE id = ?";
        Pedido pedido = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery())     {
                if (rs.next()){
                    Direccion direccion;
                    try{
                        String[] datos = rs.getString("direccion").split("\\|");
                        direccion = new Direccion(datos[0], Integer.parseInt(datos[1]), datos[2]);

                        pedido = new Pedido(
                                rs.getInt("id"),
                                direccion,
                                TipoPedido.desdeTexto(rs.getString("tipo")),
                                EstadoPedido.desdeTexto(rs.getString("estado"))
                        );

                    }catch (NumberFormatException e){
                        System.out.println("Error en el formato numérico de direccion");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }
}
