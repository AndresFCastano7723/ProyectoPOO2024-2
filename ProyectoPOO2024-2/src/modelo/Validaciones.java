package modelo;

public class Validaciones {

    public boolean validarTexto(String n){
            return n.matches("[a-zA-Z]*") && n!="\13";
    }

    public boolean validarNumeros(String n){
            return n.matches("[0-9,.]*") && n!="\13";
    }
    
    
}
