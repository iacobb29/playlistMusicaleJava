/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmusicale;

import eccezioni.EccezionePosNonValida;
import eccezioni.EccezionePosOccupata;
import eccezioni.EccezionePosVuota;
import eccezioni.FileException;
import java.io.IOException;
import utilita.TextFile;

/**
 *
 * @author Studente
 */
public class Playlist 
{
    private final static int NUM_MAX_TRACCE = 1000;
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
        
        tracce[posizione] = new Canzone(traccia);
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
    
    public Canzone[] cercaCanzoniArtista(String artista) 
    {
        
        Canzone[] canzoniArtista = new Canzone[NUM_MAX_TRACCE];
        int contatore = 0;

        for (int i = 0; i < NUM_MAX_TRACCE; i++) 
        {
            if (tracce[i] != null && tracce[i].getArtista().equalsIgnoreCase(artista)) 
            {
                canzoniArtista[contatore] = tracce[i];
                contatore++;
            }
            else if(contatore == 0)
            {
                return null;
            }
        }
        return canzoniArtista;
    }
    
    public Canzone[] cercaCanzoniGenere(String genere) 
    {
        
        Canzone[] canzoniGenere = new Canzone[NUM_MAX_TRACCE];
        int contatore = 0;

        for (int i = 0; i < NUM_MAX_TRACCE; i++) 
        {
            if (tracce[i] != null && tracce[i].getGenere().equalsIgnoreCase(genere)) 
            {
                canzoniGenere[contatore] = tracce[i];
                contatore++;
            }
            
            else if(contatore == 0)
            {
                return null;
            }
                
        }
        return canzoniGenere;
    }
    
    public Canzone[] cercaCanzoniTitolo(String titolo) 
    {
        
        Canzone[] canzoniTitolo = new Canzone[NUM_MAX_TRACCE];
        int contatore = 0;

        for (int i = 0; i < NUM_MAX_TRACCE; i++) 
        {
            if (tracce[i] != null && tracce[i].getTitolo().equalsIgnoreCase(titolo)) 
            {
                canzoniTitolo[contatore] = tracce[i];
                contatore++;
            }
            
            else if(contatore == 0)
            {
                return null;
            }
        
        
        }
        return canzoniTitolo;
    }
    
    
   
        
    

    
    
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_TRACCE;i++)
        {
            if (tracce[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+tracce[i].toString()+"\n";
        }
        
        return s;
    }
            
    
}
