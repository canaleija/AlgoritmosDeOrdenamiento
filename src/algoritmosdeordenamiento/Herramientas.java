/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    
    public static double[] generaArregloAleatorio(int num){
    
        double[] arreglo = new double[num];
        Random ran = new Random();
        
        for (int x=0; x<num;x++){
         arreglo[x] = ran.nextInt(100);
        }
        return arreglo;
    }
    
}
