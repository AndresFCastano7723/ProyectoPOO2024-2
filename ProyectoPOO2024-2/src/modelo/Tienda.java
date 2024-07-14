package modelo;

import java.io.Serializable;
import java.util.HashMap;
import vista.Presentacion;

public class Tienda implements Serializable {

    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private Inventario inventario;
    private HashMap<String, Venta> ventas;

    public Inventario getInventario() {
        return inventario;
    }

    public HashMap<String, Venta> getVentas() {
        return ventas;
    }

    public Tienda() {
        this.inventario = new Inventario();
        this.ventas = new HashMap<String, Venta>();
    }

    public void crearVenta() {
        String id;
        String nCli;
        do {
            do {
                id = vw.pedirInfo("Ingrese ID de venta");
            } while (!vl.validarNumeros(id));
        } while (!consultarID(id));
        do {
            nCli = vw.pedirInfo("Ingrese nombre del cliente");
        } while (!vl.validarTexto(nCli));
        Venta v = new Venta(nCli, id);

        int op;
        do {
            vw.mostrarRes("Acontinuación se mostraran los productos en venta");
            inventario.mostrarInventario();
            String ref;
            do {
                do {
                    ref = vw.pedirInfo("Ingrese el ID del producto que desea agregar");
                } while (!vl.validarNumeros(ref));
            } while (!verificarIDProducto(ref));
            String msg1 = "El producto elegido es el siguiente:\n\n";
            msg1 += "Referencia:\t" + inventario.getInventario().get(ref)
                    + "\nDescripcion:\t" + inventario.getInventario().get(ref).getNombre()
                    + "\nCantidad disponible:\t" + inventario.getInventario().get(ref).getCantidad();
            vw.mostrarRes(msg1);
            int cant;
            do {
                cant = vw.pedirEntero("Ingrese la cantidad del producto que desea agregar a la venta");
            } while (!vl.validarNumeros(String.valueOf(cant)));
            Producto p = inventario.getInventario().get(ref);
            v.agregarProducto(p, cant);
            op = vw.pedirEntero("¿Desea agregar otro producto?\n1. SI\t0. NO");
        } while (op != 0);
        v.mostrarFactura();
        ventas.put(id, v);
    }
    
    public void mostrarVentas(){
        String msg = "";
        int cnt = 1;
        msg += "\tReferencia\tDescripcion\tPrecio Bruto\tCantidad\tPrecio c/u\n\n";
        for (String r : this.ventas.keySet()) {
            msg += cnt + ".\t" + ventas.get(r).getIdVenta()
                    + "\t" + ventas.get(r).getNombreCliente()
                    + "\t" + ventas.get(r).getProductos()
                    + "\t" + ventas.get(r).getValorAPagar() + "\n";
            cnt++;
        }
        vw.mostrarRes(msg);
    }

    private boolean consultarID(String id) {
        for (String r : ventas.keySet()) {
            if (!ventas.containsKey(id)) {
                vw.mostrarRes("ID no existe.");
                return false;
            }
        }
        return true;
    }

    private boolean verificarIDProducto(String id) {
        for (String i : ventas.keySet()) {
            if (id.equals(ventas.get(i).getProductos().get(id).getReferencia())) {
                vw.mostrarRes("ID ya existente.");
                return false;
            }
        }
        return true;
    }
}
