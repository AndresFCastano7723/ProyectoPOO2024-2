package control;

import modelo.Tienda;
import vista.Presentacion;

public class Ejecutar {

    Presentacion vw = new Presentacion();
    private Tienda tienda;

    public static void main(String[] args) {
        new Ejecutar();
    }

    public Ejecutar() {
        this.tienda = new Tienda();
        this.menu();
    }

    private void menu() {
        String msg = """
                     Elija una opcion:
                     1. Operacion.
                     0. Salir.
                     """;
        int op;
        do {
            op = vw.pedirEntero(msg);
            switch (op) {
                case 1 ->
                    tienda.getInventario().agregarProducto();
            }
        } while (op != 0);

    }
}
