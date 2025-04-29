package ec.edu.ups.poo.clases;

public abstract class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private boolean impuesto;

    public Producto() {
    }

    public Producto(String nombre, String codigo, double precio, boolean impuesto) {
    }

    public Producto(String nombre, String codigo, double v) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isImpuesto() {
        return impuesto;
    }

    public void setImpuesto(boolean impuesto) {
        this.impuesto = impuesto;
    }
}