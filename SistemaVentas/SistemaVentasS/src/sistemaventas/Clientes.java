package sistemaventas;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class Clientes extends javax.swing.JInternalFrame {
   
    
    Connection cn;
   
    CallableStatement cts;
   
    ResultSet r;
   
    conexion conectar=new conexion();
   
   private  String numero_cliente="";
    private DefaultTableModel model;
    

     
   
   public String getNumero_Cliente() {
        return numero_cliente;
    } 
   
   public void setNumero_Cliente(String numero_cliente) {
        this.numero_cliente = numero_cliente;
    }
   
   
   
    public Clientes() {
        initComponents();
        
        
        
        
        
          cn=conectar.conectado();
          lblPasa.setVisible(false);
          lblCOD.setVisible(false);
          this.btCancelar.setEnabled(false);
          
          
        cargar("");   
        DESABILITAR();
        BOTONES();
       
        
       
          
    
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
       tabla.addColumn("CODIGO");
       tabla.addColumn("NIT");
       tabla.addColumn("NOMBRE");
       tabla.addColumn("DIRECCION");
       tabla.addColumn("TELEFONO");
            
       
       cts=cn.prepareCall("{call MostrarCliente}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[7];
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
        PreparedStatement psm=cn.prepareStatement("SELECT nombre FROM cliente WHERE nombre like '"+ busq +" %' ");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtCodCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cboCiudad = new javax.swing.JComboBox();
        lblPasa = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCOD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btGuardar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel1 = new org.edisoncor.gui.panel.Panel();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtBuscaClientes = new org.edisoncor.gui.textField.TextFieldRound();
        btnVerModificar = new org.edisoncor.gui.button.ButtonAeroLeft();
        jLabel13 = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("REGISTRO DE CLIENTES");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Telefono:");

        txtNit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });
        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Direccion:");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        txtCodCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodCliente.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nit:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Correo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Ciudad:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setEnabled(false);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        cboCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Departamento" }));
        cboCiudad.setToolTipText("");
        cboCiudad.setEnabled(false);
        cboCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCiudadActionPerformed(evt);
            }
        });

        lblPasa.setText("pasa");
        lblPasa.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        lblCOD.setText("0");
        lblCOD.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Ingrese Datos del Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(171, 171, 171))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion)
                    .addComponent(txtNombre)
                    .addComponent(txtCorreo)
                    .addComponent(cboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblPasa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCOD))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasa)
                    .addComponent(jLabel12))
                .addGap(141, 141, 141))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User edit).jpg"))); // NOI18N
        btModificar.setText("modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        btSalir.setText("salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wzdelete.jpg"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User add).jpg"))); // NOI18N
        btNuevo.setText("Agregar");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btGuardar, btModificar, btNuevo, btSalir});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNuevo)
                .addGap(18, 18, 18)
                .addComponent(btGuardar)
                .addGap(65, 65, 65)
                .addComponent(btModificar)
                .addGap(18, 18, 18)
                .addComponent(btCancelar)
                .addGap(19, 19, 19)
                .addComponent(btSalir)
                .addGap(20, 20, 20))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btGuardar, btModificar, btNuevo, btSalir});

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(jTable1);

        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel1.setColorPrimario(new java.awt.Color(153, 153, 153));
        panel1.setColorSecundario(new java.awt.Color(102, 102, 102));

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre Cliente:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        
        
        String id=lblCOD.getText();
        String cod=txtNit.getText();
        String nom=txtNombre.getText();
        String dir=txtDireccion.getText();
        String tel=txtTelefono.getText();
        String corr=txtCorreo.getText();
        String ciud=lblPasa.getText();
        String cli=txtCodCliente.getText().toString();
        
     
        
        try {
            
            if(  !cod.equals("") && !nom.equals("") && !dir.equals(""))   
                //enviar datos a validar
                 
	                        {
                                       cts=cn.prepareCall("{ call GuardaCliente(?,?,?,?,?,?,?,?)}");
            
            cts.setString(1, id);
            cts.setString(2, cod);
            cts.setString(3, nom);
            cts.setString(4, dir);
            cts.setString(5, tel);
            cts.setString(6, corr);
            cts.setString(7,ciud);
            cts.setString(8, cli);
            
            int rpta=cts.executeUpdate();
            if(rpta==1)
                JOptionPane.showMessageDialog(this,"CLIENTE REGISTRADO CORRECTAMENTE!!","Atencion",JOptionPane.INFORMATION_MESSAGE);
           
            BOTONES();
            DESABILITAR();
            limpiar();
            cargar("");
            
            /*
            if ( ciud.equals("0"))
            {
            //JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UN DEPARTAMENTO...");
            }
            else
                {
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UN DEPARTAMENTO...");
            }  */
                
                                 
	                        }
            
            else
            
                            {
	                        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos que tengan (*) .\n" +
	                            "NO puede dejar ningun campo vacio");
                                txtNit.requestFocusInWindow();
                                txtNombre.requestFocusInWindow();
                                txtDireccion.requestFocusInWindow();
                                
	                    }
           
        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, e);
        }
                  

       
    
    }//GEN-LAST:event_btGuardarActionPerformed

    
     public String GenerarNumeroCliente()
     {
         
           conexion cn=new conexion();
           try {
            PreparedStatement pstm = (PreparedStatement) cn.conectado().prepareStatement("SELECT  MAX(id_cliente)+1 as total FROM cliente ");
            ResultSet res=pstm.executeQuery();
            
            int nuevo;
            
           
            while (res.next())
            {
               nuevo=res.getInt("total");
               
                             
               String codigo = "CL";
           
               codigo = codigo  +  nuevo;
               numero_cliente = codigo;
               return codigo;
               
           }
           } catch(SQLException e){
              
               System.out.println(e);
           }
        return null;
              
    }
    
    
    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
   // TODO add your handling code here:
          
       
        ABILITAR();
         
        CARGACIUDAD();
        
           
           this.btGuardar.setEnabled(true);
           this.btNuevo.setEnabled(false);
           
           this.btModificar.setEnabled(false);
           this.btCancelar.setEnabled(true);
           
          
        
           this.txtCodCliente.setText(GenerarNumeroCliente()); 
        
           
           
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
    
        
        
        String ID=lblCOD.getText();
        String cli=txtCodCliente.getText();
        String cod=txtNit.getText();
        String nom=txtNombre.getText();
        String dir=txtDireccion.getText();
        String tel=txtTelefono.getText();
        String corr=txtCorreo.getText();
        //String ciud=cboCiudad.getSelectedItem().toString();
        String pasa=lblPasa.getText();
        
      
        
         
        
        try {
            cts=cn.prepareCall("{call ModificaCliente(?,?,?,?,?,?,?,?)}");
            
            cts.setString(1, ID);
            cts.setString(2, cod);
            cts.setString(3, nom);
            cts.setString(4, dir);
            cts.setString(5, tel);
            cts.setString(6, corr);
            cts.setString(7, pasa);
            cts.setString(8, cli);
          
            
            PASACIUDAD();
            
            
            int rpta=cts.executeUpdate();
            if(rpta==1){
                
            JOptionPane.showMessageDialog(this, "Cliente Modificado","Aviso",JOptionPane.INFORMATION_MESSAGE);
            
            limpiar(); 
            DESABILITAR();
            BOTONES();
            
            cargar("");
            }else {

         JOptionPane.showMessageDialog(this, "Error al modificar","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {JOptionPane.showMessageDialog(this, e.toString());
        }
        
  
    }//GEN-LAST:event_btModificarActionPerformed
public void BOTONES(){
           
           this.btGuardar.setEnabled(false);
           this.btNuevo.setEnabled(true);
           
           this.btModificar.setEnabled(false);
           
}
    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        
       this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void txtNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyTyped
        // TODO add your handling code here:
  
    
 
    }//GEN-LAST:event_txtNitKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
        
        String s;
        s= txtNombre.getText();
        txtNombre.setText(s.toUpperCase());
 
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
         if(  txtTelefono.getText().length()>=8)evt.consume();
        if ((car<'0'||car>'9'))evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyReleased
        // TODO add your handling code here:
        
        char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
        
        String s;
        s= txtNit.getText();
        txtNit.setText(s.toUpperCase());
     
    }//GEN-LAST:event_txtNitKeyReleased

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        BOTONES();
        DESABILITAR();
        limpiar();
        this.btCancelar.setEnabled(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        // TODO add your handling code here:
        
        txtNit.transferFocus();
        
    }//GEN-LAST:event_txtNitActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        
        
        String nombre;
        nombre=txtNombre.getText().toLowerCase();
        
        txtNombre.transferFocus();
        
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        
        txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
        txtCorreo.transferFocus();
        
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void cboCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCiudadActionPerformed
        // TODO add your handling code here:
        
        PASAID();
        
        
        
        
        
    }//GEN-LAST:event_cboCiudadActionPerformed

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void txtBuscaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClientesKeyReleased
        // TODO add your handling code here:
        
        cargar(txtBuscaClientes.getText());
  
     char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
        
        String s;
        s= txtBuscaClientes.getText();
        txtBuscaClientes.setText(s.toUpperCase());
        
        
        
    }//GEN-LAST:event_txtBuscaClientesKeyReleased

     public void cargar(String valor){
     String [] titulos = {"No.","NIT","NOMBRE","DIRECCION","TELEFONO","CORREO","CIUDAD","CODIGO"};
     String [] registros = new String [8];
     
    String sql="SELECT cliente.id_cliente, cliente.nit,cliente.nombre,cliente.direccion,cliente.telefono, cliente.correo, ciudad.descripcion, cliente.codigo FROM cliente, ciudad WHERE nombre LIKE '%"+valor+"%' && ciudad.id_ciudad=cliente.ciudad ";
 
     model= new DefaultTableModel (null,titulos)
      {
                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
                        return false;
                    }
                };
     
   
    cn=conectar.conectado();
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            registros [0]=rs.getString("id_cliente");
            registros [1]=rs.getString("nit");
            registros [2]=rs.getString("nombre");
            registros [3]=rs.getString("direccion");
            registros [4]=rs.getString("telefono");
            registros [5]=rs.getString("correo");
            registros [6]=rs.getString("descripcion");
            registros [7]=rs.getString("codigo");
            
            
            
          
           model.addRow(registros);
                  
            }
           jTable1.setModel(model);
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
		}
    
    
    private void txtBuscaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaClientesActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtBuscaClientesActionPerformed

    private void SelecionaCL(){
        
        int row=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(row, 0).toString();
        String nit=jTable1.getValueAt(row, 1).toString();
        String nom=jTable1.getValueAt(row, 2).toString();
        String dir=jTable1.getValueAt(row, 3).toString();
        String tel=jTable1.getValueAt(row, 4).toString();
        String cor=jTable1.getValueAt(row, 5).toString();
       // String ciu=jTable1.getValueAt(row, 6).toString();
        String cod=jTable1.getValueAt(row, 7).toString();
        
        
                
        
        txtCodCliente.setText(cod);
        txtNit.setText(nit);
        txtNombre.setText(nom);
        txtDireccion.setText(dir);
        txtTelefono.setText(tel);
        txtCorreo.setText(cor);
        //cboCiudad.setSelectedItem(ciu);
        lblCOD.setText(id);
        
       
     
        //jTextField5.setText(id);
        
        
            
           // jTextField1.setText(Clientes.get(tb.getSelectedRows()).get);
        
    }
    
    private void btnVerModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerModificarActionPerformed
        // TODO add your handling code here:
       
            SelecionaCL();
            
            ABILITAR();
         
           
            
           this.btGuardar.setEnabled(false);
           this.btNuevo.setEnabled(false);
           
           this.btModificar.setEnabled(true);
           this.btCancelar.setEnabled(true);
           
           
            
        
               
       
           
        
        
        
        
    }//GEN-LAST:event_btnVerModificarActionPerformed

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
        char car=evt.getKeyChar();
        if((car<'a'||car>'z')&&(car<'A'||car>'Z')&&(car<' '||car>' ')) evt.consume();
        
        String s;
        s= txtDireccion.getText();
        txtDireccion.setText(s.toUpperCase());
        
    }//GEN-LAST:event_txtDireccionKeyReleased
 
    
    
  public void CARGACIUDAD(){
        
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

cboCiudad.addItem(valor);

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
    
  public void PASAID(){
    
  
  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT id_ciudad as total FROM ciudad WHERE descripcion='"+ cboCiudad.getSelectedItem().toString()  +"'  ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
if (rs.next()) {
String valor = rs.getString("total");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

lblPasa.setText(valor);


}
else{

    lblPasa.setText("0");
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
  
 
  
  public void PASACIUDAD(){
        
  Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "SELECT ciudad.descripcion as nomb FROM ciudad,cliente WHERE ciudad.id_ciudad='"+ lblPasa.getText().toString() +"' ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) 
    
  
{
String valor = rs.getString("nomb");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

cboCiudad.setSelectedItem(valor);
//cboCiudad.addItem(valor);

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
        
        
           this.txtCodCliente.setText("");      
           this.txtNit.setText("");
           this.txtNombre.setText("");
           this.txtDireccion.setText("");
           this.txtTelefono.setText("");
           this.txtCorreo.setText("");
           this.cboCiudad.setSelectedItem("");
          
           
                    
           
 }
         
  public void ABILITAR(){
      
           this.txtNit.setEnabled(true);
           this.txtNombre.setEnabled(true);
           this.txtDireccion.setEnabled(true);
           this.txtTelefono.setEnabled(true);
           this.txtCorreo.setEnabled(true);
           this.cboCiudad.setEnabled(true);
          
           
           this.txtNit.requestFocus();
  }
  
   public void DESABILITAR(){
           
           this.txtNit.setEnabled(false);
           this.txtNombre.setEnabled(false);
           this.txtDireccion.setEnabled(false);
           this.txtTelefono.setEnabled(false);
           this.txtCorreo.setEnabled(false);
           this.cboCiudad.setEnabled(false);
           }
   
    
    
    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btSalir;
    private org.edisoncor.gui.button.ButtonAeroLeft btnVerModificar;
    private javax.swing.JComboBox cboCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private javax.swing.JLabel lblCOD;
    public static javax.swing.JLabel lblPasa;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextFieldRound txtBuscaClientes;
    public javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
