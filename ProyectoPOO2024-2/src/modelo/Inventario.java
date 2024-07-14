package modelo;

import java.io.Serializable;
import java.util.HashMap;
import vista.Presentacion;

public class Inventario implements Serializable {

    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private HashMap<String, Producto> inventario;

    public Inventario() {
        this.inventario = new HashMap<String, Producto>();
    }

    public void agregarProducto() {
        String ref;
        String dsc;
        double pb;
        int c;
        do {
            do {
                ref = vw.pedirInfo("Ingrese referencia del producto");
            } while (!vl.validarNumeros(ref.trim()));
        } while (!verificarID(ref));

        do {
            dsc = vw.pedirInfo("Ingrese nombre del producto");
        } while (!vl.validarTexto(dsc.trim()));
        do {
            pb = vw.pedirDecimales("Ingrese precio bruto del producto");
        } while (!vl.validarNumeros(String.valueOf(pb)));

        String msg = """
                    Seleccione el tipo de producto que desea agregar al inventario:
                    1. Artesania.
                    2. Accesorio.
                    """;
        int op;
        op = vw.pedirEntero(msg);
        switch (op) {
            case 1 -> {
                Producto art = new Artesania(dsc, ref, pb);
                art.calcularPrecioUnidad();
                do {
                    c = vw.pedirEntero("Ingrese la cantidad a ingresar de este producto");
                } while (!vl.validarNumeros(String.valueOf(c)));
                art.aumentarCantidad(c);
                this.inventario.put(ref, art);
                String pInfo = ""
                        + "Este es el producto ingresado:"
                        + "\nReferencia: " + ref
                        + "\nDescripcion: " + dsc
                        + "\nPrecio Bruto: " + pb
                        + "\nPrecio de venta por unidad: " + art.prcioFinal
                        + "\nCantidad: " + c;
                vw.mostrarRes(pInfo);
            }

            case 2 -> {
                Producto acc = new Accesorio(dsc, ref, pb);
                acc.calcularPrecioUnidad();
                do {
                    c = vw.pedirEntero("Ingrese la cantidad a ingresar de este producto");
                } while (!vl.validarNumeros(String.valueOf(c)));
                acc.aumentarCantidad(c);
                this.inventario.put(ref, acc);
                String pInfo2 = ""
                        + "Este es el producto ingresado:"
                        + "\nReferencia: " + ref
                        + "\nDescripcion: " + dsc
                        + "\nPrecio Bruto: " + pb
                        + "\nPrecio de venta por unidad: " + acc.prcioFinal
                        + "\nCantidad: " + c;
                vw.mostrarRes(pInfo2);
            }
        }
    }
    
    public void agregarCantProducto(){
        String msg = "";
        int cnt = 1;
        msg += "\tReferencia\tDescripcion\tPrecio Bruto\tCantidad\tPrecio c/u\n\n";
        for (String r : this.inventario.keySet()) {
            msg += cnt + ".\t" + inventario.get(r).getReferencia()
                    + "\t" + inventario.get(r).getNombre()
                    + "\t" + inventario.get(r).getPrecioBruto()
                    + "\t" + inventario.get(r).getCantidad()
                    + "\t" + inventario.get(r).prcioFinal + "\n";
            cnt++;
        }
        msg += "\n\nIngrese el ID del producto a agregar.";
        String id = vw.pedirInfo(msg);
        int c;
        do {
            c = vw.pedirEntero("Ingrese la cantidad a agregar");
        } while (!validarCantidad(id, c));
        inventario.get(id).aumentarCantidad(c);
    }

    public void retirarProducto() {
        String id;
        String msg = "";
        int cnt = 1;
        msg += "\tReferencia\tDescripcion\tPrecio Bruto\tCantidad\tPrecio c/u\n\n";
        for (String r : this.inventario.keySet()) {
            msg += cnt + ".\t" + inventario.get(r).getReferencia()
                    + "\t" + inventario.get(r).getNombre()
                    + "\t" + inventario.get(r).getPrecioBruto()
                    + "\t" + inventario.get(r).getCantidad()
                    + "\t" + inventario.get(r).prcioFinal + "\n";
            cnt++;
        }
        msg += "\n\nIngrese el ID del producto que desea retirar.";
        do {
            do {
                id = vw.pedirInfo(msg);
            } while (!vl.validarNumeros(id));
        } while (!consultarID(id));
        String msg1 = "El producto elegido es el siguiente:\n\n";
        msg1 += inventario.get(id).getReferencia()
                + "\t" + inventario.get(id).getNombre()
                + "\t" + inventario.get(id).getPrecioBruto()
                + "\t" + inventario.get(id).getCantidad()
                + "\t" + inventario.get(id).prcioFinal
                + "\n"
                + "\n1. Confirmar."
                + "\n2. Cancelar";
        int op;
        do {
            op = vw.pedirEntero(msg1);
        } while (!vl.validarNumeros(String.valueOf(op)));
        switch (op) {
            case 1 -> {
                inventario.remove(id);
                vw.mostrarRes("Producto retirado.");
            }
            case 2 -> {
                vw.mostrarRes("Cancelado con exito.");
            }
        }
    }

    public void retirarCantProducto() {
        String msg = "";
        int cnt = 1;
        msg += "\tReferencia\tDescripcion\tPrecio Bruto\tCantidad\tPrecio c/u\n\n";
        for (String r : this.inventario.keySet()) {
            msg += cnt + ".\t" + inventario.get(r).getReferencia()
                    + "\t" + inventario.get(r).getNombre()
                    + "\t" + inventario.get(r).getPrecioBruto()
                    + "\t" + inventario.get(r).getCantidad()
                    + "\t" + inventario.get(r).prcioFinal + "\n";
            cnt++;
        }
        msg += "\n\nIngrese el ID del producto a retirar.";
        String id = vw.pedirInfo(msg);
        int c;
        do {
            c = vw.pedirEntero("Ingrese la cantidad a retirar");
        } while (!validarCantidad(id, c));
        retirarCantProducto(id, c);
    }

    public void retirarCantProducto(String id, int cantidad) {
        inventario.get(id).disminuirCantidad(cantidad);
    }

    public void mostrarInventario() {
        String msg = "";
        int cnt = 1;
        msg += "\tReferencia\tDescripcion\tPrecio Bruto\tCantidad\tPrecio c/u\n\n";
        for (String r : this.inventario.keySet()) {
            msg += cnt + ".\t" + inventario.get(r).getReferencia()
                    + "\t" + inventario.get(r).getNombre()
                    + "\t" + inventario.get(r).getPrecioBruto()
                    + "\t" + inventario.get(r).getCantidad()
                    + "\t" + inventario.get(r).prcioFinal + "\n";
            cnt++;
        }
        vw.mostrarRes(msg);
    }

    private boolean verificarID(String id) {
        for (String i : inventario.keySet()) {
            if (id.equals(inventario.get(i).getReferencia())) {
                vw.mostrarRes("ID ya existente.");
                return false;
            }
        }
        return true;
    }

    private boolean consultarID(String id) {
        for (String r : inventario.keySet()) {
            if (!inventario.containsKey(id)) {
                vw.mostrarRes("ID no existe.");
                return false;
            }
        }
        return true;
    }

    private boolean validarCantidad(String id, int cantidad) {
        if (cantidad > inventario.get(id).getCantidad()) {
            vw.mostrarRes("""
                          No puede retirar una cantidad mayor a la que 
                          se encuentra disponible en el inventario""");
            return false;
        }
        return true;
    }

}
