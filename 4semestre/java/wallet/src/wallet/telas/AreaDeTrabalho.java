package wallet.telas;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import wallet.models.Cartao;
import wallet.models.Estabelecimento;
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
    private static List<Estabelecimento> estabelecimentos = new LinkedList<>();
    private static List<Cartao> cartoes = new LinkedList<>();
            
    private FrameCadastroUsuario cadastrarUsuario = null;
    private FrameCadastroCartao cadastrarCartao = null;
    private FrameCadastroEstabelecimento cadastrarEstabelecimento = null;
    
    private FrameConsultaUsuario consultarUsuario = null;

    public AreaDeTrabalho()
    {
        Usuario usuario = new Usuario();
        
        usuario.setCPF("698.571.185-50");
        usuario.setNascimento("01/01/2001");
        usuario.setNome("Bob Louco");
        usuario.setEmail("dragon@bol.com.br");
        usuario.setEndereco("Rua do Bob");
        usuario.setBairro("Bairro Tika");
        usuario.setCEP("00000-000");
        usuario.setCidade("Cidade Tititika");
        usuario.setUF("SP");
        usuario.setRenda(39033.33);
        
        setUsuario(usuario);
    }
    
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
    
    
    public static List<Estabelecimento> getEstabelecimentos()
    {
        return estabelecimentos;
    }
    
    public static void setEstabelecimento(Estabelecimento est)
    {
        estabelecimentos.add(est);
    }
    
    public static Estabelecimento getEstabelecimento(String cnpj)
    {
        Estabelecimento est = null;
        
        for (Estabelecimento e : getEstabelecimentos())
        {
            if (e.getCnpj().equals(cnpj))
            {
                est = e;
                
                break;
            }
        }
        
        return est;
    
    }
    
    public static List<Cartao> getCartoes()
    {
        return cartoes;
    }
    
    public static void setCartao(Cartao card)
    {
        cartoes.add(card);
    }
    
    public static Cartao getCartao(String numero)
    {
        Cartao card = null;
        
        for (Cartao c : getCartoes())
        {
            if (c.getNumero().equals(numero))
            {
                card = c;
                
                break;
            }
        }
        
        return card;
    
    }
    
    public void abrirCadastroUsuario(Usuario user)
    {
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
    
    public void abrirCadastroUsuario()
    {
        abrirCadastroUsuario(null);
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