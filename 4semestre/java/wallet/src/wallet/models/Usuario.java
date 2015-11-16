package wallet.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Modelo do usuário/cliente.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Usuario
{
    private transient final PropertyChangeSupport propertyChangeSupport
            = new PropertyChangeSupport(this);
    
    private int id;
    private String cpf;
    private String primeiroNome;
    private String segundoNome;
    private Date nascimento;
    private String email;
    private String senha;
    private double renda;
    private Endereco endereco;
    private Date criadoEm;
    private Date atualizadoEm;

    public static final String PROP_ID = "id";
    public static final String PROP_CPF = "cpf";
    public static final String PROP_PRIMEIRONOME = "primeiroNome";
    public static final String PROP_SEGUNDONOME = "segundoNome";
    public static final String PROP_NASCIMENTO = "nascimento";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_SENHA = "senha";
    public static final String PROP_RENDA = "renda";
    public static final String PROP_ENDERECO = "endereco";
    public static final String PROP_CRIADOEM = "criadoEm";
    public static final String PROP_ATUALIZADOEM = "atualizadoEm";

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

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        propertyChangeSupport.firePropertyChange(PROP_CPF, oldCpf, cpf);
    }

    public String getPrimeiroNome()
    {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome)
    {
        String oldPrimeiroNome = this.primeiroNome;
        this.primeiroNome = primeiroNome;
        propertyChangeSupport.firePropertyChange(PROP_PRIMEIRONOME, oldPrimeiroNome, primeiroNome);
    }

    public String getSegundoNome()
    {
        return segundoNome;
    }
    
    public void setSegundoNome(String segundoNome)
    {
        String oldSegundoNome = this.segundoNome;
        this.segundoNome = segundoNome;
        propertyChangeSupport.firePropertyChange(PROP_SEGUNDONOME, oldSegundoNome, segundoNome);
    }
    
    public Date getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(Date nascimento)
    {
        Date oldNascimento = this.nascimento;
        this.nascimento = nascimento;
        propertyChangeSupport.firePropertyChange(PROP_NASCIMENTO, oldNascimento, nascimento);
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
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange(PROP_EMAIL, oldEmail, email);
    }
    
    public String getSenha()
    {
        return senha;
    }
    
    public void setSenha(String senha)
    {
        String oldSenha = this.senha;
        this.senha = senha;
        propertyChangeSupport.firePropertyChange(PROP_SENHA, oldSenha, senha);
    }
    
    public double getRenda()
    {
        return renda;
    }
    
    public void setRenda(double renda)
    {
        double oldRenda = this.renda;
        this.renda = renda;
        propertyChangeSupport.firePropertyChange(PROP_RENDA, oldRenda, renda);
    }
    
    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        Endereco oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }
    
    public Date getCriadoEm()
    {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm)
    {
        Date oldCriadoEm = this.criadoEm;
        this.criadoEm = criadoEm;
        propertyChangeSupport.firePropertyChange(PROP_CRIADOEM, oldCriadoEm, criadoEm);
    }
    
    public void setCriadoEm(String criadoEm)
    {
        try
        {
            setCriadoEm(new SimpleDateFormat("dd/MM/yyyy").parse(criadoEm));
        }
        catch (ParseException e)
        {
            System.err.println("Data inválida.");
        }
    }
    
    public Date getAtualizadoEm()
    {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm)
    {
        Date oldAtualizadoEm = this.atualizadoEm;
        this.atualizadoEm = atualizadoEm;
        propertyChangeSupport.firePropertyChange(PROP_ATUALIZADOEM, oldAtualizadoEm, atualizadoEm);
    }
    
    public void setAtualizadoEm(String atualizadoEm)
    {
        try
        {
            setAtualizadoEm(new SimpleDateFormat("dd/MM/yyyy").parse(atualizadoEm));
        }
        catch (ParseException e)
        {
            System.err.println("Data inválida.");
        }
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
        int hash = 3;

        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.cpf);
        hash = 47 * hash + Objects.hashCode(this.primeiroNome);
        hash = 47 * hash + Objects.hashCode(this.segundoNome);
        hash = 47 * hash + Objects.hashCode(this.nascimento);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.senha);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.renda) ^ (Double.doubleToLongBits(this.renda) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.criadoEm);
        hash = 47 * hash + Objects.hashCode(this.atualizadoEm);

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
        
        final Usuario other = (Usuario) obj;
        
        if (this.id != other.id)
        {
            return false;
        }
        
        if (!Objects.equals(this.cpf, other.cpf))
        {
            return false;
        }
        
        if (!Objects.equals(this.primeiroNome, other.primeiroNome))
        {
            return false;
        }
        
        if (!Objects.equals(this.segundoNome, other.segundoNome))
        {
            return false;
        }
        
        if (!Objects.equals(this.nascimento, other.nascimento))
        {
            return false;
        }
        
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha))
        {
            return false;
        }
        
        if (Double.doubleToLongBits(this.renda) != Double.doubleToLongBits(other.renda))
        {
            return false;
        }
        
        if (!Objects.equals(this.criadoEm, other.criadoEm))
        {
            return false;
        }
        
        if (!Objects.equals(this.atualizadoEm, other.atualizadoEm))
        {
            return false;
        }

        return true;
    }

        
}
