package wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO para o banco de dados.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 * @param <E>
 */
public abstract class DAO<E>
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
            System.err.println("Erro de conexão com o banco: " + e.getMessage());
        }
    }

    /**
     * Insere um novo elemento no banco de dados.
     * @param e Objeto a ser inserido.
     * @return Se a inserção foi bem sucedida.
     */
    public abstract boolean inserir(E e);

    /**
     * Atualiza um elemento existente no banco de dados.
     * @param e Objeto a ser atualizado.
     * @return Se a atualização foi bem sucedida.
     */
    public abstract boolean atualizar(E e);
    
    /**
     * Exclui um elemento existe no banco de dados.
     * @param e Objeto a ser excluído.
     * @return Se a exclusão foi bem sucedida.
     */
    public abstract boolean excluir(E e);

    /**
     * Lista os elementos do banco de dados.
     * @return Os objetos numa LinkedList.
     */
    public abstract List<E> listar();

    /**
     * Retorna um objeto pela ID na tabela do banco de dados.
     * @param id ID do objeto.
     * @return Objeto com a ID específica.
     */
    public abstract E getById(int id);
}