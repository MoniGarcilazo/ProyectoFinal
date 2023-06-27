/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import SQL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Funcion;
import modelo.ObraTeatral;

/**
 *
 * @author josep
 */
public class DaoVentaBoleto {
    
    //Recuperar todas las funciones
    public ArrayList<Funcion> recuperarFunciones( ) {
        ArrayList<Funcion> listaFunciones = new ArrayList<Funcion>();
        
        PreparedStatement ps;
        ResultSet rs;
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement(" SELECT funciones.idFuncion, funciones.fechaPresentacion, funciones.horaPresentacion, obras.id, obras.nombre, obras.duracion, obras.precioBoleto FROM obras inner join funciones ON obras.id = funciones.idObra WHERE funciones.activo = 1 AND obras.activo = 1");
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ObraTeatral obra = new ObraTeatral();
                obra.setID(rs.getInt("obras.id"));
                obra.setNombreObra(rs.getString("obras.nombre"));
                obra.setDuracion(rs.getInt("obras.duracion"));
                obra.setPrecioBoleto(rs.getDouble("obras.precioBoleto"));       
                
                Funcion funcion = new Funcion();
                funcion.setID(rs.getInt("funciones.idFuncion"));
                funcion.setObra(obra);
                funcion.setFechaDePresentacion(rs.getDate("funciones.fechaPresentacion"));
                funcion.setHora(rs.getTime("funciones.horaPresentacion"));
                            
                listaFunciones.add(funcion);
            }
            
            
        } catch (Exception e)
        {
        }
        
        return listaFunciones;
    }
    
    
    
    
    //Cargar las fechas de las funciones  en el ComboBox
    public JComboBox cargarComboBox(JComboBox comboBox) {
        DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) comboBox.getModel();
        comboBox.setModel(modeloCombo);

        PreparedStatement ps;
        ResultSet rs;
        
        comboBox.addItem("Seleccione una fecha");

        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement(" SELECT DISTINCT fechaPresentacion FROM obras inner join funciones ON obras.id = funciones.idObra WHERE funciones.activo = 1 AND obras.activo = 1");
            rs = ps.executeQuery();
    
            while (rs.next())
            {

                comboBox.addItem(rs.getDate("fechaPresentacion").toString());           
            }
            
        } catch (SQLException e)
        {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return comboBox;
    }
    
    
    
    
    
    
    
}
