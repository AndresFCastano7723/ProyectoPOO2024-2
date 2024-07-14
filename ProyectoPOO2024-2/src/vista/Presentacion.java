
package vista;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Presentacion {
    
    public int pedirEntero(String m) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, new JTextArea(m)));
    }

    public String pedirInfo(String m) {
        return JOptionPane.showInputDialog(null, new JTextArea(m));
    }

    public double pedirDecimales(String m) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, new JTextArea(m)));
    }

    public void mostrarRes(String m) {
        JOptionPane.showMessageDialog(null, new JTextArea(m),null,JOptionPane.INFORMATION_MESSAGE);
    }
}
