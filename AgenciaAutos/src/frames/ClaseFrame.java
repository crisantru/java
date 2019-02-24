/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import conexion.ConexionBD;
import datos.ClaseRow;
import dialogs.ClaseDialog;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crisantru
 */
public class ClaseFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClaseFrame
     */
    public ClaseFrame() {
        initComponents();
        cargarClases();
    }

    private void cargarClases(){
        listaClases = new ArrayList<ClaseRow>();
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], COLUMNAS);
        String filtro = "";
        
         if(filtro_nombre != null){
                filtro = String.format("WHERE nombre LIKE '%s'", filtro_nombre);
            }
        
        
        ConexionBD conn = null;
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            //String filtro = "";
            String query = "select idclase, nombre from clase\n" + filtro;
            System.out.println(query);
            ResultSet rs = conn.query(query).getResultSet();
            
             if(rs != null){
                while(rs.next()){
                    //-------------RELLENAR LISTA CLASEROW------
                    ClaseRow cr = new ClaseRow();
                    cr.setIdclase(rs.getInt("idclase"));
                    cr.setNombre(rs.getString("nombre"));
                    listaClases.add(cr);
                    
                    // ----------------RELLENAR TABLE ------------------
                    Object fila[] = new Object[2];
                    fila[0] = rs.getString("idclase");
                    fila[1] = rs.getString("nombre");
                    model.addRow(fila);
                }
            } 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        
        this.tbl_datos.setModel(model);
        this.lbl_num.setText(""+ this.listaClases.size());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_clase = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Administrador de Clases");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Por..."));

        jLabel1.setText("Clase");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txt_clase, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_buscar))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_datos);

        jToolBar1.setRollover(true);

        jLabel2.setText("Registros: ");
        jToolBar1.add(jLabel2);

        lbl_num.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        lbl_num.setText("0");
        jToolBar1.add(lbl_num);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_editar)
                    .addComponent(btn_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
    new ClaseDialog(null, true, true, new ClaseRow());
        this.cargarClases();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        filtro_nombre = null;
        if(this.txt_clase.getText() != null && !this.txt_clase.getText().isEmpty()){
            filtro_nombre = this.txt_clase.getText();
            
        }
        cargarClases();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            ClaseRow cr = this.listaClases.get(indice);
            new ClaseDialog(null, true, false, cr);
            this.cargarClases();
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este registro?");
            
            if(respuesta == 0){
                ClaseRow cr = this.listaClases.get(indice);
                String query = String.format("DELETE FROM clase WHERE idclase = %s", cr.getIdclase());
                
                ConexionBD conn = null;
        
                try{
                    conn = new ConexionBD(host, puerto, bd, usu, pas);
                    int filas = conn.update(query).getUpdateCount();
                    JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    this.cargarClases();
                }catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    if(conn != null){
                        conn.close();
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private String filtro_nombre;
    private String[] COLUMNAS = {"ID Clase", "Marca"};
    private List<ClaseRow> listaClases;
    
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JTable tbl_datos;
    private javax.swing.JTextField txt_clase;
    // End of variables declaration//GEN-END:variables
}
