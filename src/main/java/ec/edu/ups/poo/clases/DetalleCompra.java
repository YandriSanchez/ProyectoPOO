package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.enums.EstadoSolicitud;
import ec.edu.ups.poo.interfaces.OperacionesCompra;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DetalleCompra implements OperacionesCompra {
    private EstadoSolicitud estado;
    private List<ItemCompra> listadoProductos;
    private GregorianCalendar fechaEmision;

    // Constructor
    public DetalleCompra(EstadoSolicitud estado, GregorianCalendar fechaEmision) {
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.listadoProductos = new ArrayList<>();
    }

    // Getters y Setters
    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public List<ItemCompra> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<ItemCompra> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public GregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(GregorianCalendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public double calculcarTotal() {
        double total = 0;
        for (ItemCompra item : listadoProductos) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void agregarItem(ItemCompra nuevoItem) {
        listadoProductos.add(nuevoItem);
        System.out.println("Producto agregado: " + nuevoItem);
    }


    public boolean removerItem(String codigoProducto) {
        for (ItemCompra item : listadoProductos) {
            if (item.getProducto().getCodigo().equals(codigoProducto)) {
                listadoProductos.remove(item);
                System.out.println("Producto removido: " + codigoProducto);
                return true;
            }
        }
        return false; // Si no se encuentra el producto
    }


    public ItemCompra buscarItem(String nombreProducto) {
        for (ItemCompra item : listadoProductos) {
            if (item.getProducto().getNombre().equalsIgnoreCase(nombreProducto)) {
                return item;
            }
        }
        return null; // Si no se encuentra el producto
    }


    /*public void mostrarResumenCompra() {
        System.out.println("Resumen de la Compra:");
        System.out.println("Fecha de emisión: " + fechaEmision.getTime());
        System.out.println("Estado: " + estado);
        System.out.println("Productos:");
        for (ItemCompra item : listadoProductos) {
            System.out.println(item);
        }
        System.out.println("Total: " + calcularTotalCompra());
    }*/
    @Override
    public String toString() {
        return "DetalleCompra{" +
                "estado=" + estado +
                ", fechaEmision=" + fechaEmision.getTime() +
                ", listadoProductos=" + listadoProductos +
                '}';
    }
}
