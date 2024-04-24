/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmusicale;

/**
 *
 * @author Studente
 */
public class Canzone 
{
    private String titolo;
    private String autore;
    private int idCanzone;
    private String durata;

    public Canzone(String titolo, String autore, int idCanzone, String durata) 
    {
        this.titolo = titolo;
        this.autore = autore;
        this.idCanzone = idCanzone;
        this.durata = durata;
    }
    
    

    public String getTitolo() 
    {
        return titolo;
    }

    public void setTitolo(String titolo) 
    {
        this.titolo = titolo;
    }

    public String getAutore() 
    {
        return autore;
    }

    public void setAutore(String autore) 
    {
        this.autore = autore;
    }

    public int getIdCanzone() 
    {
        return idCanzone;
    }

    public void setIdCanzone(int idCanzone) 
    {
        this.idCanzone = idCanzone;
    }

    public String getDurata() 
    {
        return durata;
    }

    public void setDurata(String durata) 
    {
        this.durata = durata;
    }
    
    
    
}
