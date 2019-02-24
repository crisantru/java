/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import conexion.ConexionBD;
import datos.MarcaRow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class MarcaDialog extends javax.swing.JDialog {

    /**
     * Creates new form MarcaDialog
     */
    public MarcaDialog(java.awt.Frame parent, boolean modal, boolean nuevo, MarcaRow marca) {
        super(parent, modal);
        initComponents();
        this.cargarPaises();
        this.nuevo = nuevo;
        this.marca = marca;
         
        if(!nuevo){
            this.txt_nombre.setText(marca.getNombre());
            this.cmb_pais.setSelectedItem(marca.getPais());
        }else{
            this.txt_nombre.setText("");
        }
        
        this.setModal(modal);
        this.setVisible(true);
        
       
    }
    
    private void cargarPaises(){
        paises = new HashMap<String, Integer>();
        ConexionBD conn = null;
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT idPais, nombre FROM pais";
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                      paises.put(rs.getString("nombre"), rs.getInt("idPais"));
                        this.cmb_pais.addItem(rs.getString("nombre"));
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn != null){
                conn.close();
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmb_pais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar);

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre de la Marca");
        jPanel2.add(jLabel2);
        jPanel2.add(txt_nombre);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Pais de Origen");
        jPanel2.add(jLabel1);

        cmb_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_paisActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_pais);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_paisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_paisActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String query = "";
        if(nuevo){
            String nombre = this.txt_nombre.getText();
            Integer idPais = this.paises.get(this.cmb_pais.getSelectedItem().toString());
            query = String.format("INSERT INTO marca VALUES (NULL, '%s', %s)", nombre, idPais);
            
        }else{
            String nombre = this.txt_nombre.getText();
            Integer idPais = this.paises.get(this.cmb_pais.getSelectedItem().toString());
            query = String.format("UPDATE marca SET nombre = '%s'," + "idPais = %s WHERE idMarca = %s", nombre, idPais, marca.getIdmarca());
        }
        
        ConexionBD conn = null;
        
        try{
            conn = new ConexionBD(host, puerto, bd, usu, pas);
            int filas = conn.update(query).getUpdateCount();
            JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn != null){
                conn.close();
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private boolean nuevo;
    private MarcaRow marca;
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    private HashMap<String, Integer> paises;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmb_pais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
