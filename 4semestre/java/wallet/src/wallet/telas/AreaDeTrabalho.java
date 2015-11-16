package wallet.telas;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import wallet.models.Cartao;
import wallet.models.Usuario;
import wallet.telas.frames.cadastros.FrameCadastroCartao;
import wallet.telas.frames.cadastros.FrameCadastroUsuario;
import wallet.telas.frames.consultas.FrameConsultaCartao;
import wallet.telas.frames.consultas.FrameConsultaUsuario;

/**
 * Classe responsável pela área da trabalho da janela principal.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class AreaDeTrabalho extends JDesktopPane
{            
    private FrameCadastroUsuario cadastrarUsuario = null;
    private FrameCadastroCartao cadastrarCartao = null;
    
    private FrameConsultaUsuario consultarUsuario = null;
    private FrameConsultaCartao consultarCartao = null;
    
    /**
     * Abre a tela de edição/cadastro de usuário.
     * @param user Modelo de usuário
     */
    public void abrirCadastroUsuario(Usuario user)
    {
        if (consultarUsuario != null)
        {
            fecharConsultaUsuario();
        }
        
        if (cadastrarUsuario == null)
        {
            if (user == null)
            {
                cadastrarUsuario = new FrameCadastroUsuario();
            }
            else
            {
                cadastrarUsuario = new FrameCadastroUsuario(user);
            }
            
            cadastrarUsuario.setVisible(true);
           
            add(cadastrarUsuario);
            
            centralizar(cadastrarUsuario);
        }
    }
    
    /**
     * Abre a tela de cadastro de usuário.
     */
    public void abrirCadastroUsuario()
    {
        abrirCadastroUsuario(null);
    }
    
    /**
     * Fecha a tela de cadastro de usuário.
     */
    public void fecharCadastroUsuario()
    {
        if (cadastrarUsuario != null)
        {
            cadastrarUsuario.dispose();
        
            cadastrarUsuario = null;
        }
    }
    
    /**
     * Abre a tela de cadastro de cartão.
     */
    public void abrirCadastroCartao()
    {
        abrirCadastroCartao(null);
    }

    /**
     * Abre a tela de edição de cartão.
     * @param cartao Cartão a ser editado.
     */
    public void abrirCadastroCartao(Cartao cartao)
    {
        if (consultarCartao != null)
        {
            fecharConsultaCartao();
        }
        
        if (cadastrarCartao == null)
        {
            if (cartao == null)
            {
                cadastrarCartao = new FrameCadastroCartao();
            }
            else
            {
                cadastrarCartao = new FrameCadastroCartao(cartao);
            }
            
            cadastrarCartao.setVisible(true);
           
            add(cadastrarCartao);
            
            centralizar(cadastrarCartao);
        }
    }
    
    /**
     * Fecha a tela de cadastro de cartão.
     */
    public void fecharCadastroCartao()
    {
        if (cadastrarCartao != null)
        {
            cadastrarCartao.dispose();
        
            cadastrarCartao = null;
        }
    }
    
    /**
     * Fecha a tela de consulta de cartão.
     */
    public void abrirConsultaCartao()
    {
        if (cadastrarCartao != null)
        {
            fecharCadastroCartao();
        }
        
        if (consultarCartao == null)
        {
            consultarCartao = new FrameConsultaCartao();
            
            consultarCartao.setVisible(true);
            
            add(consultarCartao);
            
            centralizar(consultarCartao);
        }
    }

    /**
     * Abre a tela de consulta de cartão.
     */
    public void abrirConsultaUsuario()
    {
        if (cadastrarUsuario != null)
        {
            fecharCadastroUsuario();
        }
        
        if (consultarUsuario == null)
        {
            consultarUsuario = new FrameConsultaUsuario();
            
            consultarUsuario.setVisible(true);
            
            add(consultarUsuario);
            
            centralizar(consultarUsuario);
        }
    }
    
    /**
     * Fecha a tela de consulta de usuários.
     */
    public void fecharConsultaUsuario()
    {
        if (consultarUsuario != null)
        {
            consultarUsuario.dispose();

            consultarUsuario = null;
        }
    }
    
    /**
     * fecha a tela de consulta de cartões.
     */
    public void fecharConsultaCartao()
    {
        if (consultarCartao != null)
        {
            consultarCartao.dispose();
        
            consultarCartao = null;
        }
    }
    
    /**
     * Centraliza o JInternalFrame no JDesktopPane.
     * @param jif JInternalFrame a ser centralizado
     */
    protected void centralizar(JInternalFrame jif)
    {
        int lDsk = jif.getDesktopPane().getWidth();
        int aDsk = jif.getDesktopPane().getHeight();
        int lFrm = jif.getWidth();
        int aFrm = jif.getHeight();
        
        jif.setLocation(lDsk / 2 - lFrm / 2, aDsk / 2 - aFrm / 2);
    }

}