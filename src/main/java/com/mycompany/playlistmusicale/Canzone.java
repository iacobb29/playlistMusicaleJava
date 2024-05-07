/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmusicale;

import java.time.LocalDate;

/**
 *Rappresenta una canzone
 * @author Studente
 */
public class Canzone 
{
    private String titolo;
    private String artista;
    private long idCanzone;
    private String durata;
    private String genere;
    private LocalDate dataUscita;
    private static long nextID = 1;
    

    /**
     * Classe costruttore della canzone
     * @param titolo Titolo della canzone
     * @param artista Nome dell'artista
     * @param durata Durata della canzone
     * @param genere Genere della canzone
     * @param dataUscita Data di rilascio della canzone
     */
    public Canzone(String titolo, String artista, String durata, String genere, LocalDate dataUscita) 
    {
        this.idCanzone = nextID;
        nextID++;
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
        this.genere = genere;
        this.dataUscita = dataUscita;
        
    }
    
    /**
     * Costruttore di copia
     * @param canz 
     */
    public Canzone(Canzone canz)
    {
        this.idCanzone= canz.idCanzone;
        this.titolo = canz.getTitolo();
        this.artista = canz.getArtista();
        this.durata = canz.getDurata();
        this.genere = canz.getGenere();
        this.dataUscita = canz.getDataUscita();
    }
    
    

    public String getTitolo() 
    {
        return titolo;
    }

    public void setTitolo(String titolo) 
    {
        this.titolo = titolo;
    }

    public String getArtista() 
    {
        return artista;
    }

    public void setArtista(String artista) 
    {
        this.artista = artista;
    }

    public long getIdCanzone() 
    {
        return idCanzone;
    }
    
    public String getDurata() 
    {
        return durata;
    }

    public void setDurata(String durata) 
    {
        this.durata = durata;
    }

    public String getGenere() 
    {
        return genere;
    }

    public void setGenere(String genere) 
    {
        
        this.genere = genere;
    }

    public LocalDate getDataUscita() 
    {
        return dataUscita;
    }

    public void setDataUscita(LocalDate dataUscita) 
    {
        this.dataUscita = dataUscita;
    }
    
    
    /**
     * Restituisce una stringa che contiene i dati di una canzone
     * @return 
     */
    public String toString()
    {
        String s = "Id: "+getIdCanzone()+";"+"\n"+"Titolo: "+getTitolo()+";"+"\n"+"Artista: "+getArtista()+";"+"\n"+"Genere: "+getGenere()+"\n"+"Durata: "+getDurata()+";"+"\n"+"Data di rilascio: "+getDataUscita()+"\n";
        return s;
    }
  
    
    
    
    
}
