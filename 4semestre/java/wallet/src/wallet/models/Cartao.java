
package wallet.models;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */

public abstract class Cartao
{
    private String numero;
    private int mesValidade;
    private int anoValidade;
    private Bandeira bandeira;
    private Usuario cliente;
    private String cvc;

    protected String getNumero() {
        return numero;
    }

    protected void setNumero(String numero) {
        this.numero = numero;
    }

    protected int getMesValidade() {
        return mesValidade;
    }

    protected void setMesValidade(int mesValidade) {
        this.mesValidade = mesValidade;
    }

    protected int getAnoValidade() {
        return anoValidade;
    }

    protected void setAnoValidade(int anoValidade) {
        this.anoValidade = anoValidade;
    }

    protected Bandeira getBandeira() {
        return bandeira;
    }

    protected void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    protected Usuario getCliente() {
        return cliente;
    }

    protected void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    protected String getCvc() {
        return cvc;
    }

    protected void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public abstract void passarCartao();
}
