/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosfunciones;

import static java.lang.Thread.sleep;

/**
 *
 * @author crisantru
 */
public class Contador implements Runnable {
    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("Hilo: " + i);
            
            try{
                sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
