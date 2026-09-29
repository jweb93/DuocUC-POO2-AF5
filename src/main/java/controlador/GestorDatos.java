package controlador;


import dao.EntregaDAO;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import modelo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que controla registros de BBDD y los disponibiliza en arreglos (pedidos, repartidores, entregas).
 */
public class GestorDatos {
    private ZonaDeCarga zonaDeCarga;
    private PedidoDAO pedidoDAO;
    private RepartidorDAO repartidorDAO;
    private EntregaDAO entregaDAO;

    public GestorDatos(){
        pedidoDAO = new PedidoDAO();
        repartidorDAO = new RepartidorDAO();
        entregaDAO = new EntregaDAO();
        zonaDeCarga = new ZonaDeCarga(); // Guarda los pedidos que faltan por despachar
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidoDAO.listarTodos();
    }

    public String agregarNuevoPedido(Direccion direccion, TipoPedido tipoPedido){
        return pedidoDAO.guardar(direccion, tipoPedido, EstadoPedido.PENDIENTE);
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidorDAO.listarTodos();
    }

    public String agregarNuevoRepartidor(String nombre){
        return repartidorDAO.guardar(nombre);
    }

    public ArrayList<Entrega> getEntregas(){
        return entregaDAO.allEntregas();
    }

    public String agregarNuevaEntrega(Entrega entrega){
        return entregaDAO.guardar(entrega);
    }

//    public String despacharPedidos(){
//        // Se deben obtener los pedidos, filtrarlos por aquellos con estado Pendiente, asignarlos a la zona de carga
//        // y asignar la zona de carga a los repartidores.
//
//
//        for (Pedido p : pedidoDAO.listarTodos()){
//            if(p.getEstado() == EstadoPedido.PENDIENTE){
//                try{
//                    zonaDeCarga.agregarPedido(p);
//                }catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//
//        ExecutorService executor = Executors.newFixedThreadPool(3); // Objeto que administrará 3 hilos concurrentes
//        for(Repartidor r : repartidorDAO.listarTodos()){
//            r.setZonaDeCarga(zonaDeCarga);
//            executor.execute(r);
//        }
//        executor.shutdown();
//        try{
//            boolean termino = executor.awaitTermination(1, TimeUnit.MINUTES);
//            if(termino){
//                return "Todos los pedidos han sido entregados correctamente";
//            }else{
//                return "Aun existen repartidores trabajando";
//            }
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//            return "Ha ocurrido una interrupción del servicio";
//        }
//    }

}
