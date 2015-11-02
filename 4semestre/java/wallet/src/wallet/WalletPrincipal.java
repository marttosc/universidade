package wallet;

import java.util.Locale;
import wallet.aux.LookAndFeel;
import wallet.telas.frames.Login;

/**
 * Classe principal.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class WalletPrincipal
{
    
    /**
     * Método principal.
     * @param args Vetor com parâmetros para linha de comando.
     */
    public static void main(String[] args)
    {
        Locale.setDefault(new Locale("pt", "BR"));
        
        LookAndFeel.nimbus();
        
        Login login = new Login();
        
        login.setVisible(true);
    }
    
}
