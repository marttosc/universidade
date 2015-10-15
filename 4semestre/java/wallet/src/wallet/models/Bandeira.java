package wallet.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Modelo para as bandeiras dos cartões.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Bandeira
{
    private List<Bandeira> padrao = new ArrayList<>();
    private boolean usarPadrao = false;
    
    private int id;
    private String nome;
    
    public Bandeira()
    {
        usarPadrao = false;
    }
    
    // Construtor utilizado somente para não trabalhar com persistência no DB.
    public Bandeira(boolean usarPadrao)
    {
        setPadrao(usarPadrao);

        if (usarPadrao)
        {
            Bandeira[] bandeiras = new Bandeira[]
            {
                new Bandeira(1, "American Express"),
                new Bandeira(2, "Elo"),
                new Bandeira(3, "MasterCard"),
                new Bandeira(4, "Visa"),
                new Bandeira(5, "Diners Club"),
            };

            this.padrao = new ArrayList<>(Arrays.asList(bandeiras));
        }
    }
    
    public Bandeira(int id, String nome)
    {
        setId(id);
        setNome(nome);
    }
    
    // Utilizado somente para não trabalhar com persistência no DB.
    public void setPadrao(boolean padrao)
    {
        this.usarPadrao = padrao;
    }
    
    // Utilizado somente para não trabalhar com persistência no DB.
    public boolean isPadrao()
    {
        return this.usarPadrao;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    // Utilizado somente para não trabalhar com persistência no DB.
    public List<Bandeira> getPadrao()
    {
        if (isPadrao())
        {
            return this.padrao;
        }
        else
        {
            return null;
        }
    }
    
    // Utilizado somente para não trabalhar com persistência no DB.
    public void adicionar(Bandeira bandeira)
    {
        this.padrao.add(bandeira);
    }
    
    
}
