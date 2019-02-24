
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class SegundaInterfaz extends JFrame {
    
    private void init()
    {
        /*this.getContentPane().add(new JButton("NORTE"), BorderLayout.NORTH);
        this.getContentPane().add(new JButton("SUR"), BorderLayout.SOUTH);
        this.getContentPane().add(new JButton("OESTE"), BorderLayout.WEST);
        this.getContentPane().add(new JButton("ESTE"), BorderLayout.EAST);
        this.getContentPane().add(new JButton("CENTRO"), BorderLayout.CENTER);*/
        
        //this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(0,3));
        this.getContentPane().add(new JButton("Boton 1"));
        this.getContentPane().add(new JButton("Boton 2"));
        this.getContentPane().add(new JButton("Boton 3"));
        this.getContentPane().add(new JButton("Boton 4"));
        this.getContentPane().add(new JButton("Boton 5"));
        this.getContentPane().add(new JButton("Boton 6"));
        
        this.setTitle("Ejercicio 2 Layout MAnagers");
        this.setSize(200,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    
    }
    
    public static void main (String[] args)
    {
        new SegundaInterfaz().init();
                
    }
    
}
