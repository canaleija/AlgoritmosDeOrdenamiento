/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import Algoritmos.BurbujaOptimizado;
import algoritmos.Burbuja;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmosDeOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // creamos un algoritmo de ordenamiento
        double[] datos = Herramientas.generaArregloAleatorio(10000);
        double[] arreglo = datos.clone();
        
        Burbuja burbuja = new Burbuja();
        burbuja.obtenerDatos(datos);
        burbuja.ordenarDatos();
        double[] datosOrdenados = burbuja.getResultado();
        int nVer = burbuja.getNoVer();
        int nInt = burbuja.getNoInter();
        double te = burbuja.getTiempo_e();
       
        BurbujaOptimizado burbujaOp = new BurbujaOptimizado();
        burbujaOp.obtenerDatos(arreglo);
        burbujaOp.ordenarDatos();
        
        double[] datosOrdenados2 = burbujaOp.getResultado();
        int nVer2 = burbujaOp.getNumVerificaciones();
        int nInt2 = burbujaOp.getNumIntercambios();
        double te2 = burbujaOp.getTiempo_e();
        System.out.println();
       
    }
    
}
