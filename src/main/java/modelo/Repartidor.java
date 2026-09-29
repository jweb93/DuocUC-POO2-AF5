package modelo;

/**
 * Representa un repartidor que recibirá pedido y los despachará
 */

public class Repartidor implements Runnable{
    private int id;
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    // Constructor cuando el objeto ya existe en bbdd
    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }

    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run(){
        if (zonaDeCarga !=null){
            try {
                Pedido pedidoRetirado;
                while((pedidoRetirado = zonaDeCarga.retirarPedido()) != null){
                    pedidoRetirado.setEstado(EstadoPedido.EN_REPARTO);
                    System.out.println("[Repartidor - " + nombre + "] Repartiendo " + pedidoRetirado.toString());
                    Thread.sleep(3000);

                    pedidoRetirado.setEstado(EstadoPedido.ENTREGADO);
                    System.out.println("[Repartidor - " + nombre + "] Entregó " + pedidoRetirado.toString());
                    Thread.sleep(1000); //Debe regresar a la zona de reparto a verificar si hay más pedidos
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("[Repartidor - " + nombre + "] Termina su jornada.");
        }else{
            System.out.println("[Repartidor - " + nombre + "] sin Zona de Carga asignada.");
        }

    }
}
