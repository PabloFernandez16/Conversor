/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversormodedasalura;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

/**
 *
 * @author Pablo
 */
public class ConversorModedasALURA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int deseaSeguir = -1;
 
        CsLogica logica = new CsLogica();
        do{
            logica.elejirConversor();
            deseaSeguir = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?",
                    "Alerta",JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            
            
        }while (deseaSeguir == 0); 

    }

}
