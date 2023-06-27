/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import SQL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ObraTeatral;

/**
 *
 * @author josep
 */
public class DaoObras {

    public DaoObras() {
    }
    
    public void agregarObra ( ObraTeatral obra) {
       
         try
        {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO obras (nombre, genero, resumen, duracion, actorPrincipal, actorSecundario, precioBoleto, activo) VALUES (?,?,?,?,?,?,?,?) ");

            ps.setString(1, obra.getNombreObra());
            ps.setString(2, obra.getGenero());
            ps.setString(3, obra.getResumen());
            ps.setInt(4, obra.getDuracion());
            ps.setString(5, obra.getActorPrincipal());
            ps.setString(6, obra.getActorSecundario());
            ps.setDouble(7, obra.getPrecioBoleto());
            ps.setInt(8, 1);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Guardado");

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Registro No Guardado");
        }
         
    }
    
    public void modificarObra( ObraTeatral obra) {
       
       try
        {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE obras SET nombre=?, genero=?, resumen=?, duracion=?, actorPrincipal=?, actorSecundario=?, precioBoleto=?  WHERE id=? ");

            ps.setString(1, obra.getNombreObra());
            ps.setString(2, obra.getGenero());
            ps.setString(3, obra.getResumen());
            ps.setInt(4, obra.getDuracion());
            ps.setString(5, obra.getActorPrincipal());
            ps.setString(6, obra.getActorSecundario());
            ps.setDouble(7, obra.getPrecioBoleto());
            ps.setInt(8, obra.getID());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Modificado");
            //Limpiar cada registro despues de ser guardado
            

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Registro No Modificado");
        }
   }
    
    public void eliminarObra( ObraTeatral obra) {
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE obras SET activo = 0  WHERE id=? ");

            ps.setInt(1, obra.getID());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            //Limpiar cada registro despues de ser guardado
            

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    //Cargar los datos en la tabla Usuarios
    public JTable cargarTabla(JTable tblObras) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblObras.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos =
        {
            10, 40, 40, 40, 40, 40, 40, 40
        };

        for (int i = 0; i < tblObras.getColumnCount(); i++)
        {
            tblObras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT id, nombre, genero, resumen, duracion, actorPrincipal, actorSecundario, precioBoleto FROM obras WHERE activo = 1");

            rs = ps.executeQuery();
            rsmd = rs.getMetaData(); //Para traer los metaDatos de la consulta

            columnas = rsmd.getColumnCount();

            while (rs.next())
            {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++)
                {
                    fila[indice] = rs.getObject(indice + 1);

                }

                modeloTabla.addRow(fila);
            }
        } catch (SQLException e)
        {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return tblObras;
    }
    
    //Cuando se le de click a una fila de la tabla, los datos se regresan a los txtLabel's 
    public ObraTeatral regresarDatosEnCasillas( JTable tblObra) {
        ObraTeatral obra = new ObraTeatral();
        try
        {

            int fila = tblObra.getSelectedRow();
            int id = Integer.parseInt( tblObra.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;

            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT nombre, genero, resumen, duracion, actorPrincipal, actorSecundario, precioBoleto FROM obras WHERE id = ?");
            ps.setInt(1, id);

            //Ejecutar consulta
            rs = ps.executeQuery();

            while(rs.next()) {
                obra.setID(id);
                obra.setNombreObra(rs.getString("nombre"));
                obra.setGenero(rs.getString("genero"));
                obra.setResumen(rs.getString("resumen"));
                obra.setDuracion(rs.getInt("duracion"));
                obra.setActorPrincipal(rs.getString("actorPrincipal"));
                obra.setActorSecundario(rs.getString("actorSecundario"));
                obra.setPrecioBoleto(rs.getDouble("precioBoleto"));
             
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return obra;
    }
    
}
