package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tienda;
import modelo.Validaciones;
import persistencia.ArchivoSerializable;
import vista.Presentacion;

public class Ejecutar {

    Validaciones vl = new Validaciones();
    Presentacion vw = new Presentacion();
    public Tienda tienda;

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
                     4. Guardar información.
                     5. Cargar información.
                     0. Salir.
                     """;
        int op;
        do {
            op = vw.pedirEntero(msg);
            switch (op) {
                case 1 ->
                    menuInventario();

                case 2 -> {
                    tienda.crearVenta();
                }

                case 3 ->
                    tienda.mostrarVentas();

                case 4 ->
                {
                    try {
                        almacenarS();
                    } catch (IOException ex) {
                        Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                case 5 -> 
                {
                    try {
                        cargarS();
                    } catch (ClassNotFoundException | IOException ex) {
                        Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

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

    private void almacenarS() throws FileNotFoundException, IOException {
        ArchivoSerializable.almacenar("mitienda.poo", this.tienda);
    }

    private void cargarS() throws FileNotFoundException, ClassNotFoundException, IOException {
        this.tienda = (Tienda) ArchivoSerializable.cargar("mitienda.poo");
    }
}
