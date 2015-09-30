package wallet;

import java.util.Locale;
import wallet.telas.TelaPrincipal;

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
        
        TelaPrincipal tela = new TelaPrincipal();
        
        tela.setVisible(true);
    }
    
}
