package modelo;

import java.io.Serializable;
import javax.swing.JOptionPane;
import vista.Presentacion;

public class Artesania extends Producto implements Serializable {

    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private int valTrabajo;

    public Artesania(String nombre, String referencia, double precioBruto) {
        super(nombre, referencia, precioBruto);
    }

    @Override
    public void calcularPrecioFinal() {
            do {
                valTrabajo = vw.pedirEntero("Ingrese el porcentaje adicional de este producto\nen un rango de 0 a 100");
            } while (!vl.validarNumeros(String.valueOf(valTrabajo)));
        double per = valTrabajo / 100;
        setPrcioFinal(getPrecioBruto() + getPrecioBruto() * getPorcentajeGan() + getPrecioBruto() * per);
    }

}
