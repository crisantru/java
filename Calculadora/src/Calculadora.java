import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Calculadora extends JFrame
{
    private int token;
    private double temp;
    private float operacion;
    private String dis;
    private JLabel display;
    private JButton btn_clear;
    private JButton btn_ret;
    private JButton btn_suma, btn_resta, btn_div, btn_mult;
    private JButton btn_point;
    private JButton btn_equal;
    private JButton btn_raiz;
    private JButton btn_9, btn_8, btn_7, btn_6, btn_5, btn_4, btn_3, btn_2, btn_1, btn_0;
    
    //Distribucion
    private JPanel pnl_0;
    private JPanel pnl_1;
    private JPanel pnl_2;
    private JPanel pnl_3;
    
    
    private void init()
    {
        token = 0;
        temp = 0;
        operacion = 0;
        dis = "";
        display = new JLabel("0");
        display.setOpaque(true);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
        display.setBackground(Color.WHITE);
        display.setFont(display.getFont().deriveFont(55f));
        btn_clear = new JButton("CLEAR");
        btn_ret = new JButton("<--");
        btn_suma = new JButton("+");
        btn_resta= new JButton("-");
        btn_div= new JButton("/");
        btn_mult= new JButton("*");
        btn_point= new JButton(".");
        btn_equal= new JButton("=");
        btn_raiz= new JButton("√");
        btn_9 = new JButton("9");
        btn_8 = new JButton("8");
        btn_7 = new JButton("7");
        btn_6 = new JButton("6");
        btn_5 = new JButton("5");
        btn_4 = new JButton("4");
        btn_3 = new JButton("3");
        btn_2 = new JButton("2");
        btn_1 = new JButton("1");
        btn_0 = new JButton("0");
        
        //distribucion
        pnl_0 = new JPanel();
        pnl_1 = new JPanel();
        pnl_2 = new JPanel();
        pnl_3 = new JPanel();
        
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        pnl_0.setLayout(new GridLayout());
        pnl_1.setLayout(new GridLayout());
        pnl_2.setLayout(new GridLayout(4,4,4,4));
        pnl_3.setLayout(new GridLayout(1,1));
        
       
        this.getContentPane().add(pnl_0);
        this.getContentPane().add(pnl_1);
        this.getContentPane().add(pnl_2);
        this.getContentPane().add(pnl_3);
        
        //componentes pnl_0
        pnl_0.add(display);
        
        //componentes pnl_1
        pnl_1.add(btn_clear);
        pnl_1.add(btn_ret);
        
        //componentes pnl_2
        pnl_2.add(btn_7);
        pnl_2.add(btn_8);
        pnl_2.add(btn_9);
        pnl_2.add(btn_div);
        
        pnl_2.add(btn_4);
        pnl_2.add(btn_5);
        pnl_2.add(btn_6);
        pnl_2.add(btn_mult);
        
        pnl_2.add(btn_1);
        pnl_2.add(btn_2);
        pnl_2.add(btn_3);
        pnl_2.add(btn_resta);
        
        pnl_2.add(btn_raiz);
        pnl_2.add(btn_0);
        pnl_2.add(btn_point);
        pnl_2.add(btn_suma);
        
        pnl_3.add(btn_equal);
        
        btn_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "9";
                display.setText(dis);
               
            }
        });
        
        btn_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "8";
                display.setText(dis);
            }
        });
        
        btn_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "7";
                display.setText(dis);
            }
        });
        
        btn_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "6";
                display.setText(dis);
            }
        });
        
        btn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "5";
                display.setText(dis);
            }
        });
        
        btn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "4";
                display.setText(dis);
            }
        });
        
        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "3";
                display.setText(dis);
            }
        });
        
        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "2";
                display.setText(dis);
            }
        });
        
        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "1";
                display.setText(dis);
            }
        });
        
        btn_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = dis + "0";
                display.setText(dis);
            }
        });
        
        btn_point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                //char ban;
                
                if(token == 0 || token == 8 || token == 2 || token == 3 || token == 4){
                    dis = dis + ".";
                    display.setText(dis);
                    token++;
                }
                
                
                /*for(int i=0; i < dis.length(); i++){
                //ban = dis.charAt(i);
                if(dis.charAt(i) == '.'){
                j++;
                display.setText("point encontrado");
                }
                //display.setText(String.valueOf(ban));
                }*/
                //dis = dis + ".";
                //display.setText(dis);
            }
        });
        
        btn_clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dis = "";
                display.setText("0");
                token = 0;
                temp = 0;
            }
        });
        
        btn_ret.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dis.length()>0){
                    dis = dis.substring(0,dis.length()-1);
                }
                display.setText(dis);
            }
        });
        
        btn_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               temp = Double.parseDouble(display.getText());
               display.setText("/");
               token = 8;
               dis = "";
               
              
            }
        });
        
        btn_mult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
               temp = Double.parseDouble(display.getText());
               display.setText("*");
               token = 2;
               dis = "";
            }
        });
        
        btn_suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               temp = Double.parseDouble(display.getText());
               display.setText("+");
               token = 3;
               dis = "";
                
            }
        });
        
        btn_resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               if(display.getText().equals("0") || display.getText().equals("0.0")){
                   display.setText("");
                   dis = "";
                   dis = dis + "-"; 
                   display.setText(dis);
                   
               }
                
               temp = Double.parseDouble(display.getText());
               display.setText("-");
               token = 4;
               dis = "";
                
            }
        });
        
        btn_raiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               temp = Double.parseDouble(display.getText());
               
               if(temp == 0.0 || temp < 0.0){
                   display.setText("Math Error");
                   return;
               }
                   
               int oper = (int) Math.sqrt(temp);
               display.setText(String.valueOf(oper));
               dis = "";
          
            }
        });
        
        btn_equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                double token2;
                
                token2 = Double.parseDouble(display.getText());
                        
                if(token == 8)  //div
                {
                    if((temp == 0.0 && token2 == 0) || token2 == 0){
                        
                        display.setText("Math Error");
                        return;
                    }
                    operacion = (float) (temp / token2);
                    display.setText(String.valueOf(operacion));
                    token = 0;
                    temp = 0;
                    dis = "";
                }
                
                if(token == 2) //multi
                {
                    operacion = (float) (temp * token2);
                    display.setText(String.valueOf(operacion));
                    token = 0;
                    temp = 0;
                    dis = "";
                }
                
                if(token == 3) //suma
                {
                    operacion = (float) (temp + token2);
                    display.setText(String.valueOf(operacion));
                    token = 0;
                    temp = 0;
                    dis = "";
                    
                }
                
                if(token == 4) //resta
                {
                    operacion = (float) (temp - token2);
                    display.setText(String.valueOf(operacion));
                    token = 0;
                    temp = 0;
                    dis = "";
                    
                }
                
            }
        });
        
        this.setTitle("Calculadora");
        this.setSize(400,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
    public static void main(String[] args)
    {
        new Calculadora().init();
    }
}