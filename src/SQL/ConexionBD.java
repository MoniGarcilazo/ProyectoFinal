/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author José Puc
 */
public class ConexionBD {
     private static Connection conn = null; 
    private static String base = "dbteatrofinal";
        private static String user = "JosePuc";
         private static String pass = "xxYisusxx4";
         private static String host = "serverteatro.mysql.database.azure.com";
         private static String puerto = "3306";
         
         private static String url = "jdbc:mysql://" +
                 host + ":"+ puerto + "/ " +  base ;
    
    public static Connection getConnection(){
        
        
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
     conn = DriverManager.getConnection(url,user,pass);
            if (conn != null) {
                System.out.println("Conexion Exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Conexion Erronea " + e.getMessage() + "El JAR se encuentra en la carpeta -libreriasAdicionales- que está dentro de una carpeta que se ubica en este proyecto");
        }
        return conn;
    }
    
    
      public static void main(String[] args) {
        ConexionBD.getConnection();
      }     
}


 