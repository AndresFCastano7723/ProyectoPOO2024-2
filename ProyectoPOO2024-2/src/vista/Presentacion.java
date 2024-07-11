
package vista;

import javax.swing.JOptionPane;

public class Presentacion {
    
    public int pedirEntero(String m) {
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    public String pedirInfo(String m) {
        return JOptionPane.showInputDialog(m);
    }

    public double pedirDecimales(String m) {
        return Double.parseDouble(JOptionPane.showInputDialog(m));
    }

    public void mostrarRes(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
