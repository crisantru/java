/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocuentabancaria;

/**
 *
 * @author Antonio Tablada
 */
public class Ahorrador extends Thread {
    
    private String nombre;
    private CuentaBancaria cb;
    private Double monto;
     
    public Ahorrador(String nombre, CuentaBancaria cb, Double monto){
        this.nombre= nombre;
        this.cb=cb;
        this.monto=monto;      
    }

    
    public void run(){
       for(int i=0; i<3; i++){
           this.cb.depositar(monto,this.nombre);
           try{
               sleep(2000);
           }catch(InterruptedException ex){
               ex.printStackTrace();
           }
       }
    }
       
    
}
