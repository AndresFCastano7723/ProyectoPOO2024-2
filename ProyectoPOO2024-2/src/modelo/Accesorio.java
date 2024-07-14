
package modelo;

import vista.Presentacion;

public class Accesorio extends Producto {
    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private final double D1 = 0.75;
    private final double D2 = 0.65;

    public Accesorio(String nombre, String referencia, double precioBruto) {
        super(nombre, referencia, precioBruto);
    }
    
    @Override
    public double calcularPrecioVenta(int cantidad){
        double prcVen = 0;
        if(cantidad<6){
            prcVen = prcioFinal*cantidad;
        }else if (cantidad>=6 && cantidad<12){
            prcVen = (precioBruto + precioBruto* D1)*cantidad;
        }else if(cantidad>=12){
            prcVen = (precioBruto + precioBruto * D2)*cantidad;
        }
        return prcVen;
    }

    @Override
    public void calcularPrecioUnidad() {
        prcioFinal = precioBruto + precioBruto * porcentajeGan;
    }

}
