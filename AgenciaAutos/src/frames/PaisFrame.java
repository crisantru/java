/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import conexion.ConexionBD;
import datos.ClienteRow;
import datos.MarcaRow;
import datos.PaisRow;
import dialogs.MarcaDialog;
import dialogs.PaisDialog;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crisantru
 */
public class PaisFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form PaisFrame
     */
    public PaisFrame() {
        initComponents();
        this.cargarPaises();
    }

    public void cargarPaises(){
        listaPaises = new ArrayList<PaisRow>();
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], COLUMNAS);
        ConexionBD conn = null;
        
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String filtro = "";
            
            if(filtroNombre != null){
                filtro = String.format("WHERE nombre LIKE '%s'", filtroNombre);
            }
            
            
            String query = "SELECT idpais,nombre FROM pais\n" + filtro;
            System.out.println(query);
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                    //-------------AGREGAR A LISTA DE PAISES------
                    PaisRow pr = new PaisRow();
                    pr.setIdPais(rs.getInt("idpais"));
                    pr.setNombreP(rs.getString("nombre"));
                    
                    listaPaises.add(pr);
                    
                    // ----------------RELLENAR TABLA ------------------
                    Object row[] = new Object[2];
                    row[0] = rs.getInt("idpais");
                    row[1] = rs.getString("nombre");
                    
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
        this.lbl_num.setText(""+ this.listaPaises.size());
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_pais = new javax.swing.JTextField();
        btn_buscarP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_agregarP = new javax.swing.JButton();
        btn_editarP = new javax.swing.JButton();
        btn_eliminarP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Administrador de Paises");

        jToolBar1.setRollover(true);

        jLabel1.setText("No. de Registros");
        jToolBar1.add(jLabel1);

        lbl_num.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        lbl_num.setText("0");
        jToolBar1.add(lbl_num);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por..."));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setText("Pais");
        jPanel2.add(jLabel3);

        txt_pais.setMaximumSize(new java.awt.Dimension(200, 30));
        txt_pais.setMinimumSize(new java.awt.Dimension(200, 30));
        txt_pais.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel2.add(txt_pais);

        btn_buscarP.setText("Buscar");
        btn_buscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarPActionPerformed(evt);
            }
        });
        jPanel2.add(btn_buscarP);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_agregarP.setText("Nuevo Pais");
        btn_agregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarPActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agregarP);

        btn_editarP.setText("Editar");
        btn_editarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarPActionPerformed(evt);
            }
        });
        jPanel3.add(btn_editarP);

        btn_eliminarP.setText("Eliminar");
        btn_eliminarP.setActionCommand("");
        btn_eliminarP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_eliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarPActionPerformed(evt);
            }
        });
        jPanel3.add(btn_eliminarP);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_datos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarPActionPerformed
        new PaisDialog(null, true, true, new PaisRow()); //cargar ventana PaisDialog
        
        
        this.cargarPaises();
    }//GEN-LAST:event_btn_agregarPActionPerformed

    private void btn_buscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarPActionPerformed
        filtroNombre = null;
        
        if(this.txt_pais != null && !this.txt_pais.getText().isEmpty()){
            filtroNombre = this.txt_pais.getText();
        }
        cargarPaises();
    }//GEN-LAST:event_btn_buscarPActionPerformed

    private void btn_editarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarPActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            PaisRow pr = this.listaPaises.get(indice);
            new PaisDialog(null, true, false, pr);
            this.cargarPaises();
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarPActionPerformed

    private void btn_eliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarPActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este registro?");
            
            if(respuesta == 0){
                PaisRow pr = this.listaPaises.get(indice);
                String query = String.format("DELETE FROM pais WHERE idpais = %s", pr.getIdPais());
                
                ConexionBD conn = null;
        
                try{
                    conn = new ConexionBD(host, puerto, bd, usu, pas);
                    int filas = conn.update(query).getUpdateCount();
                    JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    this.cargarPaises();
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
    }//GEN-LAST:event_btn_eliminarPActionPerformed

    private String filtroNombre;
    private String[] COLUMNAS = {"ID Pais", "Nombre"};
    private List<PaisRow> listaPaises;  //lista tipo PaisRow
    
    //datos conexion
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarP;
    private javax.swing.JButton btn_buscarP;
    private javax.swing.JButton btn_editarP;
    private javax.swing.JButton btn_eliminarP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JTable tbl_datos;
    private javax.swing.JTextField txt_pais;
    // End of variables declaration//GEN-END:variables
}
