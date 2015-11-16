package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 * Modelo para as bandeiras dos cartões.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Bandeira
{
    private transient final PropertyChangeSupport propertyChangeSupport
            = new PropertyChangeSupport(this);
    
    private int id;
    private String descricao;
    
    public static final String PROP_ID = "id";
    public static final String PROP_DESCRICAO = "descricao";
    
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

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Bandeira other = (Bandeira) obj;
        
        if (this.id != other.id)
        {
            return false;
        }
        
        if (!Objects.equals(this.descricao, other.descricao))
        {
            return false;
        }
        
        return true;
    }
    
    
}
