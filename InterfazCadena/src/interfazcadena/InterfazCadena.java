package interfazcadena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
public class InterfazCadena extends JFrame{
    
    private JLabel lbl_instrucciones;
    private JTextField text_field;
    private JButton btn_mayus;
    private JButton btn_minus;
    private JButton btn_clear;
    private String text;
   
    private void init()
    {
        lbl_instrucciones = new JLabel("Introduce la Cadena que deseas Convertir");
        text_field = new JTextField();
        btn_mayus = new JButton("Ver MAYUSCULAS");
        btn_minus = new JButton("Ver minusculas");
        btn_clear = new JButton("Limpiar");

        this.setLayout(null);
        lbl_instrucciones.setBounds(0, 0, 300, 20);
        text_field.setBounds(0, 25, 311, 20);
        btn_mayus.setBounds(0, 50, 150, 25);
        btn_minus.setBounds(160, 50, 150, 25);
        btn_clear.setBounds(0, 80, 80,20);
        
        
       btn_mayus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = text_field.getText();
                text = text.toUpperCase();
                text_field.setText(text);
                
            }
        });
        
        btn_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = text_field.getText();
                text = text.toLowerCase();
                text_field.setText(text);
                
            }
        
         });
        
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = " ";
                text_field.setText(text);
                
            }
        
         });
       
        this.getContentPane().add(btn_clear);
        this.getContentPane().add(btn_minus);
        this.getContentPane().add(btn_mayus);
        this.getContentPane().add(text_field);
        this.getContentPane().add(lbl_instrucciones);
        
        this.setTitle("Ejercicio 3 Contador de clicks");
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        new InterfazCadena().init();
    }
    
}