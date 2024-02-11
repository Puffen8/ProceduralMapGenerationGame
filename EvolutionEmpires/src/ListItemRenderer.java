import javax.swing.*;
import java.awt.*;

public class ListItemRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (component instanceof JComponent) {
            ((JComponent) component).setPreferredSize(new Dimension(100, 30));
        }
        component.setFont(Config.listItemFont);
        return component;
    }
}