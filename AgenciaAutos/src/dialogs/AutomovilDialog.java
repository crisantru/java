/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import conexion.ConexionBD;
import datos.AutomovilRow;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author crisantru
 */
public class AutomovilDialog extends javax.swing.JDialog {

    /**
     * Creates new form AutomovilDialog
     */
    public AutomovilDialog(java.awt.Frame parent, boolean modal, boolean nuevo, AutomovilRow automovil) {
        super(parent, modal);
        initComponents();
        this.cargarMarcas();
        this.cargarClases();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.nuevo = nuevo;
        this.automovil = automovil;
        
        if(!nuevo){
            this.txt_modelo.setText(automovil.getModelo());
            this.txt_anio.setText(automovil.getAnio());
            this.cmb_marca.setSelectedItem(automovil.getMarca());
            this.txt_precio.setText(String.valueOf(automovil.getPrecioventa()));
            this.cmb_clase.setSelectedItem(automovil.getClase());

        }else{
            this.txt_modelo.setText("");
            this.txt_anio.setText("");
            this.cmb_marca.addItem("");
            this.txt_precio.setText("");
            this.cmb_clase.addItem("");
        }
        
        
        this.setModal(modal);
        this.setVisible(true);
        
    }
    private boolean validar(){
        if(this.txt_modelo.getText() == null ||
            this.txt_modelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir el modelo del automovil");
            return false;
        }
        if(this.txt_anio.getText() == null ||
            this.txt_anio.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir el año del automovil");
            return false;
        }
        
        if(this.jdc_ensamble.getDate() == null || this.jdc_ensamble.getDate().toString().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes seleccionar una fecha de ensamblaje");
            return false;
        }
        
        if(this.txt_precio.getText() == null || this.txt_precio.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "debes introducir el precio a la venta del automovil");
            return false;
        }
        return true;
    }

    private void cargarMarcas(){
        marcas = new HashMap<String, Integer>();
        ConexionBD conn = null;
        this.cmb_marca.removeAllItems();
        this.cmb_marca.addItem("NO seleccionado");
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT idmarca, nombre FROM marca";
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                      marcas.put(rs.getString("nombre"), rs.getInt("idmarca"));
                        this.cmb_marca.addItem(rs.getString("nombre"));
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
    
    private void cargarClases(){
        clases = new HashMap<String, Integer>();
        ConexionBD conn = null;
        this.cmb_clase.removeAllItems();
        this.cmb_clase.addItem("NO seleccionado");
        
        try{
            
            conn = new ConexionBD(host, puerto , bd, usu, pas);
            String query = "SELECT idclase, nombre FROM clase";
            ResultSet rs = conn.query(query).getResultSet();
            
            if(rs != null){
                while(rs.next()){
                      clases.put(rs.getString("nombre"), rs.getInt("idclase"));
                        this.cmb_clase.addItem(rs.getString("nombre"));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_marca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jdc_ensamble = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        txt_anio = new javax.swing.JTextField();
        cmb_clase = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Nuevo Automovil");
        setResizable(false);

        jLabel1.setText("Modelo");

        jLabel2.setText("Año");

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel3.setText("Marca");

        jLabel4.setText("Ensamblaje");

        jLabel5.setText("Precio");

        jLabel6.setText("Clase");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_modelo)
                            .addComponent(txt_anio)
                            .addComponent(cmb_marca, 0, 155, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_ensamble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_precio)
                            .addComponent(cmb_clase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jdc_ensamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(validar()){
            String modelo = this.txt_modelo.getText();
            String anio = this.txt_anio.getText();
            Integer idMarca = this.marcas.get(this.cmb_marca.getSelectedItem().toString());
            java.util.Date fecha = this.jdc_ensamble.getDate();
            String precioventa = this.txt_precio.getText();
            Integer idClase = this.clases.get(this.cmb_clase.getSelectedItem().toString()); 
            String query = "";

            if(nuevo){
                query = String.format("INSERT INTO automovil VALUES (NULL, '%s', '%s', %s, '%s', '%s', %s)", modelo, anio,
                        idMarca, sdf.format(fecha), precioventa, idClase);
                System.out.println(query);

            }else{
                query = String.format("UPDATE automovil SET modelo = '%s'," 
                        + "anio = '%s', idmarca = %s, fecha = '%s', precioventa = %s,"
                        + "idclase = %s WHERE nomotor = %s", modelo, anio, idMarca,
                        sdf.format(fecha), precioventa, idClase, automovil.getMotor());
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
    
    private SimpleDateFormat sdf;
    private boolean nuevo;
    private AutomovilRow automovil;
    private String host = "localhost";
    private String usu = "root";
    private String pas = "Nocturnal2802";
    private String bd = "agencia";
    private Integer puerto = 3306;
    private HashMap<String, Integer> marcas;
    private HashMap<String, Integer> clases;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmb_clase;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JDateChooser jdc_ensamble;
    private javax.swing.JTextField txt_anio;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
