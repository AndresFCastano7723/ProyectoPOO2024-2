package modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable {

    private String nombre;
    private String referencia;
    protected double precioBruto;
    protected double prcioFinal;
    protected final double porcentajeGan = 0.2;
    private int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void aumentarCantidad(int a) {
        this.cantidad += a;
    }

    public void disminuirCantidad(int a) {
        this.cantidad -= a;
    }

    public void setPrcioFinal(double prcioFinal) {
        this.prcioFinal = prcioFinal;
    }

    public double getPrcioFinal() {
        return prcioFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getPrecioBruto() {
        return precioBruto;
    }

    public double getPorcentajeGan() {
        return porcentajeGan;
    }
    
    public Producto(String nombre, String referencia, double precioBruto) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.precioBruto = precioBruto;
    }

    public abstract void calcularPrecioUnidad();
    public abstract double calcularPrecioVenta(int cantidad);
}
