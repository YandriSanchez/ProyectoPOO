package ec.edu.ups.poo.clases;

import java.util.Scanner;

public class GestorMenu {

    Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP ====="+
                    "\n1. Gestionar Proveedores"+
                    "\n2. Gestionar Productos"+
                    "\n3. Gestionar Compras"+
                    "\n4. Salir"+
                    "\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            procesarMenuPrincipal(opcion);
        } while (opcion != 4);
    }

    private void procesarMenuPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                //mostrarSubMenuProveedores();
                break;
            case 2:
                //mostrarSubMenuProductos();
                break;
            case 3:
                //mostrarSubMenuCompras();
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private void mostrarSubMenuProveedores() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PROVEEDORES =====");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Buscar proveedor por ID");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            procesarSubMenuProveedores(opcion);
        } while (opcion != 4);
    }

    private void procesarSubMenuProveedores(int opcion) {
        switch (opcion) {
            case 1:
                //gestorProveedor.agregarProveedor();
                break;
            case 2:
                //gestorProveedor.mostrarTodosProveedores();
                break;
            case 3:
                //gestorProveedor.buscarProveedor();
                break;
            case 4:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarSubMenuProductos() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            procesarSubMenuProductos(opcion);
        } while (opcion != 4);
    }

    private void procesarSubMenuProductos(int opcion) {
        switch (opcion) {
            case 1:
                //gestorCompras.registrarProducto();
                break;
            case 2:
                //gestorCompras.listarProductos();
                break;
            case 3:
                //gestorCompras.buscarProductoPorNombre();
                break;
            case 4:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarSubMenuCompras() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE SOLICITUDES DE COMPRA ====="+
                    "\n1. Registrar solicitud de compra"+
                    "\n2. Listar solicitudes de compra"+
                    "\n3. Buscar solicitud por número"+
                    "\n4. Aprobar / Rechazar solicitud"+
                    "\n5. Calcular total de una solicitud"+
                    "\n6. Volver al menú principal"+
                    "\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            procesarSubMenuCompras(opcion);
        } while (opcion != 6);
    }

    private void procesarSubMenuCompras(int opcion) {
        switch (opcion) {
            case 1:
                //gestorCompras.registrarSolicitudCompra();
                break;
            case 2:
                //gestorCompras.listarSolicitudesCompra();
                break;
            case 3:
                //gestorCompras.buscarSolicitudPorNumero();
                break;
            case 4:
                //gestorCompras.gestionarEstadoSolicitud();
                break;
            case 5:
                //gestorCompras.calcularTotalSolicitud();
                break;
            case 6:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }


}
