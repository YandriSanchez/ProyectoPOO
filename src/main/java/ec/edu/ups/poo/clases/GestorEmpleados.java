package ec.edu.ups.poo.clases;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {

    private List<Empleado> listaEmpleados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarEmpleado() {
        System.out.println("Ingrese los datos del nuevo empleado:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        String identificacion = GestorMenu.solicitarCedulaValida();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Empleado nuevoEmpleado = new Empleado(nombre, identificacion, telefono, correo, direccion, usuario, contrasena);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado correctamente.");
    }

    public void eliminarEmpleado(String identificacion) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                listaEmpleados.remove(empleado);
                System.out.println("Empleado eliminado.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    public Empleado buscarEmpleado(String identificacion) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        System.out.println("Empleado no encontrado.");
        return null;
    }

    public void mostrarTodosEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                System.out.println(empleado.toString());
            }
        }
    }
}