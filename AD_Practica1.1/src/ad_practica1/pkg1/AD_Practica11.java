/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_practica1.pkg1;

import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author xChas
 */
public class AD_Practica11 {

    public static void main(String[] args) {
        
        AccesoDOM accesoDOM = new AccesoDOM();
        File fichero = new File("libros.xml");
        accesoDOM.abrirXMLaDOM(fichero);
        BufferedReader entrada = null;
        String linea;
        accesoDOM.recorreDOMyMuestra();
        accesoDOM.insertarLibroEnDom("El nombre del viento", "Patricio", "01-01-2005");
        accesoDOM.abrirXMLaDOM(fichero);
        
    }
    
}
