/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmusicale;

import eccezioni.EccezioneCanzoneNonTrovata;
import eccezioni.EccezionePosNonValida;
import eccezioni.EccezionePosOccupata;
import eccezioni.EccezionePosVuota;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;

/**
 * Classe che rappresenta una playlist,
 * ovvero un array di canzoni
 * @author Studente
 */
public class Playlist implements Serializable
{
    private final static int NUM_MAX_TRACCE = 10;
    Canzone[] tracce;
    
    /**
     * Costruttore della playlist
     */
    public Playlist()
    {
        tracce = new Canzone[NUM_MAX_TRACCE];
    }
    
    /**
     * Inserisce la canzone nella posizione "posizione"
     * della playlist "Playlist"
     * @param traccia Una canzone dell'array Playlist
     * @param posizione posizione della canzone nell'array
     * @throws EccezionePosNonValida
     * @throws EccezionePosOccupata 
     */
    public void setCanzone(Canzone traccia, int posizione) throws EccezionePosNonValida, EccezionePosOccupata
    {
        if(posizione<0 || posizione>NUM_MAX_TRACCE)
            throw new eccezioni.EccezionePosNonValida();
        
        if(tracce[posizione]!=null)
            throw new eccezioni.EccezionePosOccupata();
        
        tracce[posizione] = traccia;
    }
    
    /**
     * Restituisce la traccia in posizione "posizione"
     * della playlist "playlist"
     * @param posizione posizione della canzone nell'array 
     * @return restituisce l'oggetto della canzone, altrimenti un messaggio di errore
     * in caso la posizione inserita sia vuota o on valida
     * @throws EccezionePosNonValida
     * @throws EccezionePosVuota 
     */
    public Canzone getCanzone(int posizione) throws EccezionePosNonValida, EccezionePosVuota
    {
        Canzone canz;
        if(posizione<0 || posizione>NUM_MAX_TRACCE)
            throw new eccezioni.EccezionePosNonValida();
        
        if(tracce[posizione] == null)
            throw new eccezioni.EccezionePosVuota();
        
        canz = tracce[posizione];
        return new Canzone(canz);
        
    }
            
            
    /**
     * Restituisce il numero massimo di tracce
     * che possono essere aggiunte alla playlist
     * @return  
     */
    public int getNumMaxTracce()
    {
        return NUM_MAX_TRACCE;
    }
    
    /**
     * Restituisce il numero di tracce
     * presenti nella playlist
     * @return 
     */
    public int getNumTracce()
    {
        int contatore=0;
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            if(tracce[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    /**
     * Rimuove dalla playlist la traccia
     * in posizione "posizione"
     * @param posizione la posizione della traccia che si vuole
     * rimuovere
     * @throws EccezionePosNonValida
     * @throws eccezioni.EccezioneCanzoneNonTrovata 
     */
    public void rimuoviTraccia(int posizione) throws EccezionePosNonValida, EccezioneCanzoneNonTrovata
    {
        if(posizione<0 || posizione>NUM_MAX_TRACCE)
            throw new EccezionePosNonValida();
 
        if (tracce[posizione]==null)
                throw new EccezioneCanzoneNonTrovata();
        
        tracce[posizione] = null;
    }
    
    
    /**
     * Resituisce un array di stringhe contenente tutte le canzoni
     * corrispondenti all'artista inserito
     * @param artistaDaCercare l'artista di cui si vuole vedere tutte le canzoni
     * @return 
     */
    public String[] elencoCanzoniArtista (String artistaDaCercare)
    {
        int contaCanzoniArtista=0;
        Canzone canz;
        String[] elencoCanzoniArtista;
        
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getArtista().equalsIgnoreCase(artistaDaCercare))
                        contaCanzoniArtista++;   
                } 
                catch (EccezionePosNonValida ex)
                {
                    //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                        //non fare nulla.
                }
            }
        
        
        if (contaCanzoniArtista==0)
            return null; 
        elencoCanzoniArtista = new String[contaCanzoniArtista];
        
        contaCanzoniArtista=0; 
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getArtista().equalsIgnoreCase(artistaDaCercare))
                    {
                        elencoCanzoniArtista[contaCanzoniArtista]=canz.toString();
                        contaCanzoniArtista++;
                    } 
                } 
                catch (EccezionePosNonValida ex) 
                {
                       //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                    //non fare nulla
                }
            }
        
        return elencoCanzoniArtista;
    }
    
    /**
     * Restituisce un array di stringhe contenente tutte le canzoni
     * corrispondenti al titolo inserito
     * @param titoloDaCercare il titolo della canzone che si vuole cercare
     * @return 
     */
    public String[] elencoCanzoniTitolo (String titoloDaCercare)
    {
        int contaCanzoniTitolo=0;
        Canzone canz;
        String[] elencoCanzoniTitolo;
        
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getTitolo().equalsIgnoreCase(titoloDaCercare))
                        contaCanzoniTitolo++;   
                } 
                catch (EccezionePosNonValida ex)
                {
                    //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                        //non fare nulla.
                }
            }
        
        
        if (contaCanzoniTitolo==0)
            return null; 
        elencoCanzoniTitolo = new String[contaCanzoniTitolo];
        
        contaCanzoniTitolo=0; 
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getTitolo().equalsIgnoreCase(titoloDaCercare))
                    {
                        elencoCanzoniTitolo[contaCanzoniTitolo]=canz.toString();
                        contaCanzoniTitolo++;
                    } 
                } 
                catch (EccezionePosNonValida ex) 
                {
                       //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                    //non fare nulla
                }
            }
        
        return elencoCanzoniTitolo;
    }
    
    /**
     * Restituisce un array di stringhe contenente tutte le canzoni corrispondenti
     * al genere inserito
     * @param genereDaCercare il genere le cui canzoni si vuole trovare
     * @return 
     */
    public String[] elencoCanzoniGenere (String genereDaCercare)
    {
        int contaCanzoniGenere=0;
        Canzone canz;
        String[] elencoCanzoniGenere;
        
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getGenere().equalsIgnoreCase(genereDaCercare))
                        contaCanzoniGenere++;   
                } 
                catch (EccezionePosNonValida ex)
                {
                    //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                        //non fare nulla.
                }
            }
        
        
        if (contaCanzoniGenere==0)
            return null; 
        elencoCanzoniGenere = new String[contaCanzoniGenere];
        
        contaCanzoniGenere=0; 
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            
                try 
                {
                    canz=this.getCanzone(i);
                    if (canz.getGenere().equalsIgnoreCase(genereDaCercare))
                    {
                        elencoCanzoniGenere[contaCanzoniGenere]=canz.toString();
                        contaCanzoniGenere++;
                    } 
                } 
                catch (EccezionePosNonValida ex) 
                {
                       //non succederà mai
                } 
                catch (EccezionePosVuota ex) 
                {
                    //non fare nulla
                }
            }
        
        return elencoCanzoniGenere;
    }
    
    /**
     * Esporta su un file CSV il contenuto dell'array Playlist
     * @param nomeFile il nome del file csv su cui verranno salvate
     * le informazioni
     * @throws IOException 
     */
    public void esportaCSV(String nomeFile) throws IOException
    {
        TextFile f1;
        Canzone canz;
        
        f1 = new TextFile(nomeFile, 'W');
        String datiTraccia;
        for(int i=0;i<this.getNumMaxTracce();i++)
        {
            try 
            {
                canz = this.getCanzone(i);
                datiTraccia = i+";"+canz.getIdCanzone()+";"+canz.getTitolo()+";"+canz.getArtista()+";"+canz.getGenere()+";"+canz.getDataUscita();
                f1.toFile(datiTraccia);
            } 
            catch (EccezionePosNonValida ex) 
            {
                //Non succederà mai
            } 
            catch (EccezionePosVuota ex) 
            {
                //Non fare nulla, vai alla prossima posizione
            } 
            catch (FileException ex) 
            {
                //Non succederà mai
            }
        }
        f1.closeFile();
        System.out.println("Esportazione avvenuta correttamente");
        
    }
    
    /**
     * Importa da un file CSV le informazioni sulle canzoni e le carica
     * nell'array playlist
     * @param nomeFile nome del file CSV dal quale verranno caricate
     * le informazioni
     * @throws IOException 
     */
    public void importaDaCSV(String nomeFile) throws IOException
    {
        String rigaLetta;
        String[] datiTraccia;
        TextFile f1;
        String titolo, artista, genere;
        String durata;
        long idCanzone;
        LocalDate dataUscita;
        Canzone canz;
        int posizione;
        
        f1 = new TextFile(nomeFile, 'R');
        do
        {
            try
            {
                rigaLetta = f1.fromFile();
                datiTraccia = rigaLetta.split(";");
                posizione = Integer.parseInt(datiTraccia[0]);
                titolo = datiTraccia[1];
                artista = datiTraccia[2];
                genere = datiTraccia[3];
                durata = datiTraccia[4];
                dataUscita = LocalDate.parse(datiTraccia[5]);
                canz = new Canzone(titolo, artista, durata, genere, dataUscita);
                
                try 
                {
                    this.setCanzone(canz, posizione);
                } 
                catch (EccezionePosNonValida ex) 
                {
                    //Non succederà mai
                } 
                catch (EccezionePosOccupata ex) 
                {
                    //Non succederà mai
                }
            }
            
            catch(FileException ex)
            {
                f1.closeFile();
                break;
            }
            }while(true);
            
        }
    
    /**
     * Salva su un file binario il contenuto dell'array playlist
     * @param nomeFile nome del file binario su cui verranno salvate le informazioni
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public void salvaDati(String nomeFile) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream (nomeFile));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    /**
     * Carica da un file binario le informazioni della playlist
     * @param nomeFile nome del file binario dal quale verranno caricate
     * le informazioni
     * @return la playlist
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Playlist caricaDati(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Playlist p1;
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(nomeFile));
        p1 = (Playlist)reader.readObject();
        reader.close();
        return p1;
    }
    
    /**
     * Modifica il titolo di una canzone in posizione "posizione"
     * @param posizione posizione della canzone di cui si vuole modificare il titolo
     * @param nuovoNome nuovo titolo che si vuole dare alla canzone
     * @throws EccezionePosNonValida
     * @throws EccezionePosVuota 
     */
    public void modificaCanzoneNome(int posizione, String nuovoNome) throws EccezionePosNonValida, EccezionePosVuota 
    {
    
    if (posizione < 0 || posizione >= NUM_MAX_TRACCE) 
    {
        throw new EccezionePosNonValida();
    }
    
    
    if (tracce[posizione] == null) 
    {
        throw new EccezionePosVuota();
    }
    
   
        tracce[posizione].setTitolo(nuovoNome);
        System.out.println("Il titolo della canzone è stato modificato correttamente.");
    }
    
    /**
     * Modifica l'artista di una canzone in posizione "posizione"
     * @param posizione posizione della canzone di cui si vuole modificare l'artista
     * @param nuovoArtista nome del nuovo artista da assegnare alla canzone
     * @throws EccezionePosNonValida
     * @throws EccezionePosVuota 
     */
    public void modificaCanzoneArtista(int posizione, String nuovoArtista) throws EccezionePosNonValida, EccezionePosVuota 
    {
   
    if (posizione < 0 || posizione >= NUM_MAX_TRACCE) 
    {
        throw new EccezionePosNonValida();
    }
    
    
    if (tracce[posizione] == null) 
    {
        throw new EccezionePosVuota();
    }
    
        Canzone canzoneDaModificare = tracce[posizione];
        canzoneDaModificare.setArtista(nuovoArtista);
    }


    
    
    

          
    
    
    /**
     * Restituisce una stringa contenente
     * i dati della playlist
     * @return 
     */
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            if (tracce[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+"\n"+tracce[i].toString()+"\n";
        }
        
        return s;
    }
            
    
}
