package ec.edu.ups.poo.clases;

import java.util.ArrayList;
import java.util.List;

public class GestorProveedor {

    private List<Proveedor> listaProveedores;

    public void agregarProveedor(Proveedor nuevoProveedor) {
        listaProveedores.add(nuevoProveedor);
        System.out.println("Proveedor agregado correctamente.");
    }

    public boolean eliminarProveedor(String identificacion) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdentificacion().equals(identificacion)) {
                listaProveedores.remove(proveedor);
                System.out.println("Proveedor eliminado.");
                return true;
            }
        }
        System.out.println("Proveedor no encontrado.");
        return false;
    }

    public Proveedor buscarProveedor(String identificacion) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdentificacion().equals(identificacion)) {
                return proveedor;
            }
        }
        System.out.println("Proveedor no encontrado.");
        return null;
    }

    public void mostrarTodosProveedores() {
        if (listaProveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor proveedor : listaProveedores) {
                System.out.println(proveedor.toString());
            }
        }
    }

    public boolean asignarProductoAProveedor(String idProveedor, Producto producto) {
        Proveedor proveedor = buscarProveedor(idProveedor);
        if (proveedor != null) {
            //proveedor.agregarProducto(producto);
            System.out.println("Producto asignado correctamente.");
            return true;
        }
        System.out.println("Proveedor no encontrado.");
        return false;
    }

    public void listarProductosDeProveedor(String idProveedor) {
        Proveedor proveedor = buscarProveedor(idProveedor);
        if (proveedor != null) {
            //proveedor.mostrarListaProductos();
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

}
