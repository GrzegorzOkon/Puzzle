/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * Klasa umożliwia wyświetlanie kolorów w tabeli jTableSrc oraz zaznaczenia dwóch wylosowanych komórek czerwoną obwódką
 */
public class SourceColorRenderer extends JLabel implements TableCellRenderer{
    Border unselectedBorder = null;
    Border selectedBorder = null;
    boolean isBordered = true;
 
    public SourceColorRenderer(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
    }
 
    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        Color newColor = (Color)color;
        setBackground(newColor);
        
        if (isBordered) {
            if (isSelected) {
                if (selectedBorder == null) {
                    selectedBorder = BorderFactory.createMatteBorder(2,2,2,2, Color.RED);
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