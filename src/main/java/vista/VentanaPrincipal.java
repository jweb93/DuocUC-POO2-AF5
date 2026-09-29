package vista;

import controlador.GestorDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JButton btnRegistrarPedido;
    private JButton btnListarPedidos;
    private JButton btnRegistrarRepartidor;
    private JButton btnListarRepartidores;
    // private JButton btnIniciarEntregas;
    private GestorDatos gestorDatos;

    public VentanaPrincipal(GestorDatos gestorDatos){
        this.gestorDatos = gestorDatos;

        // Configuración base de la ventana
        setTitle("Gestor de pedidos - SpeedFast");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // En su interior sólo tendrá un panel central con botones
        setLayout(new BorderLayout(10, 10));

        // El panel de botones tendrá una estructura de 4 filas y 1 columna
        JPanel panelBotones = new JPanel(new GridLayout(4, 1));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        btnRegistrarPedido = new JButton("Registrar nuevo pedido");
        btnListarPedidos = new JButton("Ver lista de pedidos");
        btnRegistrarRepartidor = new JButton("Registrar nuevo repartidor");
        btnListarRepartidores = new JButton("Ver lista de repartidores");
        // btnIniciarEntregas = new JButton("Iniciar entregas");

        panelBotones.add(btnRegistrarPedido);
        panelBotones.add(btnListarPedidos);
        panelBotones.add(btnRegistrarRepartidor);
        panelBotones.add(btnListarRepartidores);
        // panelBotones.add(btnIniciarEntregas);

        add(panelBotones, BorderLayout.CENTER);

        // Acciones de los botones

        btnRegistrarPedido.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                VentanaRegistroPedido ventas = new VentanaRegistroPedido(gestorDatos);
                ventas.setLocationRelativeTo(this);
                ventas.setVisible(true);
            });
        });

        btnListarPedidos.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                VentanaListaPedidos ventas = new VentanaListaPedidos(gestorDatos);
                ventas.setLocationRelativeTo(this);
                ventas.setVisible(true);
            });
        });

        btnRegistrarRepartidor.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                VentanaRegistroRepartidor ventas = new VentanaRegistroRepartidor(gestorDatos);
                ventas.setLocationRelativeTo(this);
                ventas.setVisible(true);
            });
        });

        btnListarRepartidores.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                VentanaListaRepartidores ventas = new VentanaListaRepartidores(gestorDatos);
                ventas.setLocationRelativeTo(this);
                ventas.setVisible(true);
            });
        });

//        btnIniciarEntregas.addActionListener(e -> {
//            SwingUtilities.invokeLater(() -> {
//                VentanaDespacho ventas = new VentanaDespacho(gestorDatos);
//                ventas.setLocationRelativeTo(this);
//                ventas.setVisible(true);
//            });
//        });
    }

}
