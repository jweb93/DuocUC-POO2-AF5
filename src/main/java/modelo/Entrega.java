package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entrega {
    private int id;
    private Pedido pedido;
    private Repartidor repartidor;
    private LocalDate fecha;       // LocalDate.of(2026, 9, 28);
    private LocalDateTime hora;    // LocalTime.of(20, 45);

    public Entrega(int id, Pedido pedido, Repartidor repartidor, LocalDate fecha, LocalDateTime hora) {
        this.id = id;
        this.pedido = pedido;
        this.repartidor = repartidor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}
