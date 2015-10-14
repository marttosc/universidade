package wallet.models;

import java.util.List;

/**
 *  @author Jordana
 *  @author Gustavo Marttos
 *  @author Leandro
 */
public class Estabelecimento {
    
    private int id;
    private String cnpj;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String telefone;
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCnpj()
    {
        return cnpj;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
    
    public static boolean existeEstabelecimento(String cnpj)
    {
        List<Estabelecimento> estabelecimento = wallet.telas.AreaDeTrabalho.getEstabelecimentos();
        
        for (Estabelecimento e : estabelecimento)
        {
            if (e.getCnpj().equals(cnpj))
            {
                return true;
            }
        }
        
        return false; 
    } 
    
}
