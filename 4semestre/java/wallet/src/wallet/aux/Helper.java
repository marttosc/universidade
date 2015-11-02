package wallet.aux;

import java.awt.Color;
import java.util.InputMismatchException;
import javax.swing.JLabel;

/**
 * Classe com funções auxiliares.
 */
public class Helper
{
    /**
     * Exibe uma mensagem com determinada cor em uma JLabel.
     * @param msg Mensagem a ser exibida.
     * @param clr Cor da mensagem.
     * @param lbl Objeto JLabel.
     */
    public static void mostrarMensagem(String msg, Color clr, JLabel lbl)
    {
        lbl.setText(msg);
        lbl.setForeground(clr);
    }
    
    /**
     * Exibe uma mensagem com determinada cor em uma JLabel.
     * @param msg Mensagem a ser exibida.
     * @param lbl Objeto JLabel.
     */
    public static void mostrarMensagem(String msg, JLabel lbl)
    {
        mostrarMensagem(msg, Color.BLACK, lbl);
    }
    
    /**
     * Remove a máscara de CPF e CNPJ.
     * @param text CPF ou CNPJ.
     * @return Texto sem máscara.
     */
    public static String removerMascara(String text)
    {
        return text.replaceAll("[.\\-/]", "");
    }
    
    /**
     * Verifica se um CPF é válido.
     * @param cpf CPF sem máscara.
     * @return Validação do CPF
     */
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
    
    /**
     * Verifica se um CPF é válido.
     * @param cpf CPF com máscara.
     * @return Validação do CPF
     */
    public static boolean validarCPF(Object cpf)
    {
        try
        {
            if (cpf == null) return false;
            
            return Helper.validarCPF(Helper.removerMascara(cpf.toString()));
        }
        catch (InputMismatchException e)
        {
            return false;
        }
            
    }
    
    /**
     * Verifica se um CNPJ é válido.
     * @param cnpj CNPJ sem máscara.
     * @return Validação do CNPJ
     */
    public static boolean validarCNPJ(String cnpj)
    {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
            (cnpj.length() != 14))
        {
            return false;
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try
        {
            sm = 0;
            peso = 2;

            for (i = 11; i >= 0; i--)
            {
                num = (int) (cnpj.charAt(i) - 48);

                sm += num * peso;

                peso++;

                if (peso == 10)
                {
                    peso = 2;
                }
            }

            r = sm % 11;

            if (r == 0 || r == 1)
            {
                dig13 = '0';
            }
            else
            {
                dig13 = (char) ((11 - r) + 48);
            }

            sm = 0;

            peso = 2;

            for (i = 12; i >= 0; i--)
            {
                num = (int) (cnpj.charAt(i) - 48);

                sm += num * peso;

                peso++;

                if (peso == 10)
                    peso = 2;
                } 

                r = sm % 11;

                if (r == 0 || r == 1)
                {
                    dig14 = '0';
                }
                else
                {
                    dig14 = (char) ((11 - r) + 48);
                }

                return ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)));
            }
        catch (InputMismatchException e)
        {
            return false;
        }
    }
    
    /**
     * Verifica se um CNPJ é válido.
     * @param cnpj CNPJ com máscara.
     * @return Validação do CNPJ
     */
    public static boolean validarCNPJ(Object cnpj)
    {
        try
        {
            if (cnpj == null) return false;
            
            return Helper.validarCNPJ(Helper.removerMascara(cnpj.toString()));
        }
        catch (InputMismatchException e)
        {
            return false;
        }
            
    }
    
    /**
     * Retorna o valor double.
     * @param doub Valor a ser retornado.
     * @return Valor double
     */
    public static double getDouble(String doub)
    {
        return Double.parseDouble(doub.trim()
                .replaceAll("\\.", "").replaceAll(",", "."));
    }
}
