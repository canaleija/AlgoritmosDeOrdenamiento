/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;
import algoritmos.InsertSort;
import algoritmos.MergeSort;
import algoritmos.OrdenamientoRapido;
import algoritmos.SelectionSort;
import interfaces.AlgoritmoOrdenamiento;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosDeOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
//        double arreglo[] = Herramientas.generaArregloAleatorio(10);
//        MergeSort ms = new MergeSort();
//        ms.obtenerDatos(arreglo);
//        Thread hilo = new Thread(ms);
//        hilo.start();
//        hilo.join();
//        System.out.println();
            
        
       
        
        // generar un numero definido de carreras 
        int numCarreras = 3000;
        ArrayList<Double[]> tiempos = new ArrayList<>();
        tiempos.add(new Double[numCarreras]);
        tiempos.add(new Double[numCarreras]);
//        tiempos.add(new Double[numCarreras]);
//        tiempos.add(new Double[numCarreras]);
//        tiempos.add(new Double[numCarreras]);
//        tiempos.add(new Double[numCarreras]);
        
        
        for (int x= 0; x < numCarreras;x++){
            
        ArrayList<AlgoritmoOrdenamiento> algoritmos = new ArrayList<>();
//        algoritmos.add(new Burbuja());
//        algoritmos.add(new BurbujaOptimizado());
//        algoritmos.add(new SelectionSort());
//        algoritmos.add(new InsertSort());
 
        algoritmos.add(new MergeSort());
        algoritmos.add(new OrdenamientoRapido());
       
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
//        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(0)), Burbuja.class.getSimpleName());
//        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(1)), BurbujaOptimizado.class.getSimpleName());
//        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(2)), SelectionSort.class.getSimpleName());
//        g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(3)), InsertSort.class.getSimpleName());
       
     g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(0)), MergeSort.class.getSimpleName());
      g1.agregarSerie(Herramientas.convertirArreglo(tiempos.get(1)), OrdenamientoRapido.class.getSimpleName());
         
       
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
