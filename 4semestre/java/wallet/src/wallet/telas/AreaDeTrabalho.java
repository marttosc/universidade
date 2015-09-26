package wallet.telas;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
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
            
            centralizar(cadastrarUsuario);
        }
    }
    
    public void fecharCadastroUsuario()
    {
        cadastrarUsuario.dispose();
        
        cadastrarUsuario = null;
    }
    
    protected void centralizar(JInternalFrame jif)
    {
        int lDsk = jif.getDesktopPane().getWidth();
        int aDsk = jif.getDesktopPane().getHeight();
        int lFrm = jif.getWidth();
        int aFrm = jif.getHeight();
        
        jif.setLocation(lDsk/2 - lFrm/2, aDsk/2 - aFrm/2);
    }
}
