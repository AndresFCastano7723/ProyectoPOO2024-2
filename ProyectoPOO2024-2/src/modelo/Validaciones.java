package modelo;

import java.io.Serializable;

public class Validaciones implements Serializable{

    public boolean validarTexto(String n){
            return n.matches("[a-zA-Z]*");
    }

    public boolean validarNumeros(String n){
            return n.matches("[0-9,.]*");
    }
    
    
}
