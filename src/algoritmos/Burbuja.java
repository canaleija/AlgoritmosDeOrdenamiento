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
public class Burbuja implements AlgoritmoOrdenamiento,Runnable{

    private double[] datos;
    private int noVer,noInter;
    private double tiempo_e;
    private double tiempo_i,tiempo_f;

    public Burbuja() {
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
       // implentar el metodo de ordenamiento por burbuja
       // verificar que los datos no sean nulos
       
       if (datos != null){
        
           // calculamos el tiempo del sistema en milis
           this.tiempo_i = System.currentTimeMillis();
           for (int i=0; i < this.datos.length-1;i++){
              for(int j=0; j < this.datos.length-1;j++){
                 // se ejecuta la verificaciòn
                  if (this.datos[j]>this.datos[j+1]){
                    // se ejecuta el intercambio 
                    double aux = this.datos[j];
                    this.datos[j] = this.datos[j+1];
                    this.datos[j+1] = aux;
                    // contando el numero de intercambios
                    this.noInter++;
                  }
                  this.noVer++;
               }
           }
           // calculamos el tiempo del sistema en milis   
           this.tiempo_f = System.currentTimeMillis();
       
       }else {
       System.out.println("Los datos son nulos");
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
        return "Burbuja: "+this.tiempo_e; //To change body of generated methods, choose Tools | Templates.
    }
    
}
