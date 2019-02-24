/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodcons;

import javax.swing.JTextArea;

/**
 *
 * @author crisantru
 */
public class Consumidor extends Thread {
    
    private String nombre;
    private Almacen al;
    private Integer operaciones;
    private Integer kgConsumidos;
    private JTextArea log;
    
    public Consumidor(String nombre, Almacen al, JTextArea log){
        this.nombre = nombre;
        this.al = al;
        this.operaciones = 0;
        this.kgConsumidos = 0;
        this.log = log;
    }
    
    @Override
    public void run(){
        while(al.isAbierto()){
            if(al.consumir()){
                //System.out.println(String.format("%s consumio: la existencia es de: %s",this.nombre, this.al.getExistenciaTrigo()));
                log.append(String.format("\n%s consumio: la existencia es de: %s",this.nombre, this.al.getExistenciaTrigo()));
                log.getText();
                this.operaciones = operaciones + 1;
                this.kgConsumidos = this.kgConsumidos + 1;
            }
            try{
                Thread.sleep(500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //System.out.println(String.format("------- %s termino de trabajar, " + "realizo %s consumos por un pesaje de: %s kg",
          //      this.nombre,this.operaciones,this.kgConsumidos));
        log.append(String.format("\n------- %s termino de trabajar, " + "realizo %s consumos por un pesaje de: %s kg",
                this.nombre,this.operaciones,this.kgConsumidos));
        log.getText();
    }
    
}
