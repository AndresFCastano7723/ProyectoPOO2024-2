
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import vista.Presentacion;

class Venta implements Serializable{
    Presentacion vw = new Presentacion();
    Tienda t;
    private String fecha;
    private String nombreCliente;
    private String idVenta;
    private double valorAPagar;
    private HashMap<String, Producto> productos;

    public String getFecha() {
        return fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }
    
    public Venta(String nombreCliente, String idVenta) {
        this.fecha = capturarFecha();
        this.nombreCliente = nombreCliente;
        this.idVenta = idVenta;
        this.valorAPagar = calcularValor(productos);
        this.productos = new HashMap<String, Producto>();
    }
    
    public void agregarProducto(Producto p, int cant){
        String ref = p.getReferencia();
        p.setCantidad(cant);
        p.calcularPrecioVenta(cant);
        t.getInventario().retirarCantProducto(ref, cant);
        productos.put(ref, p);
    }
    
    public double calcularValor(HashMap<String,Producto> productos){
        
        double v = 0;
        for(String r : productos.keySet()){//Error NullPointerException
            if(productos.get(r) instanceof Accesorio){
                v += productos.get(r).getPrecioVenta();
            }else if(productos.get(r) instanceof Artesania){
                v += productos.get(r).getPrecioVenta();
            }
        }
        return v;
    }
    
    public String capturarFecha(){
        String fecha =
                String.valueOf(Calendar.DAY_OF_MONTH) 
                + "/" + String.valueOf(Calendar.MONTH)
                + "/" + String.valueOf(Calendar.YEAR);
        return fecha;
    }
    
    public void mostrarFactura(){
        String msg = "";
        msg+= "Fecha: " + capturarFecha()
                + "\nCliente: " + nombreCliente
                + "\nRef.   Producto    Cant.\tPrecio";
        for(String r : productos.keySet()){
            msg += productos.get(r).getReferencia()
                    + "   " + productos.get(r).getNombre()
                    + "    " + productos.get(r).getCantidad()
                    + "\t" + productos.get(r).precioVenta + "\n";
        }
        msg += "\nTotal a pagar\t\t" + calcularValor(productos);
        vw.mostrarRes(msg);
    }
}
