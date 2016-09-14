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
public class OrdenamientoRapido implements AlgoritmoOrdenamiento, Runnable{
    // atributos globales de la clase 
    private double[] datos;
    private int noVer,noInter;
    private double tiempo_e;
    private double tiempo_i,tiempo_f;

    public OrdenamientoRapido() {
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
        return "Rapido: "+this.tiempo_e; //To change body of generated methods, choose Tools | Templates.
    }

    private void ordenar(double[] tmpArray, int izq, int der) {
        // seleccionar el pivote 
        double pivote = tmpArray[izq];
        // realiza la busqueda de izq a derecha
        int i = izq;
        // realiza la busqueda de derecha a izq
        int j = der;
        double aux;
        
        // mientras no se crucen las busquedas ( i y j)
        while (i<j){
            // buscar elemento mayor al pivote 
            while (tmpArray[i]<= pivote && i<j) i++;
            
            // buscar el elemento menor al pivote
            while(tmpArray[j]>pivote) j--;
          // si no se han cruzado i y j
          // hacer intercambio
          if (i < j) {
          aux = tmpArray[i];
          tmpArray[i] = tmpArray[j];
          tmpArray[j] = aux;
          
          }
        }
        // colocar el pivote en su lugar de forma en que tendremos los menores 
        // a su izquierda y los mayores a su derecha
        tmpArray[izq] = tmpArray[j];
        tmpArray[j] = pivote;
        /// ordenar el sub arreglo izq
        if (izq<j-1)
            ordenar(tmpArray,izq,j-1);
          /// ordenar el sub arreglo der
        if (j+1 < der)
            ordenar(tmpArray, j+1, der);
        
    }

   
}
