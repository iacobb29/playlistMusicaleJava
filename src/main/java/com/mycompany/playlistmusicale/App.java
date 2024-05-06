/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playlistmusicale;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.TextFile;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        Canzone c1 = new Canzone("Ciao", "Pinna", "4:08", "Rap", LocalDate.of(2004, 11, 27));
        Canzone c2 = new Canzone("zizzirazzi", "Pow", "3:28", "Rock", LocalDate.of(2011, 9, 12));
        Canzone c3 = new Canzone("Razzazziri", "Laini", "2:27", "Hip-Hop", LocalDate.of(2006, 5, 29));
       
        Playlist p1= new Playlist();
        
        int numeroVociMenu=11;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,artista, genere, durata;
        int posizione;
        LocalDate dataUscita;
        TextFile f1 = null;
        Canzone canz;
        
        String nomeFileCSV="tracce.csv";
        String nomeFileBinario = "playlist.bin";
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutte le tracce della playlist";
        vociMenu[2]="2 -->\tAggiungi traccia (posizione)";
        vociMenu[3]="3 -->\tCerca traccia ( posizione)";
        vociMenu[4]="4 -->\tElimina traccia (posizione)";
        vociMenu[5]="5 -->\tMostra titoli di uno specifico artista";
        vociMenu[7]="7 -->\tEsporta tracce in formato CSV";
        vociMenu[8]="8 -->\tImporta tracce dal file CSV";
        vociMenu[9]="9 -->\tSalva dati playlist";
        vociMenu[10]="10 -->\tCarica dati playlist";
        
        menu=new Menu(vociMenu);
        
        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta)
            {
                case 0: //Esci
                    System.out.println("Arrivederci");
                    break;
                
                case 1:  //Visualizza tutti
                    System.out.println(p1.toString());
                    break;
                
                case 2:
                    try
                    {
                        System.out.println("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.println("Artista --> ");
                        artista = tastiera.readString();
                        System.out.println("Genere --> ");
                        genere = tastiera.readString();
                        System.out.println("Durata --> ");
                        durata = tastiera.readString();
                        
                        do
                        {
                            try
                            {
                               System.out.println("Posizione --> ");
                               posizione = tastiera.readInt(); 
                               break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto.");
                            }   
                        }while(true);
                        
                        do
                        {
                            try
                            {
                                System.out.println("Data di rilascio --> ");
                                dataUscita = LocalDate.parse(tastiera.readString());
                                break;
                            }
                            catch(IOException e)
                            {
                                System.out.println("Formato di data non corretto. Inserisci una data nel formato YYYY-MM-DD.");
                            }
                                    
                                     
                            
                        }while(true);
                        
                        canz = new Canzone(titolo, artista, durata, genere, dataUscita);
                        p1.setCanzone(canz, posizione);
                        System.out.println("Traccia inserita correttamente.");
                        
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore: impossibile leggere da tastiera");
                    }

            }
            
        }while(voceMenuScelta!=0);
        
                
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        
        
        
        
    }
}
