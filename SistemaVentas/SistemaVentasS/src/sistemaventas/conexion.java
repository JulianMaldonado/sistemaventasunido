/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaventas ;
import java.sql.*;

/**
 *
 * @author Alex
 */
public class conexion {

   
   
   
   private final String url = "jdbc:mysql://localhost/proyectofinal";
    PreparedStatement psPrepararSentencia;
    Connection con = null;
   

    
    public conexion() {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection(url,"root","");
         if (con!=null){
            System.out.println("Conexión a base de datos de agroFox. listo!!");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
         catch(ClassNotFoundException e)
         {
          System.out.println(e);
         }
    }
     /**
     *
     * @return
     */
    public Connection conectado(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
    
}
