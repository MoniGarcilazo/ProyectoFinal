
package daos;

import csql.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author José Puc
 */
public class DaoLogin {
    
    
    public Usuario autentificarUsuario( Usuario usuario) {
        Connection conexion = ConexionBD.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT usuario, contrasenia, rol FROM usuarios WHERE usuario = ? AND contrasenia = ? AND activo = 1 ";
        
        try
        {
           ps = conexion.prepareStatement(sql);
           ps.setString(1, usuario.getUsuario());
           ps.setString(2, usuario.getContraseña());
            
            rs = ps.executeQuery();
            
            
            while(rs.next()) {
                
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contrasenia"));
                usuario.setRol(rs.getString("rol"));
                
                conexion.close();
                return usuario;
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        usuario.setRol("nada");
     return usuario;   
    }
    
}
    

