package wallet.models;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public class CartaoCredito extends Cartao
{
    private double limite;
    private double valor;

    public double getLimite() {
        return limite;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    public CartaoCredito()
    {
    }
    
    public CartaoCredito(double limite)
    {
        this();
        
    }    
   
    public void passarCartao(double valor)
    {
        if (limite > 0)
        {
            limite -= valor;
            System.out.println("Seu limite atualizado é R$ "+limite);
        }
        else
        {
            System.out.println("Seu limite é insuficiente para essa compra!");
        }
    }
}
