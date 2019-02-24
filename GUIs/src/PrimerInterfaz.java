
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
public class PrimerInterfaz extends JFrame{
    
    private void init()
    {
        this.setTitle("Ejercicios Primera Interfaz");
        this.getContentPane().add(new JButton("Dame click"));
        
        this.setVisible(true);
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        new PrimerInterfaz().init();
    }
    
}
