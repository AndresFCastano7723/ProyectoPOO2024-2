package modelo;

import java.io.Serializable;
import vista.Presentacion;

public class Artesania extends Producto implements Serializable {

    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private int valTrabajo;

    public Artesania(String nombre, String referencia, double precioBruto) {
        super(nombre, referencia, precioBruto);
    }

    @Override
    public void calcularPrecioUnidad() {
            do {
                valTrabajo = vw.pedirEntero("Ingrese el porcentaje adicional de este producto\nen un rango de 0 a 50");
            } while (!vl.validarNumeros(String.valueOf(valTrabajo)) && valTrabajo <= 50);
        double per = (double)valTrabajo / 100;
        setPrecioUnidad(precioBruto + precioBruto * porcentajeGan + precioBruto * per);
        
    }

    @Override
    public double calcularPrecioVenta(int cantidad) {
        precioVenta = precioUnidad * cantidad;
        return precioVenta;
    }

}
