
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{
    private Inventario inventario;
    private ArrayList<Venta> ventas;

    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public Tienda() {
        this.inventario = new Inventario();
    }
    
    

}
