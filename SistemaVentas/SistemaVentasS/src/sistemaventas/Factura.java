
package sistemaventas;

import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public final class Factura extends javax.swing.JInternalFrame {
 Connection cn=null;
   CallableStatement cts=null;
   ResultSet r=null;
   String sql=null;
   conexion conectar=new conexion();
   
   private  String numero_factura="";
   
   
      public String getNumero_factura() {
        return numero_factura;
    }
   
   
   
   public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }
   
   
    public Factura() throws SQLException {
        initComponents();
        
        
         SimpleDateFormat formato1 = new SimpleDateFormat(
            "dd/MM/yyyy", Locale.getDefault());
      //  SimpleDateFormat formato2 = new SimpleDateFormat(
          //  "dd 'de' MMMM 'de' yyyy", Locale.getDefault());   
        
        java.util.Date fechaDate = new java.util.Date();
        String fech = formato1.format(fechaDate);
        
          cn=conectar.conectado();
         // Calendar cal=Calendar.getInstance();
          
         // String fecha=cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(cal.YEAR);
          
          this.lblFecha.setText(fech);
          
         
          this.lblCodCliente.setVisible(false);

     }
             
public static void ajustarcolumnas(){
    
    
     TableColumn columna =null;
     for(int i=0;i<=4;i++){
         columna=jtableDetalle.getColumnModel().getColumn(i);
         if(i==0){
             
             columna.setPreferredWidth(6);
            
         }
         else if(i==1){
              columna.setPreferredWidth(300);
         }
          else if(i==2){
              columna.setPreferredWidth(20);
         }
         else {
            columna.setPreferredWidth(40); 
         }
         
     }
     
     
     
      double suma=0.0;
         double subtot=0.0;
         double des=0.0;
         double igv=0.0;
         double total=0.0;
         
             for(int i=0;i<jtableDetalle.getRowCount();i++){
            String precio= jtableDetalle.getValueAt(i, 3).toString();
            String cantidad=jtableDetalle.getValueAt(i , 2).toString();
            int c=Integer.parseInt(cantidad);
            double p=Double.parseDouble(precio);
          
            suma=c*p;
             subtot+=suma;    
             des=(subtot*10)/100;
             igv=(subtot*18)/100;
             total=subtot-des;
             
             jtableDetalle.setValueAt(suma, i, 4);
             jtf_subto.setText(""+subtot);
             jtf_desc.setText(""+des);
             jtf_igv.setText(""+igv);
             jtf_total.setText(""+total);             
             
         }
     
     
     
 }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        txtFact = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jtf_total = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtf_subto = new javax.swing.JTextField();
        jtf_desc = new javax.swing.JTextField();
        jtf_igv = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDetalle = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btBuscaCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btBuscaProducto = new javax.swing.JButton();
        btRealizaVenta = new javax.swing.JButton();
        btEliminaProducto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btCalculaOperacion = new javax.swing.JButton();
        btBuscaNit = new javax.swing.JButton();
        lblCodCliente = new javax.swing.JLabel();
        btNuevaVenta = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jLabel4.setText("Calle 234 - av. La Libertad - Mazatenango - Such.");

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGROFOX");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("No. TRANS.");

        jLabel13.setText("-");

        txtNumeroFactura.setEnabled(false);

        txtFact.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFact, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("Total a Pagra:");

        jtf_total.setEditable(false);

        jLabel24.setText("Descuento 10% :");

        jLabel25.setText("Subtotal:");

        jLabel26.setText("igv:");

        jtf_subto.setEditable(false);

        jtf_desc.setEditable(false);

        jtf_igv.setEditable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_subto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jtf_subto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtableDetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jtableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO UNITARIO", "PRECIO VENTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtableDetalle);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Telefonos: 78790202  &  54893220");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre:");

        btBuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        btBuscaCliente.setText("Buscar Cliente");
        btBuscaCliente.setEnabled(false);
        btBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nit:");

        jLabel3.setText("TODO PARA SU CONSUMO ANIMAL");

        lblCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCliente.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblClienteInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        lblNit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Articulo:");

        btBuscaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        btBuscaProducto.setText("BUSCAR ...");
        btBuscaProducto.setEnabled(false);
        btBuscaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaProductoActionPerformed(evt);
            }
        });

        btRealizaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        btRealizaVenta.setText("REALIZAR VENTA");
        btRealizaVenta.setEnabled(false);
        btRealizaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizaVentaActionPerformed(evt);
            }
        });

        btEliminaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User delete).jpg"))); // NOI18N
        btEliminaProducto.setText("ELIMINAR ARTICULO");
        btEliminaProducto.setEnabled(false);
        btEliminaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminaProductoActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btCalculaOperacion.setText("ACTUALIZAR ");
        btCalculaOperacion.setEnabled(false);
        btCalculaOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalculaOperacionActionPerformed(evt);
            }
        });

        btBuscaNit.setText("Ingrese NIT");
        btBuscaNit.setEnabled(false);
        btBuscaNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaNitActionPerformed(evt);
            }
        });

        lblCodCliente.setText("CodCliente");

        btNuevaVenta.setText("Nueva Venta");
        btNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevaVentaActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Empleado:");

        lblEmpleado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblCodCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNit, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btBuscaNit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addComponent(btBuscaCliente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel5))
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btCalculaOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btEliminaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRealizaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCalculaOperacion, btEliminaProducto, btRealizaVenta, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCodCliente)
                                    .addComponent(btBuscaNit)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscaCliente)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(btBuscaProducto)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btRealizaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btEliminaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btCalculaOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCalculaOperacion, btEliminaProducto, btRealizaVenta, jButton3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btBuscaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaProductoActionPerformed
        // TODO add your handling code here:
        BuscarArticulos bs;
        try {
            bs = new BuscarArticulos();
            SistemaV.jDesktopPane1.add(bs);
        bs.toFront();
        bs.setLocation(50,10);
        bs.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }//GEN-LAST:event_btBuscaProductoActionPerformed

    private void btBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaClienteActionPerformed
        // TODO add your handling code here:
        BuscarCliente bc=new BuscarCliente();
        SistemaV.jDesktopPane1.add(bc);
        bc.toFront();
        bc.setVisible(true);
    }//GEN-LAST:event_btBuscaClienteActionPerformed
private void agregarfactura(){
    
    
        String nfac=txtNumeroFactura.getText();
        String fec=lblFecha.getText();
        String subt=jtf_subto.getText().toString();
        String desc=jtf_desc.getText().toString();
       String igv=jtf_igv.getText().toString();
        String tot=jtf_total.getText().toString();
        
        try {
            cts=cn.prepareCall("{call InsertaFactura(?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2,fec);
            cts.setString(3,subt);
            cts.setString(4, desc);
            cts.setString(5,igv);
            cts.setString(6, tot);
            int opcion=cts.executeUpdate();
            if(opcion==1)
                JOptionPane.showMessageDialog(this, "factura registrado coreectamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                     
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(this,"Error al registrar");
        }
}
private void agregarDETALLEfactura(){
    
    
     for(int i=0;i<jtableDetalle.getRowCount();i++){
        String nfac=txtNumeroFactura.getText();
        String codpro=jtableDetalle.getValueAt(i,0).toString();
        String prod=jtableDetalle.getValueAt(i,1).toString();
        String cant=jtableDetalle.getValueAt(i,2).toString();
        String pre_u=jtableDetalle.getValueAt(i,3).toString();
        String pre_v=jtableDetalle.getValueAt(i,4).toString();
        
        try{
            cts=cn.prepareCall("{call INSERTADETALLEFACTURA(?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, codpro);
            cts.setString(3, prod);
            cts.setString(4, cant);
            cts.setString(5, pre_u);
            cts.setString(6, pre_v);
            
            int opcion=cts.executeUpdate();
            if (opcion==1)
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al registrar"+e.getMessage());
                
        }}
}
    private void btRealizaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizaVentaActionPerformed
        // TODO add your handling code here:
            DefaultTableModel modelo = (DefaultTableModel) jtableDetalle.getModel();
        //ahora obtenemos la fila selccionada
        int fila_select = jtableDetalle.getSelectedRow();

        if(fila_select<0){
            // no se puede eliminar
            JOptionPane.showMessageDialog(this,"DETALLE DE VENTA ESTA VACIO GENERE UN ARTICULO AL MENOS.");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(fila_select);
        }
        agregarfactura();
        agregarDETALLEfactura();
       
    }//GEN-LAST:event_btRealizaVentaActionPerformed

    private void btEliminaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaProductoActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel modelo = (DefaultTableModel) jtableDetalle.getModel();
        //ahora obtenemos la fila selccionada
        int fila_select = jtableDetalle.getSelectedRow();

        if(fila_select<0){
            // no se puede eliminar
            JOptionPane.showMessageDialog(this,"Tabla vacia o no ha seleccionado uan fila.");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(fila_select);
        }

        
    }//GEN-LAST:event_btEliminaProductoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
             int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
             if(opcion==JOptionPane.YES_NO_OPTION){
             this.dispose();

}


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btCalculaOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculaOperacionActionPerformed
        // TODO add your handling code here:
        
         double suma=0.0;
         double subtot=0.0;
         double des=0.0;
         double igv=0.0;
         double total=0.0;
         
             for(int i=0;i<jtableDetalle.getRowCount();i++){
            String precio= jtableDetalle.getValueAt(i, 3).toString();
            String cantidad=jtableDetalle.getValueAt(i , 2).toString();
            int c=Integer.parseInt(cantidad);
            double p=Double.parseDouble(precio);
          
            suma=c*p;
             subtot+=suma;    
             des=(subtot*10)/100;
             igv=(subtot*18)/100;
             total=subtot-des;
             
             jtableDetalle.setValueAt(suma, i, 4);
             jtf_subto.setText(""+subtot);
             jtf_desc.setText(""+des);
             jtf_igv.setText(""+igv);
             jtf_total.setText(""+total);             
             
         }
         
         
    }//GEN-LAST:event_btCalculaOperacionActionPerformed

    private void btBuscaNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaNitActionPerformed
        // TODO add your handling code here:
        
        String nom=JOptionPane.showInputDialog("INGRESE NIT DEL CLIENTE...");
          try {
             cts=cn.prepareCall("{call BuscarClienteNit(?)}");
            cts.setString(1, nom);
            r=cts.executeQuery();

            if(r.next()){
            JOptionPane.showMessageDialog(this,"Cliente Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            
            
            this.lblCodCliente.setText(r.getString(1));
            this.lblNit.setText(r.getString(2));
            this.lblCliente.setText(r.getString(3));
            this.lblDireccion.setText(r.getString(4));
            
          
            
            
            
         
           
            }else{

           JOptionPane.showMessageDialog(this,"Cliente  No Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {JOptionPane.showMessageDialog(this, e.toString());
        }

        
        
        
    }//GEN-LAST:event_btBuscaNitActionPerformed

    private void btNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevaVentaActionPerformed
        // TODO add your handling code here:
        
        
        this.btBuscaCliente.setEnabled(true);
        this.btBuscaNit.setEnabled(true);
        this.btBuscaProducto.setEnabled(true);
        this.btRealizaVenta.setEnabled(true);
        this.btCalculaOperacion.setEnabled(true);
        this.btEliminaProducto.setEnabled(true);
        
        this.btNuevaVenta.setEnabled(false);
        
       
        
        this.txtNumeroFactura.setText(GenerarFactura()); 
        
        
        
        
    }//GEN-LAST:event_btNuevaVentaActionPerformed

    private void lblClienteInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblClienteInputMethodTextChanged
        // TODO add your handling code here:
        
        
       
        
        
    }//GEN-LAST:event_lblClienteInputMethodTextChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        // Limpio campos para nueva venta
        
        this.jTable1.addColumn(null);
        this.txtNumeroFactura.setText("");
         Factura.lblCliente.setText("");
         Factura.lblCodCliente.setText("");
         Factura.lblDireccion.setText("");
         Factura.lblNit.setText("");
         
         //desahbilito los botones...
         this.btNuevaVenta.setEnabled(true);
         this.btBuscaCliente.setEnabled(false);
         this.btCalculaOperacion.setEnabled(false);
         this.btRealizaVenta.setEnabled(false);
         this.btEliminaProducto.setEnabled(false);
       
       
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
        public String GenerarFactura()
     {
         conexion cn=new conexion();
           try {
            PreparedStatement pstm = (PreparedStatement) cn.conectado().prepareStatement("SELECT  MAX(id_factura)+1 as id FROM factura ");
            ResultSet res=pstm.executeQuery();
            
            int nuevo;
            
           
            while (res.next())
            {
               nuevo=res.getInt("id");
               
                             
               String cod = "TRANS";
               
           
               cod = cod + nuevo;
               numero_factura = cod;
               return cod;
               
           }
           } catch(SQLException e){
              
               System.out.println(e);
           }
        return null;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscaCliente;
    private javax.swing.JButton btBuscaNit;
    private javax.swing.JButton btBuscaProducto;
    private javax.swing.JButton btCalculaOperacion;
    private javax.swing.JButton btEliminaProducto;
    private javax.swing.JButton btNuevaVenta;
    private javax.swing.JButton btRealizaVenta;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable jtableDetalle;
    public static javax.swing.JTextField jtf_desc;
    public static javax.swing.JTextField jtf_igv;
    public static javax.swing.JTextField jtf_subto;
    public static javax.swing.JTextField jtf_total;
    public static javax.swing.JLabel lblCliente;
    public static javax.swing.JLabel lblCodCliente;
    public static javax.swing.JLabel lblDireccion;
    public static javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblNit;
    private javax.swing.JTextField txtFact;
    private javax.swing.JTextField txtNumeroFactura;
    // End of variables declaration//GEN-END:variables
}
