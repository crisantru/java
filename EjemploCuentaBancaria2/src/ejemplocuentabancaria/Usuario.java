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
public class Usuario extends Thread {
    private String nombre;
    private CuentaBancaria cb;
    private Double monto;
    private Integer operaciones;
    private Double importeRetirado;
    
    public Usuario (String nombre, CuentaBancaria cb, Double monto){
        this.nombre = nombre;
        this.cb = cb;
        this.monto = monto;
        this.operaciones = 0;
        this.importeRetirado = 0.0;
    }  
 public void run(){
     boolean estatus = true;
     while(estatus&& cb.consultaSaldo()>=0){
         estatus = cb.retirar(monto);
         if(estatus){
             System.out.println(String.format("%s retiro: %s.. el saldo es de: %s", this.nombre, this.monto, this.cb.consultaSaldo()));
             this.operaciones = operaciones + 1;
             this.importeRetirado= this.importeRetirado + this.monto;
             
         }else{
             System.out.println(String.format("%s no pudo realizar el retiro de " + ": %s.. el saldo es de: %s",this.nombre, this.monto, this.cb.consultaSaldo()));
         }
     
     try{
         Thread.sleep(1000);
         
     }catch(Exception ex){
         ex.printStackTrace();
     }
    }//termina while
   if(estatus){
       System.out.println("Ya no es posible retirar de la cuenta");
   }else{
       System.out.println("Cuenta sin fondos");
   }
   
   System.out.println(String.format("------ %s termino de utilizar la cuenta, realizo %s operaciones por un importe de : %s",this.nombre, this.operaciones, this.importeRetirado));
 }//termina metodo run
 
 public static void main(String arg[]){
 CuentaBancaria cb = new CuentaBancaria(800.0);
    System.out.println(String.format("El saldo inicial de la cuenta es de" +": %s", cb.consultaSaldo()));
    
    Usuario r1= new Usuario("Juan", cb, 50.0);
    Usuario r2= new Usuario("Ana", cb, 20.0);
    Usuario r3= new Usuario("Miguel", cb, 70.0);
 
    r1.start();r2.start();r3.start();
    
    try{
        r1.join();r2.join();r3.join();
    }catch(Exception ex){
        ex.printStackTrace();
    }
    System.out.println(String.format("***El saldo FINAL de la cuenta es" +"de: %s",cb.consultaSaldo()));
}// termina metodo main
}//termina clase Usuario

