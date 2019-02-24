/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import conexion.ConexionBD;
import datos.CompraRow;
import dialogs.CompraDialog;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author crisantru
 */
public class ComprasFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComprassFrame
     */
    public ComprasFrame() {
        initComponents();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.cargarCompras();
        this.cargarFiltroAutomoviles();
        this.cargarFiltroClientes();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_motor = new javax.swing.JComboBox<>();
        cmb_clientes = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Compras Por:"));

        jLabel1.setText("Modelo");

        jLabel2.setText("Cliente");

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setActionCommand("");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_motor, 0, 130, Short.MAX_VALUE)
                    .addComponent(cmb_clientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_motor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

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

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_datos);

        jToolBar1.setRollover(true);

        jLabel4.setText("Registros: ");
        jToolBar1.add(jLabel4);

        lbl_num.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        lbl_num.setText("0");
        jToolBar1.add(lbl_num);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        new CompraDialog (null, true, true, new CompraRow());
        
        this.cargarCompras();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            CompraRow cmp = this.listaCompras.get(indice);
            new CompraDialog(null, true, false, cmp);
            this.cargarCompras();
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este registro?");
            
            if(respuesta == 0){
                CompraRow cmp = this.listaCompras.get(indice);
                String query = String.format("DELETE FROM compra WHERE nomotor = %s AND idcliente = %s",
                        cmp.getNomotor(), cmp.getIdcliente());
                
                ConexionBD conn = null;
        
                try{
                    conn = new ConexionBD(host, puerto, bd, usu, pas);
                    int filas = conn.update(query).getUpdateCount();
                    JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    this.cargarCompras();
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

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        filtroCliente = null;
        filtroAuto = null;
        
        if(this.cmb_motor.getSelectedItem() != null ){
            filtroAuto = this.cmb_motor.getSelectedItem().toString();
            System.out.println("btn_buscar: " + filtroAuto);
        }
        
        if(this.cmb_clientes.getSelectedItem() != null){
            filtroCliente = this.cmb_clientes.getSelectedItem().toString();
            System.out.println("btn_buscar: " + filtroAuto);         
        }
        
        cargarCompras();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void cargarCompras(){
        
        listaCompras = new ArrayList<CompraRow>();
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], COLUMNAS);
        
 
        ConexionBD conn = null;
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String filtro = "";
            
            if(filtroAuto != null && filtroAuto != "NO seleccionado"){
                
                filtro = String.format("WHERE a.modelo LIKE '%s'", filtroAuto);
                System.out.println("filtro: " + filtro);
            }
             
            if(filtroCliente != null && filtroCliente != "NO seleccionado"){
                
                filtro = String.format("WHERE c.nombres LIKE '%s'", filtroCliente);
                System.out.println("filtro: " + filtro);
            }
            
            String query = "SELECT a.nomotor, a.modelo as motor, c.idcliente, c.nombres as cliente, fechacompra from compra cp "
                    + "inner join cliente c on c.idcliente = cp.idcliente\n"
                    + "inner join automovil a on a.nomotor = cp.nomotor\n" + filtro;
            System.out.println(query);
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                    //-------------AGREGAR A LISTA DE COMPRAS------
                    CompraRow cmr = new CompraRow();
                    cmr.setNomotor(rs.getInt("nomotor"));
                    cmr.setMotor(rs.getString("motor"));
                    cmr.setIdcliente(rs.getInt("idcliente"));
                    cmr.setCliente(rs.getString("cliente"));
                    cmr.setFecha(rs.getString("fechacompra"));
                    listaCompras.add(cmr);
                    
                    // ----------------RELLENAR TABLA ------------------
                    Object row[] = new Object[3];
                    row[0] = rs.getString("motor");
                    row[1] = rs.getString("cliente");
                    row[2] = rs.getString("fechacompra");
                    model.addRow(row);
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
        this.lbl_num.setText(""+ this.listaCompras.size());
        
        
        
    }
    
    private void cargarFiltroAutomoviles(){
        ConexionBD conn = null;
        this.cmb_motor.removeAllItems();
        this.cmb_motor.addItem("NO seleccionado");
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT modelo FROM automovil";
            ResultSet rs = conn.query(query).getResultSet();
            if(rs != null){
                while(rs.next()){
                    String nombre = rs.getString("modelo");
                    this.cmb_motor.addItem(nombre);
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
    
    private void cargarFiltroClientes(){
        ConexionBD conn = null;
        this.cmb_clientes.removeAllItems();
        this.cmb_clientes.addItem("NO seleccionado");
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT nombres FROM cliente";
            ResultSet rs = conn.query(query).getResultSet();
            if(rs != null){
                while(rs.next()){
                    String nombre = rs.getString("nombres");
                    this.cmb_clientes.addItem(nombre);
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
    
    private String filtroCliente;
    private String filtroAuto;
    private String[] COLUMNAS = {"Modelo", "Cliente", "Fecha de Compra"};
    private List<CompraRow> listaCompras;
    private SimpleDateFormat sdf;
    
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
    private javax.swing.JComboBox<String> cmb_clientes;
    private javax.swing.JComboBox<String> cmb_motor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JTable tbl_datos;
    // End of variables declaration//GEN-END:variables
}
