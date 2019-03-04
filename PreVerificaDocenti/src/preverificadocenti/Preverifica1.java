/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverificadocenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author gianlucanarducci
 */
public class Preverifica1 {

    /**
     * @param args the command line arguments
     */
    
         
     public static void main(String[] args) {
        List docenti = null;
        Parser dom = new Parser();
        String giorno;
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String scelta;
        String docente;
        
        try {
            System.out.println("Ciao, 1) Giorno   2)Docente");
            scelta=tastiera.readLine();
            if(scelta.equals("1")){
            System.out.println("INSERIRE IL GIORNO");
            giorno=tastiera.readLine();
            docenti = dom.parseDocument("RicevimentoDocenti.xml",giorno);}
            if(scelta.equals("2")){
                System.out.println("INSERIRE IL DOCENTE");
                docente=tastiera.readLine();
                docenti = dom.cercaDocente("RicevimentoDocenti.xml",docente);
            }
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
        Iterator iterator = docenti.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
     }
    
}
