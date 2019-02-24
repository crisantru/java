package prodcons;

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
public class Productor extends Thread{
    
    private String nombre;
    private Almacen al;
    private Integer operaciones;
    private Integer kgProducidos;
    private JTextArea log;
    
    public Productor(String nombre, Almacen al, JTextArea log){
        this.nombre = nombre;
        this.al = al;
        this.operaciones = 0;
        this.kgProducidos = 0;
        this.log = log;
    }
    
    @Override
    public void run(){
        while(al.isAbierto()){
            if(al.producir()){
                this.log.append(String.format("\n%s produjo la existencia es de: %s",this.nombre, this.al.getExistenciaTrigo()));
                //System.out.println(String.format("%s produjo la existencia es de: %s",this.nombre, this.al.getExistenciaTrigo()));
                this.log.getText();
                this.operaciones = operaciones + 1;
                this.kgProducidos = this.kgProducidos + 1;
            }
            try{
                Thread.sleep(500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        //System.out.println(String.format("------- %s termino de trabajar, " + "realizo %s producciones por un pesaje de: %s kg",
                //this.nombre,this.operaciones,this.kgProducidos));
        this.log.append(String.format("\n------- %s termino de trabajar, " + "realizo %s producciones por un pesaje de: %s kg",
                this.nombre,this.operaciones,this.kgProducidos));
    }
    
}
