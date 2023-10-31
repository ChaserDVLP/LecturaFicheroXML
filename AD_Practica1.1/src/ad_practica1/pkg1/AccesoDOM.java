/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad_practica1.pkg1;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 *
 * @author xChas
 */
public class AccesoDOM {
    
    Document doc;
    
    public int abrirXMLaDOM (File fichero) {
        
        try {
            System.out.println("Abriendo archivo XML file y generando DOM...");
            
            //Creamos nuevo objeto DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            //Ignorar comentarios y espacios en blanco
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            
            //DocumentBuilder tiene un metodo parse que es el que genere el DOM en memoria
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(fichero);
            System.out.println("DOM creado con exito");
            
            NodeList lista = doc.getElementsByTagName("*");
            for (int i = 0; i < lista.getLength(); i++) { 
                Element elemento = (Element)lista.item(i);
                String nodeName = elemento.getNodeName();
                
                switch (nodeName) {
                    case "Libro" -> System.out.println("<libro> ");
                    //Obtener el valor del nodo
                    case "Titulo" -> System.out.println("\t<Titulo> "+
                                elemento.getChildNodes().item(0).getNodeValue()+" </Titulo>");
                    case "Autor" -> {
                        System.out.println("\t<Autor> " +
                                elemento.getChildNodes().item(0).getNodeValue()+" </Autor>");
                        System.out.println("</Libro>");
                    }
                    default -> {
                    }
                }
            }
            
            //Ahora doc apunta el arbol DOM y podemos recorrerlo
            
            return 0;
            
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
    
}
