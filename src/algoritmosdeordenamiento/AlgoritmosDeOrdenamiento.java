/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosDeOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // creamos un algoritmo de ordenamiento
            
            Carrera carrera1 = new Carrera(20000);
            carrera1.agregaAlgoritmo(new Burbuja());
            carrera1.agregaAlgoritmo(new BurbujaOptimizado());
            carrera1.agregaAlgoritmo(new Burbuja());
            carrera1.ejecutaPrueba();
         
            System.out.println();
        } catch (InterruptedException ex) {
            Logger.getLogger(AlgoritmosDeOrdenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
