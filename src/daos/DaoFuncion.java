
package daos;

import csql.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Funcion;
import modelo.ObraTeatral;

/**
 *
 * @author Monica Garcilazo
 */
public class DaoFuncion {

    public DaoFuncion() {
    }
    
    /**
     * Inserta funcion a la base de datos
     * @param funcion Funcion que se desea agregar
     * @return id de la nueva funcion
     **/
    public int agregarFuncion ( Funcion funcion) {
        int idNuevaFuncion = 0;
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO funciones (fechaPresentacion, horaPresentacion, idObra, activo) VALUES (?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs;
            
            ps.setDate(1, (Date) funcion.getFechaDePresentacion());
            ps.setTime(2, funcion.getHora());
            ps.setInt(3, funcion.getObra().getID());          
            ps.setInt(4, 1);
            ps.executeUpdate(); //Ejecutar consulta
            
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                idNuevaFuncion = rs.getInt(1);
            }
            
            JOptionPane.showMessageDialog(null, "Registro Guardado");
            
        } catch (Exception e)
        {

        }
        
        return idNuevaFuncion;
    }
    
    /**
     * Modificar una funcion ya existente en la base de datos
     * @param funcion Funcion con nuevos datos
     **/
    public void modificarFuncion ( Funcion funcion) {
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE funciones SET fechaPresentacion = ?, horaPresentacion = ?, idObra = ? WHERE idFuncion = ? ");
            
            ps.setDate(1, (Date) funcion.getFechaDePresentacion());
            ps.setTime(2, funcion.getHora());         
            ps.setInt(3, funcion.getObra().getID());           
            ps.setInt(4, funcion.getID()); 
            ps.executeUpdate(); //Ejecutar consulta
            
            JOptionPane.showMessageDialog(null, "Registro Modificado");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Registro No Modificado");
        }
        
    }
    
    /**
     * Elimina una funcion de la base de datos
     * @param funcion Funcion a eliminar
     * @return ID de la funcion eliminada
     **/
    public int eliminarFuncion(Funcion funcion) {
        
         try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE funciones SET  activo = 0  WHERE idFuncion = ? ");
            
            ps.setInt(1, funcion.getID());
            ps.executeUpdate(); //Ejecutar consulta
            
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
         return funcion.getID();
    }
    
    /**
     * Verifica el numero de funciones que hay en un día desde la base de datos
     * @param funcion Funcion 
     * @return Numero de funciones en un dia
     **/
    public int verificarFuncionesPorDia ( Funcion funcion) {
        ArrayList<java.sql.Date> fechas = new ArrayList<java.sql.Date>();
        
        PreparedStatement ps;
        ResultSet rs;
        int contador = 0;
        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT funciones.fechaPresentacion FROM funciones WHERE funciones.activo = 1 AND funciones.fechaPresentacion = ?");
            ps.setDate(1, funcion.getFechaDePresentacion());
            
            rs = ps.executeQuery();
            
            while(rs.next() ) {
                fechas.add(rs.getDate("funciones.fechaPresentacion"));
                contador++;
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No hubo");
        }

        return contador;
    }
    
    /**
     * Verifica los horarios de las Funciones desde la base de datos
     * @param funcion
     * @return Numero de horarios 
     **/
    public int verificarHorariosFunciones ( Funcion funcion) {
        ArrayList<java.sql.Date> horarios = new ArrayList<java.sql.Date>();
        PreparedStatement ps;
        ResultSet rs;
        int contador = 0;
        try
        {
            
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT funciones.horaPresentacion FROM funciones WHERE funciones.activo = 1 AND funciones.fechaPresentacion = ? AND funciones.horaPresentacion = ?");
            ps.setDate(1, funcion.getFechaDePresentacion());
            ps.setTime(2, funcion.getHora());
            
            rs = ps.executeQuery();
            
            while(rs.next() ) {
                
                contador++;
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Horarios Error");
        }
        
        
        return contador;
    }
    
     //Cargar los datos en la tabla Funciones
    /**
     *  Carga los datos en la tabal de Funciones a la base de datos
     * @param tblFuncion tabla con los datos de funciones
     * @return tabla de funciones
     **/
    public JTable cargarTabla(JTable tblFuncion) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblFuncion.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos =
        {
            10, 40, 40, 40
        };

        for (int i = 0; i < tblFuncion.getColumnCount(); i++)
        {
            tblFuncion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT funciones.idFuncion, date_format(funciones.fechaPresentacion,'%d/%b/%y'), funciones.horaPresentacion, obras.nombre FROM obras inner join funciones ON obras.id = funciones.idObra WHERE obras.activo = 1 AND funciones.activo = 1 order by funciones.idFuncion");

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

            JOptionPane.showMessageDialog(null, "No se cargo la tabla i guess");
        }
        
        return tblFuncion;
    }
    
    
    /**
     * Cargar las obras en el ComboBox
     * @param comboBox comboBox al que se le asignaran los datos
     * @return comboBox con los datos asignados
     **/
    public JComboBox cargarComboBox(JComboBox comboBox) {
        DefaultComboBoxModel modeloCombo = (DefaultComboBoxModel) comboBox.getModel();
        comboBox.setModel(modeloCombo);

        PreparedStatement ps;
        ResultSet rs;

        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT id, nombre, genero, resumen, duracion, actorPrincipal, actorSecundario, precioBoleto FROM obras WHERE activo = 1");
            rs = ps.executeQuery();
    
            while (rs.next())
            {
                comboBox.addItem(
                new ObraTeatral(Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre"), rs.getString("genero"),
                        rs.getString("resumen"), 
                       Integer.parseInt(rs.getString("duracion")), 
                        rs.getString("actorPrincipal"), rs.getString("actorSecundario"), 
                         Double.parseDouble(rs.getString("precioBoleto"))));       
            }
        } catch (SQLException e)
        {

            JOptionPane.showMessageDialog(null, "No se cargo el comboBox");
        }
        
        return comboBox;
    }
    
    /**
     * Regresa los datos de la funcion a las casillas
     * @param tblFunciones Tabla a modificar
     * @return Funcion que se regresa
     **/
    public Funcion regresarDatosEnCasillas( JTable tblFunciones) {
        Funcion funcion = new Funcion();
        
        try
        {

            int fila = tblFunciones.getSelectedRow();
            int id = Integer.parseInt( tblFunciones.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            ObraTeatral obra = new ObraTeatral();

            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT funciones.idFuncion, funciones.fechaPresentacion, funciones.horaPresentacion, obras.id FROM obras inner join funciones ON obras.id = funciones.idObra WHERE idFuncion = ?");
            ps.setInt(1, id);

            //Ejecutar consulta
            rs = ps.executeQuery();

            while(rs.next()) {
                funcion.setID(id);
                funcion.setFechaDePresentacion(rs.getDate("funciones.fechaPresentacion"));
                funcion.setHora(rs.getTime("funciones.horaPresentacion"));
                obra.setID(rs.getInt("obras.id"));
                
                funcion.setObra(obra);
             
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error");
        }
        
        return funcion;
    }
    
    
    
}
