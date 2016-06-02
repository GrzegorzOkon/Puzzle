/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

/**
 * Klasa odpowaida za losowanie pojedynczych kolorów z podanej listy  
 * oraz pomieszanie przekazanej tabeli kolorów bez zmiany ich ilości
 */
import java.awt.Color;
import java.util.Random;
import java.util.*;

public class ColorDraw {
    Random generator = new Random();
    
    //Losuje kolor z podanej parametrem listy i zwraca wynik
    public Color generateColor (Color[] colors) {
       //Losuje liczby całkowite od 0 do colors.length - 1
       return colors[generator.nextInt(colors.length)];
    }
    
    //Miesza pobraną tablicę kolorów i zwraca nową
    public Object[][] mixColors (Object[][] dataSrc) {
        List<Object> SourceColors = new ArrayList<>();
        Object[][] TargetColors =  new Object[dataSrc.length][dataSrc.length];
                
        //Wczytuje kolory z tabeli dataSrc do ArrayListy celem posortowania
        for (int i = 0; i < dataSrc.length; i++) {
            for (int j = 0; j < dataSrc.length; j++) {
                SourceColors.add(dataSrc[i][j]);
            }
        }
        
        //Pobiera elementy ArrayListy i losowo umieszcza je w tabeli TargetColors
        for (int i = 0; i < dataSrc.length; i++){
            for (int j = 0; j < dataSrc.length; j++){
                TargetColors[i][j] = SourceColors.remove(generator.nextInt(SourceColors.size()));
            }
        }
                
        return TargetColors;
    }
}
