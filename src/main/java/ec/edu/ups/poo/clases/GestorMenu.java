package ec.edu.ups.poo.clases;

import java.util.Scanner;

public class GestorMenu {

    Scanner scanner = new Scanner(System.in);
    GestorProveedor proveedores = new GestorProveedor();

    public GestorMenu() {
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP ====="+
                    "\n1. Gestionar Proveedores"+
                    "\n2. Gestionar Empleados"+
                    "\n3. Gestionar Productos"+
                    "\n4. Gestionar Compras"+
                    "\n5. Salir"+
                    "\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarSubMenuProveedores();
                    break;
                case 2:
                    mostrarSubMenuEmpleados();
                    break;
                case 3:
                    mostrarSubMenuProductos();
                    break;
                case 4:
                    mostrarSubMenuCompras();
                    break;
                case 5:
                    System.out.println("Finalizando el Programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void mostrarSubMenuProveedores() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PROVEEDORES ====="+
                    "\n1. Registrar proveedor"+
                    "\n2. Listar proveedores"+
                    "\n3. Buscar proveedor por ID"+
                    "\n4. Eliminar proveedor por ID"+
                    "\n5. Agregar Producto a un Proveedor"+
                    "\n6. Volver al menú principal"+
                    "\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    proveedores.agregarProveedor();
                    break;
                case 2:
                    proveedores.mostrarTodosProveedores();
                    break;
                case 3:
                    proveedores.buscarProveedor(solicitarCedulaValida());
                    break;
                case 4:
                    proveedores.eliminarProveedor(solicitarCedulaValida());
                    break;
                case 5:
                    proveedores.agregarProducto(solicitarCedulaValida());
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void mostrarSubMenuEmpleados() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE EMPELADOS ====="+
                    "\n1. Registrar empleado"+
                    "\n2. Listar emepleados"+
                    "\n3. Buscar empleado por ID"+
                    "\n4. Volver al menú principal"+
                    "\n Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    //proveedores.agregarProveedor(new Proveedor());
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
        } while (opcion != 4);
    }

    private void mostrarSubMenuProductos() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS ====="+
                    "\n1. Registrar producto"+
                    "\n2. Listar productos"+
                    "\n3. Buscar producto por nombre"+
                    "\n4. Volver al menú principal"+
                    "\nSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

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
        } while (opcion != 4);
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
        } while (opcion != 6);
    }

    public static String solicitarCedulaValida() {
        Scanner scanner = new Scanner(System.in);
        String cedula;
        boolean esValida;

        do {
            System.out.print("Ingrese su número de cédula: ");
            cedula = scanner.nextLine();
            esValida = true;

            if (cedula.length() != 10 || !cedula.matches("\\d+")) esValida = false;
            else {
                int provincia = Integer.parseInt(cedula.substring(0, 2));
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                int digitoVerificador = Integer.parseInt(cedula.substring(9));

                if (provincia < 1 || provincia > 24 || tercerDigito > 6) esValida = false;
                else {
                    int suma = 0;
                    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};

                    for (int i = 0; i < 9; i++) {
                        int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
                        suma += (valor > 9) ? valor - 9 : valor;
                    }

                    if ((10 - (suma % 10)) % 10 != digitoVerificador) esValida = false;
                }
            }

            if (!esValida) System.out.println("Error: Cédula inválida. Intente nuevamente.");
        } while (!esValida);
        return cedula;
    }
}
