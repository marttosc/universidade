package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
}
