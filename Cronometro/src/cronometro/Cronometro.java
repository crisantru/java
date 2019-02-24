/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

/**
 *
 * @author crisantru
 */
public class Cronometro  extends Thread {

    private JLabel lbl_pantalla;
    private long tiempo;
    private boolean activo;
    private boolean pausa;

    public Cronometro(JLabel lbl_pantalla) {
        this.lbl_pantalla = lbl_pantalla;
        
    }
    
    private String formatoTiempo(){
        long horas = 0;
        long minutos = 0;
        long segundos = 0;
        
        segundos = tiempo;
        
        if(segundos >= 60){
            minutos = segundos / 60;
            segundos = segundos % 60;
        }
        if(minutos >= 60){
            horas = minutos / 60;
            minutos = minutos % 60;
        }
        
        return String.format("%02d : %02d: %02d", horas, minutos, segundos);
    }
    
    public void run(){
        
        while(activo){
            esperar();
            lbl_pantalla.setText(this.formatoTiempo());
            tiempo = tiempo + 1;
            
            try{
                sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            
        }
   
    }
    
    public synchronized void esperar(){
        
        while(pausa){
            try{
                wait();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    public boolean isActivo(){
        return this.activo;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }
    
    
}
