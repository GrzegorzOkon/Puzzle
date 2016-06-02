/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

/**
 * Klasa uruchamiająca czas odliczający do nowego losowania uruchamiana w osobnym wątku
 * 
 */
class Clock implements Runnable {
    // Wątek
    private Thread watek;
    
    // Liczba milisekund pauzy (1000 ms czyli 1 sekunda)
    private int pause = 1000;
    JLabel etykieta;
    int Counter;
    int ComputerTime;

    //Dane do przekazania do ComputerMove
    TemporaryModel Grid;
    JTable SrcTable;
    JTable TmpTable;
 
    // Konstruktor klasy
    public Clock(JLabel etykieta, int ComputerTime, TemporaryModel Grid, JTable TmpTable, JTable SrcTable) {
        this.etykieta = etykieta;  
        Counter = ComputerTime;
        this.ComputerTime = ComputerTime;
        this.Grid = Grid;
        this.SrcTable = SrcTable;
        this.TmpTable = TmpTable;
    }

 // metoda start tworzy i uruchamia wątek zegara
 public void start() {
  // jeśli nie ma działającego wątka, utwórz i uruchom nowy
  if (watek == null) {
    watek = new Thread(this);
    watek.start();
  }
 }

 // metoda wywołana po starcie wątku
 public void run() {
  // dopóki zmienna watek wskazuje na bieżący wątek
  while ( watek == Thread.currentThread()) {
   etykieta.setText("" + Counter);
   if (Counter == 0){
       etykieta.setText("Wykonuję ruch...");
       ComputerMove Go = new ComputerMove(Grid, TmpTable, SrcTable);
       Go.runComputerMove();
       Counter = ComputerTime + 1;
   }
   try {
    // wstrzymujemy działanie wątku na 1 sekundę
    watek.sleep(pause);
    Counter -= 1;
   } catch (InterruptedException e) {}
  }
 }

 // metoda zatrzymująca zegar (wątek)
 public void stop() {
  // ustawiamy referencję watek na null
  watek = null;
 }
}
