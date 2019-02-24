package prodcons;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisantru
 */
public class Almacen {
    private int operaciones;
    private int operacionesMaximas;
    private int capacidadMinima;
    private int capacidadMaxima;
    private int existenciaTrigo;
    private Boolean abierto;
    private JTextArea log;
    private JProgressBar proTask;
    
    public Almacen(int capacidadMinima, int existenciaTrigo, int capacidadMaxima, int operacionesMaximas, JTextArea log, JProgressBar proTask ){
        
        this.capacidadMinima = capacidadMinima;
        this.existenciaTrigo = existenciaTrigo;
        this.capacidadMaxima = capacidadMaxima;
        this.operacionesMaximas = operacionesMaximas;
        this.abierto = true;
        this.operaciones = 0;
        this.log = log;
        this.proTask = proTask;
    }
    
    public synchronized boolean producir(){
        
        if(existenciaTrigo+1 <= capacidadMaxima){
            this.existenciaTrigo += 1;
            proTask.setValue(existenciaTrigo);
            this.operaciones++;
            if(operaciones==operacionesMaximas){
                this.abierto = false;
                log.append("\n***EL ALMACEN ESTA CERRADO...");
                //System.out.println("***EL ALMACEN ESTA CERRADO...");
                log.getText();
                notifyAll();
            }else{
                notify();
            }
            return true;
        }else{
            try{
                log.append("\nNo se puede producir mas.. El granero esta por alcanzar su máximo. EN ESPERA DE CONSUMIDORES...");
                //System.out.println("No se puede producir mas.. El granero esta por alcanzar su máximo. EN ESPERA DE CONSUMIDORES...");
                log.getText();
                wait();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public synchronized boolean consumir(){
        
        if(existenciaTrigo-1 >= capacidadMinima){
            this.existenciaTrigo -= 1;
            proTask.setValue(existenciaTrigo);
            this.operaciones++;
            if(operaciones==operacionesMaximas){
                this.abierto = false;
                log.append("\n***EL ALMACEN ESTA CERRADO...");
                //System.out.println("***EL ALMACEN ESTA CERRADO...");
                log.getText();
                notifyAll();
            }else{
                notify();
            }
            return true;
        }else{
            try{
                log.append("\nNo se puede consumir mas.. El granero esta por alcanzar su mínimo. EN ESPERA DE PRODUCTORES...");
                //System.out.println("No se puede consumir mas.. El granero esta por alcanzar su mínimo. EN ESPERA DE PRODUCTORES...");
                log.getText();
                wait();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public synchronized boolean isAbierto(){
        return this.abierto;
    }
    
    public synchronized void cerrarAlmacen(){
        this.abierto = false;
        log.append("\n***EL ALMACEN ESTA CERRADO...");
        //System.out.println("***EL ALMACEN ESTA CERRADO...");
        log.getText();
        notifyAll();
    }
    
    public synchronized Integer getExistenciaTrigo(){
        return this.existenciaTrigo;
    }
    
    
}
