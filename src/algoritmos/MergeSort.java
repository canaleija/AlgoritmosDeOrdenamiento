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
public class MergeSort implements AlgoritmoOrdenamiento,Runnable {

    private double[] datos;
    private int noVer,noInter;
    private double tiempo_e;
    private double tiempo_i,tiempo_f;

    public MergeSort() {
        this.noVer = 0;
        this.noInter = 0;
        this.datos = null;
        this.tiempo_e = 0;
        this.tiempo_i = 0;
        this.tiempo_f = 0;
    }
        
    @Override
    public void obtenerDatos(double[] datos) {
        // recibimos los datos a ordenar 
        this.datos = datos;
    }

    @Override
    public void ordenarDatos() {
      // implementar el metodo de ordenamiento por mezcla
      // verificar que los datos no sean nulos
      if (datos != null){
         double tmpArray []=  this.datos.clone();
         this.tiempo_i = System.currentTimeMillis();
         ordenar(tmpArray,0,tmpArray.length-1);
         // calculamos el tiempo del sistema en milis   
           this.tiempo_f = System.currentTimeMillis();
       
      }
      this.tiempo_e = (this.tiempo_f - this.tiempo_i)/1000;
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
        return "Mezcla: "+this.tiempo_e; //To change body of generated methods, choose Tools | Templates.
    }

    private void ordenar(double[] tmpArray, int left, int right) {
        // verificar por lo menos left sea menor que right
        if (left < right){
           int center = (left+right)/2;
            ordenar(tmpArray, left, center);
            ordenar(tmpArray, center+1, right);
            merge(tmpArray,left,center+1,right);
        }
        
    }

    private void merge(double[] tmpArray, int leftpos, int rightpos, int rightEnd) {
        // establecer unos limites
        int leftEnd = rightpos - 1;
        int tmpPos = leftpos;
        // calcular un numero de elementos 
        int numElements = rightEnd - leftpos + 1;
        
        // generar los cambios en el arreglo temporal 
        while (leftpos <= leftEnd && rightpos<=rightEnd) {
            if (this.datos[leftpos]<this.datos[rightpos]){
              tmpArray[tmpPos++] = this.datos[leftpos++];
            }else {
               tmpArray[tmpPos++] = this.datos[rightpos++];
            }
        }
        // copiar el resto de la primera mitad
        while (leftpos <= leftEnd){
          tmpArray[tmpPos++] = this.datos[leftpos++];
        }        
        // copiar el resto de la segunda mitad
         while (rightpos <= rightEnd){
          tmpArray[tmpPos++] = this.datos[rightpos++];
        }  
        
        // actualizar el arreglo 
        // recorrer el arreglo
        for (int i = 0; i < numElements; i++, rightEnd--){
        this.datos[rightEnd] = tmpArray[rightEnd];
        }
            
    }
}
