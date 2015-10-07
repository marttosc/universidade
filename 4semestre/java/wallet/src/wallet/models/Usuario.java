package wallet.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Modelo do usuário/cliente.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Usuario
{
    private int id;
    
    private String cpf;
    
    private String nome;
    
    private Date nascimento;
    
    private String email;
    
    private String endereco;
    
    private String bairro;
    
    private String cep;
    
    private String cidade;
    
    private String uf;
    
    private Double renda;
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setCPF(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getCPF()
    {
        return this.cpf;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }
    
    public void setNascimento(String nascimento)
    {
        try
        {
            setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(nascimento));
        }
        catch (ParseException e)
        {
            System.err.println("Data inválida.");
        }
    }
    
    public Date getNascimento()
    {
        return this.nascimento;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEndereco(String endereco)       
    {
        this.endereco = endereco;
    }
    
    public String getEndereco()
    {
        return this.endereco;
    }
    
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }
    
    public String getBairro()
    {
        return this.bairro;
    }
    
    public void setCEP(String cep)
    {
        this.cep = cep;
    }
    
    public String getCEP()
    {
        return this.cep;
    }
    
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }
    
    public String getCidade()
    {
        return this.cidade;
    }
    
    public void setUF(String uf)
    {
        this.uf = uf;
    }
    
    public String getUF()
    {
        return this.uf;
    }
    
    public void setRenda(double renda)
    {
        this.renda = renda;
    }
    
    public double getRenda()
    {
        return this.renda;
    }
    
    public static boolean existeUsuario(String cpf)
    {
        List<Usuario> usuarios = wallet.telas.AreaDeTrabalho.getUsuarios();
        
        for (Usuario u : usuarios)
        {
            if (u.getCPF().equals(cpf))
            {
                return true;
            }
        }
        
        return false;
    }
}
