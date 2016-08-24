/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;
import algoritmos.SelectionSort;
import interfaces.AlgoritmoOrdenamiento;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SealedObject;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosDeOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        
       
        
        // generar un numero definido de carreras 
        int numCarreras = 500;
        ArrayList<Double[]> tiempos = new ArrayList<>();
        tiempos.add(new Double[numCarreras]);
        tiempos.add(new Double[numCarreras]);
        tiempos.add(new Double[numCarreras]);
        
        for (int x= 0; x < numCarreras;x++){
            
        ArrayList<AlgoritmoOrdenamiento> algoritmos = new ArrayList<>();
        algoritmos.add(new Burbuja());
        algoritmos.add(new BurbujaOptimizado());
        algoritmos.add(new SelectionSort());
           // 
           Carrera carreraActual = new Carrera(5*x);
           // agregamos los algoritmos 
           for (AlgoritmoOrdenamiento a: algoritmos){
           carreraActual.agregaAlgoritmo(a);
           }
           carreraActual.ejecutaPrueba();
           // agregamos los tiempos
           for (int y = 0; y < algoritmos.size();y++ ){
             tiempos.get(y)[x]= algoritmos.get(y).getTiempo_e();
           }
        }
        
        // la grafica 
        Grafica g1 = new Grafica("GRafica", "x", "y");
        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(0)), "Algoritmo1");
        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(1)), "Algoritmo2");
        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(2)), "Algoritmo3");
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
