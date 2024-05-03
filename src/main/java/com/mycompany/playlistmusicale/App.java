/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playlistmusicale;

import java.time.LocalDate;

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
       
        Playlist playlist= new Playlist();
                
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        
        
        
        
    }
}
