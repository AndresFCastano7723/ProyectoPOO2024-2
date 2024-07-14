package modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable {

    private String nombre;
    private String referencia;
    protected double precioBruto;
    protected double precioUnidad;
    protected double precioVenta;
    protected final double porcentajeGan = 0.2;
    private int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
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

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
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
