
package modelo;

import java.io.Serializable;
import java.util.HashMap;

class Venta implements Serializable{
    private String fecha;
    private String nombreCliente;
    private String idVenta;
    private double valorAPagar;
    private HashMap<String, Producto> productos;

    public Venta(String fecha, String nombreCliente, String idVenta, double valorAPagar) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.idVenta = idVenta;
        this.valorAPagar = valorAPagar;
    }
    
    public void agregarProducto(String ref){
        
    }
}
