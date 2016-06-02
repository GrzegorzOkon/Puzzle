/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

/**
 * Klasa losuje dwie komórki obok siebie a następnie zamienia je kolorami
 * 
 */
import java.util.Random;
import java.util.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ComputerMove {
    //Zmienne przechowujące dane żródłowe tabeli
    TemporaryModel Grid;
    JTable SrcTable;
    JTable TmpTable;
    Color FirstColor, SecondColor;
    
    //Zmienne wylosowanych adresów komórek
    int Cell1[] = new int[2];
    int Cell2[] = new int[2];
    
    Random generator = new Random();
    
    //Konstruktor pobiera dane źródłowe na których klasa będzie operowała
    public ComputerMove (TemporaryModel Grid, JTable TmpTable, JTable SrcTable) {
        this.Grid = Grid;
        this.TmpTable = TmpTable;
        this.SrcTable = SrcTable;
    }
    
    //Wykonuje ruch komputera poprzez losowanie współrzędnych przesuwanych komórek
    public void runComputerMove(){    
        //Zmienna tymczasowa służaca do losowania
        List<Integer> TempCells = new ArrayList<>();
        
        //Losuję współrzędne pierwszej komórki
        Cell1[0] = generator.nextInt(Grid.getRowCount());
        Cell1[1] = generator.nextInt(Grid.getRowCount());
        
        //Wybieranie komórki powyżej pierwszego losu
        if (Cell1[0] - 1 >= 0) {
            TempCells.add(Cell1[0] - 1);
            TempCells.add(Cell1[1]);
        }
        
        //Wybieranie komórki poniżej pierwszego losu
        if (Cell1[0] + 1 < Grid.getRowCount()) {
            TempCells.add(Cell1[0] + 1);
            TempCells.add(Cell1[1]);
        }   
        
        //Wybieranie komórki na lewo od pierwszego losu
        if (Cell1[1] - 1 >= 0) {
            TempCells.add(Cell1[0]);
            TempCells.add(Cell1[1]-1);
        }
        
        //Wybieranie komórki na prawo od pierwszego losu
        if (Cell1[1] + 1 < Grid.getRowCount()) {
            TempCells.add(Cell1[0]);
            TempCells.add(Cell1[1]+1);
        }   

        //Losowanie drugiej komórki leżącej przy pierwszej
        int i = generator.nextInt(TempCells.size()/2);
        Cell2[0] = TempCells.get(i*2);
        Cell2[1] = TempCells.get(i*2+1);
        
        //Pobranie kolorów
        FirstColor = (Color)Grid.getValueAt(Cell1[0], Cell1[1]);
        SecondColor = (Color)Grid.getValueAt(Cell2[0], Cell2[1]);  
        
        //Zamienienie kolorów
        Grid.setValueAt(SecondColor, Cell1[0], Cell1[1]);
        Grid.setValueAt(FirstColor, Cell2[0], Cell2[1]);
        
        //Ustawiam czerwoną ramkę dla zmienionych komórek         
        SrcTable.changeSelection(Cell1[0], Cell1[1], false, false);
        SrcTable.changeSelection(Cell2[0], Cell2[1], true, false);
        
        //Odświeżenie komórek w tabeli
        TmpTable.repaint();
    }
}