
package sistemaventas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;



public class AccessoSistema extends javax.swing.JFrame {
    
    conexion conectar = new conexion();
    Connection conn;
    

  public Timer objetotimer;
    public int a;
    
    public AccessoSistema() {
        initComponents();
        
         conn=conectar.conectado();
         lblTipoUsuario.setVisible(false);
         
        
    }
public void IniciarSesion(){
    
   conexion cn=new conexion();
    
    objetotimer = new Timer(10,new claseTimer());
    
        try {
            PreparedStatement pstm = (PreparedStatement) cn.conectado().prepareStatement("SELECT  "+"   user,clave,tipo_usuario "+" FROM empleado WHERE user='"+ txtUsuario.getText() +"' && clave='"+ txtContraseña.getText() +"'   ");
            ResultSet res=pstm.executeQuery();
            
            String estusuario=null;
            String estclave=null;
            
            
            String user=txtUsuario.getText();
            String clave=txtContraseña.getText();
           
           
            while (res.next())
            {
               estusuario=res.getString("user");
               estclave = res.getString("clave");
              
            
           }
            
                                // VERIFICA QUE NO ESTEN VACIOS LOS CAMPOS USER Y CLAVE                            
	                  if (txtUsuario.getText().length() > 0 && txtContraseña.getText().length() > 0 )
	                    {
	                        // VERIFICA QUE EL USER Y CLAVE SEAN AUTENTICADOS...                           
	                  if(  user.equals(estusuario) && clave.equals(estclave) )                               
                                 // EMPIEZA A VALIDAR CON LA BARRA DE TIEMPOS                                  
	                       {                                  
	                         
                              
                              
                              objetotimer.start();                                 
                              this.btnIniciarSesion.setEnabled(false);
                                 
   
                                  
                                  
	                       }                          
                          else 
	                        {
                                    
	                            JOptionPane.showMessageDialog(null, "El nombre de USUARIO y/o CLAVE  no son validos.");
	                           // JOptionPane.showMessageDialog(null, txtUsuario.getText()+" " +txtContraseña.getText() );
                                    
                                    
                                    //LIMPIA LOS CAMPOS PARA ESCRIBIR DE NUEVO...
	                            txtUsuario.setText("");    
	                            txtContraseña.setText("");
	                            txtUsuario.requestFocusInWindow();
	                        }
	                    }
                          
                            else
	                    {
	                        JOptionPane.showMessageDialog(null, "FAVOR DE ESCRIBIR USUARIO Y CLAVE.\n" +
	                        "PARA PODER ENTRAR...");
                                txtUsuario.requestFocusInWindow();
	                    }            
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }                   
}
        

public class claseTimer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          a=jProgressBar1.getValue();
          if (a <100){
              a++;
              jProgressBar1.setValue(a);
               }
          else{
              
              objetotimer.stop();
              
        
        
            
              SistemaV fr2=new SistemaV(); 
              fr2.setEnabled(true);
              fr2.lblUsuarioActivo.setText(txtUsuario.getText());
              fr2.control.setText(lblTipoUsuario.getText());
              fr2.menuRegistros.setEnabled(true);
             
              fr2.show();
              cerrar();
        
              
         
              
            
        
        
         
              
              
                                      
          }                  
          
        }
    
}
private void cerrar(){
   this.dispose(); 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new java.awt.TextField();
        btnIniciarSesion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        txtContraseña = new javax.swing.JPasswordField();
        lblTipoUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accesso al sistema");

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fg[1].jpg"))); // NOI18N
        btnIniciarSesion.setText("Aceptar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        btnIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniciarSesionKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sesion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jProgressBar1.setForeground(new java.awt.Color(0, 255, 51));
        jProgressBar1.setStringPainted(true);

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });

        lblTipoUsuario.setText("jLabel3");
        lblTipoUsuario.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(btnIniciarSesion)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtContraseña)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(lblTipoUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarSesion)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
     
        IniciarSesion();
        Connection cn;
    conexion conectar=new conexion();
    cn=conectar.conectado();
PreparedStatement pstmt = null;
ResultSet rs = null;


String sql = "SELECT  "+"   tipo_usuario "+" FROM empleado WHERE user='"+ txtUsuario.getText() +"' && clave='"+ txtContraseña.getText() +"'   ";
try {
pstmt = cn.prepareStatement(sql);
rs = pstmt.executeQuery();
while (rs.next()) 
    
  
{
String valor = rs.getString("tipo_usuario");
// Aquí recuperas los valores obtenidos y realizas la carga del a mostrar

lblTipoUsuario.setText(valor);
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



    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnIniciarSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniciarSesionKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() ==KeyEvent.VK_ENTER){ 
        IniciarSesion();}
    }//GEN-LAST:event_btnIniciarSesionKeyPressed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            System.exit(0);
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
        
        txtContraseña.transferFocus();
    }//GEN-LAST:event_txtContraseñaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccessoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccessoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccessoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccessoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AccessoSistema().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    public static javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private java.awt.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
