package modelo;

import java.awt.Component;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Presentacion;

public class Inventario implements Serializable {

    Presentacion vw = new Presentacion();
    Validaciones vl = new Validaciones();
    private HashMap<String, Producto> productos;

    public Inventario() {
    }

    public void agregarProducto() {
        String msg = """
                    Seleccione el tipo de producto que desea agregar al inventario\n
                    1. Artesania\n
                    2. Accesorio
                    """;
        int op;
        do {
            op = vw.pedirEntero(msg);
            switch (op) {
                case 1:
                {
                        agregarArt();
                }
                    break;


                case 2:

                    break;
            }
        } while (op != 1 && op != 2);

    }

    private void agregarArt(){
        String ref;
        String dsc;
        double pb;
        do {
            ref = vw.pedirInfo("Ingrese referencia del producto");
        } while (!vl.validarNumeros(ref.trim()));
        do {
            dsc = vw.pedirInfo("Ingrese nombre del producto");
        } while (!vl.validarTexto(dsc.trim()));
    }

}
