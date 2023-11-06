/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad_practica1.pkg1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
    
    public void recorreDOMyMuestra() {
        
        //Guardamos la información de cada libro
        String[] datos = new String[3];
        Node nodo;
        
        Node root = doc.getFirstChild();
        NodeList nodelist = root.getChildNodes();
        
        //Recorrer el arbol DOM. El 1er nivel de nodos hijos del raiz
        for (int i = 0; i < nodelist.getLength(); i++) {
            
            //nodo toma el valor de los hijos del raiz
            nodo = nodelist.item(i);
            
            //Comprobamos que es la variable nodo es un nodo
            if (nodo.getNodeType()==Node.ELEMENT_NODE) {
                Node ntemp;
                int contador = 1;
                
                //Obtenemos el valor de del atributo de libro
                datos[0] = nodo.getAttributes().item(0).getNodeValue();
                
                //Sacamos los valores de los hijos del nodo, Titulo y Autor
                NodeList n12 = nodo.getChildNodes();
                
                for (int j = 0; j < n12.getLength(); j++) {
                    
                    ntemp = n12.item(j);
                    
                    if(ntemp.getNodeType() == Node.ELEMENT_NODE) {
                        //Para obtener el texto del titulo y autor se puede hacer con getNodeValue()
                        //Si es un ELEMENT getTextContent()

                        datos[contador] = ntemp.getTextContent();
                        //Alternativa: datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
                        contador++;
                    }
                }
                //El array de String datos[] tiene los valores que necesitamos
                    System.out.println(datos[0]+"--"+datos[2]+"--"+datos[1]);
            }
        }
    }
    
}
