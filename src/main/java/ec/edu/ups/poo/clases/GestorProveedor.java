package ec.edu.ups.poo.clases;

import java.util.List;
import java.util.Scanner;

public class GestorProveedor {

    private List<Proveedor> listaProveedores;
    private List<Producto> listaProductos;

    Scanner scanner = new Scanner(System.in);
    GestorMenu gestorMenu = new GestorMenu();
    GestorProducto gestorProducto = new GestorProducto();

    public GestorProveedor() {
    }

    public void agregarProveedor() {
        System.out.println("Ingrese los datos del nuevo proveedor:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        String identificacion = gestorMenu.solicitarCedulaValida();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        agregarProducto(GestorMenu.solicitarCedulaValida());

        Proveedor nuevoProveedor = new Proveedor(nombre, identificacion, telefono, correo, direccion,null);

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

    public void agregarProducto(String identificacion) {
        Proveedor proveedorEncontrado = buscarProveedor(identificacion);
        listaProductos = proveedorEncontrado.getListaProductos();
        listaProductos.add(gestorProducto.solicitarProducto());
        proveedorEncontrado.setListaProductos(listaProductos);
        System.out.println("Producto agregado correctamente ");
    }

    public void listarProductosDeProveedor(String idProveedor) {
        Proveedor proveedor = buscarProveedor(idProveedor);
        if (proveedor != null) {
            listaProductos = proveedor.getListaProductos();
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
}
