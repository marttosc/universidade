
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
    
    public static boolean existeCartao(String numero)
    {
        List<Cartao> cartoes = wallet.telas.AreaDeTrabalho.getCartoes();
        
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
