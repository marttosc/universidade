package wallet.dao;
/**
 * @author Gustavo Marttos
 * @author Jordana
 * @author Leandro
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO
{
    private static final String HOST = "localhost";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String BASE = "skuld";
    
    private static final String URL = "jdbc:mysql://" + HOST + "/" + BASE;

    protected Connection conn;
    
    public DAO()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Erro ao localizar o driver: " + e.getMessage());   
        }
        catch(SQLException e)
        {
            System.err.println("Erro de conexão com o banco: " +e.getMessage());
        }
    }
}
