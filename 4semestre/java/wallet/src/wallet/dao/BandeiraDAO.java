package wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import wallet.models.Bandeira;

/**
 * Classe responsável pelas ações das Bandeiras.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 */
public class BandeiraDAO extends DAO<Bandeira>
{

    @Override
    public boolean inserir(Bandeira bandeira)
    {
        try
        {
            String sql = "INSERT INTO bandeiras (descricao) VALUES (?)";
           
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int seq = 1;
            
            stmt.setString(seq++, bandeira.getDescricao());
            
            if (stmt.executeUpdate() > 0) 
            {
                ResultSet rs = stmt.getGeneratedKeys();
                
                rs.next();
                
                bandeira.setId(rs.getInt(1));
                
                return true;
            }   
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao inserir Bandeira: " + e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean atualizar(Bandeira bandeira)
    {
        return false;
    }

    @Override
    public boolean excluir(Bandeira bandeira)
    {
        return false;
    }

    @Override
    public List<Bandeira> listar()
    {
        List<Bandeira> bandeiras = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM bandeiras";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Bandeira bandeira = new Bandeira();
                
                bandeira.setId(rs.getInt("id"));
                bandeira.setDescricao(rs.getString("descricao"));
                
                bandeiras.add(bandeira);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Bandeiras: " + e.getMessage());
        }
        
        return bandeiras;
    }

    @Override
    public Bandeira getById(int id)
    {
        Bandeira bandeira = null;
        
        try
        {
            String sql = "SELECT * FROM bandeiras WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                bandeira = new Bandeira();

                bandeira.setId(id);
                bandeira.setDescricao(rs.getString("descricao"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Bandeira: " + e.getMessage());
        }
        
        return bandeira;
    }
    
    public Bandeira getByDescription(String descricao)
    {
        Bandeira bandeira = null;
        
        try
        {
            String sql = "SELECT * FROM bandeiras WHERE descricao LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, "%" + descricao + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                bandeira = new Bandeira();

                bandeira.setId(rs.getInt("id"));
                bandeira.setDescricao(rs.getString("descricao"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Bandeira: " + e.getMessage());
        }
        
        return bandeira;
    }
    
}
