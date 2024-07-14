
package modelo;

import java.io.Serializable;
import vista.Presentacion;

public class Accesorio extends Producto implements Serializable{
    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private final double D1 = 0.75;
    private final double D2 = 0.65;

    public Accesorio(String nombre, String referencia, double precioBruto) {
        super(nombre, referencia, precioBruto);
    }
    
    @Override
    public double calcularPrecioVenta(int cantidad){
        if(cantidad<6){
            precioVenta = precioUnidad*cantidad;
        }else if (cantidad>=6 && cantidad<12){
            precioVenta = (precioBruto + precioBruto* D1)*cantidad;
        }else if(cantidad>=12){
            precioVenta = (precioBruto + precioBruto * D2)*cantidad;
        }
        return precioVenta;
    }

    @Override
    public void calcularPrecioUnidad() {
        precioUnidad = precioBruto + precioBruto * porcentajeGan;
    }

}
