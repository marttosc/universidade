package wallet.aux.swing.renderer;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import wallet.models.Usuario;

/**
 * Renderiza a model Usuario nas combobox.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class UsuarioRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Usuario)
        {
            Usuario usuario = (Usuario) value;
            
            this.setText(usuario.getPrimeiroNome() + " " + usuario.getSegundoNome());
        }
        
        return this;
    }
}
