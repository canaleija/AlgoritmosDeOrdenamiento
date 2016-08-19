/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;
import interfaces.AlgoritmoOrdenamiento;
import java.util.LinkedList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Carrera {
    
    // lista de algoritmos
    private LinkedList<AlgoritmoOrdenamiento> algoritmos;
    private double[] tiempos;
    private double[] datos;
    private int numAlgoritmos,n;
    

    public Carrera(int n) {
      //  this.numAlgoritmos = numAlgoritmos;
        this.tiempos = new double[numAlgoritmos];
        this.datos = new double[n];
        this.algoritmos = new LinkedList<>();
       this.n=n;
    }
    
    public void agregaAlgoritmo (AlgoritmoOrdenamiento algoritmo){
    
        if (this.algoritmos != null){
          this.algoritmos.add(algoritmo);
        }
    
    }
    
    public void ejecutaPrueba () throws InterruptedException{
        //vamos a crear 2 algoritmos
//        Burbuja a1 = new Burbuja();
//        BurbujaOptimizado a2 = new BurbujaOptimizado();
//        
//        // agregar a la linked
//        this.algoritmos.add(a1);
//        this.algoritmos.add(a2);
        
        // datos creados previamente 
        this.datos = Herramientas.generaArregloAleatorio(this.n);
        // crar un ciclo para ejecutar los alogoritmos y medir sus tiempos
        for (int x=0; x < this.algoritmos.size();x++){
         // mandar los datos a cada uno de los algoritmos
         double[] aux = this.datos.clone();
         this.algoritmos.get(x).obtenerDatos(aux);
         Thread hiloAux = new Thread((Runnable)this.algoritmos.get(x));
         // ejecutar los alglritmos en hilos independientes 
         hiloAux.start();
         hiloAux.join();
                
        }
        // imprimir los tiempos 
        for(AlgoritmoOrdenamiento a : this.algoritmos){
        System.out.println(a.toString()); 
        }
           
    }
    
    
    
    
}
