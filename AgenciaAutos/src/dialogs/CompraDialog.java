/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import conexion.ConexionBD;
import datos.CompraRow;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class CompraDialog extends javax.swing.JDialog {

    /**
     * Creates new form CompraDialog
     */
    public CompraDialog(java.awt.Frame parent, boolean modal, boolean nuevo, CompraRow compra) {
        super(parent, modal);
        initComponents();
        cargarAutomoviles();
        cargarClientes();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.compra = compra;
        
        if(!nuevo){
            //cargar clientes();
            this.cmb_motor.setSelectedItem(compra.getMotor());
            this.cmb_clientes.setSelectedItem(compra.getCliente());

        }else{
            this.cmb_motor.setSelectedItem("");
            this.cmb_clientes.setSelectedItem("");
            
        }

        this.nuevo = nuevo;
        this.compra = compra;
        this.setModal(modal);
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmb_motor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmb_clientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Modelo");

        jLabel2.setText("Cliente");

        jLabel3.setText("Compra");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_motor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_clientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(validar()){
            
            Integer nomotor = this.automoviles.get(this.cmb_motor.getSelectedItem().toString());
            Integer cliente = this.clientes.get(this.cmb_clientes.getSelectedItem().toString());
            java.util.Date fecha = this.jdc_fecha.getDate();
            System.out.println(nomotor);
            System.out.println(cliente);
            System.out.println(fecha);
            
            
            String query = "";

            if(nuevo){
                query = String.format("INSERT INTO compra VALUES (%s, %s, '%s')", nomotor, cliente, sdf.format(fecha));
                System.out.println(query);

            }else{
                query = String.format("UPDATE compra SET nomotor = %s, " 
                        + "idcliente = %s, fechacompra = '%s' "
                        + "WHERE nomotor = %s AND idcliente = %s", nomotor, cliente,
                        sdf.format(fecha), compra.getNomotor(), compra.getIdcliente());
                System.out.println(query);
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
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

     private boolean validar(){
        if(this.cmb_motor.getSelectedItem() == null ||
            this.cmb_motor.getSelectedItem() == "NO seleccionado"){
            JOptionPane.showMessageDialog(this, "debes introducir el modelo del automovil");
            return false;
        }
        if(this.cmb_clientes == null ||
            this.cmb_clientes.getSelectedItem() == "NO seleccionado"){
            JOptionPane.showMessageDialog(this, "debes introducir el cliente de la compra");
            return false;
        }
        
        if(this.jdc_fecha.getDate() == null || this.jdc_fecha.getDate().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes seleccionar la fecha de compra");
            return false;
        }
        
        return true;
    }

    
    private void cargarAutomoviles(){
        automoviles = new HashMap<String, Integer>();
        ConexionBD conn = null;
        this.cmb_motor.removeAllItems();
        this.cmb_motor.addItem("NO seleccionado");
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT nomotor, modelo FROM automovil";
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                      automoviles.put(rs.getString("modelo"), rs.getInt("nomotor"));
                        this.cmb_motor.addItem(rs.getString("modelo"));
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
    
    private void cargarClientes(){
        clientes = new HashMap<String, Integer>();
        ConexionBD conn = null;
        this.cmb_clientes.removeAllItems();
        this.cmb_clientes.addItem("NO seleccionado");
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT idcliente, nombres FROM cliente";
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                      clientes.put(rs.getString("nombres"), rs.getInt("idcliente"));
                        this.cmb_clientes.addItem(rs.getString("nombres"));
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
    
    private boolean nuevo;
    private CompraRow compra;
    private SimpleDateFormat sdf;
    
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    private HashMap<String, Integer> automoviles;
    private HashMap<String, Integer> clientes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmb_clientes;
    private javax.swing.JComboBox<String> cmb_motor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    // End of variables declaration//GEN-END:variables
}
