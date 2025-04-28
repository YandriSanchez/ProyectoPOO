package ec.edu.ups.poo.clases;

public class ProductoEnPromocion {
    private double descuento;

    public ProductoEnPromocion(double descuento) {
        this.descuento = descuento;
    }

    public double calcularPrecioFinal(double precioBase) {
        return precioBase * (1 - descuento / 100);
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ProductoEnPromocion{" +
                "descuento=" + descuento +
                '}';
    }
}
