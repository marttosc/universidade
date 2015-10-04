package wallet.aux;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Classe com funções auxiliares.
 * @author Gustavo Marttos
 */
public class Helper
{
    public static void mostrarMensagem(String msg, Color clr, JLabel lbl)
    {
        lbl.setText(msg);
        lbl.setForeground(clr);
    }
    
    public static void mostrarMensagem(String msg, JLabel lbl)
    {
        mostrarMensagem(msg, Color.BLACK, lbl);
    }
}
