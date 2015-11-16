package wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import wallet.models.Cartao;

public class CartaoDAO extends DAO<Cartao>
{
    @Override
    public boolean inserir(Cartao cartao)
    {
        try
        {
            String sql = "INSERT INTO cartoes (id_usuario, id_bandeira, numero, "
                    + "mes_validade, ano_validade, cvc, limite) VALUES (?, ?, ?, "
                    + "?, ?, ?, ?)";
           
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int seq = 1;
            
            stmt.setInt(seq++, cartao.getUsuario().getId());
            stmt.setInt(seq++, cartao.getBandeira().getId());
            stmt.setString(seq++, cartao.getNumero());
            stmt.setInt(seq++, cartao.getMesValidade());
            stmt.setInt(seq++, cartao.getAnoValidade());
            stmt.setInt(seq++, cartao.getCvc());
            stmt.setDouble(seq++, cartao.getLimite());
            
            if (stmt.executeUpdate() > 0) 
            {
                ResultSet rs = stmt.getGeneratedKeys();
                
                rs.next();
                
                cartao.setId(rs.getInt(1));
                
                return true;
            }   
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao inserir Cartão: " + e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean atualizar(Cartao cartao)
    {
        try
        {
            String sql = "UPDATE cartoes SET id_usuario = ?, mes_validade = ?, "
                    + "ano_validade = ?, cvc = ?, limite = ? WHERE id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            int seq = 1;
            
            stmt.setInt(seq++, cartao.getUsuario().getId());
            stmt.setInt(seq++, cartao.getMesValidade());
            stmt.setInt(seq++, cartao.getAnoValidade());
            stmt.setInt(seq++, cartao.getCvc());
            stmt.setDouble(seq++, cartao.getLimite());
            stmt.setInt(seq++, cartao.getId());
            
            return (stmt.executeUpdate() > 0);
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao atualizar Cartão: " + e.getMessage());
        }
        
        return false;
    }

    @Override
    public List<Cartao> listar()
    {
        List<Cartao> cartoes = new LinkedList<>();
        
        try
        {
            String sql = "SELECT * FROM cartoes";
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Cartao cartao = new Cartao();
                
                cartao.setId(rs.getInt("id"));
                cartao.setUsuario(new UsuarioDAO().getById(rs.getInt("id_usuario")));
                cartao.setBandeira(new BandeiraDAO().getById(rs.getInt("id_bandeira")));
                cartao.setNumero(rs.getString("numero"));
                cartao.setMesValidade(rs.getInt("mes_validade"));
                cartao.setAnoValidade(rs.getInt("ano_validade"));
                cartao.setCvc(rs.getInt("cvc"));
                cartao.setLimite(rs.getDouble("limite"));
                
                cartoes.add(cartao);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuários: " + e.getMessage());
        }
        
        return cartoes;
    }

    @Override
    public Cartao getById(int id)
    {
        Cartao cartao = null;
        
        try
        {
            String sql = "SELECT * FROM cartoes WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                cartao = new Cartao();

                cartao.setId(id);
                cartao.setUsuario(new UsuarioDAO().getById(rs.getInt("id_usuario")));
                cartao.setBandeira(new BandeiraDAO().getById(rs.getInt("id_bandeira")));
                cartao.setNumero(rs.getString("numero"));
                cartao.setMesValidade(rs.getInt("mes_validade"));
                cartao.setAnoValidade(rs.getInt("ano_validade"));
                cartao.setCvc(rs.getInt("cvc"));
                cartao.setLimite(rs.getDouble("limite"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Usuário: " + e.getMessage());
        }
        
        return cartao;
    }
    
    public Cartao getByNumero(String numero)
    {
        Cartao cartao = null;
        
        try
        {
            String sql = "SELECT * FROM cartoes WHERE numero = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, numero);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            {
                cartao = new Cartao();

                cartao.setId(rs.getInt("id"));
                cartao.setUsuario(new UsuarioDAO().getById(rs.getInt("id_usuario")));
                cartao.setBandeira(new BandeiraDAO().getById(rs.getInt("id_bandeira")));
                cartao.setNumero(rs.getString("numero"));
                cartao.setCvc(rs.getInt("cvc"));
                cartao.setMesValidade(rs.getInt("mes_validade"));
                cartao.setAnoValidade(rs.getInt("ano_validade"));
                cartao.setLimite(rs.getDouble("limite"));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao consultar Cartão: " + e.getMessage());
        }
        
        return cartao;
    }

    @Override
    public boolean excluir(Cartao cartao)
    {
        try
        {
            String sql = "DELETE FROM cartoes WHERE id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, cartao.getId());
            
            return (stmt.executeUpdate() > 0);
        }
        catch(SQLException e)
        {
            System.err.println("Erro ao excluir Cartão: " + e.getMessage());
        }
        
        return false;
    }
    
}
