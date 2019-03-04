package preverificadocenti;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List docenti;

    public Parser() {
        docenti = new ArrayList();
    }

    public List parseDocument(String filename, String giorno)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        boolean coincide = false;
        String[] datiDocente = null;

        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "link"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                datiDocente = getTextValue(element, "td");
                try {
                    Docente docente = new Docente(datiDocente[1], datiDocente[2], datiDocente[3]);
                    if (datiDocente[2].equals(giorno)) {
                        docenti.add(docente);
                    }
                } catch (Exception ex) {
                }
            }
        }
        return docenti;
    }

    public List cercaDocente(String filename, String docente)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        boolean coincide = false;
        String[] datiDocente = null;

        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "link"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                datiDocente = getTextValue(element, "td");
                try {
                    Docente docenteTest = new Docente(datiDocente[1], datiDocente[2], datiDocente[3]);
                    if (datiDocente[1].contains(docente)) {
                        docenti.add(docenteTest);
                    }
                } catch (Exception ex) {
                }
            }
        }
        return docenti;
    }
    private String GetContent(Element element) {
        return element.getFirstChild().getNodeValue();
    }

    // restituisce il valore testuale dell’elemento figlio specificato
    private String[] getTextValue(Element element, String tag) {
        NodeList td = element.getElementsByTagName("td");
        String[] datiDocente = new String[td.getLength()];
        for (int j = 0; j < td.getLength(); j++) {
            element = (Element) td.item(j);
            if (element != null && element.getFirstChild() != null) {
                String dati = GetContent(element);
                if (!dati.equals(null)) {
                    datiDocente[j] = dati;
                }
            }
        }
        return datiDocente;
    }
            
}
