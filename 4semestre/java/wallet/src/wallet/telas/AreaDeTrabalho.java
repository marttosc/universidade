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
    // Lista para armazenar os usuários sem persistência.
    private static List<Usuario> usuarios = new LinkedList<>();
    // Lista para armazenar os estabelecimentos sem persistência.
    private static List<Estabelecimento> estabelecimentos = new LinkedList<>();
    // Lista para armazenar os cartões sem persistência.
    private static List<Cartao> cartoes = new LinkedList<>();
            
    private FrameCadastroUsuario cadastrarUsuario = null;
    private FrameCadastroCartao cadastrarCartao = null;
    private FrameCadastroEstabelecimento cadastrarEstabelecimento = null;
    
    private FrameConsultaUsuario consultarUsuario = null;
    
    /**
     * Retorna os usuários da lista.
     * @return Os Usuários
     */
    public static List<Usuario> getUsuarios()
    {
        return usuarios;
    }
    
    /**
     * Inclui um novo usuário na lista.
     * @param usuario Modelo a ser incluído
     */
    public static void setUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
    
    /**
     * Retorna um usuário através de seu CPF.
     * @param cpf CPF sem máscara.
     * @return Modelo usuário
     */
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
    
    /**
     * Retorna os estabelecimentos da lista.
     * @return Os Estabelecimentos.
     */
    public static List<Estabelecimento> getEstabelecimentos()
    {
        return estabelecimentos;
    }
    
    /**
     * Inclui um novo estabelecimento na lista.
     * @param est Modelo a ser incluído
     */
    public static void setEstabelecimento(Estabelecimento est)
    {
        estabelecimentos.add(est);
    }
    
    /**
     * Retorna um usuário através do seu CNPJ.
     * @param cnpj CNPJ sem máscara.
     * @return Modelo estabelecimento
     */
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
    
    /**
     * Retorna os cartões da lista.
     * @return Os cartões
     */
    public static List<Cartao> getCartoes()
    {
        return cartoes;
    }
    
    /**
     * Inclui um novo cartão na lista.
     * @param card Modelo a ser incluído
     */
    public static void setCartao(Cartao card)
    {
        cartoes.add(card);
    }
    
    /**
     * Retorna o cartão através do número dele.
     * @param numero Número do cartão
     * @return Modelo cartão.
     */
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
    
    /**
     * Abre a tela de cadastro de usuário. Servirá para editar!
     * @param user Modelo de usuário
     */
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
        cadastrarUsuario.dispose();
        
        cadastrarUsuario = null;
    }
    
    /**
     * Abre a tela de cadastro de cartão.
     */
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
    
    /**
     * Fecha a tela de cadastro de cartão.
     */
    public void fecharCadastroCartao()
    {
        cadastrarCartao.dispose();
        cadastrarCartao = null;
    }
    
    /**
     * Abre a tela de cadastro de estabelecimento.
     */
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
    
    /**
     * Fecha a tela de cadastro de estabelecimento.
     */
    public void fecharCadastroEstabelecimento()
    {
        cadastrarEstabelecimento.dispose();
        cadastrarEstabelecimento = null;
    }
    
    /**
     * Abre a tela de consulta de usuários.
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
        consultarUsuario.dispose();
        
        consultarUsuario = null;
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
        
        jif.setLocation(lDsk/2 - lFrm/2, aDsk/2 - aFrm/2);
    }

}