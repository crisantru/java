/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariafinal;

import javax.swing.JTextArea;

/**
 *
 * @author Lu
 */
public class Usuario extends Thread {
    private String nombre;
    private CuentaBancaria cb;
    private Double monto;
    private Integer operaciones;
    private Double ImporteRetirado;
    private JTextArea log;
    
    public Usuario(String nombre, CuentaBancaria cb, Double monto,JTextArea log){
        this.nombre= nombre;
        this.cb=cb;
        this.monto=monto;
        this.operaciones=0;
        this.ImporteRetirado=0.0;
        this.log=log;
    }
    
    public void run(){
        boolean estatus = true;
        while (estatus && cb.consultarSaldo()>=0){
            estatus = cb.retirar(monto);
            if(estatus){
                //System.out.println(String.format("%s retiro: %s.. el saldo es de %s", this.nombre, this.monto, this.cb.consultarSaldo()));
                log.append(String.format("\n%s retiro: %s.. el saldo es de %s", this.nombre, this.monto, this.cb.consultarSaldo()));
                log.getText();
            this.operaciones = operaciones + 1;
            this.ImporteRetirado = this.ImporteRetirado + this.monto;
            
           }else{
                log.append(String.format("\n%s NO pudo realizar el retiro" + "de: %s.. el saldo es de: %s", this.nombre, this.monto, this.cb.consultarSaldo()));
                log.getText();
                //System.out.println(String.format("%s NO pudo realizar el retiro" + "de: %s.. el saldo es de: %s", this.nombre, this.monto, this.cb.consultarSaldo()));
                
            }  try{
            Thread.sleep(1000);
            
            }catch(Exception ex){
        ex.printStackTrace();
        }
        if(estatus){
            log.append("\nya no es posible retirar de la cuenta");
            log.getText();
            //System.out.println("ya no es posible retirar de la cuenta");
        }else{
            log.append("\nla cuenta se quedó sin fondos");
            log.getText();
            //System.out.println("la cuenta se quedó sin fondos");
        }
        
      //System.out.println(String.format("...... %s termino de utilizar la cuenta, realizo %s operaciones por un importe de: %s", this.nombre, this.monto, this.cb.consultarSaldo()));
      log.append(String.format("\n...... %s termino de utilizar la cuenta, realizo %s operaciones por un importe de: %s", this.nombre, this.monto, this.cb.consultarSaldo()));
      log.getText();
    }
    }
    
   /* public static void main(String arg[]){
        CuentaBancaria cb = new CuentaBancaria(800.0);
        System.out.println(String.format("El saldo inicial de la cuenta es de:" + ": %s", cb.consultarSaldo()));
        
        Usuario r1 = new Usuario("Juan", cb, 50.0);
        Usuario r2 = new Usuario("Ana", cb, 20.0);
        Usuario r3 = new Usuario("Miguel", cb, 70.0);
        
        Ahorrador a1 = new Ahorrador("Paquito",cb,200.00);
        Ahorrador a2 = new Ahorrador("Angelito",cb,100.00);
        
                
        r1.start(); 
        r2.start(); 
        r3.start();
        a1.start();
        a2.start();
        
        
        try{
            r1.join(); 
            r2.join(); 
            r3.join();
            a1.join();
            a2.join();
            
        } catch (InterruptedException ex){ex.printStackTrace();}
        
        System.out.println(String.format("**** El saldo FINAL de la cuenta es" + "de: %s", cb.consultarSaldo()));
    }*/
    
}
