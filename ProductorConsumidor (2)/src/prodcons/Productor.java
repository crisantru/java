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
public class Productor extends Thread {
    private String nombre;
    private Almacen al;
    private Integer operaciones;
    private Integer kgProducidos;
    
    public Productor(String nombre, Almacen al){
        this.nombre = nombre;
        this.al = al;
        this.operaciones = 0;
        this.kgProducidos = 0;
    }
    
    @Override
    public void run(){
        while(al.isAbierto()){
            if(al.producir()){
                System.out.println(String.format("%s produjo la existencia es de: %s",this.nombre, this.al.getExistenciaTrigo()));
                this.operaciones = operaciones + 1;
                this.kgProducidos = this.kgProducidos + 1;
            }
            try{
                Thread.sleep(500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println(String.format("------- %s termino de trabajar, "
                + "realizo %s producciones por un pesaje de: %s kg",
                this.nombre,this.operaciones,this.kgProducidos));
    }
    
}
