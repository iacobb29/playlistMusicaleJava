/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playlistmusicale;

import eccezioni.EccezioneCanzoneNonTrovata;
import eccezioni.EccezionePosNonValida;
import eccezioni.EccezionePosOccupata;
import eccezioni.EccezionePosVuota;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.TextFile;

/**
 *
 * @author Studente
 */
public class App 
{

    public static void main(String[] args)  
    {
       
        Playlist p1= new Playlist();
        
        int numeroVociMenu=13;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,artista, genere, durata;
        int posizione;
        LocalDate dataUscita;
        TextFile f1 = null;
        String [] elencoCanzoniTitolo;
        String [] elencoCanzoniArtista;
        String [] elencoCanzoniGenere;
        Canzone canz;
        
        String nomeFileCSV="tracce.csv";
        String nomeFileBinario = "playlist.bin";
        
        
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutte le tracce della playlist";
        vociMenu[2]="2 -->\tAggiungi traccia (posizione)";
        vociMenu[3]="3 -->\tCerca traccia (posizione)";
        vociMenu[4]="4 -->\tElimina traccia (posizione)";
        vociMenu[5]="5 -->\tCerca una canzone per titolo";
        vociMenu[6]="6 -->\tMostra titoli di uno specifico artista";
        vociMenu[7]="7 -->\tMostra titoli di uno specifico genere";
        vociMenu[8]="8 -->\tEsporta tracce in formato CSV";
        vociMenu[9]="9 -->\tImporta tracce dal file CSV";
        vociMenu[10]="10 -->\tSalva dati playlist";
        vociMenu[11]="11 -->\tCarica dati playlist";
        vociMenu[12]="12 -->\tModifica una canzone";
        
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
                        System.out.print("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.print("Artista --> ");
                        artista = tastiera.readString();
                        System.out.print("Genere --> ");
                        genere = tastiera.readString();
                        System.out.print("Durata --> ");
                        durata = tastiera.readString();
                        
                        do
                        {
                            try
                            {
                               System.out.print("Posizione --> ");
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
                                System.out.print("Data di rilascio --> ");
                                dataUscita = LocalDate.parse(tastiera.readString());
                                break;
                            }
                            catch(DateTimeParseException e)
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
                    catch (EccezionePosNonValida ex) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosOccupata ex) 
                    {
                        System.out.println("Posizione occupata");
                    }
                    
                    break;
                    
                case 3:
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.print("Posizione --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        canz=p1.getCanzone(posizione);
                        System.out.println("Canzone cercata:\n"+canz.toString());
                        
                    }
                    catch(IOException e)
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera");
                    }
                    catch (EccezionePosNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosVuota ex)
                    {
                        System.out.println("Nessuna traccia presente in quella posizione!");
                    }
                    break;
                
                case 4:
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.print("Posizione --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        p1.rimuoviTraccia(posizione);
                        System.out.println("La traccia è stata rimossa correttamente");
                        }
                        catch(IOException e)
                        {
                            System.out.println("Errore. Impossibile leggere da tastiera");
                        }
                        catch (EccezionePosNonValida ex) 
                        {
                            System.out.println("Posizione non valida");
                        } 
                        catch (EccezioneCanzoneNonTrovata ex)
                        {
                            System.out.println("Non è stata trovata nessuna canzone in quella posizione");
                        }
                    break;


                    
                case 5:
                    try
                    {
                        System.out.print("Titolo --> ");
                        titolo=tastiera.readString();
                        elencoCanzoniTitolo=p1.elencoCanzoniTitolo(titolo);
                        if (elencoCanzoniTitolo!=null)
                        {
                            for(int i=0;i<elencoCanzoniTitolo.length;i++)
                            {
                                System.out.println(elencoCanzoniTitolo[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna canzone presente per il titolo indicato.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                
                case 6:
                    try
                    {
                        System.out.print("Artista --> ");
                        artista=tastiera.readString();
                        elencoCanzoniArtista=p1.elencoCanzoniArtista(artista);
                        if (elencoCanzoniArtista!=null)
                        {
                            for(int i=0;i<elencoCanzoniArtista.length;i++)
                            {
                                System.out.println(elencoCanzoniArtista[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna canzone presente per l'artista indicato.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                    
                case 7:
                    try
                    {
                        System.out.print("Genere --> ");
                        genere=tastiera.readString();
                        elencoCanzoniGenere=p1.elencoCanzoniGenere(genere);
                        if (elencoCanzoniGenere!=null)
                        {
                            for(int i=0;i<elencoCanzoniGenere.length;i++)
                            {
                                System.out.println(elencoCanzoniGenere[i]);
                            }
                        }
                        else
                            System.out.println("Nessuna canzone presente per il genere indicato.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                    
                case 8:
                    try 
                    {
                        p1.esportaCSV(nomeFileCSV);
                        System.out.println("Tracce esportate correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile espoertare su file");
                    }
                    break;
                    
                case 9:
                    try 
                    {
                        p1.importaDaCSV(nomeFileCSV);
                        System.out.println("Fine operazione di caricamento");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile caricare le tracce dal file.");
                    }
                
                    break;
                    
                case 10:
                    try 
                    {
                        p1.salvaDati(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    }
                    break;
                    
                case 11:
                    try 
                    {
                        p1=p1.caricaDati(nomeFileBinario);
                        System.out.println("Caricamento effettuato correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere il dato memorizzato");
                    }
                    break;
                    
                case 12: 
                    try 
                    {
                     System.out.print("Posizione della canzone da modificare --> ");
                     posizione = tastiera.readInt();

                     System.out.println("Vuoi modificare:");
                     System.out.println("1. Titolo");
                     System.out.println("2. Artista");
                     int sceltaModifica = tastiera.readInt();

                     switch (sceltaModifica) 
                    {
                        case 1:
                            System.out.print("Nuovo titolo --> ");
                            String nuovoTitolo = tastiera.readString();

                            p1.modificaCanzoneNome(posizione, nuovoTitolo);
                            System.out.println("Il titolo della canzone è stato modificato correttamente.");
                            break;

                        case 2:
                            System.out.print("Nuovo artista --> ");
                            String nuovoArtista = tastiera.readString();

                            p1.modificaCanzoneArtista(posizione, nuovoArtista);
                            System.out.println("L'artista della canzone è stato modificato correttamente.");
                            break;

                        default:
                            System.out.println("Scelta non valida.");
                            break;
                    }
                    }    
                    catch (IOException e) 
                    {
                        System.out.println("Errore: impossibile leggere da tastiera");
                    } 
                    catch (EccezionePosNonValida e) 
                    {
                        System.out.println("Posizione non valida");
                    } 
                    catch (EccezionePosVuota e)
                    {
                        System.out.println("Nessuna canzone presente in quella posizione!");
                    }
            break;

                    
                
                    
                    
                

                    
            
            }
            
        
                
        }while(voceMenuScelta!=0);
    }
}

