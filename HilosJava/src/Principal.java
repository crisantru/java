/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisantru
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContadorThread  h1 = new ContadorThread("Cristian", 1, 10);
        h1.start();
        
        ContadorThread  h2 = new ContadorThread("Bulnes", 1, 10);
        h2.start();
        
        Thread h3 = new Thread(new ContadorRunnable("Rueda", 1, 10));
        h3.start();
        
        Thread h4 = new Thread(new ContadorRunnable("Falfan", 1, 10));
        h4.start();
    }
    
}
