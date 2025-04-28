package ec.edu.ups.poo.clases;


import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona{

    private List<Producto> listaProductos;

    public Proveedor(String nombre, String identificacion, String telefono, String correo,
                     String direccion, List<Producto> listaProductos) {
        super(nombre, identificacion, telefono, correo, direccion);
        this.listaProductos = listaProductos;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "{nombre='" + getNombre() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                "Proveedor{" +
                "listaProductos=" + listaProductos +
                '}';
    }


}
