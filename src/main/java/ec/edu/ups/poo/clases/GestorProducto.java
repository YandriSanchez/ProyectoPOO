package ec.edu.ups.poo.clases;

import java.util.Scanner;

public class GestorProducto {
    Scanner scanner = new Scanner(System.in);

    public Producto solicitarProducto() {

        System.out.println("Ingrese los datos del producto:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        return new Producto(nombre, codigo, precio);
    }

}
