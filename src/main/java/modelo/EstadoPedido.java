package modelo;

public enum EstadoPedido {
    PENDIENTE("Pendiente"),
    EN_REPARTO("En reparto"),
    ENTREGADO("Entregado");

    private final String descripcion;

    EstadoPedido(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    // Este metodo se agrega para poder convertir de String a EstadoPedido desde BBDD
    public static EstadoPedido desdeTexto(String texto){
        return EstadoPedido.valueOf(texto.toUpperCase());
    }
}