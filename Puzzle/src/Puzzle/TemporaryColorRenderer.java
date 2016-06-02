/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

/**
 * Klasa umożliwia wyświetlanie kolorów w tabeli jTableTmp oraz zaznaczenia czerwoną obwódką wybranej komórki
 * 
 */
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
 
public class TemporaryColorRenderer extends JLabel implements TableCellRenderer {
    Border unselectedBorder = null;
    Border selectedBorder = null;
    boolean isBordered = true;
 
    public TemporaryColorRenderer(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true); 
    }
 
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        Color newColor = (Color)color;
        setBackground(newColor);
        
        if (isBordered) {
            if (isSelected) {
                if (selectedBorder == null) {
                    selectedBorder = BorderFactory.createMatteBorder(1,1,1,1, Color.RED);
                }
                setBorder(selectedBorder);
            } else {
                if (unselectedBorder == null) {
                    unselectedBorder = BorderFactory.createMatteBorder(1,1,1,1, table.getSelectionBackground());
                }
                setBorder(unselectedBorder);
            }
        }
        return this;
    }
}