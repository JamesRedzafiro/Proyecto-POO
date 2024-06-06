package Vista;

import java.awt.Component;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;

public class NegritaTabla extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(c.getFont().deriveFont(c.getFont().getStyle() | Font.BOLD)); // Establece la fuente en negrita
        return c;
    }
}
