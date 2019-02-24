/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import conexion.ConexionBD;
import datos.ClaseRow;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class ClaseDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClaseDialog
     */
    public ClaseDialog(java.awt.Frame parent, boolean modal, boolean nuevo, ClaseRow clase) {
        super(parent, modal);
        initComponents();
        this.nuevo = nuevo;
        this.clase = clase;
        
         if(!nuevo){
            //cargar clientes();
            this.txt_claseNombre.setText(clase.getNombre());
        }else{
            this.txt_claseNombre.setText("");
        }
        
        
        this.setVisible(modal);
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_claseNombre = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Clase Automovil");

        jLabel1.setText("Clase de Automovil");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_claseNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_claseNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
          if(validar()){
            String nombre = this.txt_claseNombre.getText();
            String query;
            
            
            if(nuevo){
                query = String.format("INSERT INTO clase VALUES" + " (NULL, '%s')",
                        nombre);

            }else{
                query = String.format("UPDATE clase " 
                        + "SET nombre = '%s' WHERE idclase = %s", nombre, clase.getIdclase());
            }           
            
            ConexionBD conn = null;
            
            try{
                conn = new ConexionBD(host, puerto, bd, usu, pas);
                System.out.println(query);
                int filas = conn.update(query).getUpdateCount();
                JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(conn != null){
                    conn.close();
                }
                
            }
        }
    }                                           

    private boolean validar(){
        if(this.txt_claseNombre.getText() == null ||
            this.txt_claseNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir el nombre de la clase del automovil");
            return false;
        }
        
        return true;
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    
    private boolean nuevo;
    private ClaseRow clase;
    
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_claseNombre;
    // End of variables declaration//GEN-END:variables
}
