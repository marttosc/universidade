package wallet.aux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

/**
 * Classe auxiliar para leitura de JSON.
 * @author Gustavo Marttos
 */
public class JSON
{
    /**
     * Ler todas as informações do JSON.
     * @param rd Reader do JSON
     * @return String contendo informações do JSON.
     */
    private static String readAll(Reader rd)
    {
        StringBuilder sb = new StringBuilder();
        
        int cp;
        
        try
        {
            while ((cp = rd.read()) != -1)
            {
                sb.append((char) cp);
            }
        }
        catch (IOException e)
        {
            System.err.println("Erro ao ler stream.");
        }
        
        return sb.toString();
    }
    
    /**
     * Lê o JSON via uma URL.
     * @param url URL a ser lida.
     * @return Objeto JSON para leitura.
     */
    public static JSONObject lerJsonViaUrl(String url)
    {
        InputStream is = null;
        JSONObject json = null;
        
        try
        {
            is = new URL(url).openStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            
            String jsonTxt = readAll(br);
            
            json =  new JSONObject(jsonTxt);
            
            return json;
        }
        catch (IOException e)
        {
            System.err.println("Erro ao abrir stream de leitura.");
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    System.err.println("Erro ao encerrar stream de leitura.");
                }
            }
        }
        
        return json;
    }
}
