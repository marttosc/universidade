package wallet.telas;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import wallet.models.Usuario;
import wallet.telas.frames.cadastros.FrameCadastroCartao;
import wallet.telas.frames.cadastros.FrameCadastroEstabelecimento;
import wallet.telas.frames.cadastros.FrameCadastroUsuario;
import wallet.telas.frames.consultas.FrameConsultaUsuario;

/**
 * Classe responsável pela área da trabalho da janela principal.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class AreaDeTrabalho extends JDesktopPane
{
    private static List<Usuario> usuarios = new LinkedList<>();
            
    private FrameCadastroUsuario cadastrarUsuario = null;
    private FrameCadastroCartao cadastrarCartao = null;
    private FrameCadastroEstabelecimento cadastrarEstabelecimento = null;
    
    private FrameConsultaUsuario consultarUsuario = null;
    
    public static List<Usuario> getUsuarios()
    {
        return usuarios;
    }
    
    public static void setUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
    
    public static Usuario getUsuario(String cpf)
    {
        Usuario usuario = null;
        
        for (Usuario u : getUsuarios())
        {
            if (u.getCPF().equals(cpf))
            {
                usuario = u;
                
                break;
            }
        }
        
        return usuario;
    }
    
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
    
    public void abrirCadastroCartao()
    {
        if (cadastrarCartao == null)
        {
            cadastrarCartao = new FrameCadastroCartao();
            
            cadastrarCartao.setVisible(true);
         
            add(cadastrarCartao);
            
            centralizar(cadastrarCartao);
        }
    }
    
    public void fecharCadastroCartao()
    {
        cadastrarCartao.dispose();
        cadastrarCartao = null;
    }
    
    public void abrirCadastroEstabelecimento()
    {
        if (cadastrarEstabelecimento == null)
        {
            cadastrarEstabelecimento = new FrameCadastroEstabelecimento();
            
            cadastrarEstabelecimento.setVisible(true);
            
            add(cadastrarEstabelecimento);
            
            centralizar(cadastrarEstabelecimento);
        }
    }
    
    public void fecharCadastroEstabelecimento()
    {
        cadastrarEstabelecimento.dispose();
        cadastrarEstabelecimento = null;
    }
    
    public void abrirConsultaUsuario()
    {
        if (consultarUsuario == null)
        {
            consultarUsuario = new FrameConsultaUsuario();
            
            consultarUsuario.setVisible(true);
            
            add(consultarUsuario);
            
            centralizar(consultarUsuario);
        }
    }
    
    public void fecharConsultaUsuario()
    {
        consultarUsuario.dispose();
        
        consultarUsuario = null;
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