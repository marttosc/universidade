package wallet.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import wallet.aux.Password;
import wallet.models.Usuario;

/**
 * Classe responsável pelas ações dos Usuários.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public class UsuarioDAO extends DAO
{
    public List<Usuario> listar()
    {
        List<Usuario> usuarios = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM usuarios";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setPrimeiroNome(rs.getString("primeiro_nome"));
                usuario.setSegundoNome(rs.getString("segundo_nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getDate("nascimento"));
                usuario.setEndereco(new EnderecoDAO().getById(rs.getInt("id_endereco")));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setCriadoEm(rs.getTimestamp("criado_em"));
                usuario.setAtualizadoEm(rs.getTimestamp("atualizado_em"));               
                
                usuarios.add(usuario);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuários: " + e.getMessage());
        }
        
        return usuarios;
    }
    
    public boolean inserir(Usuario usuario)
    {
        try
        {
           String sql = "INSERT INTO usuarios (primeiro_nome, segundo_nome, "
                   + "cpf, nascimento, id_endereco, email, senha, renda, "
                   + "criado_em, atualizado_em) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
           
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int seq = 1;
            
            stmt.setString(seq++, usuario.getPrimeiroNome());
            stmt.setString(seq++, usuario.getSegundoNome());
            stmt.setString(seq++, usuario.getCpf());
            stmt.setDate(seq++, new Date(usuario.getNascimento().getTime()));
            stmt.setInt(seq++, usuario.getEndereco().getId());
            stmt.setString(seq++, usuario.getEmail());
            stmt.setString(seq++, usuario.getSenha());
            stmt.setDouble(seq++, usuario.getRenda());
            stmt.setTimestamp(seq++, new Timestamp(usuario.getCriadoEm().getTime()));
            stmt.setTimestamp(seq++, new Timestamp(usuario.getAtualizadoEm().getTime()));
            
            if (stmt.executeUpdate() > 0) 
            {
                ResultSet rs = stmt.getGeneratedKeys();
                
                rs.next();
                
                usuario.setId(rs.getInt(1));
                
                return true;
            }   
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao inserir Usuário: " + e.getMessage());
        }
        
        return false;
    }

    public Usuario getById(int id)
    {
        Usuario usuario = null;
        
        try
        {
            String sql = "SELECT * FROM usuarios WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                usuario = new Usuario();

                usuario.setId(id);
                usuario.setPrimeiroNome(rs.getString("primeiro_nome"));
                usuario.setSegundoNome(rs.getString("segundo_nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getDate("nascimento"));
                usuario.setEndereco(new EnderecoDAO().getById(rs.getInt("id_endereco")));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setCriadoEm(rs.getTimestamp("criado_em"));
                usuario.setAtualizadoEm(rs.getTimestamp("atualizado_em")); 
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuário: " + e.getMessage());
        }
        
        return usuario;
    }
    
    public Usuario getByEmail(String email)
    {
        Usuario usuario = null;
        
        try
        {
            String sql = "SELECT * FROM usuarios WHERE email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setPrimeiroNome(rs.getString("primeiro_nome"));
                usuario.setSegundoNome(rs.getString("segundo_nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getDate("nascimento"));
                usuario.setEndereco(new EnderecoDAO().getById(rs.getInt("id_endereco")));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setCriadoEm(rs.getTimestamp("criado_em"));
                usuario.setAtualizadoEm(rs.getTimestamp("atualizado_em")); 
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuário: " + e.getMessage());
        }
        
        return usuario;
    }
    
    public Usuario getByCpf(String cpf)
    {
        Usuario usuario = null;
        
        try
        {
            String sql = "SELECT * FROM usuarios WHERE cpf = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setPrimeiroNome(rs.getString("primeiro_nome"));
                usuario.setSegundoNome(rs.getString("segundo_nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNascimento(rs.getDate("nascimento"));
                usuario.setEndereco(new EnderecoDAO().getById(rs.getInt("id_endereco")));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setRenda(rs.getDouble("renda"));
                usuario.setCriadoEm(rs.getTimestamp("criado_em"));
                usuario.setAtualizadoEm(rs.getTimestamp("atualizado_em")); 
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuário: " + e.getMessage());
        }
        
        return usuario;
    }
    
    public Usuario login(String cpf, String senha)
    {
        try
        {
            String sql = "SELECT id, senha FROM usuarios WHERE cpf = ?";
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                if (Password.isValid(senha, rs.getString("senha")))
                {
                    return getById(rs.getInt("id"));
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuário: " + e.getMessage());
        }
        
        return null;
    }
}
