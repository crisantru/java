/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocuentabancaria;

/**
 *
 * @author xxmadoo
 */
public class CuentaBancaria {
    private double importe;
    
    public CuentaBancaria(Double importe){
        this.importe = importe;
    }
    public synchronized void depositar(){
        this.importe += importe;
    }
    public synchronized boolean retirar(Double importe){
        if (this.importe>=importe){
            this.importe-= importe;
            return true;
        }
        return false;
    }
    public synchronized double consultaSaldo(){
        return this.importe;
    }
}
