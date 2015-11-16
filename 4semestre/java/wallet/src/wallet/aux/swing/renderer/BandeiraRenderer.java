package wallet.aux.swing.renderer;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import wallet.models.Bandeira;

/**
 * Renderiza a model Bandeira nas combobox.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class BandeiraRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Bandeira)
        {
            Bandeira bandeira = (Bandeira) value;
            
            this.setText(bandeira.getDescricao());
        }
        
        return this;
    }
}
