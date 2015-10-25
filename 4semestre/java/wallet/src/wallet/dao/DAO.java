
package wallet.dao;
/**
 * @author Gustavo Marttos
 * @author Jordana
 * @author Leandro
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Usada para criar a persistência com o banco*/

public class DAO {
    
    protected Connection conn;
    
    public DAO(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdcb:mysql:localhost/skuld";
            conn = DriverManager.getConnection(url,"root","123"); 
            
        }catch(ClassNotFoundException e){
    
            System.out.println("Erro ao localizar o Driver: "+ e.getMessage());
            
        }catch(SQLException e){
            
            System.out.println("Erro de conexão com o banco: "+e.getMessage());
            
        }
        
    } 
}
