/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

/**
 * Klasa waliduje poprawność pliku pod kątem poprawnej ilości danych oraz zakresu zmiennych dla parametrów RGB od 0 do 255
 * 
 */
import java.util.*;
import java.io.IOException;
import java.awt.Color;

public class FileValidator {
    Color[][] CustomizedPattern;
    List<String> RGBStringList = new ArrayList<>();
    List<Integer> RGBIntegerList = new ArrayList<>();
    
    //Metoda waliduąjąca string danych z pliku
    public Color[][] validate (String RowText) throws IOException {
        //Podielenie tekstu w miejscach przecinków i usunięcie spacji na brzegach tekstów
        for (String RetVal: RowText.split(",")){
             RGBStringList.add(RetVal.trim());
        }
        
        //Warunek sprawdzający dla jakiej wielkości tablicy pasuje ilośc danych (5x5, 15x15, 30x30)
        if (RGBStringList.size() == 75 || RGBStringList.size() == 675 || RGBStringList.size() == 2700) { 
            for (String Item : RGBStringList){
                //Sprawdzanie poprawności zakresu zmiennych
                if (Integer.valueOf(Item) >= 0 && Integer.valueOf(Item) <= 255){
                    //Konwersja Stringów na Integer
                    RGBIntegerList.add(Integer.valueOf(Item));
                } else {
                    //Komunikat błędu
                    throw new IOException("Wartość składowej RGB przekracza zakres 0, 255.");
                } 
            }
        
            //Stweozenie tablicy kolorów  pobranych składowych RGB
            for (int a = 0; a < RGBIntegerList.size(); a++){
                //Dla 75 składowych RGB tworzy tablicę 5x5
                if (RGBStringList.size() == 75) {
                    CustomizedPattern = new Color[5][5];
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++){
                            //Konstruktor tworzy kolor z trzech pobranych kolejno składowych, które następnie usuwa z ArrayListy
                            CustomizedPattern[i][j] = new Color(RGBIntegerList.remove(0), RGBIntegerList.remove(0), RGBIntegerList.remove(0));
                        }
                    }
                }
                
                //Dla 675 składowych RGB tworzy tablicę 15x15
                if (RGBStringList.size() == 675) {
                    CustomizedPattern = new Color[15][15];
                }
                
                //Dla 2700 składowych RGB tworzy tablicę 30x30
                if (RGBStringList.size() == 2700) {
                    CustomizedPattern = new Color[30][30];
                }
            }
        } else {
            throw new IOException("Niepoprawna ilość kolorów lub brak przecinka pomiędzy składowymi RGB w pliku.");
        }
        
        return CustomizedPattern;
    }
}
