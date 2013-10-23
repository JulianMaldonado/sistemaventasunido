
package sistemaventas;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Conexion.ConexionMySQL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Empleados extends javax.swing.JInternalFrame {
    //agrego para el filtro
    DefaultTableModel model;
    
    
    
    
    
   CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion();
   
   
   
   
   
    public Empleados() {
        initComponents();
     
         
     cn=conectar.conectado();
    // lbldepto.setVisible(false);
    // lblcargo.setVisible(false);
     //lbltipo.setVisible(false);
     //lblempleado.setVisible(false);      
       
       
        cargar("");
        llenarcombo();
        llenarciudad();
        llenacargos ();
        BOTONES();
        DESABILITAR();
       
       
       
    }
    
     
 
    public void cargar(String valor){
     String [] titulos = {"No.","NOMBRE","APELLIDO","DIRECCION","TELEFONO","D  P  I","DEPARTAMENTO","CARGO","USUARIO","TIPO USUARIO"};
     String [] registros = new String [10];
     
    String sql="select empleado.id_empleado, empleado.em_nombre,empleado.em_apellido,empleado.em_direccion,empleado.em_telefono,empleado.em_dpi,ciudad.descripcion,cargo_empleado.cardescripcion,empleado.user, nivel_user.niveldescripcion from empleado,ciudad,cargo_empleado, nivel_user where em_nombre LIKE '%"+valor+"%' and  empleado.id_ciudad=ciudad.id_ciudad and empleado.id_cargo=cargo_empleado.id_cargo and empleado.tipo_usuario=nivel_user.nivel ";
   // String sql="select * from empleado where em_nombre LIKE '%"+valor+"%'";
     model= new DefaultTableModel (null,titulos);
     
    //conexion conectar=new conexion();
    cn=conectar.conectado();
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            registros [0]=rs.getString("id_empleado");
            registros [1]=rs.getString("em_nombre");
            registros [2]=rs.getString("em_apellido");
            registros [3]=rs.getString("em_direccion");
            registros [4]=rs.getString("em_telefono");
            registros [5]=rs.getString("em_dpi");
           registros [6]=rs.getString("descripcion");
           // registros [6]=rs.getString("id_ciudad");
            registros [7]=rs.getString("cardescripcion");
           // registros [7]=rs.getString("id_cargo");
            registros [8]=rs.getString("user");
           // registros [9]=rs.getString("clave");
            registros [9]=rs.getString("niveldescripcion");
            //registros [10]=rs.getString("tipo_usuario");
           model.addRow(registros);
                  
            }
           jTable3.setModel(model);
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
   
    
 
           
}
    
 public void llenarciudad(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT descripcion as nombre FROM ciudad ORDER BY descripcion ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cbodepto.addItem(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}

    }    

 public void pasaidciudad(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_ciudad as total FROM ciudad WHERE descripcion='"+ cbodepto.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lbldepto.setText(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}


}   

 public void llenacargos(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT cardescripcion as nombre FROM cargo_empleado ORDER BY cardescripcion ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cbocargo.addItem(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}

    }    

 public void pasaidcargo(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_cargo as total FROM cargo_empleado WHERE cardescripcion='"+ cbocargo.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lblcargo.setText(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}


}   
    
 public void llenarcombo(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
    PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT niveldescripcion as nombre FROM nivel_user ORDER BY id ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cbotipo.addItem(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}

    }       
       
 public void pasaidcombo(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT nivel as total FROM nivel_user WHERE niveldescripcion='"+ cbotipo.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lbltipo.setText(valor);

}
}
catch(Exception e) {}
finally {
try {
if (pstmt != null) pstmt.close();
}
catch (Exception e) {}
try {
if (rs != null) rs.close();
}
catch (Exception e) {}
}


}   
      

    
    
    
    
    
    

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDPI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbodepto = new javax.swing.JComboBox();
        cbocargo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtclave = new javax.swing.JTextField();
        cbotipo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbldepto = new javax.swing.JLabel();
        lblcargo = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblempleado = new javax.swing.JLabel();
        txtfiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtBuscaClientes = new org.edisoncor.gui.textField.TextFieldRound();
        btnVerModificar = new org.edisoncor.gui.button.ButtonAeroLeft();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento de Empleados.....");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DPI:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Usuario:");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtDPI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDPIActionPerformed(evt);
            }
        });
        txtDPI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDPIFocusLost(evt);
            }
        });
        txtDPI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDPIKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtuser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtuserFocusLost(evt);
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtuserKeyPressed(evt);
            }
        });

        txtdireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdireccionFocusLost(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Direccion:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Departamento:");

        cbodepto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbodepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Departamento" }));
        cbodepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbodeptoActionPerformed(evt);
            }
        });
        cbodepto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbodeptoFocusLost(evt);
            }
        });

        cbocargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbocargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Cargo" }));
        cbocargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocargoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Cargo:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Clave:");

        txtclave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cbotipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Nivel" }));
        cbotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Nivel User:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtuser, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtclave)
                                    .addComponent(cbotipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDPI, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(10, 49, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbodepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(cbocargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtTelefono))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(txtdireccion)))))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbodepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbocargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User add).jpg"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        btnguardar.setText("REGISTRAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User edit).jpg"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User delete).jpg"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wzdelete.jpg"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnbuscar, btncancelar, btneliminar, btnguardar, btnmodificar, btnnuevo});

        lbldepto.setText("depto");

        lblcargo.setText("cargo");

        lbltipo.setText("tipo");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        lblempleado.setText("Empleado");

        txtfiltro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfiltroKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ingresa DPI:");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelHeader1.setText("Ingrese nombre del empleado que desea buscar....");

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
        btnVerModificar.setText("Ver Empleado");
        btnVerModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnVerModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnVerModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbltipo)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbldepto)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblcargo)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(lblempleado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldepto)
                            .addComponent(lblcargo)
                            .addComponent(lbltipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblempleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
         ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion
        
         String nom=txtNombres.getText(); 
         String apellido=txtApellidos.getText(); 
         String direc=txtdireccion.getText(); 
         String tel=txtTelefono.getText(); 
         String dpi=txtDPI.getText(); 
         String idciu=lbldepto.getText();
         String idcar=lblcargo.getText();
         String user=txtuser.getText(); 
         String clave=txtclave.getText(); 
         String idtip=lbltipo.getText();
  
        
        try {
            
            
         
          
    if(  !nom.equals("") && !apellido.equals("") && !direc.equals("") && !tel.equals("") &&! dpi.equals("") &&!user.equals("") &&!clave.equals("") &&!idciu.equals("") &&!idcar.equals("") &&!idtip.equals(""))   
                //enviar datos a validar
            
                                    
	                        {
	                         
                                    
    cts=cn.prepareCall("{ call guarda_empleados(?,?,?,?,?,?,?,?,?,?)}");
            
            cts.setString(1, nom);
            cts.setString(2, apellido);
            cts.setString(3, direc);
            cts.setString(4, tel);
            cts.setString(5, dpi);
            cts.setString(6, idciu);
            cts.setString(7, idcar);
            cts.setString(8, user);
            cts.setString(9, clave);
            cts.setString(10,idtip);
           
            
                     
            
            
            int rpta=cts.executeUpdate();
            if(rpta==1)
                JOptionPane.showMessageDialog(this,"CLIENTE REGISTRADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);
           
            
            
            BOTONES();
            
            
            DESABILITAR();
            limpiar();
            
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
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, e);
        }
                  

    }//GEN-LAST:event_btnguardarActionPerformed

 
    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String cod=txtfiltro.getText(); //JOptionPane.showInputDialog("INGRESE EL DNI DE EMPLEADO A BUSCAR si decea puede editalpara modificar o eliminar el registro");
       String id=lblempleado.getText();
        try {
            cts=cn.prepareCall("{call buscaempleado(?)}");
            cts.setString(1, cod);
            r=cts.executeQuery();
            
            if(r.next()){
            JOptionPane.showMessageDialog(this,"Empleado  Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            
                this.lblempleado.setText(r.getString(1));
                this.txtNombres.setText(r.getString(2));
                this.txtApellidos.setText(r.getString(3));
                this.txtdireccion.setText(r.getString(4));
                this.txtTelefono.setText(r.getString(5));
                this.txtDPI.setText(r.getString(6));
                this.lbldepto.setText(r.getString(7));
                this.lblcargo.setText(r.getString(8));
                this.txtuser.setText(r.getString(9));
                this.txtclave.setText(r.getString(10));
                this.lbltipo.setText(r.getString(11));
             
                         
             
            
         ABILITAR();
         
         this.btnguardar.setEnabled(false);
           this.btnnuevo.setEnabled(false);
           this.btnbuscar.setEnabled(false);
           this.btnmodificar.setEnabled(true);
           this.btneliminar.setEnabled(true);
            }else{

           JOptionPane.showMessageDialog(this,"Empleado  No Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

  
    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
   
         ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion
        
         String id=lblempleado.getText(); 
         String nom=txtNombres.getText(); 
         String apellido=txtApellidos.getText(); 
         String direc=txtdireccion.getText(); 
         String tel=txtTelefono.getText(); 
         String dpi=txtDPI.getText(); 
         String idciu=lbldepto.getText();
         String idcar=lblcargo.getText();
         String user=txtuser.getText(); 
         String clave=txtclave.getText(); 
         String idtip=lbltipo.getText();
        
       try {
            
            
         
          
    if(  !nom.equals("") && !apellido.equals("") && !direc.equals("") && !tel.equals("") &&! dpi.equals("") &&!user.equals("") &&!clave.equals("") &&!idciu.equals("") &&!idcar.equals("") &&!idtip.equals(""))   
                //enviar datos a validar
            
                                    
	                        {
	                         
                                    
    cts=cn.prepareCall("{ call modifica_empleado(?,?,?,?,?,?,?,?,?,?,?)}");
            
            cts.setString(1, id);
            cts.setString(2, nom);
            cts.setString(3, apellido);
            cts.setString(4, direc);
            cts.setString(5, tel);
            cts.setString(6, dpi);
            cts.setString(7, idciu);
            cts.setString(8, idcar);
            cts.setString(9, user);
            cts.setString(10, clave);
            cts.setString(11, idtip);
              int rpta=cts.executeUpdate();
            if(rpta==1)
                JOptionPane.showMessageDialog(this,"EMPLEADO A SIDO MODIFICADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);
            
            BOTONES();
                limpiar();
                DESABILITAR();
                // llenarciudad();
                cargar("");
            
            
     
                                }
            
            else
            
                            {
	                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos que tengan (*) .\n" +
	                            "NO puede dejar ningun campo vacio");
                                                             
	                    }
        
            
           
        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, e);
        }
        
     
        
    }//GEN-LAST:event_btnmodificarActionPerformed


    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
//          String cod=this.jTextField1.getText();
        try {
            cts=cn.prepareCall("{call eliminarEmpleado(?)}");
//            cts.setString(1, cod);
            int rpta=cts.executeUpdate();

            if(rpta==1){
            JOptionPane.showMessageDialog(this, "Empleado Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            DESABILITAR();
            BOTONES();
                    }else {
             JOptionPane.showMessageDialog(this, "Empleado No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtNombres.requestFocus();
          
       // llenarcombo();
       // llenarciudad();
       // llenacargos ();
        limpiar();
       
        
        
       
         ABILITAR();
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btnbuscar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        BOTONES();
        DESABILITAR();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtDPIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDPIKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
           if(  txtDPI.getText().length()>=13)evt.consume();
       if((car<'0' || car>'9') ) evt.consume();
       
        String s;
        s= txtDPI.getText();
        txtDPI.setText(s.toUpperCase());
       
       
    }//GEN-LAST:event_txtDPIKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
           if(  txtTelefono.getText().length()>=9)evt.consume();
       if((car<'0' || car>'9') ) evt.consume();
       
        String s;
        s= txtTelefono.getText();
        txtTelefono.setText(s.toUpperCase());
       
       
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        
        char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
        
        String s;
        s= txtApellidos.getText();
        txtApellidos.setText(s.toUpperCase());
        
        
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
          char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
       
        String s;
        s= txtNombres.getText();
        txtNombres.setText(s.toUpperCase());
        
        
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        String s;
        s= txtdireccion.getText();
        txtdireccion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
        
        pasaidcombo();
        
        
        /* mcombos mcombos1 =(mcombos) cbotipo.getSelectedItem(); //esto es por el mcombos
idtipo = mcombos1.getID();

 String id = mcombos1.getID();
    lbltipo.setText(id);*/
    }//GEN-LAST:event_cbotipoActionPerformed

    private void cbodeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodeptoActionPerformed
        // TODO add your handling code here:
        pasaidciudad();
        
        
    }//GEN-LAST:event_cbodeptoActionPerformed

    private void cbocargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocargoActionPerformed
        // TODO add your handling code here:
        pasaidcargo();
        
        
    }//GEN-LAST:event_cbocargoActionPerformed

    private void txtDPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDPIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDPIActionPerformed

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        // TODO add your handling code here:
        String s;
        s= txtNombres.getText();
        txtNombres.setText(s.toUpperCase());
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        // TODO add your handling code here:
        String s;
        s= txtApellidos.getText();
        txtApellidos.setText(s.toUpperCase());
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtdireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdireccionFocusLost
        // TODO add your handling code here:
         String s;
        s= txtdireccion.getText();
        txtdireccion.setText(s.toUpperCase());
    }//GEN-LAST:event_txtdireccionFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:
         String s;
        s= txtTelefono.getText();
        txtTelefono.setText(s.toUpperCase());
        
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtDPIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDPIFocusLost
        // TODO add your handling code here:
         String s;
        s= txtDPI.getText();
        txtDPI.setText(s.toUpperCase());
    }//GEN-LAST:event_txtDPIFocusLost

    private void txtuserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyPressed
        // TODO add your handling code here:
        String s;
        s= txtuser.getText();
        txtuser.setText(s.toUpperCase());
    }//GEN-LAST:event_txtuserKeyPressed

    private void txtuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserFocusLost
        // TODO add your handling code here:
        String s;
        s= txtuser.getText();
        txtuser.setText(s.toUpperCase());
    }//GEN-LAST:event_txtuserFocusLost

    private void cbodeptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbodeptoFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbodeptoFocusLost

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
        }
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyReleased
        // TODO add your handling code here:
         cargar(txtfiltro.getText());
       
    }//GEN-LAST:event_txtfiltroKeyReleased

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

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

private void SelecionaCL(){
        
        int row=jTable3.getSelectedRow();
        String id=jTable3. getValueAt   (row, 0).toString();
        String nom=jTable3.getValueAt   (row, 1).toString();
        String ape=jTable3.getValueAt   (row, 2).toString();
        String direc=jTable3.getValueAt (row, 3).toString();
        String tel=jTable3.getValueAt   (row, 4).toString();
        String dpi=jTable3.getValueAt   (row, 5).toString();
        String depto=jTable3.getValueAt (row, 6).toString();
        String cargo=jTable3.getValueAt (row, 7).toString();
        String user=jTable3.getValueAt  (row, 8).toString();
        String tipo=jTable3.getValueAt  (row, 9).toString();
        
        
        lblempleado.setText(id);
        txtNombres.setText(nom);
        txtApellidos.setText(ape);
        txtdireccion.setText(direc);
        txtTelefono.setText(tel);
        txtDPI.setText (dpi);
        lbldepto.setText(depto);
        lblcargo.setText(cargo);
        txtuser.setText(user);
        lbltipo.setText(tipo);
        cbodepto.setSelectedItem(depto);
        cbocargo.setSelectedItem(cargo);
        cbotipo.setSelectedItem(tipo);
        
       
        
        
       
     
        //jTextField5.setText(id);
        
        
            
           // jTextField1.setText(Clientes.get(tb.getSelectedRows()).get);
        
    }   
    
    private void btnVerModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerModificarActionPerformed
        // TODO add your handling code here:
        
      SelecionaCL();
      ABILITAR();

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

    
    public void limpiar(){
   
        this.txtNombres.setText("");    
        this.txtApellidos.setText("");
        this.txtdireccion.setText(""); 
        this.txtTelefono.setText("");
        this.txtDPI.setText("");
        this.cbodepto.setSelectedIndex(0);
        this.cbocargo.setSelectedIndex(0);
        this.txtuser.setText("");
        this.txtclave.setText("");
        this.cbotipo.setSelectedIndex(0);
        this.txtfiltro.setText("");
        this.txtNombres.requestFocus();}
    
      public void ABILITAR(){
          
           this.txtNombres.setEnabled(true);
           this.txtApellidos.setEnabled(true);
           this.txtdireccion.setEnabled(true);
           this.txtTelefono.setEnabled(true);
           this.txtDPI.setEnabled(true);
           this.cbodepto.setEnabled(true);
           this.cbocargo.setEnabled(true);
           this.txtuser.setEnabled(true);
           this.cbotipo.setEnabled(true);
           this.txtclave.setEnabled(true);
           this.txtNombres.requestFocus();
  }
   private void DESABILITAR(){
           this.txtNombres.setEnabled(false);
           this.txtApellidos.setEnabled(false);
           this.txtdireccion.setEnabled(false);
           this.txtTelefono.setEnabled(false);
           this.txtDPI.setEnabled(false);
           this.cbodepto.setEnabled(false);
           this.cbocargo.setEnabled(false);
           this.txtuser.setEnabled(false);
           this.txtclave.setEnabled(false);
           this.cbotipo.setEnabled(false);
           //this.txtfiltro.setEnabled(false);
                  }
  private void BOTONES(){
           this.btnguardar.setEnabled(false);
           this.btnnuevo.setEnabled(true);
           this.btnbuscar.setEnabled(true);
           this.btnmodificar.setEnabled(false);
           this.btneliminar.setEnabled(false);
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAeroLeft btnVerModificar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbocargo;
    private javax.swing.JComboBox cbodepto;
    private javax.swing.JComboBox cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private javax.swing.JLabel lblcargo;
    private javax.swing.JLabel lbldepto;
    private javax.swing.JLabel lblempleado;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JTextField txtApellidos;
    private org.edisoncor.gui.textField.TextFieldRound txtBuscaClientes;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtclave;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfiltro;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
