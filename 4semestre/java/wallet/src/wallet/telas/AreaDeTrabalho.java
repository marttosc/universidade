package wallet.telas;

import javax.swing.JDesktopPane;
import wallet.telas.frames.cadastros.FrameCadastroUsuario;

/**
 * Classe responsável pela área da trabalho da janela principal.
 * @author Gustavo Marttos
 */
public class AreaDeTrabalho extends JDesktopPane
{
    FrameCadastroUsuario cadastrarUsuario = null;
    
    public void abrirCadastroUsuario()
    {
        if (cadastrarUsuario == null)
        {
            cadastrarUsuario = new FrameCadastroUsuario();
            
            cadastrarUsuario.setVisible(true);
            
            add(cadastrarUsuario);
        }
    }
    
    public void fecharCadastroUsuario()
    {
        cadastrarUsuario.dispose();
        
        cadastrarUsuario = null;
    }
}
