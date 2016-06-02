/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 * Tabela jTableTmp wczytuje obiekt klasy TemporaryModel który służy za żródło danych wejściowych,
 * które następnie są aktualizowane w trakcie rozgrywki.
 */
public class TemporaryModel extends AbstractTableModel {
    //Konstruktor inicjalizuje zmienne konkretnymi wartościami wygenerowanymi losowo
    public TemporaryModel(Object[][] data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }
    
    //Zmienna data służy do przechowywania kolorów, które następnie są pobierane przez tabelę i wyświetlane
    private Object[][] data = null;
    private String[] columnNames = null;

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setValueAt(Object obj, int row, int col) {
        data[row][col] = obj;
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    //Metoda toString służy do wykorzystania w metodzie equals w celu porównania równosci logicznej klas SourceModel i TemporaryModel
    public String toString(){
        String Content = "";
        for (Object[] k : data){
            for (Object item : k) {
                Content += "" + ((Color)item).getRGB();
            }
        }        
        return Content; 
    }    
}
