/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmusicale;

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
 *
 * @author Studente
 */
public class Playlist implements Serializable
{
    private final static int NUM_MAX_TRACCE = 10;
    private Canzone[] tracce;
    
    public Playlist()
    {
        tracce = new Canzone[NUM_MAX_TRACCE];
    }
    
    public void setCanzone(Canzone traccia, int posizione) throws EccezionePosNonValida, EccezionePosOccupata
    {
        if(posizione<0 || posizione>NUM_MAX_TRACCE)
            throw new eccezioni.EccezionePosNonValida();
        
        if(tracce[posizione]!=null)
            throw new eccezioni.EccezionePosOccupata();
        
        tracce[posizione] = traccia;
    }
    
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
            
            
    
    public int getNumMaxTracce()
    {
        return NUM_MAX_TRACCE;
    }
    
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
    
    public void rimuoviTraccia(int posizione) throws EccezionePosNonValida, EccezionePosVuota
    {
        if(posizione<0 || posizione>NUM_MAX_TRACCE)
            throw new EccezionePosNonValida();
 
        if (tracce[posizione]==null)
                throw new EccezionePosVuota();
        
        tracce[posizione] = null;
    }
    
    public String[] elencoCanzoniArtista (String artistaDaCercare)
    {
        int contaCanzoniArtista=0;
        Canzone canz;
        String[] elencoCanzoniArtista;
        
        for(int i=0;i<getNumTracce();i++)
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
        for(int i=0;i<getNumTracce();i++)
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
    
    public String[] elencoCanzoniTitolo (String titoloDaCercare)
    {
        int contaCanzoniTitolo=0;
        Canzone canz;
        String[] elencoCanzoniTitolo;
        
        for(int i=0;i<getNumTracce();i++)
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
        for(int i=0;i<getNumTracce();i++)
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
    
    public String[] elencoCanzoniGenere (String genereDaCercare)
    {
        int contaCanzoniGenere=0;
        Canzone canz;
        String[] elencoCanzoniGenere;
        
        for(int i=0;i<getNumTracce();i++)
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
        for(int i=0;i<getNumTracce();i++)
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
    
    public void salvaDati(String nomeFile) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream (nomeFile));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    public Playlist caricaDati(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Playlist p1;
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(nomeFile));
        p1 = (Playlist)reader.readObject();
        reader.close();
        return p1;
    }
    
    
    public void modifica(int posizione, String nuovoTitolo, String nuovoArtista, String nuovoGenere, String nuovaDurata, LocalDate nuovaDataUscita) throws EccezionePosNonValida, EccezionePosVuota 
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
    canzoneDaModificare.setTitolo(nuovoTitolo);
    canzoneDaModificare.setArtista(nuovoArtista);
    canzoneDaModificare.setGenere(nuovoGenere);
    canzoneDaModificare.setDurata(nuovaDurata);
    canzoneDaModificare.setDataUscita(nuovaDataUscita);
}

          
    
    
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
