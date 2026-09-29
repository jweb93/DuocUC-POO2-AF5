package vista;

import controlador.GestorDatos;
import modelo.Direccion;
import modelo.TipoPedido;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroRepartidor extends JFrame{
    private GestorDatos gestorDatos;
    private JTextField nombre;
    private JButton btnCancelar;
    private JButton btnGuardar;

    public VentanaRegistroRepartidor(GestorDatos gestorDatos){
        this.gestorDatos = gestorDatos;

        // Configuración base de la ventana
        setTitle("Registrar nuevo repartidor - SpeedFast");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de datos
        JPanel panelDatos = new JPanel(new GridLayout(0, 2));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelDatos.add(new JLabel("▸ DATOS DEL REPARTIDOR"));
        panelDatos.add(new JLabel(""));

        panelDatos.add(new JLabel("Nombre:"));
        nombre = new JTextField(20);
        panelDatos.add(nombre);

        add(panelDatos, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnCancelar = new JButton("Cancelar");
        btnGuardar = new JButton("Guardar");
        panelBotones.add(btnCancelar);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> crearRepartidor());

        btnCancelar.addActionListener(e-> dispose());
    }

    public void crearRepartidor() {
        //Validar campos
        if (!validarCampos()) {
            return;
        }

        // Enviamos el nuevo repartidor al controlador
        String respuesta = gestorDatos.agregarNuevoRepartidor(nombre.getText().trim());

        // Informamos operación exitosa
        operacionExitosa(respuesta);
        dispose();
    }

    public boolean validarCampos(){
        // Validación de nombre no vacío
        if (nombre.getText().trim().isEmpty()){
            alertarInconsistencia("Debe completar el nombre del repartidor");
            return false;
        }
        return true;
    }

    public void alertarInconsistencia(String alerta) {
        JOptionPane.showMessageDialog(
                this,
                alerta,
                "Alerta",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void operacionExitosa(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
