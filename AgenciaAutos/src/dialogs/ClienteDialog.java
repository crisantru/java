/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import com.toedter.calendar.JCalendar;
import conexion.ConexionBD;
import datos.ClienteRow;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class ClienteDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClienteDialog
     */
    public ClienteDialog(java.awt.Frame parent, boolean modal, boolean nuevo, ClienteRow cliente) {
        super(parent, modal);
        initComponents();
        
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.nuevo = nuevo;
        this.cliente = cliente;
       
        //rellena para editar
        if(!nuevo){
            //cargar clientes();
            this.txt_nombre.setText(cliente.getNombre());
            this.txt_apellidos.setText(cliente.getApellidos());
            //System.out.println(cliente.getFecha());
            //this.dhc_fecha.setDate();
        }else{
            this.txt_nombre.setText("");
            this.txt_apellidos.setText("");
        }
        this.setVisible(modal);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dhc_fecha = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Cliente");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Fecha de Nacimiento");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/no.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dhc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dhc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(validar()){
            String nombre = this.txt_nombre.getText();
            String apellido = this.txt_apellidos.getText();
            java.util.Date fecha = this.dhc_fecha.getDate();
            String query ="";
            
            
            if(nuevo){
                query = String.format("INSERT INTO cliente VALUES" + " (NULL, '%s', '%s', '%s')",
                        nombre, apellido, sdf.format(fecha));
                System.out.println(query);

            }else{
                query = String.format("UPDATE cliente " 
                        + "SET nombres = '%s', apellidos = '%s',"
                        + "fechanacimiento ='%s' WHERE idcliente = %s", nombre, apellido, sdf.format(fecha),
                        cliente.getIdcliente());
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
    }//GEN-LAST:event_btn_guardarActionPerformed

    private boolean validar(){
        if(this.txt_nombre.getText() == null ||
            this.txt_nombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir el nombre del cliente");
            return false;
        }
        if(this.txt_apellidos.getText() == null ||
            this.txt_apellidos.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir los apellidos del cliente");
            return false;
        }
        if(this.dhc_fecha.getDate() == null){
            JOptionPane.showMessageDialog(this, "debes introducir la fecha de nacimiento del cliente");
            return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
  
    
    
    private SimpleDateFormat sdf;
    private boolean nuevo;
    private ClienteRow cliente;
    
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private com.toedter.calendar.JCalendar dhc_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
