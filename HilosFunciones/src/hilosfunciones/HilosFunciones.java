/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosfunciones;

/**
 *
 * @author crisantru
 */
public class HilosFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Contador());
        t1.start();
        
        /*try{
            t1.join();
            
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }*/
        while(t1.isAlive()){}
        System.out.println("El hilo t1 termino");
    }
    
}
