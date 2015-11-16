package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Modelo do endereço (base dos Correios).
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 */
public class Endereco
{
    private transient final PropertyChangeSupport propertyChangeSupport
            = new PropertyChangeSupport(this);
    
    private int id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public static final String PROP_ID = "id";
    public static final String PROP_CEP = "cep";
    public static final String PROP_LOGRADOURO = "logradouro";
    public static final String PROP_BAIRRO = "bairro";
    public static final String PROP_LOCALIDADE = "localidade";
    public static final String PROP_UF = "uf";

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }
    
    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        String oldCep = this.cep;
        this.cep = cep;
        propertyChangeSupport.firePropertyChange(PROP_CEP, oldCep, cep);
    }
    
    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        String oldLogradouro = this.logradouro;
        this.logradouro = logradouro;
        propertyChangeSupport.firePropertyChange(PROP_LOGRADOURO, oldLogradouro, logradouro);
    }
    
    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        propertyChangeSupport.firePropertyChange(PROP_BAIRRO, oldBairro, bairro);
    }

    public String getLocalidade()
    {
        return localidade;
    }

    public void setLocalidade(String localidade)
    {
        String oldLocalidade = this.localidade;
        this.localidade = localidade;
        propertyChangeSupport.firePropertyChange(PROP_LOCALIDADE, oldLocalidade, localidade);
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        String oldUf = this.uf;
        this.uf = uf;
        propertyChangeSupport.firePropertyChange(PROP_UF, oldUf, uf);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
