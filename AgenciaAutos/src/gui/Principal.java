/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import frames.AutomovilFrame;
import frames.ClaseFrame;
import frames.ClientesFrame;
import frames.ComprasFrame;
import frames.MarcasFrame;
import frames.PaisFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("wayXalapa");
        setMaximumSize(new java.awt.Dimension(1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(new java.awt.Dimension(1024, 700));
        setResizable(false);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Autos");

        jMenuItem1.setText("Automoviles");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Marcas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Compras");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Catalogos");

        jMenuItem5.setText("Clases de Auto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Paises");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        jMenuItem7.setText("Acerca DE");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        String mensaje = "Agencia Automotriz: BestCars \n" +
                         "Institucion: Universidad Veracruzana \n" +
                         "Carrera: Tecnologias Computacionales \n" +
                         "Desarrollador: Cristian Alberto";
        JOptionPane.showMessageDialog(this, mensaje, "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.cambiarInternalFrame(4);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.cambiarInternalFrame(1);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.cambiarInternalFrame(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.cambiarInternalFrame(2);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.cambiarInternalFrame(3);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.cambiarInternalFrame(5);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cambiarInternalFrame(int tipoframe){
        boolean existe = false;
        
        if(this.jDesktopPane1 != null){
            for(int a=0; a<this.jDesktopPane1.getComponentCount(); a++){
                switch(tipoframe){
                    
                    case 0: if(PaisFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));                
                        }
                        break;
                    
                    case 1: if(MarcasFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));      
                        }
                        break;
                    
                    case 2: if(ClientesFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));
                        }
                        break; 
                        
                    case 3: if(ClaseFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));
                        }
                        break; 
                        
                    case 4: if(AutomovilFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));
                        }
                        break; 
                        
                    case 5: if(ComprasFrame.class.isInstance(jDesktopPane1.getComponent(a))){
                        existe = true;
                        jDesktopPane1.moveToFront(jDesktopPane1.getComponent(a));
                        }
                        break; 
                        
                }//switch
            }//for
        }//if
        
        if(!existe){
            switch(tipoframe){
                case 0: PaisFrame paises = new PaisFrame();
                paises.setVisible(true);
                this.jDesktopPane1.add(paises);
                jDesktopPane1.moveToFront(paises);
                break;
                
                case 1: MarcasFrame marcas = new MarcasFrame();
                marcas.setVisible(true);
                this.jDesktopPane1.add(marcas);
                jDesktopPane1.moveToFront(marcas);
                break;
                
                case 2: ClientesFrame clientes = new ClientesFrame();
                clientes.setVisible(true);
                this.jDesktopPane1.add(clientes);
                jDesktopPane1.moveToFront(clientes);
                break;
                
                case 3: ClaseFrame clase = new ClaseFrame();
                clase.setVisible(true);
                this.jDesktopPane1.add(clase);
                jDesktopPane1.moveToFront(clase);
                break;
                
                case 4: AutomovilFrame automovil = new AutomovilFrame();
                automovil.setVisible(true);
                this.jDesktopPane1.add(automovil);
                jDesktopPane1.moveToFront(automovil);
                break;
                
                case 5: ComprasFrame compras = new ComprasFrame();
                compras.setVisible(true);
                this.jDesktopPane1.add(compras);
                jDesktopPane1.moveToFront(compras);
                break;
            }//switch
            
        }//if
    }//metodo
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
