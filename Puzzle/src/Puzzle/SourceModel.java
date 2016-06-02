package Puzzle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tabela jTableSrc wczytuje obiekt klasy SourceModel który służy za żródło danych wejściowych.
 * Dane nie ulegją zmianie w trakcie gry.
 */
import javax.swing.table.AbstractTableModel;
import java.awt.Color;

public class SourceModel extends AbstractTableModel {
    //Konstruktor inicjalizuje zmienne konkretnymi wartościami wygenerowanymi losowo
    public SourceModel(Object[][] data, String[] columnNames) {
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
