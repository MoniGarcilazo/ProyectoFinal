
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoAsientos;
import DAO.DaoFuncion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Funcion;
import modelo.ObraTeatral;
import vista.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlFuncion implements ActionListener, MouseListener{

    Funcion funcion = null;
    VentanaPrincipal menu = new VentanaPrincipal();
    DaoFuncion daoFuncion = new DaoFuncion();
    DaoAsientos daoAsientos = new DaoAsientos();

    public ControlFuncion(Funcion funcion, VentanaPrincipal menu) {
        
        this.funcion = funcion;
        this.menu = menu;
        
        this.menu.getPanelFuncion().setTblFunciones(daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones()));
        
        this.menu.getPanelFuncion().getBtnAgregar().addActionListener(this);
        this.menu.getPanelFuncion().getBtnModificar().addActionListener(this);
        this.menu.getPanelFuncion().getBtnEliminar().addActionListener(this);
        //Añadir Mouse Listener a la tabla de funciones
        this.menu.getPanelFuncion().getTblFunciones().addMouseListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        agregarFuncion(e);
        modificarFuncion(e);
        eliminarFuncion(e);
    }
    
    public void agregarFuncion(ActionEvent e){
        //Agregar Funcion
        if ( this.menu.getPanelFuncion().getBtnAgregar() == e.getSource()) {
            capturarDatos();
            if( funcion != null ) {
                 int numFunciones = daoFuncion.verificarFuncionesPorDia(funcion);      
                int numHorarios = daoFuncion.verificarHorariosFunciones(funcion);
                boolean menosDeDosFunciones = numFunciones == 0 || numFunciones == 1 ;
                // Este if con ayuda del dao verifica si existen menos de 2 funciones para poder agregar otros, en caso contrario no agregar y mandar msj del error
                if (menosDeDosFunciones) {                                  
                            if( numHorarios == 0 ) {
                                int idSala = daoFuncion.agregarFuncion(funcion);
                                daoAsientos.agregarSala(idSala);
                                daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
                                this.funcion = null;
                            } else {
                                JOptionPane.showMessageDialog(null, "Registro sin éxito, existe una función con el mismo horario y el mismo día");
                            }

                }else {
                    JOptionPane.showMessageDialog(null, "Registro sin éxito, se han pasado los limites de registros de dicha fecha");
                        }
            }
        }
    }
    
    public void modificarFuncion(ActionEvent e){
        if (this.menu.getPanelFuncion().getBtnModificar()== e.getSource() ) {
             capturarDatos();
             
                if( funcion != null ) {
                    
                     int numHorarios = daoFuncion.verificarHorariosFunciones(funcion);
                    if( numHorarios == 0 ) {
                        this.funcion.setID(Integer.parseInt(menu.getPanelFuncion().getTxtID().getText()));
                        daoFuncion.modificarFuncion(funcion);
                        daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
                        this.funcion = null;
                    } else {
                        JOptionPane.showMessageDialog(null, "Registro sin éxito, existe una función con el mismo horario y el mismo día, tendrás que cambiar la fecha de la función");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado alguna funcion");
                }
             
        }
    }
    
    public void eliminarFuncion(ActionEvent e){
        if(this.menu.getPanelFuncion().getBtnEliminar() == e.getSource()) {
            capturarDatos();
            if( funcion != null ) { 
                this.funcion.setID(Integer.parseInt(menu.getPanelFuncion().getTxtID().getText()));
                int ID = daoFuncion.eliminarFuncion(funcion);
                daoAsientos.eliminarSala(ID);
                daoFuncion.cargarTabla(menu.getPanelFuncion().getTblFunciones());
                this.funcion = null;
            } else {
                 JOptionPane.showMessageDialog(null, "No ha seleccionado alguna funcion");
            }
            
        }
    }
    
    public void capturarDatos() {
        
        try
        {
            ObraTeatral obra = (ObraTeatral) this.menu.getPanelFuncion().getComboBoxObras().getSelectedItem();
        
          //Capturar la fecha y pasarlo a formato para base MySQL
            Date date = this.menu.getPanelFuncion().getCalendarFecha().getDate();
            long d = date.getTime(); 
            
            //Conversion a SQL
            java.sql.Date fecha = new java.sql.Date(d);
       
            String hora = this.menu.getPanelFuncion().getBoxHorario().getSelectedItem().toString();
                java.sql.Time horaConvertida = java.sql.Time.valueOf(hora);
            
                this.funcion = new Funcion();
                //Establecer la obra a la funcion
            this.funcion.setObra(obra);
            this.funcion.setHora(horaConvertida);
            //Asignar la fecha la funcion
            this.funcion.setFechaDePresentacion(fecha);  
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        }
        
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        this.funcion = daoFuncion.regresarDatosEnCasillas(menu.getPanelFuncion().getTblFunciones());
        
        menu.getPanelFuncion().getTxtID().setText(String.valueOf(funcion.getID()));
       
        int tamaño = menu.getPanelFuncion().getComboBoxObras().getItemCount();
        for( int i = 0; i < tamaño; i++ ) {
            if( menu.getPanelFuncion().getComboBoxObras().getItemAt(i).getID() == funcion.getObra().getID()) {
                menu.getPanelFuncion().getComboBoxObras().setSelectedIndex(i);
            }
        }
        
        menu.getPanelFuncion().getCalendarFecha().setDate(funcion.getFechaDePresentacion());
        menu.getPanelFuncion().getBoxHorario().setSelectedItem(funcion.getHora().toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
 
    
    
    
}
