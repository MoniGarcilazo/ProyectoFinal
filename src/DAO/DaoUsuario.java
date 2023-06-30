/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import SQL.ConexionBD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author josep
 */

/**
 * Clase que realiza consultas a la base de datos relacionado con los usuarios
 */
public class DaoUsuario {
    
    /**
     * Constructor de DaoUsuario
     */
    public DaoUsuario() {
       
    }
    /**
     * Metodo que realiza la consulta al agregar un usuario a la base de datos
     * @param usuario a agregar a la base de datos 
     */
    public void agregarUsuario ( Usuario usuario) {
       
         try
        {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuarios (nombre, apellido, curp, rol, usuario, contrasenia, activo) VALUES (?,?,?,?,?,?,?) ");

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCURP());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getUsuario());
            ps.setString(6, usuario.getContraseña());
            ps.setInt(7, 1); //ACTIVO
            
            ps.executeUpdate(); //hacer la consulta

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            //Limpiar cada registro despues de ser guardado

        } catch (HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Registro No Guardado");
        }
         
    }
    
    /**
     * Método que realiza la consulta para modificar usuario existente en la base de datos
     * @param usuario a modificar en la base de datos
     */
    public void modificarUsuario( Usuario usuario) {
       
       try
        {

            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, curp=?, rol=?, usuario=?, contrasenia=?  WHER E id=? ");

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCURP());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getUsuario());
            ps.setString(6, usuario.getContraseña());
            ps.setInt(7, usuario.getID());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Modificado");
            //Limpiar cada registro despues de ser guardado
            

        } catch (HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Registro No Modificado");
        }
   }
    /**
     * Metodo para eliminar un usuario existente en la base de datos
     * @param usuario a eliminar de la base de datos
     */
    public void eliminarUsuario( Usuario usuario) {
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE usuarios SET activo = 0  WHERE id=? ");

            ps.setInt(1, usuario.getID());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            //Limpiar cada registro despues de ser guardado
            

        } catch (HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    /**
     * Método que retorna los datos de usuarios en casillas
     * @param tblUsuarios Tabla que muestra el usuario en cuestión
     * @return usuario que se mostrará en ventana
     */
    public Usuario regresarDatosEnCasillas( JTable tblUsuarios) {
        Usuario usuario = new Usuario();
        try
        {

            int fila = tblUsuarios.getSelectedRow();
            int id = Integer.parseInt( tblUsuarios.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;

            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT nombre, apellido, curp, rol, usuario, contrasenia FROM usuarios WHERE id = ?");
            ps.setInt(1, id);

            //Ejecutar consulta
            rs = ps.executeQuery();

            while(rs.next()) {
                usuario.setID(id);
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCURP(rs.getString("curp"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contrasenia"));
                if(rs.getString("rol").equals("Administrador")) {
                   usuario.setRol("Administrador");
               } else if (rs.getString("rol").equals("Vendedor")) {
                   usuario.setRol("Vendedor");
                }
             
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usuario;
    }
    
    /**
     * Método que toma la tabla dee usuarios y la carga a la base de datos
     * @param tblUsuarios que será eventualmente cargada
     * @return tabla de usuarios cargada
     */
    public JTable cargarTabla(JTable tblUsuarios) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos =
        {
            10, 40, 40, 40, 40, 40, 40
        };

        for (int i = 0; i < tblUsuarios.getColumnCount(); i++)
        {
            tblUsuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT id, nombre, apellido, curp, rol, usuario, contrasenia FROM usuarios WHERE activo = 1");

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
        
        return tblUsuarios;
    }
}
