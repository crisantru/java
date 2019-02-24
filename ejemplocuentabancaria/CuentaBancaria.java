/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocuentabancaria;

/**
 *
 * @author Lu
 */
public class CuentaBancaria {
    private Double importe;
    
    
    public CuentaBancaria(Double importe){
        this.importe=importe;
    }
    
public synchronized void depositar(Double importe, String nombre){
    this.importe +=importe;
    String mensaje = 
            String.format("%s deposito %s - la cuenta tiene un "
                    + "saldo de %s \n",
                    nombre, importe, this.importe);
        System.out.println(mensaje);
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
