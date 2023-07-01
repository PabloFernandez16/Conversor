/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversoralura;

import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Pablo
 */
public class DialogPersonalizado {

    public void dialogo() {
        // Crear una instancia de JDialog personalizado
        JDialog dialog = new JDialog();

        // Establecer el tamaño y el estilo del texto
        Font font = new Font("Comic Sans MS", Font.BOLD, 25);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("TextField.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("List.font", font);
        UIManager.put("ComboBox.font", font);
        
        // Establecer el tamaño de fuente para los botones del JOptionPane
        Font buttonFont = UIManager.getFont("Button.font").deriveFont(Font.CENTER_BASELINE, 18f);
        UIManager.put("Button.font", buttonFont);
        
        UIManager.put("OptionPane.background", Color.WHITE); // Establecer el color de fondo del JOptionPane
        UIManager.put("Panel.background", Color.WHITE); // Establecer el color de fondo del panel interno del JOptionPane

    }

}
