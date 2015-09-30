package wallet.aux.swing.text;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Permite definir uma determinada quantia de caracteres.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class TextFieldLimit extends PlainDocument
{
    private final int limite;

    public TextFieldLimit(int limite)
    {
        super();
        
        this.limite = limite;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException
    {
        if (str == null) return;
        
        if ((getLength() + str.length()) <= limite)
        {
            super.insertString(offset, str, attr);
        }
    }
    
}
