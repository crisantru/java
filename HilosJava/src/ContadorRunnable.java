/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisantru
 */
public class ContadorRunnable implements Runnable {
    
    private String nombre;
    private int inicio;
    private int termino;

    public ContadorRunnable(String nombre, int inicio, int termino) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.termino = termino;
    }
    
    
    @Override
    public void run() {
        
        System.out.println("--- Inicia Hilo: " + nombre);
        
        while(inicio <= termino){
            System.out.println(String.format("Hilo %s - valor: %s", nombre, inicio));
            inicio++;
        }
        
        System.out.println("*** Termina Hilo: " + nombre);
        
    }
    
}
