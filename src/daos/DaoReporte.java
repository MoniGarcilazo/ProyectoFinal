/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import csql.ConexionBD;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Ticket;

/**
 *Clase que realiza las consultas a la base de datos relacionado con los tickets
 */
public class DaoReporte {
    
    private File archivo;
    
    /**
     * Método que agrega un ticket a la base de datos 
     * @param dataTicket Ticket a agregar
     * @return idNuevoTicket
     **/
    public int agregarTicket(Ticket dataTicket) {
        int idNuevoTicket = 0;
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO tickets (totalBoletos,fechaVenta,horaVenta,costoTotal,montoEntregado,cambio) VALUES (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs;
            
            
            ps.setInt(1, dataTicket.getBoletosVendidos());
            ps.setDate(2,dataTicket.getFechaVenta()); 
            ps.setTime(3, dataTicket.getHoraVenta());
            ps.setDouble(4, dataTicket.getTotal());
            ps.setDouble(5, dataTicket.getMontoEntregado());
            ps.setDouble(6, dataTicket.getCambio());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                idNuevoTicket = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }      
        return idNuevoTicket;
    }
    
    /**
     * Método que agrega las fechas al combobox 
     * @param comboBox comboBox a cargar
     * @return comboBox
     **/
    public JComboBox cargarComboBox(JComboBox comboBox) {
        DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) comboBox.getModel();
        comboBox.setModel(modeloCombo);
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement(" SELECT DISTINCT fechaVenta FROM tickets");
            rs = ps.executeQuery();
            while (rs.next()) {
                comboBox.addItem(rs.getDate("fechaVenta").toString());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return comboBox;
    }
    
    
    /**
     * Método que obtiene todos los tickets de la base de datos
     * @return comboBox
     **/
    public ArrayList<Ticket> recuperarTickets() {
        ArrayList<Ticket> listaTickets = new ArrayList<Ticket>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT idTicket, totalBoletos, fechaVenta, horaVenta, costoTotal, montoEntregado, cambio FROM tickets");
            rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setNumDeVenta(rs.getInt("idTicket"));
                ticket.setBoletosVendidos(rs.getInt("totalBoletos"));
                ticket.setFechaVenta(rs.getDate("fechaVenta"));
                ticket.setHoraVenta(rs.getTime("horaVenta"));
                ticket.setTotal(rs.getDouble("costoTotal"));
                ticket.setMontoEntregado(rs.getDouble("montoEntregado"));
                ticket.setCambio(rs.getDouble("cambio"));

                listaTickets.add(ticket);
            }
        } catch (Exception e) {
        }
        return listaTickets;
    }
    
    /**
     * Método que crea un archivo con el nombre Ticket.txt
     **/
    public void crearArchivo() {
        File archivo = new File("Ticket.txt");
    }
    
    /**
     * Método que registra el ticket en un archivo txt
     * @param  datosTicket
     **/
    public void registrarTicketEnArchivo(String datosTicket) {
             
        if ( archivo == null) {
            crearArchivo();
        } else {
            
        }
        
            FileWriter fr;
        try
        {
            fr = new FileWriter("Ticket.txt");
            fr.write(datosTicket);
            fr.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso de los tickets en archivo");
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Error en la escritura del archivo" + ex.getMessage());
        }
        
    }
}
