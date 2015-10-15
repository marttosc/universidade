
package wallet.models;

import java.util.List;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public class Cartao
{
    private String numero;
    private int mesValidade;
    private int anoValidade;
    private String bandeira;
    private Usuario cliente;
    private String cvc;
    private String tipo;

    public String getNumero()
    {
        return numero;
    }
    

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public int getMesValidade()
    {
        return mesValidade;
    }

    public void setMesValidade(int mesValidade)
    {
        this.mesValidade = mesValidade;
    }

    public int getAnoValidade()
    {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade)
    {
        this.anoValidade = anoValidade;
    }

    public String getBandeira()
    {
        return bandeira;
    }

    public void setBandeira(String bandeira)
    {
        this.bandeira = bandeira;
    }

    public Usuario getCliente()
    {
        return cliente;
    }

    public void setCliente(Usuario cliente)
    {
        this.cliente = cliente;
    }

    public String getCvc()
    {
        return cvc;
    }

    public void setCvc(String cvc)
    {
        this.cvc = cvc;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public String getTipo()
    {
        return this.tipo;
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
}
