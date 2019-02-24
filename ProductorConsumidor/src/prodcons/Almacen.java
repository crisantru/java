/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodcons;

/**
 *
 * @author Frost
 */
public class Almacen {
    private Integer operaciones;
    private Integer operacionesMaximas;
    private Integer capacidadMinima;
    private Integer existenciaTrigo;
    private Integer capacidadMaxima;
    private Boolean abierto;
    
    public Almacen(Integer capacidadMinima, Integer existenciaTrigo, 
            Integer capacidadMaxima, Integer operacionesMaximas){
        this.capacidadMinima = capacidadMinima;
        this.existenciaTrigo = existenciaTrigo;
        this.capacidadMaxima = capacidadMaxima;
        this.abierto = true;
        this.operaciones = 0;
        this.operacionesMaximas = operacionesMaximas;
    }
    
    public synchronized boolean producir(){
        
        if(existenciaTrigo+1 <= capacidadMaxima){
            this.existenciaTrigo += 1;
            this.operaciones++;
            if(operaciones==operacionesMaximas){
                this.abierto = false;
                System.out.println("***EL ALMACEN ESTA CERRADO...");
                notifyAll();
            }else{
                notify();
            }
            return true;
        }else{
            try{
                System.out.println("No se puede producir mas.. El granero esta por alcanzar su máximo. EN ESPERA DE CONSUMIDORES...");
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
            this.operaciones++;
            if(operaciones==operacionesMaximas){
                this.abierto = false;
                System.out.println("***EL ALMACEN ESTA CERRADO...");
                notifyAll();
            }else{
                notify();
            }
            return true;
        }else{
            try{
                System.out.println("No se puede consumir mas.. El granero esta por alcanzar su mínimo. EN ESPERA DE PRODUCTORES...");
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
        System.out.println("***EL ALMACEN ESTA CERRADO...");
        notifyAll();
    }
    
    public synchronized Integer getExistenciaTrigo(){
        return this.existenciaTrigo;
    }
}
