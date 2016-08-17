/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Roberto Cruz Leija
 */
public interface AlgoritmoOrdenamiento  {
  // definir de una forma abstracta los 
  // comportamientos de un algoritmo de ordenamiento 
    public void obtenerDatos(double[] datos);
    public void ordenarDatos();
    public double[] getResultado();
}
