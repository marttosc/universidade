package wallet.telas;

import javax.swing.JDesktopPane;
import wallet.telas.frames.cadastros.FrameCadastroCartao;
import wallet.telas.frames.cadastros.FrameCadastroUsuario;

/**
 * Classe responsável pela área da trabalho da janela principal.
 * @author Gustavo Marttos
 * @author Jordana Nogueira (Informações sobre Cadastrar Cartão)
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
    
    FrameCadastroCartao cadastrarCartao = null;
    
    public void abrirCadastroCartao()
    {
        if(cadastrarCartao == null)
        {
            cadastrarCartao = new FrameCadastroCartao();
            
            cadastrarCartao.setVisible(true);
            
            add(cadastrarCartao);
        }          
    }
    
    public void fecharCadastroCartao()
    {
        cadastrarCartao.dispose();
        
        cadastrarCartao = null;
    }
    
}
