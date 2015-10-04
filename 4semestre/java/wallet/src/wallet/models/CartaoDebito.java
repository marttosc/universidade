package wallet.models;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class CartaoDebito extends Cartao
{
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    private double valor;

    public CartaoDebito()
    {
    }
    
    public CartaoDebito(double saldo)
    {
        this();
    }
    
    public void passarCartao(double valor)
    {
        if(saldo > 0)
        {
            saldo -= valor;
             System.out.println("Seu limite atualizado é R$ "+saldo);
        }
        else
        {
            System.out.println("Seu saldo é insuficiente para essa compra!");
        }
    }
    
}
