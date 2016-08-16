/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import interfaces.AlgoritmoOrdenamiento;

/**
 *
 * @author É
 */
public class BurbujaOptimizado implements AlgoritmoOrdenamiento{
    
    private double[] datos;
    private int numIntercambios, numVerificaciones;
    private int bandera;
    private double tiempo_e;
    private double tiempo_i,tiempo_f;

    public BurbujaOptimizado() {
        this.numIntercambios = 0;
        this.numVerificaciones = 0;
        this.bandera = 1;
        this.datos = null;
        this.tiempo_e = 0;
        this.tiempo_i = 0;
        this.tiempo_f = 0;
    }
    
    @Override
    public void obtenerDatos(double[] datos) {
        this.datos = datos;
    }

    @Override
    public void ordenarDatos() {
        // Verifica que los datos no sean nulos
        if(datos != null){
            // Se detiene el ciclo si en el paso anterior no hubo cambios
             // calculamos el tiempo del sistema en milis
           this.tiempo_i = System.currentTimeMillis();
            for(int i = 0; i < this.datos.length - 1 && bandera == 1; i++) {
                bandera = 0;
                for(int j = 0; j < this.datos.length - i - 1; j++) {
                    // Se ejecuta el intercambio de datos
                    if(this.datos[j] > this.datos[j+1]) {
                        bandera = 1;
                        double aux = this.datos[j];
                        this.datos[j] = this.datos[j+1];
                        this.datos[j+1] = aux;
                        
                        // Cuenta el número de intercambios
                        numIntercambios++;
                    }
                    // Cuenta el número de verificaciones
                    numVerificaciones++;
                }
            }
            // calculamos el tiempo del sistema en milis   
           this.tiempo_f = System.currentTimeMillis();
        } else{
            System.err.println("Los datos son nulos!");
        }
         this.tiempo_e = (this.tiempo_f - this.tiempo_i)/1000;
    }

    @Override
    public double[] getResultado() {
        return datos;
    }

    /**
     * @return the numIntercambios
     */
    public int getNumIntercambios() {
        return numIntercambios;
    }

    /**
     * @return the numVerificaciones
     */
    public int getNumVerificaciones() {
        return numVerificaciones;
    }

    /**
     * @return the tiempo_e
     */
    public double getTiempo_e() {
        return tiempo_e;
    }
    
}
