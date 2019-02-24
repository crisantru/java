/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariafinal;

import javax.swing.JTextArea;

/**
 *
 * @author Antonio Tablada
 */
public class Ahorrador extends Thread {
    
    private String nombre;
    private CuentaBancaria cb;
    private Double monto;
    private JTextArea log;
     
    public Ahorrador(String nombre, CuentaBancaria cb, Double monto, JTextArea log){
        this.nombre= nombre;
        this.cb=cb;
        this.monto=monto;
        this.log=log;
    }

    @Override
    public void run(){
       for(int i=0; i<3; i++){
           this.cb.depositar(monto,this.nombre,log);
           try{
               sleep(2000);
           }catch(InterruptedException ex){
               ex.printStackTrace();
           }
       }
    }
       
    
}
