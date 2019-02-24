package contador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
public class Contador extends JFrame{
    
    private JLabel lbl_instrucciones;
    private JButton btn_click;
    private JButton btn_clear;
    private JLabel lbl_resultado;
    private int contador;
    
    private void init()
    {
        lbl_instrucciones = new JLabel("Da click en boton" + " para aumentar el contador");
        btn_click = new JButton("Dame click");
        btn_clear = new JButton("Limpiar");
        lbl_resultado = new JLabel();
        contador = 0;
        
        this.setLayout(null);
        lbl_instrucciones.setBounds(0, 0, 300, 20);
        btn_click.setBounds(0, 25, 80, 25);
        btn_clear.setBounds(0, 55, 80, 25);
        lbl_resultado.setBounds(85, 25, 200, 25);
        
        btn_click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                lbl_resultado.setText(String.format("N. de clicks: %s", contador));
            }
        });
        
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                lbl_resultado.setText(String.format(" "));
                
            }
        
         });
        
        this.getContentPane().add(btn_click);
        this.getContentPane().add(btn_clear);
        this.getContentPane().add(lbl_resultado);
        this.getContentPane().add(lbl_instrucciones);
        
        this.setTitle("Ejercicio 3 Contador de clicks");
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        new Contador().init();
    }
    
}