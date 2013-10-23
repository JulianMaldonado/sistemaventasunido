
package sistemaventas;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author avalos
 */
public final class BuscarArticulos extends javax.swing.JInternalFrame {

    /**
     * Creates new form BuscarArticulos
     */
    
    
      conexion conectar=new conexion();
      Connection cn;
      CallableStatement cts;
      ResultSet r;
    private DefaultTableModel model;
      
      
    public BuscarArticulos() throws SQLException {
        initComponents();
        
        
         cn=conectar.conectado();
        cargar();
        //CARGAPROCUTO();
        
        
        
    }
    
    
     public void CARGAPRODUCTO(String valor){
     String [] titulos = {"DESCRIPCION"};
     String [] registros = new String [1];
     
    String sql="SELECT producto.descripcion FROM producto WHERE descripcion LIKE '%"+valor+"%' ";
 
     model= new DefaultTableModel (null,titulos);
     
   
    cn=conectar.conectado();
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
            registros [0]=rs.getString("descripcion");
          
          
           model.addRow(registros);
                  
            }
           jTable1.setModel(model);
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
		}
    
    
 public void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
           
           
       tabla.addColumn("CODIGO");
       tabla.addColumn("DETALLE");   
      // tabla.addColumn("PRECIO_COSTO");
      // tabla.addColumn("PRECIO_VENTA");
      
       
       
         cts=cn.prepareCall("{ call MostrarProd }");
          r=cts.executeQuery();
                while (r.next())
                {
                       Object dato[]=new  Object[4];
                       for (int i=0; i<5; i++){
                       dato[i]=r.getString(i+1);

                                              }
                       tabla.addRow(dato);
                 }
                      this.jTable1.setModel(tabla);
     
       
       }catch (Exception e){}}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProduc = new javax.swing.JTextField();
        btBuscaProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDescuentoProducto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtTotalProducto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        bnRegistrarArticulo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();

        jMenuItem1.setText("Actualizar");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exportar Registro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Busqueda de Articulos");

        jLabel2.setText("codigo producto:");

        txtBuscarProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProducKeyReleased(evt);
            }
        });

        btBuscaProd.setText("Buscar");
        btBuscaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaProdActionPerformed(evt);
            }
        });

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
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad:");

        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Descuento:");

        txtDescuentoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoProductoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("P. Unit:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Total:");

        bnRegistrarArticulo.setText("Registrar Articulo");
        bnRegistrarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnRegistrarArticuloActionPerformed(evt);
            }
        });

        jLabel4.setText("Stock:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btBuscaProd)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bnRegistrarArticulo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescuentoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaProd)
                    .addComponent(bnRegistrarArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtDescuentoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel4)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void Selecionaarticulo(){
       
         DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();
        int row=jTable1.getSelectedRow();
        String COD=jTable1.getValueAt(row, 0).toString();
        String DETALLE=jTable1.getValueAt(row, 1).toString();
        //String PREC_VENTA=jTable1.getValueAt(row, 2).toString();
        //String PREC_COST=jTable1.getValueAt(row, 3).toString();
        
          
         int i=0; 
         i=i+1;
         Object[]  dato=new Object[2];
         
         
         
            dato[0]=COD;
            dato[1]=DETALLE;
            //dato[2]=PREC_VENTA.toString();
           // dato[3]=PREC_COST.toString();
            modelo.addRow(dato);
            
           Factura.jtableDetalle.setModel(modelo);
           Factura.jtableDetalle.editCellAt(row, 2);
           Factura.ajustarcolumnas();
            this.dispose();
           

         
       
 }
    private void btBuscaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaProdActionPerformed
        // TODO add your handling code here:
        String x=txtBuscarProduc.getText();
        DefaultTableModel tabla= new DefaultTableModel();
       try{
           
       tabla.addColumn("CODIGO");
       tabla.addColumn("DETALLE");
       tabla.addColumn("MARCA");
       tabla.addColumn("PROVEEDOR");    
       tabla.addColumn("PRECIO_COSTO");
       tabla.addColumn("PRECIO_VENTA");
       tabla.addColumn("STOCK");    
       
         cts=cn.prepareCall("{call BuscaProd(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
       
         while (r.next()){
         Object dato[]=new  Object[6];
         for (int i=0; i<6; i++){
         dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
    }//GEN-LAST:event_btBuscaProdActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Selecionaarticulo();
        
                
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtCantidadProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyReleased
        // TODO add your handling code here:

        double suma;
        double descuento = Double.parseDouble(txtDescuentoProducto.getText());
        double precio = Double.parseDouble(txtPrecioUnitario.getText());
        int cant = Integer.parseInt( txtCantidadProducto.getText() );
        double desc = descuento/100;
        double porcent;
        if (descuento == 0)
        {
            suma = precio*cant ;
        }
        else
        {
            porcent = precio*desc;
            suma = (precio-porcent)*cant ;
        }
        txtTotalProducto.setText(Double.toString(suma));

    }//GEN-LAST:event_txtCantidadProductoKeyReleased

    private void txtDescuentoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoProductoActionPerformed

    private void bnRegistrarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnRegistrarArticuloActionPerformed
        // TODO add your handling code here:
        /*
        
         int c = Integer.parseInt(txtStock.getText());
        int b = Integer.parseInt(txtCantidadProducto.getText());
                
        if(!txtCantidadProducto.getText().equals("0") )
        {
            if (c > b)
            {            
            
     //       if (txtCantidadProducto.getText(),txtTotalProducto.getText())
            {
                JOptionPane.showMessageDialog(this, "El articulo se registro con exito");
                txtCantidadProducto.setText("0");
                txtTotalProducto.setText("0");                
                txtDescuentoProducto.setText("");
            }
            //else
            {
                JOptionPane.showMessageDialog(this, "Error al registrar el articulo");
            }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "El stock del articulo no soporta la venta por favor actualize en stock");
            }
        }
            else
            {
            JOptionPane.showMessageDialog(this, "La cantidad no es valida");
            }
        
        String[] columnas = {"Numero_factura","Codigo articulo","Descripcion","Cantidad","Total"};
        datostabla = con.datos_detallefactura(num_factura.getText());
        DefaultTableModel datosta = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datosta);
        
        Double a = con.total_factura(num_factura.getText());
        
        total_factura.setText(a.toString());
        IVA iva = new IVA(Double.parseDouble(txtTotalProducto.getText()));
        iva_art.setText(iva.calcular_iva().toString());
        
        
        */
    }//GEN-LAST:event_bnRegistrarArticuloActionPerformed

    private void txtBuscarProducKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProducKeyReleased
        // TODO add your handling code here:
        
     /*   if(txtBuscarProduc.getText()!=null )
     {
            
            Object[][] datos = cn.descripcion(txtBuscarProduc.getText().toString());
            articulo_venta.getText(datos[0][0].toString());
            txtPrecioUnitario.setText(datos[0][1].toString());
            txtStock.setText(datos[0][2].toString());
            txtCantidadProducto.setText("0");
            txtTotalProducto.setText("0");
            txtDescuentoProducto.setText("0");
            
           
        
            
        }        
        */
        
        //CARGAPRODUCTO();
    }//GEN-LAST:event_txtBuscarProducKeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        
        
        
        
        
    }//GEN-LAST:event_jTable1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnRegistrarArticulo;
    private javax.swing.JButton btBuscaProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscarProduc;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDescuentoProducto;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotalProducto;
    // End of variables declaration//GEN-END:variables

   
}