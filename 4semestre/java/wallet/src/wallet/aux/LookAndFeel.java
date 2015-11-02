package wallet.aux;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe auxiliar para utilizaçaõ de LookAndFeel
 * @author Gustavo Marttos
 */
public class LookAndFeel
{
    public static void nimbus()
    {
        try
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | 
                InstantiationException | IllegalAccessException e)
        {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
