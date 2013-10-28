/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaventas;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Conexion.ConexionMySQL;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JULIAN
 */
public class form_Compras extends javax.swing.JDialog {
String idproveedor ;
String idproducto;
 CallableStatement cts;
   ResultSet r;
   Connection cn;
   conexion conectar=new conexion(); 
    /**
     * Creates new form form_Compras
     */
   
     public form_Compras(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        
        
                
        
        initComponents();
        setLocationRelativeTo (null);
        setTitle ("REGISTRO DE COMPRAS");
        jLabel15.setVisible(false);
        txtturno.setVisible(false);
        llenarprove();
        llenarproducto();
        cbodocumento.setEnabled(false);
	btncancelar.setEnabled(false);
        btnagregar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnguardar.setEnabled(false);
        lblpasafecha.setVisible(false);
        DESABILITAR();	
    }
   
   
   
    public void llenarprove(){

  Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT nombre_comercial as nombre FROM proveedor ORDER BY nombre_comercial ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cboproveedor.addItem(valor);

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
    
    public void pasaidproveedor(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_proveedor as total FROM proveedor WHERE nombre_comercial='"+ cboproveedor.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
idproveedor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lblproveedor.setText(idproveedor);

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
    
     public void llenarproducto(){

Connection cn;
conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT nombre_producto as nombre FROM producto ORDER BY nombre_producto ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
String valor = rs.getString("nombre");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cboproducto.addItem(valor);

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
    
    public void pasaidproducto(){


  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_producto as total FROM producto WHERE nombre_producto='"+ cboproducto.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) {
idproducto = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar
lblproducto.setText(idproducto);

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
    
    public void limpiar(){
   
        this.txtnodocumento.setText("");    
        this.txtserie.setText(""); 
        this.datedocumento.setCalendar(null);  
        this.lblpasafecha.setVisible(false);
        this.cboproveedor.setSelectedIndex(0);
        this.cboproducto.setSelectedIndex(0);
        this.txtunidades.setText(""); 
        this.txtcosto.setText(""); 
        this.txtventa.setText(""); 
        this.txtgrantotal.setText(""); 
        
        this.txtnodocumento.requestFocus();
    }

    public void ABILITAR(){
           this.cbodocumento.setEnabled(true);
           this.txtnodocumento.setEnabled(true);
           this.txtserie.setEnabled(true);
           this.datedocumento.setEnabled(true);
           this.lblpasafecha.setVisible(true);
           this.cboproveedor.setEnabled(true);
           this.cboproducto.setEnabled(true);
           this.txtunidades.setEnabled(true);
           this.txtcosto.setEnabled(true);
           this.txtventa.setEnabled(true);
           this.txtgrantotal.setEnabled(true);
           
           this.txtnodocumento.requestFocus();
  }
    private void DESABILITAR(){
           
           this.txtnodocumento.setEnabled(false);
           this.txtserie.setEnabled(false);
           this.datedocumento.setEnabled(false);
           this.lblpasafecha.setVisible(false);
           this.cboproveedor.setEnabled(false);
           this.cboproducto.setEnabled(false);
           this.txtunidades.setEnabled(false);
           this.txtcosto.setEnabled(false);
           this.txtventa.setEnabled(false);
           this.txtgrantotal.setEnabled(false);
           this.cbodocumento.setEnabled(false);   
    }
    
    private void BOTONES(){
           this.btnguardar.setEnabled(false);
           this.btnnuevo.setEnabled(true);
           this.btnagregar.setEnabled(false);
           this.btneliminar.setEnabled(false);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        txtventa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboproveedor = new javax.swing.JComboBox();
        cboproducto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtserie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtgrantotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblproveedor = new javax.swing.JLabel();
        lblproducto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnodocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        datedocumento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbodocumento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        txtunidades = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtturno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        btneliminar = new javax.swing.JButton();
        lblpasafecha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnsalir1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacompra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(51, 51, 51));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        txtventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtventaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Fecha Registro:");

        txtcosto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcostoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Valor Venta:");

        cboproveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Proveedor" }));
        cboproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboproveedorActionPerformed(evt);
            }
        });

        cboproducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboproducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Producto" }));
        cboproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboproductoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Serie Documento:");

        txtserie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Gran Total:");

        txtgrantotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtgrantotal.setEnabled(false);
        txtgrantotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtgrantotalKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Q.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Q.");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Q.");

        lblproveedor.setText("prove");

        lblproducto.setText("produc");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de Documento:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("No. Documento:");

        txtnodocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Fecha De Documento:");

        datedocumento.setDateFormatString("yyyy-MM-dd");
        datedocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datedocumento.setMaxSelectableDate(new java.util.Date(253370790064000L));
        datedocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datedocumentoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Proveedor:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Producto:");

        cbodocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbodocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACTURA", "FACTURA COMBIARIA", "NOTA DE CREDITO", "NOTA DE DEBITO" }));
        cbodocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbodocumentoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Valor Costo:");

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir-carrito-de-la-tienda-en-linea-de-comercio-electronico-icono-7379-64.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        txtunidades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtunidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtunidadesKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Unidades:");

        txtturno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtturno.setText("10");
        txtturno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtturnoKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("turno");

        labelHeader1.setText("Registro de Compras");
        labelHeader1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tienda-online-de-comercio-electronico-excluir-a-la-cesta-icono-8396-64.png"))); // NOI18N
        btneliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lblpasafecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpasafecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpasafecha.setText("FECHA REG");
        lblpasafecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblproveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblproducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbodocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(datedocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cboproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtgrantotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtunidades)
                                    .addComponent(lblpasafecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtserie)
                                    .addComponent(txtnodocumento)
                                    .addComponent(txtventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btneliminar)
                                        .addGap(20, 20, 20))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel13)))
                        .addContainerGap(11, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblproveedor)
                    .addComponent(lblproducto)
                    .addComponent(txtturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(datedocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cboproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cboproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(txtnodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblpasafecha))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtunidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(txtgrantotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadido-excluir-de-compra-en-linea-de-comercio-electronico-de-la-tienda-icono-9156-48.png"))); // NOI18N
        btnnuevo.setText("NUEVA COMPRA");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/la-lucha-contra-la-caja-registradora-icono-4028-48.png"))); // NOI18N
        btnguardar.setText("REGISTRAR");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir-de-gnome-icono-8179-48.png"))); // NOI18N
        btnsalir1.setText("SALIR");
        btnsalir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-icono-4399-48.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        tablacompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablacompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablacompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Unidades", "Costo", "Valor Venta"
            }
        ));
        jScrollPane1.setViewportView(tablacompra);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtnodocumento.requestFocus();
       lblpasafecha.setVisible(true);
       limpiar();
       
       ABILITAR();
        btnguardar.setEnabled(true);
        btnagregar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:

        ConexionMySQL mysql = new ConexionMySQL(); //abre la conecxion
        Connection cn = mysql.Conectar(); //abre la conecxion

        String doc,nodoc,datedoc,serie,prove,datereg,producto,unidades,costo,venta,turno,grantotal;
        String formato ="yyyy/MM/dd";
        //Formato
        java.util.Date datedocu =  datedocumento.getDate();
       // java.util.Date dateregi =  lblpasafecha.getText();

        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        datedoc = sdf.format(datedocu);
        datereg = lblpasafecha.getText();
        //datereg =  sdf.format(dateregi);
        JOptionPane.showMessageDialog(this,"00!!"+datereg,"Atencion",JOptionPane.INFORMATION_MESSAGE);
        int rpta=0;
        int totalrow=tablacompra.getRowCount();
        totalrow-=1;
        for (int i=0; i<=(totalrow);i++)
        {

            doc=cbodocumento.getSelectedItem().toString();
            nodoc=txtnodocumento.getText();
            serie=txtserie.getText();
            prove=lblproveedor.getText();
            producto=String.valueOf(tablacompra.getValueAt(i, 0)) ;
            unidades=String.valueOf(tablacompra.getValueAt(i, 2)) ;
            costo=String.valueOf(tablacompra.getValueAt(i, 3)) ;
            venta=String.valueOf(tablacompra.getValueAt(i, 4)) ;
            turno=txtturno.getText();

            grantotal=txtgrantotal.getText();
            JOptionPane.showMessageDialog(this,"11!!"+datereg,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            try {

                if(  !doc.equals("") && !nodoc.equals("") && !datedoc.equals("") &&! serie.equals("") &&!prove.equals("") &&!datereg.equals("") &&!datereg.equals("")&&!producto.equals("") &&!producto.equals("")&&!turno.equals("") )
                //enviar datos a validar

                {
                    JOptionPane.showMessageDialog(this,"procedimiento","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    cts=cn.prepareCall("{ call guardacompra(?,?,?,?,?,?,?,?,?,?,?,?)}");

                    cts.setString(1, doc);
                    cts.setString(2, serie);
                    cts.setString(3, nodoc);
                    cts.setString(4, producto);
                    cts.setString(5, prove);
                    cts.setString(6, datedoc);
                    cts.setString(7, unidades);
                    cts.setString(8, costo);
                    cts.setString(9, venta);
                    cts.setString(10, grantotal);
                    cts.setString(11, turno);
                    cts.setString(12, datereg);
                    //cts.setString(13, tipotran);

                  
                    rpta=cts.executeUpdate();
                  
                    if(rpta==1)

                    JOptionPane.showMessageDialog(this,"COMPRA REGISTRADA EXITOSAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

                    else
                    
                    BOTONES();
                    limpiar();
                    DESABILITAR();
                    

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
                JOptionPane.showMessageDialog(this,e.getMessage(),"Atencion",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        BOTONES();
        DESABILITAR();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        // TODO add your handling code here:
        //int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
        //if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
       // }
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void txtturnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtturnoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtturnoKeyTyped

    private void txtunidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunidadesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunidadesKeyTyped

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        DefaultTableModel tabla= (DefaultTableModel) tablacompra.getModel();

        Object nuevafila[] = {idproducto,cboproducto.getSelectedItem(),txtunidades.getText(),txtcosto.getText(),txtventa.getText()};
        tabla.addRow(nuevafila);
        double grantotal=0.0 ;
        int totalrow=tablacompra.getRowCount();

        totalrow-=1;
        for (
            int i=0; i<=(totalrow);i++
        )
        {
            double total = Double.parseDouble(String.valueOf(tablacompra.getValueAt(i, 3)));
            grantotal+=total;

        }

        txtgrantotal.setText(String.valueOf(grantotal));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarActionPerformed

    private void cbodocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbodocumentoActionPerformed

    private void datedocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datedocumentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_datedocumentoKeyTyped

    private void txtgrantotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgrantotalKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  txtgrantotal.getText().length()>=1000000000)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_txtgrantotalKeyTyped

    private void cboproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboproductoActionPerformed
        // TODO add your handling code here:
        pasaidproducto();
    }//GEN-LAST:event_cboproductoActionPerformed

    private void cboproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboproveedorActionPerformed
        // TODO add your handling code here:
        pasaidproveedor();
    }//GEN-LAST:event_cboproveedorActionPerformed

    private void txtcostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  txtcosto.getText().length()>=1000000000)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_txtcostoKeyTyped

    private void txtventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtventaKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if(  txtventa.getText().length()>=1000000000)evt.consume();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_txtventaKeyTyped

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabla= (DefaultTableModel) tablacompra.getModel();
        int indFil = tablacompra.getSelectedRow();
        if (indFil >= 0)
        tabla.removeRow(indFil);

        double grantotal=0.0 ;
        int totalrow=tablacompra.getRowCount();
        totalrow-=1;
        for (
            int i=0; i<=(totalrow);i++
        )
        {
            double total = Double.parseDouble(String.valueOf(tablacompra.getValueAt(i, 3)));
            grantotal+=total;

        }
        txtgrantotal.setText(String.valueOf(grantotal));
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_Compras dialog = new form_Compras(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JComboBox cbodocumento;
    private javax.swing.JComboBox cboproducto;
    private javax.swing.JComboBox cboproveedor;
    private com.toedter.calendar.JDateChooser datedocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    public static javax.swing.JLabel lblpasafecha;
    private javax.swing.JLabel lblproducto;
    private javax.swing.JLabel lblproveedor;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablacompra;
    private javax.swing.JTextField txtcosto;
    private javax.swing.JTextField txtgrantotal;
    private javax.swing.JTextField txtnodocumento;
    private javax.swing.JTextField txtserie;
    public static javax.swing.JTextField txtturno;
    private javax.swing.JTextField txtunidades;
    private javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
