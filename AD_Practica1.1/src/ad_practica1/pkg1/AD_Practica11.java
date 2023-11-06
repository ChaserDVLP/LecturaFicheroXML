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
        
        /*try {
            entrada = new BufferedReader(new FileReader(fichero));
            linea = entrada.readLine();
            while (linea != null) {                
                System.out.println(linea);
                linea = entrada.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
        
    }
    
}
