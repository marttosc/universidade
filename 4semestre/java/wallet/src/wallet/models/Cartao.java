
package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public class Cartao
{
    private String numero;

    public static final String PROP_NUMERO = "numero";

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }

    private int mesValidade;

    public static final String PROP_MESVALIDADE = "mesValidade";

    public int getMesValidade() {
        return mesValidade;
    }

    public void setMesValidade(int mesValidade) {
        int oldMesValidade = this.mesValidade;
        this.mesValidade = mesValidade;
        propertyChangeSupport.firePropertyChange(PROP_MESVALIDADE, oldMesValidade, mesValidade);
    }

    private int anoValidade;

    public static final String PROP_ANOVALIDADE = "anoValidade";

    public int getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade) {
        int oldAnoValidade = this.anoValidade;
        this.anoValidade = anoValidade;
        propertyChangeSupport.firePropertyChange(PROP_ANOVALIDADE, oldAnoValidade, anoValidade);
    }

    private String bandeira;

    public static final String PROP_BANDEIRA = "bandeira";

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        String oldBandeira = this.bandeira;
        this.bandeira = bandeira;
        propertyChangeSupport.firePropertyChange(PROP_BANDEIRA, oldBandeira, bandeira);
    }

        private Usuario cliente;

    public static final String PROP_CLIENTE = "cliente";

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        Usuario oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }


    private String cvc;

    public static final String PROP_CVC = "cvc";

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        String oldCvc = this.cvc;
        this.cvc = cvc;
        propertyChangeSupport.firePropertyChange(PROP_CVC, oldCvc, cvc);
    }

    private String tipo;

    public static final String PROP_TIPO = "tipo";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        propertyChangeSupport.firePropertyChange(PROP_TIPO, oldTipo, tipo);
    }
    
    public void passarCartao() {}
    
    // Utilizado somente para não trabalhar com persistência no DB.
    /**
     * Verifica se o número do cartão já está cadastrado na lista.
     * @param numero Número do cartão
     * @return Se o cartão existe ou não.
     */
    public static boolean existeCartao(String numero)
    {
        // Retorna a lista de cartões da AreaDeTrabalho.
        List<Cartao> cartoes = wallet.telas.AreaDeTrabalho.getCartoes();
        
        // Percorre e verifica se o número existe, se sim, retorna verdadeiro.
        for (Cartao c : cartoes)
        {
            if (c.getNumero().equals(numero))
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
