
package daos;

import csql.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Asiento;
import modelo.Funcion;

/**
 *
 * @author Monica Garcilazo
 */
public class DaoAsientos {
    
    private int filasB = 5;
    private int columnasB = 2;
    private int filasA = 2;
    private int columnasA = 5;
    
    /**
     * Metodo para agregar una sala a la base de datos
     * @param idSala id de la sale a crear
     **/
    public void agregarSala( int idSala) {
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO asientos (idFuncion) VALUES (?) ");
            
            ps.setInt(1, idSala);
            ps.executeUpdate(); //Ejecutar consulta
            
            JOptionPane.showMessageDialog(null, "Sala Creada");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Sala No Creada");
        }
        
    }
    
    /**
     * Modifica la sola en la base de datos
     * @param funcion Fucnion a modificar
     **/
    public void modificarSala( Funcion funcion) {
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("UPDATE asientos SET A1=?, A2=?, A3=?, A4=?, A5=?, A6=?, A7=?, A8=?, A9=?, A10=?, C1=?, C2=?, C3=?, C4=?, C5=?, C6=?, C7=?, C8=?, C9=?, C10=?, B1=?, B2=?, B3=?, B4=?, B5=?, B6=?, B7=?, B8=?, B9=?, B10=?, B11=?, B12=?, B13=?, B14=?, B15=?, B16=?, B17=?, B18=?, B19=?, B20=? WHERE idFuncion = ? ");
            
            int indice= 1;
            for( int i = 0; i < filasA; i++ ) {
                for( int k = 0; k < columnasA; k++) {  
                   ps.setInt(indice, funcion.getZonaA()[i][k].isDisponible());   
                   indice++;
            }
            }
            
            for( int i = 0; i < filasA; i++ ) {
                for( int k = 0; k < columnasA; k++) {  
                   ps.setInt(indice, funcion.getZonaC()[i][k].isDisponible());   
                   indice++;
            }
            }
            
            for( int i = 0; i < filasB; i++ ) {
                for( int k = 0; k < columnasB; k++) {
                     ps.setInt(indice, funcion.getZonaB()[i][k].isDisponible());   
                   indice++;
                }     
            }
            
            for( int i = 0; i < filasB; i++ ) {
                for( int k = 0; k < columnasB; k++) {
                     ps.setInt(indice, funcion.getZonaB2()[i][k].isDisponible());   
                   indice++;
                } 
                
            }
            
            ps.setInt(indice, funcion.getID());
            
            ps.executeUpdate(); //Ejecutar consulta
            
            JOptionPane.showMessageDialog(null, "Sala modificada");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString() + "XD");
        }
        
    }
    
    /**
     * Elimina una sala en la base de datos
     * @param idSala ID de la sala a eliminar
     **/
    public void eliminarSala( int idSala) {
        
        try
        {
            Connection conexion = ConexionBD.getConnection();
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM asientos WHERE idFuncion = ?; ");
            
            ps.setInt(1, idSala);
            ps.executeUpdate(); //Ejecutar consulta
            
            JOptionPane.showMessageDialog(null, "Sala Eliminada");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    /**
     * Trae o alctualiza los datos de los asientos dependiendo de su estado
     * @param funcion Funcion a la que se le asignaran los datos de los asientos
     * @return Funcion con la informacion de los asientos
     **/
    public Funcion traerDatosAsientos( Funcion funcion) {
        int contador = 0;
        int lugarSilla = 1;
        PreparedStatement ps;
        ResultSet rs;
        Asiento[][] zonaA = new Asiento[filasA][columnasA];
        Asiento[][] zonaB = new Asiento[filasB][columnasB];
        Asiento[][] zonaB2 = new Asiento[filasB][columnasB];
        Asiento[][] zonaC = new Asiento[filasA][columnasA];
        try
        {
            Connection conexion = ConexionBD.getConnection();
            ps = conexion.prepareStatement("SELECT A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10  FROM asientos WHERE idFuncion = ?");
            ps.setInt(1, funcion.getID());
            
            rs = ps.executeQuery();
            
            while( rs.next() ) {
                    
                    for( int i = 0;  i < filasA; i++) {
                            for(int k = 0; k < columnasA; k++ ) {
                               Asiento asiento = new Asiento();
                                asiento.setNombre("A"+lugarSilla);
                                asiento.setDisponible(rs.getInt("A"+lugarSilla));
                                asiento.setPrecioAsiento(funcion.getObra().getPrecioBoleto() * 1.8 ); //Asignarle precios a los asientos
                                zonaA[i][k] = asiento;
                               
                                contador++;
                                lugarSilla++;
                            }
                    }
                     
                     lugarSilla = 1;
                    for( int i = 0;  i < filasB; i++) {
                            for(int k = 0; k < columnasB; k++ ) {
                                
                                Asiento asiento = new Asiento();
                                asiento.setNombre("B"+lugarSilla);
                                asiento.setDisponible(rs.getInt("B"+lugarSilla));
                                asiento.setPrecioAsiento(funcion.getObra().getPrecioBoleto() * 1.5 ); //Asignarle precios a los asientos
                                zonaB[i][k] = asiento;
                                contador++;
                                lugarSilla++;
                            }
                    }
                    
                    lugarSilla = 11;
                    for( int i = 0;  i < filasB; i++) {
                            for(int k = 0; k < columnasB; k++ ) {
                                Asiento asiento = new Asiento();
                                asiento.setNombre("B"+lugarSilla);
                                asiento.setDisponible(rs.getInt("B"+lugarSilla));
                                asiento.setPrecioAsiento(funcion.getObra().getPrecioBoleto() * 1.5 ); //Asignarle precios a los asientos
                                zonaB2[i][k] = asiento;
                                contador++;
                                lugarSilla++;
                            }
                    }
                    
                    lugarSilla = 1;
                    for( int i = 0;  i < filasA; i++) {
                            for(int k = 0; k < columnasA; k++ ) {
                                Asiento asiento = new Asiento();
                                asiento.setNombre("C"+lugarSilla);
                                asiento.setDisponible(rs.getInt("C"+lugarSilla));
                                asiento.setPrecioAsiento(funcion.getObra().getPrecioBoleto() * 1.3 ); //Asignarle precios a los asientos
                                zonaC[i][k] = asiento;
                                contador++;
                                lugarSilla++;
                            }
                    }
                    
                }
            funcion.setZonaA(zonaA);
            funcion.setZonaB(zonaB);
            funcion.setZonaB2(zonaB2);
            funcion.setZonaC(zonaC);

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Dude idk");
        }
        
        
        
        return funcion;
    }
    
    
    
    
    
}
