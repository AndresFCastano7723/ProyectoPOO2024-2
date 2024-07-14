
package modelo;

import java.io.Serializable;
import java.util.HashMap;

public class Tienda implements Serializable{
    public Inventario inventario;
    private HashMap<String,Venta> ventas;

    public Inventario getInventario() {
        return inventario;
    }

    public HashMap<String,Venta> getVentas() {
        return ventas;
    }

    public Tienda() {
        this.inventario = new Inventario();
        this.ventas = new HashMap<String,Venta>();
    }
    
    public void crearVenta(){
        String id;
        String nCli;
        String fch;
        
    }

}
