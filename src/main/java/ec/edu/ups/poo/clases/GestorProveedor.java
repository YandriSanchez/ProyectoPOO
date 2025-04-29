package ec.edu.ups.poo.clases;

import java.util.*;

public class GestorProveedor {

    private final List<Proveedor> listaProveedores = new ArrayList<>();
    private List<ProductoConImpuesto> listaProductosConImpuestos;
    private List<ProductoSinImpuesto> listaProductosSinImpuestos;
    private List<? extends Producto> listaProductos;
    Scanner scanner = new Scanner(System.in);

    public void agregarProveedor() {
        GestorProducto gestorProducto = new GestorProducto();
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

        System.out.print("¿El proveedor tiene productos con impuestos? (true/false): ");
        boolean tieneImpuesto = scanner.nextBoolean();

        if(tieneImpuesto){
            listaProductosConImpuestos = new ArrayList<>();
            listaProductosConImpuestos.add(gestorProducto.solicitarProductoConImpuesto());
        } else {
            listaProductosSinImpuestos = new ArrayList<>();
            listaProductosSinImpuestos.add(gestorProducto.solicitarProductoSinImpuesto());
        }
        System.out.println("Producto agregado correctamente ");
        listaProductos = listaProductosSinImpuestos;
        Proveedor nuevoProveedor = new Proveedor(nombre, identificacion, telefono, correo, direccion, tieneImpuesto,
                listaProductos);
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
        if(proveedorEncontrado.isImpuesto()){
            listaProductosConImpuestos = new ArrayList<>();
            listaProductosConImpuestos.add(gestorProducto.solicitarProductoConImpuesto());
            listaProductos = listaProductosConImpuestos;
        } else {
            listaProductosSinImpuestos = new ArrayList<>();
            System.out.println("Ingrese los productos sin impuestos:");
            listaProductosSinImpuestos.add(gestorProducto.solicitarProductoSinImpuesto());
            listaProductos = listaProductosSinImpuestos;
        }
        System.out.println("Producto agregado correctamente ");
    }

    /*public void proveedoresporDefecto() {
        List<Proveedor> proveedoresPorDefecto = Arrays.asList(
                new Proveedor("ElectroTech S.A.", "1712345678", "0987654321", "ventas@electrotech.ec", "Av. 6 de Diciembre 123",
                        Arrays.asList(
                                new Producto("Smartphone Samsung", "SAM001", 899.99),
                                new Producto("Laptop Dell XPS", "DEL002", 1350.50),
                                new Producto("Tablet Lenovo Tab", "LEN003", 450.75),
                                new Producto("Auriculares Sony WH-1000XM4", "SON004", 299.99),
                                new Producto("Monitor LG UltraWide", "LG005", 320.00),
                                new Producto("Teclado mecánico Corsair", "COR006", 110.00),
                                new Producto("Mouse inalámbrico Logitech", "LOG007", 49.99)
                        )
                ),

                new Proveedor("Hogar y Diseño", "1809876543", "0996543210", "contacto@hogardiseno.ec", "Calle Bolívar 456",
                        Arrays.asList(
                                new Producto("Sofá de cuero", "SOF001", 750.00),
                                new Producto("Mesa de comedor", "COM002", 420.00),
                                new Producto("Silla ergonómica", "SIL003", 280.00),
                                new Producto("Lámpara de pie", "LAM004", 150.00),
                                new Producto("Colchón viscoelástico", "COL005", 600.00),
                                new Producto("Estantería metálica", "EST006", 240.00),
                                new Producto("Cama King Size", "CAM007", 720.00)
                        )
                ),

                new Proveedor("AutoPartes Ecuador", "0912345678", "0965432109", "info@autopartes.ec", "Av. Amazonas 789",
                        Arrays.asList(
                                new Producto("Aceite sintético Mobil", "ACE001", 55.00),
                                new Producto("Filtro de aire Bosch", "FIL002", 35.50),
                                new Producto("Batería de auto LTH", "BAT003", 120.75),
                                new Producto("Luces LED Philips", "LED004", 80.99),
                                new Producto("Neumático Pirelli 225/55R17", "NEU005", 250.00),
                                new Producto("Radio multimedia Pioneer", "RAD006", 410.00),
                                new Producto("Cámara de reversa", "CAM007", 185.99)
                        )
                ),

                new Proveedor("Farmacia Vida", "1019876543", "0976543210", "farmacia@vida.ec", "Calle Sucre 321",
                        Arrays.asList(
                                new Producto("Paracetamol 500mg", "PAR001", 3.50),
                                new Producto("Ibuprofeno 400mg", "IBU002", 4.75),
                                new Producto("Jarabe para la tos", "JAR003", 6.90),
                                new Producto("Vitamina C 1000mg", "VIT004", 12.99),
                                new Producto("Antibiótico Amoxicilina", "AMO005", 7.50),
                                new Producto("Gel desinfectante", "GEL006", 2.99),
                                new Producto("Mascarillas N95", "MAS007", 10.00)
                        )
                )
        );
        listaProveedores.addAll(proveedoresPorDefecto);
    }*/
}