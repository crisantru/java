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
public class Principal {
    public static void main(String arg[]){
        Almacen al = new Almacen(0,0,999,10);
        
        System.out.println(String.format("***** LOS TRABAJADORES COMIENZAN A TRABAJAR la existencia es de %s kg.", al.getExistenciaTrigo()));
        
        Productor p1 = new Productor ("PROD_1",al);
        Productor p2 = new Productor ("PROD_2",al);
        Consumidor c1 = new Consumidor ("CONSUMIDOR_1",al);
        Consumidor c2 = new Consumidor ("CONSUMIDOR_2",al);
        Consumidor c3 = new Consumidor ("CONSUMIDOR_3",al);
        
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        
        try{
            p1.join();
            p2.join();
            c1.join();
            c2.join();
            c3.join();
        }catch(Exception ex){ ex.printStackTrace(); }
        
        System.out.println(String.format("***** LOS TRABAJADORES HAN TERMINADO la existencia es de %s kg.", al.getExistenciaTrigo()));
    }
}
