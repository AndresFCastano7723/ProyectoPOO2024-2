package control;

import modelo.Tienda;
import modelo.Validaciones;
import vista.Presentacion;

public class Ejecutar {

    Validaciones vl = new Validaciones();
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
                     1. Ir a inventario.
                     2. Realizar venta.
                     3. Ver ventas.
                     0. Salir.
                     """;
        int op;
        do {
            op = vw.pedirEntero(msg);
            switch (op) {
                case 1:
                    menuInventario();
                    break;

                case 2:
                    realizarVenta();
                    tienda.crearVenta();
                    break;

                case 3:
                    tienda.mostrarVentas();
                    break;
            }
        } while (op != 0);

    }

    private void menuInventario() {
        String msg = """
                     1. Ver inventario.
                     2. Agregar producto a inventario.
                     3. Retirar producto de inventario.
                     4. Agregar cantidad a un producto.
                     5. Retirar cantidad de un producto.
                     0. Salir.
                     """;
        int op;
        do {
            op = vw.pedirEntero(msg);
            switch (op) {
                case 1 ->
                    tienda.getInventario().mostrarInventario();
                case 2 ->
                    tienda.getInventario().agregarProducto();
                case 3 -> 
                    tienda.getInventario().retirarProducto();
                case 4 ->
                    tienda.getInventario().agregarCantProducto();
                case 5 ->
                    tienda.getInventario().retirarCantProducto();
            }
        } while (op != 0);

    }

    private void realizarVenta() {
    }

    private void mostrarVentas() {
    }

    public final String defaultMessage = """
                                        ⁣⣿⣿⡿⠋⠄⡀⣿⣿⣿⣿⣿⣿⣿⠿⠛⠋⣉⣉⣉⡉⠙⠻
                                        ⣿⣿⣇⠔⠈⣿⣿⣿⣿⡿⠛⢉⣤⣶⣾⣿⣿⣿⣿⣿⣿⣦
                                        ⣿⠃⠄⢠⣾⣿⣿⠟⢁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                                        ⣿⣿⣿⣿⣿⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                                        ⣿⣿⣿⡟⠁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                                        ⣿⣿⠋⢠⣾⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿
                                        ⡿⠁⣰⣿⣿⣿⣿⣿⣿⣿⣿⠗⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿
                                        ⠁⣼⣿⣿⣿⣿⣿⣿⡿⠋⠄⠄⠄⣠⣄⢰⣿⣿⣿⣿⣿⣿
                                        ⣼⣿⣿⣿⣿⣿⣿⡇⠄⢀⡴⠚⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                                        ⢰⣿⣿⣿⣿⣿⡿⣿⣿⠴⠋⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⡟
                                        ⣿⣿⣿⣿⣿⣿⠃⠈⠁⠄⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⡟⢀
                                        ⣿⣿⣿⣿⣿⣿⠄⠄⠄⠄⢶⣿⣿⣿⣿⣿⣿⣿⣿⠏⢀⣾
                                        ⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⠋⣠⣿⣿
                                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣼⣿⣿⣿
                                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢁⣴⣿⣿⣿⣿⣿
                                        ⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢁⣴⣿⣿⣿⠗⠄⠄⣿
                                        ⠈⠻⣿⣿⣿⣿⣿⣿⠿⠛⣉⣤⣾⣿⣿⣿⣿⣇⠠⠺⣷⣿
                                        ⣦⣄⣈⣉⣉⣉⣡⣤⣶⣿⣿⣿⣿⣿⣿⣿⠉⠁⣀⣼⣿⣿
                                        """;
}
