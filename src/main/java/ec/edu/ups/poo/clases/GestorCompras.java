package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class GestorCompras{
    private List<DetalleCompra> listaCompras = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private EstadoSolicitud estado;

    public void registrarSolicitudCompra() {
        System.out.println("Ingrese el estado de la solicitud (SOLICITADA, EN_REVISION, APROBADA, RECHAZADA): ");
        estado = EstadoSolicitud.valueOf(scanner.next().toUpperCase());
        DetalleCompra nuevaCompra = new DetalleCompra(estado, new GregorianCalendar());
        listaCompras.add(nuevaCompra);
        System.out.println("Solicitud de compra registrada.");
    }


    public void listarSolicitudesCompra() {
        if (listaCompras.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
        } else {
            for (DetalleCompra compra : listaCompras) {
                System.out.println(compra.toString());
            }
        }
    }

    public DetalleCompra buscarSolicitudPorNumero(int numero) {
        if (numero >= 0 && numero < listaCompras.size()) {
            return listaCompras.get(numero);
        }
        System.out.println("Solicitud no encontrada.");
        return null;
    }

    public void gestionarEstadoSolicitud(int numero, EstadoSolicitud nuevoEstado) {
        DetalleCompra compra = buscarSolicitudPorNumero(numero);
        if (compra != null) {
            compra.setEstado(nuevoEstado);
            System.out.println("✅ Estado actualizado a: " + nuevoEstado);
        }
    }

    public void calcularTotalSolicitud(int numero) {
        DetalleCompra compra = buscarSolicitudPorNumero(numero);
        if (compra != null) {
            System.out.println("💰 Total de la compra: " + compra.calculcarTotal()); // Usa el método de la interfaz
        }
    }


    public int NumeroBuscar(){
        System.out.println("Ingrese el numero dependiendo del orden de Compras: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    public EstadoSolicitud nuevoEstado(){
        System.out.println("Ingrese el nuevo estado de la compra: "+
                "\nSOLICITADA"+
                "\nEN_REVISION"+
                "\nAPROVADA"+
                "\nRECHAZADA");
        return EstadoSolicitud.valueOf(scanner.next().toUpperCase());
    }

}
