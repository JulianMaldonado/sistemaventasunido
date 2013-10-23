/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaventas;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import Conexion.ConexionMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author JULIAN
 */
public class Interfaz_cargos extends javax.swing.JInternalFrame {
 DefaultTableModel model;
   CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion();
 
  private  String numero_cargo="";
  
    

     
   
   public String getNumero_Cliente() {
        return numero_cargo;
    } 
   
   public void setNumero_Cliente(String numero_cliente) {
        this.numero_cargo = numero_cliente;
    }
   
   
   
    /**
     * Creates new form Interfaz_cargos
     */
    public Interfaz_cargos() {
        initComponents();
         BOTONES();
        inhabilitar();
        cn=conectar.conectado();
        cargar("");
       
        
       
    }
  
     private void cargar1(){
        
        
       
       DefaultTableModel tabla= new DefaultTableModel()
          {
                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
                        return false;
                    }
                };
       try{
       tabla.addColumn("No.");
       tabla.addColumn("DESCRIPCION");
       tabla.addColumn("SALARIO");
    
            
       
       cts=cn.prepareCall("{call mostrarcargos}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[3];
       for (int i=0; i<7; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
       
       
       
       
             
             if(this.txtBuscaClientes.getText().isEmpty()){
       
        }
        else{
        try{
        String busq=this.txtBuscaClientes.getText();
        PreparedStatement psm=cn.prepareStatement("SELECT cardescripcion FROM cargo_empleado WHERE cardescripcion like '"+ busq +" %' ");
        ResultSet rs=psm.executeQuery();
        while(rs.next()){
            
            JOptionPane.showMessageDialog(this, rs);
        
        tabla.addColumn((ListSelectionListener) rs.getObject(1));
       
        }
        this.jTable1.setModel((TableModel) tabla);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"NO SE HA ENCONTRADO EL NOMBRE");
        }
        
        } 
       
       
       
       
       
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void cargar(String valor){

     String [] titulos = {"No.","CARGO","SUELDO"};
     String [] registros = new String [10];
     
    String sql="select cargo_empleado.id_cargo, cargo_empleado.cardescripcion,cargo_empleado.sueldo from cargo_empleado where cardescripcion LIKE '%"+valor+"%' ";
   
     model= new DefaultTableModel (null,titulos);
     
    
     
     
    //conexion conectar=new conexion();
    cn=conectar.conectado();
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            registros [0]=rs.getString("id_cargo");
            registros [1]=rs.getString("cardescripcion");
            registros [2]=rs.getString("sueldo");
            
          
           model.addRow(registros);
                  
            }
           jTable1.setModel(model);
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
  
       
}
    
    
    public void limpiar(){
   
        this.txtdescripcion.setText("");    
        this.txtsueldo.setText("");
        } 
    
void habilitar()
    {
       
        txtdescripcion.setEnabled(true);
        txtdescripcion.setText("");
        txtsueldo.setEnabled(true);
        txtsueldo.setText("");
        btnguardar.setEnabled(true); 
        btnbuscar.setEnabled(true);
        btncancelar.setEnabled(true);
              
    }
     void inhabilitar()
    {
       
       
        txtdescripcion.setEnabled(false);
        txtdescripcion.setText("");
        txtsueldo.setEnabled(false);
        txtsueldo.setText("");
        btnguardar.setEnabled(false); 
      //  btnbuscar.setEnabled(false);
        btncancelar.setEnabled(false);
              
    }
    
      private void BOTONES(){
           this.btnguardar.setEnabled(false);
           this.btnnuevo.setEnabled(true);
           this.btnbuscar.setEnabled(true);
           this.btnmodificar.setEnabled(false);
           
}
     
        
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblcargo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtBuscaClientes = new org.edisoncor.gui.textField.TextFieldRound();
        btnVerModificar = new org.edisoncor.gui.button.ButtonAeroLeft();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Creacion de Cargos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Q.");

        txtsueldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsueldo.setText("jTextField1");
        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsueldoKeyTyped(evt);
            }
        });

        txtdescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdescripcion.setText("jTextField1");
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdescripcionFocusLost(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Sueldo:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion:");

        lblcargo.setText("cargo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblcargo)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcargo)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User edit).jpg"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User add).jpg"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wzdelete.jpg"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addGap(7, 7, 7)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar)
                .addGap(21, 21, 21)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ingresa Proveedor:");

        txtfiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelHeader1.setText("Ingrese nombre cliente que desea buscar....");

        txtBuscaClientes.setCaretColor(new java.awt.Color(51, 51, 51));
        txtBuscaClientes.setDisabledTextColor(new java.awt.Color(153, 204, 255));
        txtBuscaClientes.setSelectionColor(new java.awt.Color(102, 204, 255));
        txtBuscaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaClientesActionPerformed(evt);
            }
        });
        txtBuscaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClientesKeyReleased(evt);
            }
        });

        btnVerModificar.setBackground(new java.awt.Color(112, 67, 67));
        btnVerModificar.setText("Ver Cliente");
        btnVerModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVerModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void SelecionaCL(){
        
        int row=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(row, 0).toString();
        String des=jTable1.getValueAt(row, 1).toString();
        String sueldo=jTable1.getValueAt(row, 2).toString();
          
        
                
        
        txtdescripcion.setText(des);
        txtsueldo.setText(sueldo);
        
        lblcargo.setText(id);
        
       
     
        //jTextField5.setText(id);
        
        
            
           // jTextField1.setText(Clientes.get(tb.getSelectedRows()).get);
        
    }   
    
   
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // GUARDAR

        
        ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion
  
              
        
        String des=txtdescripcion.getText();
        String sueldo=txtsueldo.getText();
       
        try {

            if(  !des.equals("") && !sueldo.equals("") )
            //enviar datos a validar

            {

                cts=cn.prepareCall("{ call guardar_cargo(?,?)}");

                cts.setString(1, des);
                cts.setString(2, sueldo);
                
                

                int rpta=cts.executeUpdate();
                if(rpta==1)
                JOptionPane.showMessageDialog(this,"CARGO REGISTRADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

                BOTONES();
                limpiar();
                inhabilitar ();
                cargar("");

            }

            else

            {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos que tengan (*) .\n" +
                    "NO puede dejar ningun campo vacio");
               
                                txtdescripcion.requestFocusInWindow();
                                txtsueldo.requestFocusInWindow();

            }

        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    
    
    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtdescripcion.requestFocus();
        habilitar();
        cargar("");
        

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
        // TODO add your handling code here:
         String s;
        s= txtdescripcion.getText();
        txtdescripcion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdescripcionKeyPressed

    private void txtdescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescripcionFocusLost
        // TODO add your handling code here:
         String s;
        s= txtdescripcion.getText();
        txtdescripcion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdescripcionFocusLost

    private void txtsueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();  
if((car<'0' || car>'9') && txtsueldo.getText().contains(".")){
   evt.consume();
}else if((car<'0' || car>'9') && (car!='.')){
   evt.consume();
}
    }//GEN-LAST:event_txtsueldoKeyTyped

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
         int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();}
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        // TODO add your handling code here:
           String s;
        s= txtdescripcion.getText();
        txtdescripcion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       // TODO add your handling code here:
        String cod=txtfiltro.getText(); //JOptionPane.showInputDialog("INGRESE EL DNI DE EMPLEADO A BUSCAR si decea puede editalpara modificar o eliminar el registro");
        String id=lblcargo.getText();
        try {
            cts=cn.prepareCall("{call buscar_cargo(?)}");
            cts.setString(1, cod);
            r=cts.executeQuery();

            if(r.next()){
                JOptionPane.showMessageDialog(this,"Cargo Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

                this.lblcargo.setText(r.getString(1));
                this.txtdescripcion.setText(r.getString(2));
                this.txtsueldo.setText(r.getString(3));
                
                habilitar();
                
                this.btnguardar.setEnabled(false);
                this.btnnuevo.setEnabled(false);
                this.btnbuscar.setEnabled(false);
                this.btnmodificar.setEnabled(true);
                
            }else{

                JOptionPane.showMessageDialog(this,"Cargo  No Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    
    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:

        /* modifica_proveedores modifica= new modifica_proveedores();
        SistemaV.jDesktopPane1.add(modifica);
        modifica.toFront();
        modifica.setVisible(true);
        this.dispose();*/

        ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion

        String idcar=lblcargo.getText();
        String des=txtdescripcion.getText();
        String sueldo=txtsueldo.getText();
       

        try {

            if(  !idcar.equals("") && !des.equals("") && !sueldo.equals(""))
            //enviar datos a validar

            {

                cts=cn.prepareCall("{ call modificar_cargo(?,?,?)}");

                cts.setString(1, idcar);
                cts.setString(2, des);
                cts.setString(3, sueldo);
               
                int rpta=cts.executeUpdate();
                if(rpta==1)
                JOptionPane.showMessageDialog(this,"CARGO A SIDO MODIFICADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

                BOTONES();
                limpiar();
                inhabilitar();
            
                cargar("");

            }

            else

            {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos que tengan (*) .\n" +
                    "NO puede dejar ningun campo vacio");
                //txtNit.requestFocusInWindow();
                //txtNombre.requestFocusInWindow();
                //txtDireccion.requestFocusInWindow();

            }

        } catch (SQLException | HeadlessException e) {
           // Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, e);
        }

        txtdescripcion.setText("");
        txtsueldo.setText("");
        

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        // TODO add your handling code here:
        cargar(txtfiltro.getText());
    }//GEN-LAST:event_txtfiltroKeyReleased

    private void txtBuscaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaClientesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscaClientesActionPerformed

    private void txtBuscaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClientesKeyReleased
        // TODO add your handling code here:

        cargar(txtBuscaClientes.getText());

        char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();

        String s;
        s= txtBuscaClientes.getText();
        txtBuscaClientes.setText(s.toUpperCase());

    }//GEN-LAST:event_txtBuscaClientesKeyReleased

    private void btnVerModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerModificarActionPerformed
        // TODO add your handling code here:
        
        
        SelecionaCL();
           habilitar();
                
                this.btnguardar.setEnabled(false);
                this.btnnuevo.setEnabled(false);
                this.btnbuscar.setEnabled(false);
                this.btnmodificar.setEnabled(true);
/*        ABILITAR();

        this.btGuardar.setEnabled(false);
        this.btNuevo.setEnabled(false);

        this.btModificar.setEnabled(true);
        this.btCancelar.setEnabled(true);
*/
    }//GEN-LAST:event_btnVerModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAeroLeft btnVerModificar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private javax.swing.JLabel lblcargo;
    private org.edisoncor.gui.textField.TextFieldRound txtBuscaClientes;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtfiltro;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
