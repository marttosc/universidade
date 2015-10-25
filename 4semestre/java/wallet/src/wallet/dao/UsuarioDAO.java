package wallet.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import wallet.models.Usuario;

/**
 * @author Gustavo Marttos
 * @author Jordana
 * @author Leandro
 */

public class UsuarioDAO extends DAO {
    
    public boolean inserir(Usuario u)
    {
        try{
           String sql = "insert into usuario (id,primeiro_nome,segundo_nome,cpf,"
                   + "nascimento,id_endereco,email,senha,criado_em,atualizado_em)"
                   + " values (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getPrimeiroNome());
            stmt.setString(3, u.getSegundoNome());
            stmt.setString(4, u.getCPF());
            stmt.setDate(5, (Date) u.getNascimento());
            //stmt.setInt (6, u.getIdEndereco());
            stmt.setString(7, u.getEmail());
            //stmt.setString(8, u.getSenha());
            //stmt.setDate(9, u.getCriadoEm());
            //stmt.setDate(10, u.getAtualizadoEm());
            
            
            if(stmt.executeUpdate()>0) 
            {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                u.setId(rs.getInt(1));
                return true;
            }   
        }catch(SQLException e){
            System.out.println("Erro ao inserir: "+e.getMessage());
        }
        return false;
    }
    public List<Usuario> listar() {
        List<Usuario> lst = new LinkedList<>();
        try
        {
            String sql = "select * from usuario;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Usuario us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setPrimeiroNome(rs.getString("primeiro_nome"));
                us.setSegundoNome(rs.getString("segundo_nome"));
                us.setCPF(rs.getString("cpf"));
                us.setNascimento(rs.getDate("nascimento"));
                us.setEndereco (rs.getString("endereco"));
                us.setEmail(rs.getString("email"));
              //us.setSenha(rs.getString("senha"));
              //us.setCriadoEm(rs.getDate("criado_em"));
              //us.setAtualizadoEm(rs.getDate("atualizado_em"));               
                
                lst.add(us);
            }
        }catch(SQLException e)
        {
            System.out.println("Erro ao consultar: "+e.getMessage());
        }
        return lst;
    }
    
    //recebe um id e retorna um objeto Cliente
    public Usuario getById(int id)
    {
        Usuario us = null;
        try{
            String sql = "select * from usuario where id=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                us = new Usuario();
                us.setId(id);
                us.setPrimeiroNome(rs.getString("primeiro_nome"));
                us.setSegundoNome(rs.getString("segundo_nome"));
                us.setCPF(rs.getString("cpf"));
                us.setNascimento(rs.getDate("nascimento"));
                us.setEndereco (rs.getString("endereco"));
                us.setEmail(rs.getString("email"));
              //us.setSenha(rs.getString("senha"));
              //us.setCriadoEm(rs.getDate("criado_em"));
              //us.setAtualizadoEm(rs.getDate("atualizado_em")); 
            }
        }catch(SQLException e){
            System.out.println("erro"+e.getMessage());
        }
        return us;
    }
    
    
}
