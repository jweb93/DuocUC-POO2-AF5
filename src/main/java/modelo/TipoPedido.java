package modelo;

public enum TipoPedido {
    COMIDA("Comida"),
    ENCOMIENDA("Encomienda"),
    EXPRESS("Express");

    private final String descripcion;

    TipoPedido(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    // Este metodo se agrega para poder convertir de String a TipoPedido desde BBDD
    public static TipoPedido desdeTexto(String texto){
        return TipoPedido.valueOf(texto.toUpperCase());
    }
}
