package ec.edu.ups.poo.clases;
import ec.edu.ups.poo.enums.TipoProductoSinIVA;

public class ProductoSinIVA {

    private TipoProductoSinIVA tipoExencion;

    public ProductoSinIVA(TipoProductoSinIVA tipoExencion) {
        this.tipoExencion = tipoExencion;
    }

    public double calcularPrecioFinal(double precioBase) {
        return precioBase;
    }

    public TipoProductoSinIVA getTipoExencion() {
        return tipoExencion;
    }

    public void setTipoExencion(TipoProductoSinIVA tipoExencion) {
        this.tipoExencion = tipoExencion;
    }

    @Override
    public String toString() {
        return "ProductoSinIVA{" +
                "tipoExencion=" + tipoExencion +
                '}';
    }
}