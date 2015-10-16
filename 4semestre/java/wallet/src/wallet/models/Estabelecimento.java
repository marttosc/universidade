package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * Classe de estabelecimento.
 * @author Jordana
 * @author Gustavo Marttos
 * @author Leandro
 */
public class Estabelecimento
{
    
    private int id;
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private String cnpj;

    public static final String PROP_CNPJ = "cnpj";

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        propertyChangeSupport.firePropertyChange(PROP_CNPJ, oldCnpj, cnpj);
    }

    private String endereco;

    public static final String PROP_ENDERECO = "endereco";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }

    private String bairro;

    public static final String PROP_BAIRRO = "bairro";

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        propertyChangeSupport.firePropertyChange(PROP_BAIRRO, oldBairro, bairro);
    }

    private String cidade;

    public static final String PROP_CIDADE = "cidade";

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        propertyChangeSupport.firePropertyChange(PROP_CIDADE, oldCidade, cidade);
    }

    private String cep;

    public static final String PROP_CEP = "cep";

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        propertyChangeSupport.firePropertyChange(PROP_CEP, oldCep, cep);
    }

    private String uf;

    public static final String PROP_UF = "uf";

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        propertyChangeSupport.firePropertyChange(PROP_UF, oldUf, uf);
    }

    private String telefone;

    public static final String PROP_TELEFONE = "telefone";

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }
    
    // Utilizado somente para não trabalhar com persistência no DB.
    public static boolean existeEstabelecimento(String cnpj)
    {
        // Retorna a lista de estabelecimentos da AreaDeTrabalho.
        List<Estabelecimento> estabelecimento = wallet.telas.AreaDeTrabalho.getEstabelecimentos();
        
        // Percorre e verifica se o estabelecimento existe, se sim, retorna verdadeiro.
        for (Estabelecimento e : estabelecimento)
        {
            if (e.getCnpj().equals(cnpj))
            {
                return true;
            }
        }
        
        return false; 
    } 
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}
