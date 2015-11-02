package wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import wallet.models.Endereco;

/**
 * Classe responsável pelas ações dos Endereços.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 */
public class EnderecoDAO extends DAO
{
    public List<Endereco> listar()
    {
        List<Endereco> enderecos = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM enderecos";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("id"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setUf(rs.getString("uf"));
                
                enderecos.add(endereco);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Endereços: " + e.getMessage());
        }
        
        return enderecos;
    }
    
    public boolean inserir(Endereco endereco)
    {
        try
        {
           String sql = "INSERT INTO enderecos (cep, logradouro, bairro, "
                   + "localidade, uf) values (?, ?, ?, ?, ?)";
           
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int seq = 1;
            
            stmt.setString(seq++, endereco.getCep());
            stmt.setString(seq++, endereco.getLogradouro());
            stmt.setString(seq++, endereco.getBairro());
            stmt.setString(seq++, endereco.getLocalidade());
            stmt.setString(seq++, endereco.getUf());
            
            if (stmt.executeUpdate() > 0) 
            {
                ResultSet rs = stmt.getGeneratedKeys();
                
                rs.next();
                
                endereco.setId(rs.getInt(1));
                
                return true;
            }   
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao inserir Endereço: " + e.getMessage());
        }
        
        return false;
    }
    
    public boolean atualizar(Endereco endereco)
    {
        try
        {
           String sql = "UPDATE enderecos SET logradouro = ?, bairro = ?, "
                   + "localidade = ?, uf = ? WHERE id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            int seq = 1;

            stmt.setString(seq++, endereco.getLogradouro());
            stmt.setString(seq++, endereco.getBairro());
            stmt.setString(seq++, endereco.getLocalidade());
            stmt.setString(seq++, endereco.getUf());
            stmt.setInt(seq++, endereco.getId());
            
            return stmt.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao inserir Endereço: " + e.getMessage());
        }
        
        return false;
    }
    
    public Endereco getById(int id)
    {
        Endereco endereco = null;
        
        try
        {
            String sql = "SELECT * FROM enderecos WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                endereco = new Endereco();
                
                endereco.setId(id);
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setLocalidade(rs.getString("localidade"));
                endereco.setUf(rs.getString("uf"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Endereço: " + e.getMessage());
        }
        
        return endereco;
    }
    
    public Endereco getByCep(String cep)
    {
        Endereco endereco = null;
        
        try
        {
            String sql = "SELECT * FROM enderecos WHERE cep = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cep);
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                endereco = new Endereco();
                
                endereco.setId(rs.getInt("id"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setLocalidade(rs.getString("localidade"));
                endereco.setUf(rs.getString("uf"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Endereço: " + e.getMessage());
        }
        
        return endereco;
    }
}
