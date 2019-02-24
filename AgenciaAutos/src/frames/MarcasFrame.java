/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import conexion.ConexionBD;
import datos.MarcaRow;
import dialogs.MarcaDialog;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crisantru
 */
public class MarcasFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form MarcasFrame
     */
    public MarcasFrame() {
        initComponents();
        cargarMarcas();
        cargarFiltroPaises();
    }
    
    private void cargarMarcas(){
        listaMarcas = new ArrayList<MarcaRow>();
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], COLUMNAS);
        
        
        ConexionBD conn = null;
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String filtro = "";
            if(filtro_nombre != null){
                filtro = String.format("WHERE m.nombre LIKE '%s'", filtro_nombre);
            }
            
            if(this.cmb_pais.getSelectedIndex()> 0){
                if(filtro.isEmpty()){
                    filtro = String.format("WHERE p.nombre LIKE '%s'", this.cmb_pais.getSelectedItem().toString());
                }else{
                    filtro += String.format(" AND p.nombre LIKE '%s'", this.cmb_pais.getSelectedItem().toString());
                }
            }
            String query = "select m.idmarca, m.nombre, m.idpais, p.nombre AS pais from marca m inner join pais p on m.idpais = p.idpais\n" + 
                    filtro;
            System.out.println(query);
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                    //-------------RELLENAR LISTA MARCAROW------
                    MarcaRow mr = new MarcaRow();
                    mr.setIdmarca(rs.getInt("idmarca"));
                    mr.setNombre(rs.getString("nombre"));
                    mr.setIdpais(rs.getInt("idpais"));
                    mr.setPais(rs.getString("pais"));
                    listaMarcas.add(mr);
                    
                    // ----------------RELLENAR TABLE ------------------
                    Object fila[] = new Object[2];
                    fila[0] = rs.getString("nombre");
                    fila[1] = rs.getString("pais");
                    model.addRow(fila);
                }
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            if(conn != null){
                conn.close();
            }
            
            this.tbl_datos.setModel(model);
            this.lbl_num.setText(""+ this.listaMarcas.size());
        }
         
    }
    
    private void cargarFiltroPaises(){ 
        
        ConexionBD conn = null;
        this.cmb_pais.removeAllItems();
        this.cmb_pais.addItem("NO seleccionado");
        
        try{
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT nombre FROM pais";
            ResultSet rs = conn.query(query).getResultSet();
            if(rs != null){
                while(rs.next()){
                    String nombre = rs.getString("nombre");
                    this.cmb_pais.addItem(nombre);
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

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        Pais = new javax.swing.JLabel();
        cmb_pais = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrador de Marcas");
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        jToolBar1.setRollover(true);

        jLabel1.setText("No. de Registros");
        jToolBar1.add(jLabel1);

        lbl_num.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lbl_num.setText("0");
        jToolBar1.add(lbl_num);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda de Marcas"));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3);

        txt_nombre.setMaximumSize(new java.awt.Dimension(200, 30));
        txt_nombre.setMinimumSize(new java.awt.Dimension(200, 30));
        txt_nombre.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel2.add(txt_nombre);

        Pais.setText("Pais");
        jPanel2.add(Pais);

        jPanel2.add(cmb_pais);

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_buscar);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_nuevo.setText("Nueva marca");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btn_nuevo);

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_editar);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_eliminar);

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

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            MarcaRow mr = this.listaMarcas.get(indice);
            new MarcaDialog(null, true, false, mr);
            this.cargarMarcas();
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        new MarcaDialog(null, true, true, new MarcaRow());
        this.cargarMarcas();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int indice = this.tbl_datos.getSelectedRow();
        
        if(indice >= 0){
            
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este registro?");
            
            if(respuesta == 0){
                MarcaRow mr = this.listaMarcas.get(indice);
                String query = String.format("DELETE FROM marca WHERE idMarca = %s", mr.getIdmarca());
                
                ConexionBD conn = null;
        
                try{
                    conn = new ConexionBD(host, puerto, bd, usu, pas);
                    int filas = conn.update(query).getUpdateCount();
                    JOptionPane.showMessageDialog(this, "Filas Afectadas" + filas, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    this.cargarMarcas();
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
        
        filtro_nombre = null;
        if(this.txt_nombre.getText() != null && !this.txt_nombre.getText().isEmpty()){
            filtro_nombre = this.txt_nombre.getText();
            
        }
        this.cargarMarcas();
    }//GEN-LAST:event_btn_buscarActionPerformed
    
    private String filtro_nombre;
    private String[] COLUMNAS = {"Marca", "Pais"};
    private List<MarcaRow> listaMarcas;
    
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pais;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cmb_pais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JTable tbl_datos;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
