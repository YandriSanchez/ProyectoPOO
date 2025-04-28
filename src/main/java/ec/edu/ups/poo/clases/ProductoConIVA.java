package ec.edu.ups.poo.clases;

public class ProductoConIVA {
    private double tasaIVA;

    public ProductoConIVA(double tasaIVA) {
        this.tasaIVA = tasaIVA;
    }

    public double calcularPrecioFinal(double precioBase) {
        return precioBase * (1 + tasaIVA / 100);
    }

    public double getTasaIVA() {
        return tasaIVA;
    }

    public void setTasaIVA(double tasaIVA) {
        this.tasaIVA = tasaIVA;
    }

    @Override
    public String toString() {
        return "ProductoConIVA{" +
                "tasaIVA=" + tasaIVA +
                '}';
    }
}
