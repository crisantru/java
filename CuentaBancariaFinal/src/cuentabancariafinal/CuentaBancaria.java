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
public class CuentaBancaria {
    private Double importe;
    private JTextArea log;
    
    
    public CuentaBancaria(Double importe){
        this.importe=importe;
    }
    
public synchronized void depositar(Double importe, String nombre, JTextArea log){
    this.importe +=importe;
    this.log.append( String.format("\n%s deposito %s - la cuenta tiene un " + "saldo de %s \n",nombre, importe, this.importe));
    this.log.getText();
    //String mensaje = 
      //      String.format("%s deposito %s - la cuenta tiene un "
        //            + "saldo de %s \n",
          //          nombre, importe, this.importe);
        //System.out.println(mensaje);
    
}

public synchronized boolean retirar(Double importe){
    if(this.importe>=importe){
        this.importe -= importe;
        return true;
    }
        return false;
}

public synchronized Double consultarSaldo(){
    return this.importe;
}

   

}
