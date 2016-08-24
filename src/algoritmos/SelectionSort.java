/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import interfaces.AlgoritmoOrdenamiento;

/**
 *
 * @author Roberto Cruz Leija
 */
public class SelectionSort implements AlgoritmoOrdenamiento,Runnable{

    private double[] datos;
    private int noVer,noInter;
    private double tiempo_e;
    private double tiempo_i,tiempo_f;

    public SelectionSort() {
      
        this.noVer = 0;
        this.noInter = 0;
        this.datos = null;
        this.tiempo_e = 0;
        this.tiempo_i = 0;
        this.tiempo_f = 0;
    }
    
    @Override
    public void obtenerDatos(double[] datos) {
        // asignando a los datos 
        this.datos = datos;
    }

    @Override
    public void ordenarDatos() {
       // programar el algoritmo e seleccion 
       
       // calculamos el tiempo del sistema en milis
       this.tiempo_i = System.currentTimeMillis();
       // recorrer el arreglo de datos 
       for (int x=0; x < datos.length-1;x++){
           int iM = x;
           // ciclo interno : actualizando el indice 
           for (int j = x + 1; j < datos.length; j++){
              // verificar si el elemento j es menor que  iM
              if (datos[j]<datos[iM]){
                 //actualizando el indice donde se encuentra el elemento menor
                  iM = j;
              }
            }
           // realizar el intercambio 
           if (x!=iM){
            double aux= datos[iM];
            datos[iM] = datos[x]; 
            datos[x] = aux;
           }
       
       }
       // calculamos el tiempo del sistema en milis   
       this.tiempo_f = System.currentTimeMillis();
       this.tiempo_e = (this.tiempo_f - this.tiempo_i)/1000;
       System.out.println();
    }

    @Override
    public double[] getResultado() {
       // retornamos los datos    
     return datos; 
    }
    
      /**
     * @return the noVer
     */
    public int getNoVer() {
        return noVer;
    }

    /**
     * @return the noInter
     */
    public int getNoInter() {
        return noInter;
    }

    /**
     * @return the tiempo_e
     */
    @Override
    public double getTiempo_e() {
        return tiempo_e;
    }

    @Override
    public void run() {
       // Aqui tiene que ordenar 
       ordenarDatos();
    }

    @Override
    public String toString() {
        return "Seleccion: "+this.tiempo_e; //To change body of generated methods, choose Tools | Templates.
    }
    
}
