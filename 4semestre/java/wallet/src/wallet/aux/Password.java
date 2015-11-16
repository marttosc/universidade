package wallet.aux;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Classe responsável pela criptografia e verificação das senhas.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class Password
{
    public static final String DEFAULT_SALT = "SKULD";

    /**
     * Retorna a senha criptografada.
     * @param senha Texto a ser criptografado.
     * @param salt Salt gerado.
     * @return Senha criptografada.
     */
    public static String getPassword(String senha, String salt)
    {
        String criptografado;
        
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            md.update(salt.getBytes());
            
            byte[] bytes = md.digest(senha.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            criptografado = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
        
        return criptografado;
    }
    
    /**
     * Retorna a senha criptografada.
     * @param senha Texto a ser criptografado.
     * @param useRandomSalt Se usará salt randômico ou não.
     * @return Senha criptografada.
     */
    public static String getPassword(String senha, boolean useRandomSalt)
    {
        try
        {
            if (useRandomSalt)
            {
                return Password.getPassword(senha, Password.getSalt());
            }
            else
            {
                return Password.getPassword(senha, DEFAULT_SALT);
            }
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
    }
    
    /**
     * Retorna a senha criptografada.
     * @param password Texto a ser criptografado.
     * @return Senha criptografada.
     */
    public static String getPassword(String password)
    {
        try
        {
            return Password.getPassword(password, Password.getSalt());
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
    }
    
    /**
     * Verifica se a senha informada é válida.
     * @param senha Texto a ser comparado.
     * @param criptografado Hash da senha.
     * @return Se a verificação entre senhas casam.
     */
    public static boolean isValid(String senha, String criptografado)
    {
        return isValid(senha, DEFAULT_SALT, criptografado);
    }
    
    /**
     * Verifica se a senha informada é válida.
     * @param senha Texto a ser comparado.
     * @param salt Salt gerado.
     * @param criptografado Hash da senha.
     * @return Se a verificação entre senhas casam.
     */
    public static boolean isValid(String senha, String salt, String criptografado)
    {
        return getPassword(senha, salt).equals(criptografado);
    }
    
    /**
     * Retorna um salt randômico.
     * @return O salt.
     * @throws NoSuchAlgorithmException 
     */
    public static String getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        
        byte[] salt = new byte[16];
        
        sr.nextBytes(salt);
        
        return sr.toString();
    }
    
    /**
     * Transfore a senha de char para String.
     * @param senha Cadeia de char de senha.
     * @return String da senha.
     */
    public static String getString(char[] senha)
    {
        StringBuilder pwd = new StringBuilder();
        
        for (int i = 0; i < senha.length; i++)
        {
            pwd.append(senha[i]);
        }
        
        return pwd.toString();
    }
}
