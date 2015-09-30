package wallet.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Modelo do usuário/cliente.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Usuario
{
    private int id;
    
    private String cpf;
    
    private String nome;
    
    private Date nascimento;
    
    private String endereco;
    
    private String bairro;
    
    private String cep;
    
    private String cidade;
    
    private String uf;
    
    private Double renda;
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setCPF(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getCPF()
    {
        return this.cpf;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }
    
    public void setNascimento(String nascimento)
    {
        try
        {
            setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(nascimento));
        }
        catch (ParseException e)
        {
            System.err.println("Data inválida.");
        }
    }
    
    public Date getNascimento()
    {
        return this.nascimento;
    }
    
    public void setEndereco(String endereco)       
    {
        this.endereco = endereco;
    }
    
    public String getEndereco()
    {
        return this.endereco;
    }
    
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }
    
    public String getBairro()
    {
        return this.bairro;
    }
    
    public void setCEP(String cep)
    {
        this.cep = cep;
    }
    
    public String getCEP()
    {
        return this.cep;
    }
    
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }
    
    public String getCidade()
    {
        return this.cidade;
    }
    
    public void setUF(String uf)
    {
        this.uf = uf;
    }
    
    public String getUF()
    {
        return this.uf;
    }
    
    public void setRenda(double renda)
    {
        this.renda = renda;
    }
    
    public double getRenda()
    {
        return this.renda;
    }
    
    public static boolean validarCPF()
    {
        return Usuario.validarCPF(Usuario.removerMascaraCPF(new Usuario().getCPF()));
    }
    
    public static boolean validarCPF(Object cpf)
    {
        try
        {
            if (cpf == null) return false;
            
            return Usuario.validarCPF(Usuario.removerMascaraCPF(cpf.toString()));
        }
        catch (InputMismatchException e)
        {
            return false;
        }
            
    }
    
    public static boolean validarCPF(String cpf)
    {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
           (cpf.length() != 11))
        {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try
        {
            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++)
            {
                num = (int) (cpf.charAt(i) - 48);

                sm += num * peso;

                peso--;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
            {
                dig10 = '0';
            }
            else
            {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++)
            {
                num = (int) (cpf.charAt(i) - 48);

                sm += num * peso;

                peso--;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
            {
                dig11 = '0';
            }
            else
            {
                dig11 = (char) (r + 48);
            }

            return ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)));
        }
        catch (InputMismatchException e)
        {
            return false;
        }
    }
    
    public static String removerMascaraCPF(String cpf)
    {
        return cpf.replaceAll("[.\\-]", "");
    }
    
    public static boolean cpf(String cpf)
    {
        return Usuario.removerMascaraCPF(cpf.trim()).length() > 6
                && Usuario.validarCPF(Usuario.removerMascaraCPF(cpf.trim()));
    }
}
