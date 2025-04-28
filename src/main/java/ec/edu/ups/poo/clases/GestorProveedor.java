package ec.edu.ups.poo.clases;

import java.util.*;

public class GestorProveedor {

    private List<Proveedor> listaProveedores = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void agregarProveedor() {
        GestorMenu gestorMenu = new GestorMenu();

        System.out.println("Ingrese los datos del nuevo proveedor:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        String identificacion = GestorMenu.solicitarCedulaValida();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        GestorProducto gestorProducto = new GestorProducto();
        listaProductos.add(gestorProducto.solicitarProducto());
        System.out.println("Producto agregado correctamente ");

        Proveedor nuevoProveedor = new Proveedor(nombre, identificacion, telefono, correo, direccion,listaProductos);

        listaProveedores.add(nuevoProveedor);
        System.out.println("Proveedor agregado correctamente.");
    }


    public void eliminarProveedor(String identificacion) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdentificacion().equals(identificacion)) {
                listaProveedores.remove(proveedor);
                System.out.println("Proveedor eliminado.");
                return;
            }
        }
        System.out.println("Proveedor no encontrado.");
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
        GestorProducto gestorProducto = new GestorProducto();
        Proveedor proveedorEncontrado = buscarProveedor(identificacion);
        listaProductos = proveedorEncontrado.getListaProductos();
        listaProductos.add(gestorProducto.solicitarProducto());
        proveedorEncontrado.setListaProductos(listaProductos);
        System.out.println("Producto agregado correctamente ");
    }
}
