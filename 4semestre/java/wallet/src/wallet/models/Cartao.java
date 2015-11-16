package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Modelo para os cartões de crédito.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public class Cartao
{
    private transient final PropertyChangeSupport propertyChangeSupport
            = new PropertyChangeSupport(this);

    private int id;
    private Usuario usuario;
    private Bandeira bandeira;
    private String numero;
    private int mesValidade;
    private int anoValidade;
    private int cvc;
    private double limite;
    
    public static final String PROP_ID = "id";
    public static final String PROP_USUARIO = "usuario";
    public static final String PROP_BANDEIRA = "bandeira";
    public static final String PROP_NUMERO = "numero";
    public static final String PROP_MESVALIDADE = "mesValidade";
    public static final String PROP_ANOVALIDADE = "anoValidade";
    public static final String PROP_CVC = "cvc";
    public static final String PROP_LIMITE = "limite";
    
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
    
    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        Usuario oldUsuario = this.usuario;
        this.usuario = usuario;
        propertyChangeSupport.firePropertyChange(PROP_USUARIO, oldUsuario, usuario);
    }
    
    public Bandeira getBandeira()
    {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira)
    {
        Bandeira oldBandeira = this.bandeira;
        this.bandeira = bandeira;
        propertyChangeSupport.firePropertyChange(PROP_BANDEIRA, oldBandeira, bandeira);
    }
    
    public String getNumero()
    {
        return numero;
    }
    
    public void setNumero(String numero)
    {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }
    
    public int getMesValidade()
    {
        return mesValidade;
    }
    
    public void setMesValidade(int mesValidade)
    {
        int oldMesValidade = this.mesValidade;
        this.mesValidade = mesValidade;
        propertyChangeSupport.firePropertyChange(PROP_MESVALIDADE, oldMesValidade, mesValidade);
    }
    
    public int getAnoValidade()
    {
        return anoValidade;
    }
    
    public void setAnoValidade(int anoValidade)
    {
        int oldAnoValidade = this.anoValidade;
        this.anoValidade = anoValidade;
        propertyChangeSupport.firePropertyChange(PROP_ANOVALIDADE, oldAnoValidade, anoValidade);
    }
    
    public int getCvc()
    {
        return cvc;
    }
    
    public void setCvc(int cvc)
    {
        int oldCvc = this.cvc;
        this.cvc = cvc;
        propertyChangeSupport.firePropertyChange(PROP_CVC, oldCvc, cvc);
    }
    
    public double getLimite()
    {
        return limite;
    }
    
    public void setLimite(double limite)
    {
        double oldLimite = this.limite;
        this.limite = limite;
        propertyChangeSupport.firePropertyChange(PROP_LIMITE, oldLimite, limite);
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
