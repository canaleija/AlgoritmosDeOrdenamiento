/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;
import algoritmos.SelectionSort;
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
        Grafica g1 = new Grafica("GRafica", "x", "y");
        g1.agregarSerie(new double[]{4.0,5.1,7.8,8.9}, "Algoritmo1");
        g1.agregarSerie(new double[]{4.6,5.1,7.8,10.9}, "Algoritmo2");
        g1.agregarSerie(new double[]{5.3,5.1,7.8,56.9}, "Algoritmo3");
        g1.creaYmuestraGrafica();
//        
//       
//        
//        try {
//            // creamos un algoritmo de ordenamiento
//            
//            Carrera carrera1 = new Carrera(2000);
//            carrera1.agregaAlgoritmo(new Burbuja());
//            carrera1.agregaAlgoritmo(new BurbujaOptimizado());
//            carrera1.agregaAlgoritmo(new SelectionSort());
//            carrera1.ejecutaPrueba();
//         
//            System.out.println();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AlgoritmosDeOrdenamiento.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
    }
    
}
