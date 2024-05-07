/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.playlistmusicale;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author iacob
 */
public class CanzoneTest 
{
    private Canzone canzone;

    @BeforeEach
    public void setup() {
        // Prima di ogni test, creiamo un'istanza di Canzone con dati validi
        canzone = new Canzone("Title 1", "Artist 1", "3:45", "Pop", LocalDate.of(2022, 1, 1));
    }

    @Test
    public void testCostruttoreFunzionante() {
        assertEquals("Title 1", canzone.getTitolo());
        assertEquals("Artist 1", canzone.getArtista());
        assertEquals("3:45", canzone.getDurata());
        assertEquals("Pop", canzone.getGenere());
        assertEquals(LocalDate.of(2022, 1, 1), canzone.getDataUscita());
    }

    @Test
    public void testSetTitolo() {
        canzone.setTitolo("New Title");
        assertEquals("New Title", canzone.getTitolo());
    }

    @Test
    public void testGetTitolo() {
        assertEquals("Title 1", canzone.getTitolo());
    }

    @Test
    public void testSetAutore() {
        canzone.setArtista("New Artist");
        assertEquals("New Artist", canzone.getArtista());
    }

    @Test
    public void testGetAutore() {
        assertEquals("Artist 1", canzone.getArtista());
    }

    @Test
    public void testSetDurata() {
        canzone.setDurata("4:30");
        assertEquals("4:30", canzone.getDurata());
    }

    @Test
    public void testGetDurata() {
        assertEquals("3:45", canzone.getDurata());
    }

    @Test
    public void testSetGenere() {
        canzone.setGenere("Rock");
        assertEquals("Rock", canzone.getGenere());
    }

    @Test
    public void testGetGenere() {
        assertEquals("Pop", canzone.getGenere());
    }

    @Test
    public void testSetDataUscita() {
        LocalDate newDate = LocalDate.of(2023, 2, 2);
        canzone.setDataUscita(newDate);
        assertEquals(newDate, canzone.getDataUscita());
    }

    @Test
    public void testGetDataUscita() {
        assertEquals(LocalDate.of(2022, 1, 1), canzone.getDataUscita());
    }

    @Test
    public void testToString() {
        String expectedString = "Id: " + canzone.getIdCanzone() + ";\n"
                + "Titolo: " + canzone.getTitolo() + ";\n"
                + "Artista: " + canzone.getArtista() + ";\n"
                + "Genere: " + canzone.getGenere() + ";\n"
                + "Durata: " + canzone.getDurata() + ";\n"
                + "Data di rilascio: " + canzone.getDataUscita() + "\n";
        assertEquals(expectedString, canzone.toString());
    }

    @Test
    public void testCostruttoreDiCopia() {
        Canzone canzoneCopia = new Canzone(canzone);
        assertEquals(canzone.getIdCanzone(), canzoneCopia.getIdCanzone());
        assertEquals(canzone.getTitolo(), canzoneCopia.getTitolo());
        assertEquals(canzone.getArtista(), canzoneCopia.getArtista());
        assertEquals(canzone.getDurata(), canzoneCopia.getDurata());
        assertEquals(canzone.getGenere(), canzoneCopia.getGenere());
        assertEquals(canzone.getDataUscita(), canzoneCopia.getDataUscita());
    }
}
    
    

    
    
